import SwiftUI

struct ContentView: View {
    @StateObject var ble = BLEManager()
    @State var hex = ""

    var body: some View {
        NavigationView {
            VStack(spacing: 12) {
                HStack {
                    TextField("Service UUID", text: $ble.serviceUUIDString).textFieldStyle(.roundedBorder)
                }
                HStack {
                    TextField("TX Characteristic UUID", text: $ble.txUUIDString).textFieldStyle(.roundedBorder)
                }
                HStack {
                    TextField("RX Characteristic UUID", text: $ble.rxUUIDString).textFieldStyle(.roundedBorder)
                }
                HStack {
                    Button(ble.isScanning ? "Stop Scan" : "Start Scan") { ble.isScanning ? ble.stopScan() : ble.startScan() }.buttonStyle(.borderedProminent)
                    Button("Discover") { ble.discover() }.disabled(ble.connected == nil)
                }
                List {
                    Section("Devices") {
                        ForEach(ble.devices, id: \.identifier) { p in
                            HStack {
                                Text(p.name ?? "Unknown")
                                Spacer()
                                Button("Connect") { ble.connect(p) }
                            }
                        }
                    }
                    Section("Connected") {
                        Text(ble.connected?.name ?? "None")
                    }
                    Section("Send Hex") {
                        HStack {
                            TextField("e.g. A1B20304", text: $hex).textFieldStyle(.roundedBorder)
                            Button("Send") { ble.write(hex: hex) }
                        }
                    }
                    Section("Logs") {
                        ForEach(ble.logs.indices, id: \.self) { i in
                            Text(ble.logs[i])
                                .font(.footnote)
                        }
                    }
                }
            }.padding().navigationTitle("Vehicle Unlocker")
        }
    }
}

