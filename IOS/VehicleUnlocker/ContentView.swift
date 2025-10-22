import SwiftUI

struct ContentView: View {
    @StateObject var ble = BLEManager()
    @State var hex = ""
    @State var serviceFilter = ""

    var body: some View {
        NavigationView {
            List {
                Section("Setup") {
                    VStack(alignment: .leading, spacing: 8) {
                        TextField("Service UUID", text: $ble.serviceUUIDString)
                            .textFieldStyle(.roundedBorder)
                        TextField("TX Characteristic UUID", text: $ble.txUUIDString)
                            .textFieldStyle(.roundedBorder)
                        TextField("RX Characteristic UUID", text: $ble.rxUUIDString)
                            .textFieldStyle(.roundedBorder)
                    }
                    HStack {
                        TextField("Optional: Scan filter service UUID", text: $serviceFilter)
                            .textFieldStyle(.roundedBorder)
                        Button(ble.isScanning ? "Stop" : "Scan") {
                            if ble.isScanning { ble.stopScan() } else { ble.startScan(serviceFilter: serviceFilter) }
                        }.buttonStyle(.borderedProminent)
                    }
                }

                Section("Devices") {
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
                                Button("Discover Service") { ble.discover() }
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

                Section("Send Hex") {
                    HStack {
                        TextField("e.g. A1B20304", text: $hex)
                            .textFieldStyle(.roundedBorder)
                        Button("Send") { ble.write(hex: hex) }
                            .buttonStyle(.bordered)
                    }
                    .disabled(!ble.isConnected)
                }

                Section("Logs") {
                    HStack {
                        Button("Clear Logs") { ble.clearLogs() }
                            .buttonStyle(.bordered)
                        Spacer()
                        Text("\(ble.logs.count) entries")
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

