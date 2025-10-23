package com.pauldemarco.flutter_blue;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import com.google.protobuf.ByteString;
import com.pauldemarco.flutter_blue.Protos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.UByte;
/* loaded from: classes.dex */
public class ProtoMaker {
    private static final UUID CCCD_UUID = UUID.fromString("000002902-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Protos.ScanResult from(BluetoothDevice bluetoothDevice, byte[] bArr, int i) {
        Protos.ScanResult.Builder newBuilder = Protos.ScanResult.newBuilder();
        newBuilder.setDevice(from(bluetoothDevice));
        if (bArr != null && bArr.length > 0) {
            newBuilder.setManufacturerData(ByteString.copyFrom(getManufacturer(bArr)));
        }
        newBuilder.setRssi(i);
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Protos.ScanResult from(BluetoothDevice bluetoothDevice, ScanResult scanResult) {
        Protos.ScanResult.Builder newBuilder = Protos.ScanResult.newBuilder();
        newBuilder.setDevice(from(bluetoothDevice));
        ScanRecord scanRecord = scanResult.getScanRecord();
        newBuilder.setRssi(scanResult.getRssi());
        newBuilder.setManufacturerData(ByteString.copyFrom(getManufacturer(scanRecord.getBytes())));
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Protos.BluetoothDevice from(BluetoothDevice bluetoothDevice) {
        Protos.BluetoothDevice.Builder newBuilder = Protos.BluetoothDevice.newBuilder();
        newBuilder.setRemoteId(bluetoothDevice.getAddress());
        String name = bluetoothDevice.getName();
        if (name != null) {
            newBuilder.setName(name);
        }
        int type = bluetoothDevice.getType();
        if (type == 1) {
            newBuilder.setType(Protos.BluetoothDevice.Type.CLASSIC);
        } else if (type == 2) {
            newBuilder.setType(Protos.BluetoothDevice.Type.LE);
        } else if (type == 3) {
            newBuilder.setType(Protos.BluetoothDevice.Type.DUAL);
        } else {
            newBuilder.setType(Protos.BluetoothDevice.Type.UNKNOWN);
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Protos.BluetoothService from(BluetoothDevice bluetoothDevice, BluetoothGattService bluetoothGattService, BluetoothGatt bluetoothGatt) {
        Protos.BluetoothService.Builder newBuilder = Protos.BluetoothService.newBuilder();
        newBuilder.setRemoteId(bluetoothDevice.getAddress());
        newBuilder.setUuid(bluetoothGattService.getUuid().toString());
        newBuilder.setIsPrimary(bluetoothGattService.getType() == 0);
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            newBuilder.addCharacteristics(from(bluetoothDevice, bluetoothGattCharacteristic, bluetoothGatt));
        }
        for (BluetoothGattService bluetoothGattService2 : bluetoothGattService.getIncludedServices()) {
            newBuilder.addIncludedServices(from(bluetoothDevice, bluetoothGattService2, bluetoothGatt));
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Protos.BluetoothCharacteristic from(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, BluetoothGatt bluetoothGatt) {
        Protos.BluetoothCharacteristic.Builder newBuilder = Protos.BluetoothCharacteristic.newBuilder();
        newBuilder.setRemoteId(bluetoothDevice.getAddress());
        newBuilder.setUuid(bluetoothGattCharacteristic.getUuid().toString());
        newBuilder.setProperties(from(bluetoothGattCharacteristic.getProperties()));
        if (bluetoothGattCharacteristic.getValue() != null) {
            newBuilder.setValue(ByteString.copyFrom(bluetoothGattCharacteristic.getValue()));
        }
        for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
            newBuilder.addDescriptors(from(bluetoothDevice, bluetoothGattDescriptor));
        }
        if (bluetoothGattCharacteristic.getService().getType() == 0) {
            newBuilder.setServiceUuid(bluetoothGattCharacteristic.getService().getUuid().toString());
        } else {
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                Iterator<BluetoothGattService> it = bluetoothGattService.getIncludedServices().iterator();
                while (true) {
                    if (it.hasNext()) {
                        BluetoothGattService next = it.next();
                        if (next.getUuid().equals(bluetoothGattCharacteristic.getService().getUuid())) {
                            newBuilder.setServiceUuid(bluetoothGattService.getUuid().toString());
                            newBuilder.setSecondaryServiceUuid(next.getUuid().toString());
                            break;
                        }
                    }
                }
            }
        }
        return newBuilder.build();
    }

    static Protos.BluetoothDescriptor from(BluetoothDevice bluetoothDevice, BluetoothGattDescriptor bluetoothGattDescriptor) {
        Protos.BluetoothDescriptor.Builder newBuilder = Protos.BluetoothDescriptor.newBuilder();
        newBuilder.setRemoteId(bluetoothDevice.getAddress());
        newBuilder.setUuid(bluetoothGattDescriptor.getUuid().toString());
        newBuilder.setCharacteristicUuid(bluetoothGattDescriptor.getCharacteristic().getUuid().toString());
        newBuilder.setServiceUuid(bluetoothGattDescriptor.getCharacteristic().getService().getUuid().toString());
        if (bluetoothGattDescriptor.getValue() != null) {
            newBuilder.setValue(ByteString.copyFrom(bluetoothGattDescriptor.getValue()));
        }
        return newBuilder.build();
    }

    static Protos.CharacteristicProperties from(int i) {
        return Protos.CharacteristicProperties.newBuilder().setBroadcast((i & 1) != 0).setRead((i & 2) != 0).setWriteWithoutResponse((i & 4) != 0).setWrite((i & 8) != 0).setNotify((i & 16) != 0).setIndicate((i & 32) != 0).setAuthenticatedSignedWrites((i & 64) != 0).setExtendedProperties((i & 128) != 0).setNotifyEncryptionRequired((i & 256) != 0).setIndicateEncryptionRequired((i & 512) != 0).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Protos.DeviceStateResponse from(BluetoothDevice bluetoothDevice, int i) {
        Protos.DeviceStateResponse.Builder newBuilder = Protos.DeviceStateResponse.newBuilder();
        if (i == 0) {
            newBuilder.setState(Protos.DeviceStateResponse.BluetoothDeviceState.DISCONNECTED);
        } else if (i == 1) {
            newBuilder.setState(Protos.DeviceStateResponse.BluetoothDeviceState.CONNECTING);
        } else if (i == 2) {
            newBuilder.setState(Protos.DeviceStateResponse.BluetoothDeviceState.CONNECTED);
        } else if (i == 3) {
            newBuilder.setState(Protos.DeviceStateResponse.BluetoothDeviceState.DISCONNECTING);
        }
        newBuilder.setRemoteId(bluetoothDevice.getAddress());
        return newBuilder.build();
    }

    private static byte[] getManufacturer(byte[] bArr) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && (i = bArr[i2]) > 0) {
            if ((bArr[i2 + 1] & UByte.MAX_VALUE) == 255) {
                int i4 = i - 1;
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2 + 2, bArr2, 0, i4);
                arrayList.add(bArr2);
                i3 += i4;
            }
            i2 += i + 1;
        }
        byte[] bArr3 = new byte[i3];
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            int i7 = 0;
            while (i7 < ((byte[]) arrayList.get(i6)).length) {
                bArr3[i5] = ((byte[]) arrayList.get(i6))[i7];
                i7++;
                i5++;
            }
        }
        return bArr3;
    }
}
