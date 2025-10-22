import SwiftUI
import CoreBluetooth

struct ContentView: View {
    @StateObject var ble = BLEManager()
    @State var scanningFilter = ""

    var body: some View {
        NavigationView {
            List {
                Section("Target") {
                    TextField("Auto-connect name contains", text: $ble.targetNameContains)
                        .textFieldStyle(.roundedBorder)
                        .autocorrectionDisabled(true)
                        .textInputAutocapitalization(.never)
                }
                Section("Devices") {
                    HStack {
                        TextField("Optional scan filter (Service UUID)", text: $scanningFilter)
                            .textFieldStyle(.roundedBorder)
                        Button(ble.isScanning ? "Stop" : "Scan") {
                            if ble.isScanning { ble.stopScan() } else { ble.startScan(serviceFilter: scanningFilter) }
                        }
                        .buttonStyle(.borderedProminent)
                    }
                    if ble.devices.isEmpty {
                        Text("No devices yet. Tap Scan.")
                            .foregroundColor(.secondary)
                    }
                    ForEach(ble.devices, id: \.identifier) { p in
                        HStack {
                            VStack(alignment: .leading, spacing: 4) {
                                Text(p.name ?? "Unknown")
                                    .font(.headline)
                                Text(p.identifier.uuidString.prefix(8) + "…")
                                    .font(.caption)
                                    .foregroundColor(.secondary)
                            }
                            Spacer()
                            Text("RSSI \(ble.rssiMap[p.identifier] ?? 0)")
                                .font(.caption)
                                .foregroundColor(.secondary)
                            Button("Connect") { ble.connect(p) }
                                .buttonStyle(.bordered)
                        }
                    }
                }

                Section("Connected") {
                    if let c = ble.connected {
                        VStack(alignment: .leading, spacing: 8) {
                            Text(c.name ?? "Unknown")
                                .font(.headline)
                            Text(c.identifier.uuidString)
                                .font(.caption)
                                .foregroundColor(.secondary)
                            HStack {
                                Button("Discover Service(s)") { ble.discover() }
                                    .buttonStyle(.borderedProminent)
                                Button("Enable Notifications") { ble.enableAllNotifications() }
                                    .buttonStyle(.bordered)
                                Button("Disconnect") { ble.disconnect() }
                                    .buttonStyle(.bordered)
                            }
                        }
                    } else {
                        Text("Not connected")
                            .foregroundColor(.secondary)
                    }
                }

                Section("Characteristics") {
                    if ble.discoveredCharacteristics.isEmpty {
                        Text("Run Discover to list characteristics.")
                            .foregroundColor(.secondary)
                    } else {
                        ForEach(ble.discoveredCharacteristics, id: \.uuid.uuidString) { ch in
                            HStack {
                                VStack(alignment: .leading) {
                                    Text(ch.uuid.uuidString).font(.footnote)
                                    Text(propsString(ch.properties))
                                        .font(.caption2).foregroundColor(.secondary)
                                }
                                Spacer()
                                Button("Set TX") { ble.setTX(uuid: ch.uuid.uuidString) }
                                    .buttonStyle(.bordered)
                                Button("Set RX") { ble.setRX(uuid: ch.uuid.uuidString) }
                                    .buttonStyle(.bordered)
                            }
                        }
                        if !ble.selectedTXUUID.isEmpty || !ble.selectedRXUUID.isEmpty {
                            VStack(alignment: .leading, spacing: 4) {
                                if !ble.selectedTXUUID.isEmpty { Text("TX: \(ble.selectedTXUUID)").font(.caption) }
                                if !ble.selectedRXUUID.isEmpty { Text("RX: \(ble.selectedRXUUID)").font(.caption) }
                            }
                        }
                    }
                }

                Section("Actions") {
                    if !ble.isConnected {
                        Text("Connect to a device to use actions.")
                            .foregroundColor(.secondary)
                    }
                    VStack(spacing: 12) {
                        HStack {
                            Button("Unlock") { ble.send(action: "Unlock") }
                                .buttonStyle(.borderedProminent)
                                .disabled(!ble.isConnected)
                            Button("Lock") { ble.send(action: "Lock") }
                                .buttonStyle(.bordered)
                                .disabled(!ble.isConnected)
                        }
                        HStack {
                            Button("Lights On") { ble.send(action: "LightsOn") }
                                .buttonStyle(.bordered)
                                .disabled(!ble.isConnected)
                            Button("Lights Off") { ble.send(action: "LightsOff") }
                                .buttonStyle(.bordered)
                                .disabled(!ble.isConnected)
                        }
                        HStack {
                            Button("Horn") { ble.send(action: "Horn") }
                                .buttonStyle(.bordered)
                                .disabled(!ble.isConnected)
                            Button("Ping") { ble.send(action: "Ping") }
                                .buttonStyle(.bordered)
                                .disabled(!ble.isConnected)
                        }
                    }
                }

                Section("Logs") {
                    HStack {
                        Button("Clear Logs") { ble.clearLogs() }
                            .buttonStyle(.bordered)
                        Spacer()
                        Text("\\(ble.logs.count) entries")
                            .font(.caption)
                            .foregroundColor(.secondary)
                    }
                    ForEach(ble.logs.indices, id: \.self) { i in
                        Text(ble.logs[i])
                            .font(.footnote)
                            .textSelection(.enabled)
                    }
                }
            }
            .listStyle(.insetGrouped)
            .navigationTitle("Vehicle Unlocker")
        }
    }
}

private func propsString(_ p: CBCharacteristicProperties) -> String {
    var parts: [String] = []
    if p.contains(.read) { parts.append("read") }
    if p.contains(.write) { parts.append("write") }
    if p.contains(.writeWithoutResponse) { parts.append("writeNR") }
    if p.contains(.notify) { parts.append("notify") }
    if p.contains(.indicate) { parts.append("indicate") }
    if p.contains(.broadcast) { parts.append("broadcast") }
    if p.contains(.authenticatedSignedWrites) { parts.append("signed") }
    if p.contains(.extendedProperties) { parts.append("extended") }
    return parts.joined(separator: ", ")
}

