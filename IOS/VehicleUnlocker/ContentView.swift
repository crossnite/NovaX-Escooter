import SwiftUI
import CoreBluetooth
import UIKit

struct ContentView: View {
    @StateObject var ble = BLEManager()
    @State var scanningFilter = ""

    var body: some View {
        NavigationView {
            ScrollView {
                VStack(spacing: UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20) {
                    // Header Section
                    VStack(alignment: .leading, spacing: 8) {
                        Text("Vehicle Control")
                            .font(.system(size: UIDevice.current.userInterfaceIdiom == .pad ? 40 : 34))
                            .fontWeight(.bold)
                        Text("Connect and control your vehicle")
                            .font(.system(size: UIDevice.current.userInterfaceIdiom == .pad ? 20 : 17))
                            .foregroundColor(.secondary)
                    }
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.horizontal, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)

                    // Device Scanning Section
                    VStack(spacing: 16) {
                        HStack {
                            TextField("Service UUID Filter (Optional)", text: $scanningFilter)
                                .textFieldStyle(.roundedBorder)
                                .autocorrectionDisabled(true)
                                .textInputAutocapitalization(.never)

                            Button(ble.isScanning ? "Stop" : "Scan") {
                                if ble.isScanning {
                                    ble.stopScan()
                                } else {
                                    ble.startScan(serviceFilter: scanningFilter.isEmpty ? nil : scanningFilter)
                                }
                            }
                            .buttonStyle(.borderedProminent)
                            .frame(width: 80)
                        }
                        .padding(.horizontal, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)

                        if ble.devices.isEmpty {
                            EmptyStateView(
                                icon: "antenna.radiowaves.left.and.right",
                                title: "No Devices Found",
                                description: "Tap Scan to search for nearby Bluetooth devices"
                            )
                        } else {
                            LazyVGrid(columns: [GridItem(.adaptive(minimum: UIDevice.current.userInterfaceIdiom == .pad ? 400 : 300))], spacing: 16) {
                                ForEach(ble.devices, id: \.identifier) { device in
                                    DeviceCard(device: device, rssi: ble.rssiMap[device.identifier] ?? 0, bleManager: ble)
                                }
                            }
                            .padding(.horizontal, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)
                        }
                    }

                    // Connection Status Section
                    if let connected = ble.connected {
                        ConnectionCard(device: connected, bleManager: ble)
                    } else {
                        EmptyStateView(
                            icon: "link",
                            title: "Not Connected",
                            description: "Connect to a device to control your vehicle"
                        )
                    }

                    // Actions Section
                    if ble.isConnected {
                        ActionsCard(bleManager: ble)
                    }

                    // Logs Section
                    if !ble.logs.isEmpty {
                        LogsCard(logs: ble.logs, clearLogs: { ble.clearLogs() })
                    }

                    Spacer()
                }
                .padding(.vertical, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)
            }
            .background(Color(.systemGroupedBackground))
            .navigationTitle("")
            .toolbar {
                ToolbarItem(placement: .principal) {
                    Text("Vehicle Control")
                        .font(.headline)
                }
            }
        }
        .navigationViewStyle(.stack)
    }
}

struct DeviceCard: View {
    let device: CBPeripheral
    let rssi: Int
    let bleManager: BLEManager

    var body: some View {
        VStack(alignment: .leading, spacing: 12) {
            HStack {
                VStack(alignment: .leading, spacing: 4) {
                    Text(device.name ?? "Unknown Device")
                        .font(.headline)
                        .lineLimit(1)
                    Text(device.identifier.uuidString.prefix(8) + "...")
                        .font(.caption)
                        .foregroundColor(.secondary)
                }
                Spacer()
                Text("RSSI: \(rssi)")
                    .font(.caption2)
                    .foregroundColor(.secondary)
            }

            Button("Connect") {
                bleManager.connect(device)
            }
            .buttonStyle(.bordered)
            .frame(maxWidth: .infinity)
        }
        .padding()
        .background(Color(.secondarySystemGroupedBackground))
        .cornerRadius(12)
        .shadow(color: Color.black.opacity(0.1), radius: 2, x: 0, y: 1)
    }
}

