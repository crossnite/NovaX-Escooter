import Foundation
import CoreBluetooth
import Combine

class BLEManager: NSObject, ObservableObject {
    @Published var isScanning = false
    @Published var devices: [CBPeripheral] = []
    @Published var connected: CBPeripheral?
    @Published var logs: [String] = []
    @Published var serviceUUIDString: String = "2c00"
    @Published var txUUIDString: String = "2c01"
    @Published var rxUUIDString: String = "2c01"
    @Published var rssiMap: [UUID: Int] = [:]
    @Published var discoveredCharacteristics: [CBCharacteristic] = []
    @Published var selectedTXUUID: String = ""
    @Published var selectedRXUUID: String = ""

    private var central: CBCentralManager!
    private var txChar: CBCharacteristic?
    private var rxChar: CBCharacteristic?

    override init() {
        super.init()
        central = CBCentralManager(delegate: self, queue: .main)
    }

    func startScan() {
        isScanning = true
        devices.removeAll()
        central.scanForPeripherals(withServices: nil)
        append("scan started")
    }

    func stopScan() {
        isScanning = false
        central.stopScan()
        append("scan stopped")
    }

    func connect(_ p: CBPeripheral) {
        guard central != nil else { append("central not ready"); return }
        guard central.state == .poweredOn else { append("cannot connect: bt state=\(central.state.rawValue)"); return }
        DispatchQueue.main.async {
            self.central.connect(p, options: nil)
        }
        append("connect \(p.identifier.uuidString)")
    }

    func disconnect() {
        if let p = connected { central.cancelPeripheralConnection(p) }
    }

    var isConnected: Bool { connected != nil }

    func discover() {
        guard let p = connected else { return }
        if serviceUUIDString.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty {
            p.discoverServices(nil)
            append("discover all services")
        } else {
            let su = CBUUID(string: serviceUUIDString)
            p.discoverServices([su])
            append("discover service \(serviceUUIDString)")
        }
    }

    func write(hex: String) {
        guard let p = connected, let c = txChar else { return }
        let data = Data(hexString: hex)
        guard data.count > 0 else { return }
        p.writeValue(data, for: c, type: .withoutResponse)
        append("write \(hex)")
    }

    // Placeholder action sender to be wired with real payloads later
    func send(action name: String) {
        ensureTXRXSelectedIfPossible()
        switch name {
        case "Unlock":
            // Sequence derived from frames 730–748
            // 1) AT+OKFCG=OKAI_CAR,0,0,1,0024$\r\n
            writeAscii("AT+OKFCG=OKAI_CAR,0,0,1,0024$\r\n", withResponse: true)
            // 2) AT+OKXWM=OKAI_CAR,1,0004$\r\n (frame 737)
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.10) {
                self.writeAscii("AT+OKXWM=OKAI_CAR,1,0004$\r\n", withResponse: true)
            }
            // 3) AT+OKLFC=OKAI_CAR,0,1,1,1,3,0,1,1,0,0,2,0,ES520A-BT,1,0,0,0026$\r\n (frame 742)
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.20) {
                self.writeAscii("AT+OKLFC=OKAI_CAR,0,1,1,1,3,0,1,1,0,0,2,0,ES520A-BT,1,0,0,0026$\r\n", withResponse: true)
            }
            // 4) AT+OKXWM=OKAI_CAR,0,0003$\r\n (frame 748)
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.30) {
                self.writeAscii("AT+OKXWM=OKAI_CAR,0,0003$\r\n", withResponse: true)
                self.append("action: Unlock sequence sent")
            }
        case "Lock":
            // Exact lock sequence from OnlyLocking.txt: OKXWM=1,0004 then OKXWM=0,0003
            writeAscii("AT+OKXWM=OKAI_CAR,1,0004$\r\n", withResponse: true)
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.2) {
                self.writeAscii("AT+OKXWM=OKAI_CAR,0,0003$\r\n", withResponse: true)
                self.append("action: Lock sent (XWM=1->0)")
            }
        case "SendOKFCG":
            writeAscii("AT+OKFCG=OKAI_CAR,0,0,1,0024$\r\n", withResponse: true)
        case "SendXWM1":
            writeAscii("AT+OKXWM=OKAI_CAR,1,0004$\r\n", withResponse: true)
        case "SendLFC":
            writeAscii("AT+OKLFC=OKAI_CAR,0,1,1,1,3,0,1,1,0,0,2,0,ES520A-BT,1,0,0,0026$\r\n", withResponse: true)
        case "SendXWM0":
            writeAscii("AT+OKXWM=OKAI_CAR,0,0003$\r\n", withResponse: true)
        default:
            append("action: \(name) (unknown)")
        }
    }

    func setTX(uuid: String) {
        selectedTXUUID = uuid
        append("TX set to \(uuid)")
        if let p = connected, let c = findCharacteristic(by: uuid, on: p) {
            txChar = c
        }
    }

    func setRX(uuid: String) {
        selectedRXUUID = uuid
        append("RX set to \(uuid)")
        if let p = connected, let c = findCharacteristic(by: uuid, on: p) {
            rxChar = c
            p.setNotifyValue(true, for: c)
        }
    }

    private func findCharacteristic(by uuidString: String, on peripheral: CBPeripheral) -> CBCharacteristic? {
        let target = CBUUID(string: uuidString)
        for s in peripheral.services ?? [] {
            for ch in s.characteristics ?? [] {
                if ch.uuid == target { return ch }
            }
        }
        return nil
    }

    private func ensureTXRXSelectedIfPossible() {
        guard let p = connected else { return }
        if txChar == nil {
            if let c = firstWritableCharacteristic(on: p) { txChar = c; append("auto TX -> \(c.uuid.uuidString)") }
        }
        if rxChar == nil {
            if let c = firstNotifyingCharacteristic(on: p) { rxChar = c; p.setNotifyValue(true, for: c); append("auto RX -> \(c.uuid.uuidString)") }
        }
    }

    private func firstWritableCharacteristic(on peripheral: CBPeripheral) -> CBCharacteristic? {
        for s in peripheral.services ?? [] {
            for ch in s.characteristics ?? [] {
                let props = ch.properties
                if props.contains(.write) || props.contains(.writeWithoutResponse) { return ch }
            }
        }
        return nil
    }

    private func firstNotifyingCharacteristic(on peripheral: CBPeripheral) -> CBCharacteristic? {
        for s in peripheral.services ?? [] {
            for ch in s.characteristics ?? [] {
                let props = ch.properties
                if props.contains(.notify) || props.contains(.indicate) { return ch }
            }
        }
        return nil
    }

    private func writeAscii(_ s: String, withResponse: Bool) {
        guard let p = connected, let c = txChar else { return }
        if let data = s.data(using: .utf8) {
            p.writeValue(data, for: c, type: withResponse ? .withResponse : .withoutResponse)
            append("write ascii \(s.trimmingCharacters(in: .whitespacesAndNewlines))")
        }
    }

    func clearLogs() {
        logs.removeAll()
    }

    func startScan(serviceFilter: String?) {
        guard central != nil else { append("central not ready"); return }
        guard central.state == .poweredOn else {
            append("bluetooth not poweredOn (state=\(central.state.rawValue))")
            return
        }
        isScanning = true
        devices.removeAll()
        if let f = serviceFilter, !f.isEmpty {
            central.scanForPeripherals(withServices: [CBUUID(string: f)])
            append("scan started (filter \(f))")
        } else {
            central.scanForPeripherals(withServices: nil)
            append("scan started")
        }
    }

    func enableAllNotifications() {
