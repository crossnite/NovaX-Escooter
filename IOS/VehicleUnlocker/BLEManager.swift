import Foundation
import CoreBluetooth
import Combine

class BLEManager: NSObject, ObservableObject {
    @Published var isScanning = false
    @Published var devices: [CBPeripheral] = []
    @Published var connected: CBPeripheral?
    @Published var logs: [String] = []
    @Published var serviceUUIDString: String = ""
    @Published var txUUIDString: String = ""
    @Published var rxUUIDString: String = ""

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
        central.connect(p)
        append("connect \(p.identifier.uuidString)")
    }

    func disconnect() {
        if let p = connected { central.cancelPeripheralConnection(p) }
    }

    func discover() {
        guard let p = connected else { return }
        let su = CBUUID(string: serviceUUIDString)
        p.discoverServices([su])
        append("discover service \(serviceUUIDString)")
    }

    func write(hex: String) {
        guard let p = connected, let c = txChar else { return }
        let data = Data(hexString: hex)
        guard data.count > 0 else { return }
        p.writeValue(data, for: c, type: .withoutResponse)
        append("write \(hex)")
    }

    private func append(_ s: String) { logs.append(s) }
}

extension BLEManager: CBCentralManagerDelegate, CBPeripheralDelegate {
    func centralManagerDidUpdateState(_ central: CBCentralManager) {
        if central.state == .poweredOn { append("poweredOn") } else { append("state \(central.state.rawValue)") }
    }

    func centralManager(_ central: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String : Any], rssi RSSI: NSNumber) {
        if !devices.contains(where: { $0.identifier == peripheral.identifier }) { devices.append(peripheral) }
    }

    func centralManager(_ central: CBCentralManager, didConnect peripheral: CBPeripheral) {
        connected = peripheral
        peripheral.delegate = self
        append("connected")
    }

    func centralManager(_ central: CBCentralManager, didDisconnectPeripheral peripheral: CBPeripheral, error: Error?) {
        append("disconnected")
        if connected?.identifier == peripheral.identifier { connected = nil }
    }

    func peripheral(_ peripheral: CBPeripheral, didDiscoverServices error: Error?) {
        let su = CBUUID(string: serviceUUIDString)
        guard let services = peripheral.services else { return }
        for s in services where s.uuid == su { peripheral.discoverCharacteristics(nil, for: s) }
    }

    func peripheral(_ peripheral: CBPeripheral, didDiscoverCharacteristicsFor service: CBService, error: Error?) {
        let tx = CBUUID(string: txUUIDString)
        let rx = CBUUID(string: rxUUIDString)
        service.characteristics?.forEach { ch in
            if ch.uuid == tx { txChar = ch }
            if ch.uuid == rx { rxChar = ch; peripheral.setNotifyValue(true, for: ch) }
        }
        append("chars ready")
    }

    func peripheral(_ peripheral: CBPeripheral, didUpdateValueFor characteristic: CBCharacteristic, error: Error?) {
        guard let v = characteristic.value else { return }
        append("notify \(v.hexString())")
    }
}

private extension Data {
    init(hexString: String) {
        let clean = hexString.replacingOccurrences(of: " ", with: "").replacingOccurrences(of: "0x", with: "").replacingOccurrences(of: ",", with: "")
        var bytes: [UInt8] = []
        var i = clean.startIndex
        while i < clean.endIndex {
            let j = clean.index(i, offsetBy: 2, limitedBy: clean.endIndex) ?? clean.endIndex
            let b = String(clean[i..<j])
            if let v = UInt8(b, radix: 16) { bytes.append(v) }
            i = j
        }
        self.init(bytes)
    }
    func hexString() -> String {
        map { String(format: "%02X", $0) }.joined()
    }
}