struct ConnectionCard: View {
    let device: CBPeripheral
    let bleManager: BLEManager

    var body: some View {
        VStack(spacing: 16) {
            HStack {
                Image(systemName: "checkmark.circle.fill")
                    .foregroundColor(.green)
                    .font(.title2)
                VStack(alignment: .leading, spacing: 4) {
                    Text("Connected")
                        .font(.headline)
                    Text(device.name ?? "Unknown Device")
                        .font(.subheadline)
                        .foregroundColor(.secondary)
                }
                Spacer()
            }

            HStack(spacing: 12) {
                Button("Discover Services") {
                    bleManager.discover()
                }
                .buttonStyle(.bordered)

                Button("Enable Notifications") {
                    bleManager.enableAllNotifications()
                }
                .buttonStyle(.bordered)

                Button("Disconnect") {
                    bleManager.disconnect()
                }
                .buttonStyle(.bordered)
                .foregroundColor(.red)
            }
        }
        .padding()
        .background(Color(.secondarySystemGroupedBackground))
        .cornerRadius(12)
        .shadow(color: Color.black.opacity(0.1), radius: 2, x: 0, y: 1)
        .padding(.horizontal, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)
    }
}

struct ActionsCard: View {
    let bleManager: BLEManager

    var body: some View {
        VStack(spacing: 16) {
            Text("Vehicle Actions")
                .font(.headline)

            HStack(spacing: 16) {
                Button("Unlock") {
                    bleManager.send(action: "Unlock")
                }
                .buttonStyle(.borderedProminent)
                .frame(maxWidth: .infinity)

                Button("Lock") {
                    bleManager.send(action: "Lock")
                }
                .buttonStyle(.bordered)
                .frame(maxWidth: .infinity)
            }
        }
        .padding()
        .background(Color(.secondarySystemGroupedBackground))
        .cornerRadius(12)
        .shadow(color: Color.black.opacity(0.1), radius: 2, x: 0, y: 1)
        .padding(.horizontal, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)
    }
}

struct LogsCard: View {
    let logs: [String]
    let clearLogs: () -> Void

    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            HStack {
                Text("Activity Logs")
                    .font(.headline)
                Spacer()
                Button("Clear") {
                    clearLogs()
                }
                .buttonStyle(.bordered)
                .foregroundColor(.red)
            }

            ScrollView {
                VStack(alignment: .leading, spacing: 8) {
                    ForEach(logs.indices, id: \.self) { index in
                        Text(logs[index])
                            .font(.caption)
                            .foregroundColor(.secondary)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .padding(.vertical, 4)
                            .padding(.horizontal, 8)
                            .background(Color(.tertiarySystemGroupedBackground))
                            .cornerRadius(6)
                    }
                }
            }
            .frame(height: 150)
        }
        .padding()
        .background(Color(.secondarySystemGroupedBackground))
        .cornerRadius(12)
        .shadow(color: Color.black.opacity(0.1), radius: 2, x: 0, y: 1)
        .padding(.horizontal, UIDevice.current.userInterfaceIdiom == .pad ? 32 : 20)
    }
}

struct EmptyStateView: View {
    let icon: String
    let title: String
    let description: String

    var body: some View {
        VStack(spacing: 12) {
            Image(systemName: icon)
                .font(.system(size: 48))
                .foregroundColor(.secondary)
            Text(title)
                .font(.headline)
                .foregroundColor(.primary)
            Text(description)
                .font(.subheadline)
                .foregroundColor(.secondary)
                .multilineTextAlignment(.center)
        }
        .frame(maxWidth: .infinity)
        .padding(.vertical, 40)
    }
}

