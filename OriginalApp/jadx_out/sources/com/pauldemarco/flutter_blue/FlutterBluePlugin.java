package com.pauldemarco.flutter_blue;

import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.Log;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.pauldemarco.flutter_blue.Protos;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public class FlutterBluePlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static final UUID CCCD_ID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private static final String NAMESPACE = "plugins.pauldemarco.com/flutter_blue";
    private static final String TAG = "FlutterBluePlugin";
    private Activity activity;
    private ActivityPluginBinding activityBinding;
    private Application application;
    private MethodChannel channel;
    private Context context;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothManager mBluetoothManager;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private BluetoothAdapter.LeScanCallback scanCallback18;
    private ScanCallback scanCallback21;
    private EventChannel stateChannel;
    private Object initializationLock = new Object();
    private final Map<String, BluetoothDeviceCache> mDevices = new HashMap();
    private LogLevel logLevel = LogLevel.EMERGENCY;
    private ArrayList<String> macDeviceScanned = new ArrayList<>();
    private boolean allowDuplicates = false;
    private final EventChannel.StreamHandler stateHandler = new EventChannel.StreamHandler() { // from class: com.pauldemarco.flutter_blue.FlutterBluePlugin.1
        private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.pauldemarco.flutter_blue.FlutterBluePlugin.1.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                    switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
                        case 10:
                            AnonymousClass1.this.sink.success(Protos.BluetoothState.newBuilder().setState(Protos.BluetoothState.State.OFF).build().toByteArray());
                            return;
                        case 11:
                            AnonymousClass1.this.sink.success(Protos.BluetoothState.newBuilder().setState(Protos.BluetoothState.State.TURNING_ON).build().toByteArray());
                            return;
                        case 12:
                            AnonymousClass1.this.sink.success(Protos.BluetoothState.newBuilder().setState(Protos.BluetoothState.State.ON).build().toByteArray());
                            return;
                        case 13:
                            AnonymousClass1.this.sink.success(Protos.BluetoothState.newBuilder().setState(Protos.BluetoothState.State.TURNING_OFF).build().toByteArray());
                            return;
                        default:
                            return;
                    }
                }
            }
        };
        private EventChannel.EventSink sink;

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            this.sink = eventSink;
            FlutterBluePlugin.this.context.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(Object obj) {
            this.sink = null;
            FlutterBluePlugin.this.context.unregisterReceiver(this.mReceiver);
        }
    };
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.pauldemarco.flutter_blue.FlutterBluePlugin.3
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onConnectionStateChange] status: " + i + " newState: " + i2);
            if (i2 == 0 && !FlutterBluePlugin.this.mDevices.containsKey(bluetoothGatt.getDevice().getAddress())) {
                bluetoothGatt.close();
            }
            BluetoothDeviceCache bluetoothDeviceCache = (BluetoothDeviceCache) FlutterBluePlugin.this.mDevices.get(bluetoothGatt.getDevice().getAddress());
            if (bluetoothDeviceCache != null) {
                bluetoothDeviceCache.state = i2;
            }
            FlutterBluePlugin.this.invokeMethodUIThread("DeviceState", ProtoMaker.from(bluetoothGatt.getDevice(), i2).toByteArray());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onServicesDiscovered] count: " + bluetoothGatt.getServices().size() + " status: " + i);
            Protos.DiscoverServicesResult.Builder newBuilder = Protos.DiscoverServicesResult.newBuilder();
            newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                newBuilder.addServices(ProtoMaker.from(bluetoothGatt.getDevice(), bluetoothGattService, bluetoothGatt));
            }
            FlutterBluePlugin.this.invokeMethodUIThread("DiscoverServicesResult", newBuilder.build().toByteArray());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onCharacteristicRead] uuid: " + bluetoothGattCharacteristic.getUuid().toString() + " status: " + i);
            Protos.ReadCharacteristicResponse.Builder newBuilder = Protos.ReadCharacteristicResponse.newBuilder();
            newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
            newBuilder.setCharacteristic(ProtoMaker.from(bluetoothGatt.getDevice(), bluetoothGattCharacteristic, bluetoothGatt));
            FlutterBluePlugin.this.invokeMethodUIThread("ReadCharacteristicResponse", newBuilder.build().toByteArray());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onCharacteristicWrite] uuid: " + bluetoothGattCharacteristic.getUuid().toString() + " status: " + i);
            Protos.WriteCharacteristicRequest.Builder newBuilder = Protos.WriteCharacteristicRequest.newBuilder();
            newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
            newBuilder.setCharacteristicUuid(bluetoothGattCharacteristic.getUuid().toString());
            newBuilder.setServiceUuid(bluetoothGattCharacteristic.getService().getUuid().toString());
            Protos.WriteCharacteristicResponse.Builder newBuilder2 = Protos.WriteCharacteristicResponse.newBuilder();
            newBuilder2.setRequest(newBuilder);
            newBuilder2.setSuccess(i == 0);
            FlutterBluePlugin.this.invokeMethodUIThread("WriteCharacteristicResponse", newBuilder2.build().toByteArray());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onCharacteristicChanged] uuid: " + bluetoothGattCharacteristic.getUuid().toString());
            Protos.OnCharacteristicChanged.Builder newBuilder = Protos.OnCharacteristicChanged.newBuilder();
            newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
            newBuilder.setCharacteristic(ProtoMaker.from(bluetoothGatt.getDevice(), bluetoothGattCharacteristic, bluetoothGatt));
            FlutterBluePlugin.this.invokeMethodUIThread("OnCharacteristicChanged", newBuilder.build().toByteArray());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onDescriptorRead] uuid: " + bluetoothGattDescriptor.getUuid().toString() + " status: " + i);
            Protos.ReadDescriptorRequest.Builder newBuilder = Protos.ReadDescriptorRequest.newBuilder();
            newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
            newBuilder.setCharacteristicUuid(bluetoothGattDescriptor.getCharacteristic().getUuid().toString());
            newBuilder.setDescriptorUuid(bluetoothGattDescriptor.getUuid().toString());
            if (bluetoothGattDescriptor.getCharacteristic().getService().getType() == 0) {
                newBuilder.setServiceUuid(bluetoothGattDescriptor.getCharacteristic().getService().getUuid().toString());
            } else {
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    Iterator<BluetoothGattService> it = bluetoothGattService.getIncludedServices().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            BluetoothGattService next = it.next();
                            if (next.getUuid().equals(bluetoothGattDescriptor.getCharacteristic().getService().getUuid())) {
                                newBuilder.setServiceUuid(bluetoothGattService.getUuid().toString());
                                newBuilder.setSecondaryServiceUuid(next.getUuid().toString());
                                break;
                            }
                        }
                    }
                }
            }
            Protos.ReadDescriptorResponse.Builder newBuilder2 = Protos.ReadDescriptorResponse.newBuilder();
            newBuilder2.setRequest(newBuilder);
            newBuilder2.setValue(ByteString.copyFrom(bluetoothGattDescriptor.getValue()));
            FlutterBluePlugin.this.invokeMethodUIThread("ReadDescriptorResponse", newBuilder2.build().toByteArray());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onDescriptorWrite] uuid: " + bluetoothGattDescriptor.getUuid().toString() + " status: " + i);
            Protos.WriteDescriptorRequest.Builder newBuilder = Protos.WriteDescriptorRequest.newBuilder();
            newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
            newBuilder.setDescriptorUuid(bluetoothGattDescriptor.getUuid().toString());
            newBuilder.setCharacteristicUuid(bluetoothGattDescriptor.getCharacteristic().getUuid().toString());
            newBuilder.setServiceUuid(bluetoothGattDescriptor.getCharacteristic().getService().getUuid().toString());
            Protos.WriteDescriptorResponse.Builder newBuilder2 = Protos.WriteDescriptorResponse.newBuilder();
            newBuilder2.setRequest(newBuilder);
            newBuilder2.setSuccess(i == 0);
            FlutterBluePlugin.this.invokeMethodUIThread("WriteDescriptorResponse", newBuilder2.build().toByteArray());
            if (bluetoothGattDescriptor.getUuid().compareTo(FlutterBluePlugin.CCCD_ID) == 0) {
                Protos.SetNotificationResponse.Builder newBuilder3 = Protos.SetNotificationResponse.newBuilder();
                newBuilder3.setRemoteId(bluetoothGatt.getDevice().getAddress());
                newBuilder3.setCharacteristic(ProtoMaker.from(bluetoothGatt.getDevice(), bluetoothGattDescriptor.getCharacteristic(), bluetoothGatt));
                FlutterBluePlugin.this.invokeMethodUIThread("SetNotificationResponse", newBuilder3.build().toByteArray());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onReliableWriteCompleted] status: " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onReadRemoteRssi] rssi: " + i + " status: " + i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            FlutterBluePlugin flutterBluePlugin = FlutterBluePlugin.this;
            LogLevel logLevel = LogLevel.DEBUG;
            flutterBluePlugin.log(logLevel, "[onMtuChanged] mtu: " + i + " status: " + i2);
            if (i2 == 0 && FlutterBluePlugin.this.mDevices.containsKey(bluetoothGatt.getDevice().getAddress())) {
                ((BluetoothDeviceCache) FlutterBluePlugin.this.mDevices.get(bluetoothGatt.getDevice().getAddress())).mtu = i;
                Protos.MtuSizeResponse.Builder newBuilder = Protos.MtuSizeResponse.newBuilder();
                newBuilder.setRemoteId(bluetoothGatt.getDevice().getAddress());
                newBuilder.setMtu(i);
                FlutterBluePlugin.this.invokeMethodUIThread("MtuSize", newBuilder.build().toByteArray());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum LogLevel {
        EMERGENCY,
        ALERT,
        CRITICAL,
        ERROR,
        WARNING,
        NOTICE,
        INFO,
        DEBUG
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new FlutterBluePlugin().setup(registrar.messenger(), registrar.context() != null ? (Application) registrar.context().getApplicationContext() : null, registrar.activity(), registrar, null);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activityBinding = activityPluginBinding;
        setup(this.pluginBinding.getBinaryMessenger(), (Application) this.pluginBinding.getApplicationContext(), this.activityBinding.getActivity(), null, this.activityBinding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        tearDown();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    private void setup(BinaryMessenger binaryMessenger, Application application, Activity activity, PluginRegistry.Registrar registrar, ActivityPluginBinding activityPluginBinding) {
        synchronized (this.initializationLock) {
            Log.i(TAG, "setup");
            this.activity = activity;
            this.application = application;
            this.context = application;
            MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.pauldemarco.com/flutter_blue/methods");
            this.channel = methodChannel;
            methodChannel.setMethodCallHandler(this);
            EventChannel eventChannel = new EventChannel(binaryMessenger, "plugins.pauldemarco.com/flutter_blue/state");
            this.stateChannel = eventChannel;
            eventChannel.setStreamHandler(this.stateHandler);
            BluetoothManager bluetoothManager = (BluetoothManager) application.getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            this.mBluetoothAdapter = bluetoothManager.getAdapter();
        }
    }

    private void tearDown() {
        Log.i(TAG, "teardown");
        this.context = null;
        this.activityBinding = null;
        this.channel.setMethodCallHandler(null);
        this.channel = null;
        this.stateChannel.setStreamHandler(null);
        this.stateChannel = null;
        this.mBluetoothAdapter = null;
        this.mBluetoothManager = null;
        this.application = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        char c;
        BluetoothGatt connectGatt;
        byte[] bArr;
        if (this.mBluetoothAdapter == null && !"isAvailable".equals(methodCall.method)) {
            result.error("bluetooth_unavailable", "the device does not have bluetooth", null);
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        switch (str.hashCode()) {
            case -2129330689:
                if (str.equals("startScan")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2064454390:
                if (str.equals("getConnectedDevices")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1553974309:
                if (str.equals("deviceState")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1301283666:
                if (str.equals("writeDescriptor")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1162471827:
                if (str.equals("setNotification")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1130630310:
                if (str.equals("writeCharacteristic")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -938333999:
                if (str.equals("readCharacteristic")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -309915358:
                if (str.equals("setLogLevel")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 108462:
                if (str.equals("mtu")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3241129:
                if (str.equals("isOn")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 37093023:
                if (str.equals("requestMtu")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 109757585:
                if (str.equals("state")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 206669221:
                if (str.equals("readDescriptor")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 444517567:
                if (str.equals("isAvailable")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 530405532:
                if (str.equals("disconnect")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 951351530:
                if (str.equals("connect")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1379209310:
                if (str.equals("services")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1614410599:
                if (str.equals("discoverServices")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1714778527:
                if (str.equals("stopScan")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                startScan(methodCall, result);
                return;
            case 1:
                List<BluetoothDevice> connectedDevices = this.mBluetoothManager.getConnectedDevices(7);
                Protos.ConnectedDevicesResponse.Builder newBuilder = Protos.ConnectedDevicesResponse.newBuilder();
                for (BluetoothDevice bluetoothDevice : connectedDevices) {
                    newBuilder.addDevices(ProtoMaker.from(bluetoothDevice));
                }
                result.success(newBuilder.build().toByteArray());
                LogLevel logLevel = LogLevel.EMERGENCY;
                log(logLevel, "mDevices size: " + this.mDevices.size());
                break;
            case 2:
                String str2 = (String) methodCall.arguments;
                BluetoothDeviceCache bluetoothDeviceCache = this.mDevices.get(str2);
                try {
                    result.success(ProtoMaker.from(this.mBluetoothAdapter.getRemoteDevice(str2), bluetoothDeviceCache != null ? bluetoothDeviceCache.state : 0).toByteArray());
                    return;
                } catch (Exception e) {
                    result.error("device_state_error", e.getMessage(), e);
                    return;
                }
            case 3:
                try {
                    Protos.WriteDescriptorRequest build = ((Protos.WriteDescriptorRequest.Builder) Protos.WriteDescriptorRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
                    try {
                        BluetoothGatt locateGatt = locateGatt(build.getRemoteId());
                        BluetoothGattDescriptor locateDescriptor = locateDescriptor(locateCharacteristic(locateGatt, build.getServiceUuid(), build.getSecondaryServiceUuid(), build.getCharacteristicUuid()), build.getDescriptorUuid());
                        if (!locateDescriptor.setValue(build.getValue().toByteArray())) {
                            result.error("write_descriptor_error", "could not set the local value for descriptor", null);
                        }
                        if (!locateGatt.writeDescriptor(locateDescriptor)) {
                            result.error("write_descriptor_error", "writeCharacteristic failed", null);
                            return;
                        } else {
                            result.success(null);
                            return;
                        }
                    } catch (Exception e2) {
                        result.error("write_descriptor_error", e2.getMessage(), null);
                        return;
                    }
                } catch (InvalidProtocolBufferException e3) {
                    result.error("RuntimeException", e3.getMessage(), e3);
                    return;
                }
            case 4:
                try {
                    Protos.SetNotificationRequest build2 = ((Protos.SetNotificationRequest.Builder) Protos.SetNotificationRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
                    try {
                        BluetoothGatt locateGatt2 = locateGatt(build2.getRemoteId());
                        BluetoothGattCharacteristic locateCharacteristic = locateCharacteristic(locateGatt2, build2.getServiceUuid(), build2.getSecondaryServiceUuid(), build2.getCharacteristicUuid());
                        BluetoothGattDescriptor descriptor = locateCharacteristic.getDescriptor(CCCD_ID);
                        if (descriptor == null) {
                            throw new Exception("could not locate CCCD descriptor for characteristic: " + locateCharacteristic.getUuid().toString());
                        }
                        if (build2.getEnable()) {
                            boolean z = (locateCharacteristic.getProperties() & 16) > 0;
                            boolean z2 = (locateCharacteristic.getProperties() & 32) > 0;
                            if (!z2 && !z) {
                                result.error("set_notification_error", "the characteristic cannot notify or indicate", null);
                                return;
                            }
                            bArr = z2 ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : null;
                            if (z) {
                                bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                            }
                        } else {
                            bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                        }
                        if (!locateGatt2.setCharacteristicNotification(locateCharacteristic, build2.getEnable())) {
                            result.error("set_notification_error", "could not set characteristic notifications to :" + build2.getEnable(), null);
                            return;
                        } else if (!descriptor.setValue(bArr)) {
                            result.error("set_notification_error", "error when setting the descriptor value to: " + bArr, null);
                            return;
                        } else if (!locateGatt2.writeDescriptor(descriptor)) {
                            result.error("set_notification_error", "error when writing the descriptor", null);
                            return;
                        } else {
                            result.success(null);
                            return;
                        }
                    } catch (Exception e4) {
                        result.error("set_notification_error", e4.getMessage(), null);
                        return;
                    }
                } catch (InvalidProtocolBufferException e5) {
                    result.error("RuntimeException", e5.getMessage(), e5);
                    return;
                }
            case 5:
                try {
                    Protos.WriteCharacteristicRequest build3 = ((Protos.WriteCharacteristicRequest.Builder) Protos.WriteCharacteristicRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
                    try {
                        BluetoothGatt locateGatt3 = locateGatt(build3.getRemoteId());
                        BluetoothGattCharacteristic locateCharacteristic2 = locateCharacteristic(locateGatt3, build3.getServiceUuid(), build3.getSecondaryServiceUuid(), build3.getCharacteristicUuid());
                        if (!locateCharacteristic2.setValue(build3.getValue().toByteArray())) {
                            result.error("write_characteristic_error", "could not set the local value of characteristic", null);
                        }
                        if (build3.getWriteType() == Protos.WriteCharacteristicRequest.WriteType.WITHOUT_RESPONSE) {
                            locateCharacteristic2.setWriteType(1);
                        } else {
                            locateCharacteristic2.setWriteType(2);
                        }
                        if (!locateGatt3.writeCharacteristic(locateCharacteristic2)) {
                            result.error("write_characteristic_error", "writeCharacteristic failed", null);
                            return;
                        } else {
                            result.success(null);
                            return;
                        }
                    } catch (Exception e6) {
                        result.error("write_characteristic_error", e6.getMessage(), null);
                        return;
                    }
                } catch (InvalidProtocolBufferException e7) {
                    result.error("RuntimeException", e7.getMessage(), e7);
                    return;
                }
            case 6:
                try {
                    Protos.ReadCharacteristicRequest build4 = ((Protos.ReadCharacteristicRequest.Builder) Protos.ReadCharacteristicRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
                    try {
                        BluetoothGatt locateGatt4 = locateGatt(build4.getRemoteId());
                        if (locateGatt4.readCharacteristic(locateCharacteristic(locateGatt4, build4.getServiceUuid(), build4.getSecondaryServiceUuid(), build4.getCharacteristicUuid()))) {
                            result.success(null);
                            return;
                        } else {
                            result.error("read_characteristic_error", "unknown reason, may occur if readCharacteristic was called before last read finished.", null);
                            return;
                        }
                    } catch (Exception e8) {
                        result.error("read_characteristic_error", e8.getMessage(), null);
                        return;
                    }
                } catch (InvalidProtocolBufferException e9) {
                    result.error("RuntimeException", e9.getMessage(), e9);
                    return;
                }
            case 7:
                this.logLevel = LogLevel.values()[((Integer) methodCall.arguments).intValue()];
                result.success(null);
                return;
            case '\b':
                String str3 = (String) methodCall.arguments;
                BluetoothDeviceCache bluetoothDeviceCache2 = this.mDevices.get(str3);
                if (bluetoothDeviceCache2 != null) {
                    Protos.MtuSizeResponse.Builder newBuilder2 = Protos.MtuSizeResponse.newBuilder();
                    newBuilder2.setRemoteId(str3);
                    newBuilder2.setMtu(bluetoothDeviceCache2.mtu);
                    result.success(newBuilder2.build().toByteArray());
                    return;
                }
                result.error("mtu", "no instance of BluetoothGatt, have you connected first?", null);
                return;
            case '\t':
                result.success(Boolean.valueOf(this.mBluetoothAdapter.isEnabled()));
                return;
            case '\n':
                try {
                    Protos.MtuSizeRequest build5 = ((Protos.MtuSizeRequest.Builder) Protos.MtuSizeRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
                    try {
                        BluetoothGatt locateGatt5 = locateGatt(build5.getRemoteId());
                        int mtu = build5.getMtu();
                        if (Build.VERSION.SDK_INT < 21) {
                            result.error("requestMtu", "Only supported on devices >= API 21 (Lollipop). This device == " + Build.VERSION.SDK_INT, null);
                        } else if (locateGatt5.requestMtu(mtu)) {
                            result.success(null);
                        } else {
                            result.error("requestMtu", "gatt.requestMtu returned false", null);
                        }
                        return;
                    } catch (Exception e10) {
                        result.error("requestMtu", e10.getMessage(), e10);
                        return;
                    }
                } catch (InvalidProtocolBufferException e11) {
                    result.error("RuntimeException", e11.getMessage(), e11);
                    return;
                }
            case 11:
                Protos.BluetoothState.Builder newBuilder3 = Protos.BluetoothState.newBuilder();
                try {
                    switch (this.mBluetoothAdapter.getState()) {
                        case 10:
                            newBuilder3.setState(Protos.BluetoothState.State.OFF);
                            break;
                        case 11:
                            newBuilder3.setState(Protos.BluetoothState.State.TURNING_ON);
                            break;
                        case 12:
                            newBuilder3.setState(Protos.BluetoothState.State.ON);
                            break;
                        case 13:
                            newBuilder3.setState(Protos.BluetoothState.State.TURNING_OFF);
                            break;
                        default:
                            newBuilder3.setState(Protos.BluetoothState.State.UNKNOWN);
                            break;
                    }
                } catch (SecurityException unused) {
                    newBuilder3.setState(Protos.BluetoothState.State.UNAUTHORIZED);
                }
                result.success(newBuilder3.build().toByteArray());
                return;
            case '\f':
                try {
                    Protos.ReadDescriptorRequest build6 = ((Protos.ReadDescriptorRequest.Builder) Protos.ReadDescriptorRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
                    try {
                        BluetoothGatt locateGatt6 = locateGatt(build6.getRemoteId());
                        if (locateGatt6.readDescriptor(locateDescriptor(locateCharacteristic(locateGatt6, build6.getServiceUuid(), build6.getSecondaryServiceUuid(), build6.getCharacteristicUuid()), build6.getDescriptorUuid()))) {
                            result.success(null);
                            return;
                        } else {
                            result.error("read_descriptor_error", "unknown reason, may occur if readDescriptor was called before last read finished.", null);
                            return;
                        }
                    } catch (Exception e12) {
                        result.error("read_descriptor_error", e12.getMessage(), null);
                        return;
                    }
                } catch (InvalidProtocolBufferException e13) {
                    result.error("RuntimeException", e13.getMessage(), e13);
                    return;
                }
            case '\r':
                result.success(Boolean.valueOf(this.mBluetoothAdapter != null));
                return;
            case 14:
                String str4 = (String) methodCall.arguments;
                int connectionState = this.mBluetoothManager.getConnectionState(this.mBluetoothAdapter.getRemoteDevice(str4), 7);
                BluetoothDeviceCache remove = this.mDevices.remove(str4);
                if (remove != null) {
                    BluetoothGatt bluetoothGatt = remove.gatt;
                    bluetoothGatt.disconnect();
                    if (connectionState == 0) {
                        bluetoothGatt.close();
                    }
                }
                result.success(null);
                return;
            case 15:
                break;
            case 16:
                String str5 = (String) methodCall.arguments;
                try {
                    BluetoothGatt locateGatt7 = locateGatt(str5);
                    Protos.DiscoverServicesResult.Builder newBuilder4 = Protos.DiscoverServicesResult.newBuilder();
                    newBuilder4.setRemoteId(str5);
                    for (BluetoothGattService bluetoothGattService : locateGatt7.getServices()) {
                        newBuilder4.addServices(ProtoMaker.from(locateGatt7.getDevice(), bluetoothGattService, locateGatt7));
                    }
                    result.success(newBuilder4.build().toByteArray());
                    return;
                } catch (Exception e14) {
                    result.error("get_services_error", e14.getMessage(), e14);
                    return;
                }
            case 17:
                try {
                    if (locateGatt((String) methodCall.arguments).discoverServices()) {
                        result.success(null);
                    } else {
                        result.error("discover_services_error", "unknown reason", null);
                    }
                    return;
                } catch (Exception e15) {
                    result.error("discover_services_error", e15.getMessage(), e15);
                    return;
                }
            case 18:
                stopScan();
                result.success(null);
                return;
            default:
                result.notImplemented();
                return;
        }
        try {
            Protos.ConnectRequest build7 = ((Protos.ConnectRequest.Builder) Protos.ConnectRequest.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
            String remoteId = build7.getRemoteId();
            BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(remoteId);
            boolean contains = this.mBluetoothManager.getConnectedDevices(7).contains(remoteDevice);
            if (this.mDevices.containsKey(remoteId) && contains) {
                result.error("already_connected", "connection with device already exists", null);
            } else if (this.mDevices.containsKey(remoteId) && !contains) {
                if (this.mDevices.get(remoteId).gatt.connect()) {
                    result.success(null);
                } else {
                    result.error("reconnect_error", "error when reconnecting to device", null);
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23) {
                    connectGatt = remoteDevice.connectGatt(this.context, build7.getAndroidAutoConnect(), this.mGattCallback, 2);
                } else {
                    connectGatt = remoteDevice.connectGatt(this.context, build7.getAndroidAutoConnect(), this.mGattCallback);
                }
                this.mDevices.put(remoteId, new BluetoothDeviceCache(connectGatt));
                result.success(null);
            }
        } catch (InvalidProtocolBufferException e16) {
            result.error("RuntimeException", e16.getMessage(), e16);
        }
    }

    private BluetoothGatt locateGatt(String str) throws Exception {
        BluetoothDeviceCache bluetoothDeviceCache = this.mDevices.get(str);
        if (bluetoothDeviceCache == null || bluetoothDeviceCache.gatt == null) {
            throw new Exception("no instance of BluetoothGatt, have you connected first?");
        }
        return bluetoothDeviceCache.gatt;
    }

    private BluetoothGattCharacteristic locateCharacteristic(BluetoothGatt bluetoothGatt, String str, String str2, String str3) throws Exception {
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str));
        if (service == null) {
            throw new Exception("service (" + str + ") could not be located on the device");
        }
        BluetoothGattService bluetoothGattService = null;
        if (str2.length() > 0) {
            for (BluetoothGattService bluetoothGattService2 : service.getIncludedServices()) {
                if (bluetoothGattService2.getUuid().equals(UUID.fromString(str2))) {
                    bluetoothGattService = bluetoothGattService2;
                }
            }
            if (bluetoothGattService == null) {
                throw new Exception("secondary service (" + str2 + ") could not be located on the device");
            }
        }
        if (bluetoothGattService != null) {
            service = bluetoothGattService;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(str3));
        if (characteristic != null) {
            return characteristic;
        }
        throw new Exception("characteristic (" + str3 + ") could not be located in the service (" + service.getUuid().toString() + ")");
    }

    private BluetoothGattDescriptor locateDescriptor(BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) throws Exception {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(str));
        if (descriptor != null) {
            return descriptor;
        }
        throw new Exception("descriptor (" + str + ") could not be located in the characteristic (" + bluetoothGattCharacteristic.getUuid().toString() + ")");
    }

    private void startScan(MethodCall methodCall, MethodChannel.Result result) {
        try {
            Protos.ScanSettings build = ((Protos.ScanSettings.Builder) Protos.ScanSettings.newBuilder().mergeFrom((byte[]) methodCall.arguments())).build();
            this.allowDuplicates = build.getAllowDuplicates();
            this.macDeviceScanned.clear();
            if (Build.VERSION.SDK_INT >= 21) {
                startScan21(build);
            } else {
                startScan18(build);
            }
            result.success(null);
        } catch (Exception e) {
            result.error("startScan", e.getMessage(), e);
        }
    }

    private void stopScan() {
        if (Build.VERSION.SDK_INT >= 21) {
            stopScan21();
        } else {
            stopScan18();
        }
    }

    private ScanCallback getScanCallback21() {
        if (this.scanCallback21 == null) {
            this.scanCallback21 = new ScanCallback() { // from class: com.pauldemarco.flutter_blue.FlutterBluePlugin.2
                @Override // android.bluetooth.le.ScanCallback
                public void onScanResult(int i, ScanResult scanResult) {
                    super.onScanResult(i, scanResult);
                    if (!FlutterBluePlugin.this.allowDuplicates && scanResult != null && scanResult.getDevice() != null && scanResult.getDevice().getAddress() != null) {
                        if (FlutterBluePlugin.this.macDeviceScanned.contains(scanResult.getDevice().getAddress())) {
                            return;
                        }
                        FlutterBluePlugin.this.macDeviceScanned.add(scanResult.getDevice().getAddress());
                    }
                    FlutterBluePlugin.this.invokeMethodUIThread("ScanResult", ProtoMaker.from(scanResult.getDevice(), scanResult).toByteArray());
                }

                @Override // android.bluetooth.le.ScanCallback
                public void onBatchScanResults(List<ScanResult> list) {
                    super.onBatchScanResults(list);
                }

                @Override // android.bluetooth.le.ScanCallback
                public void onScanFailed(int i) {
                    super.onScanFailed(i);
                }
            };
        }
        return this.scanCallback21;
    }

    private void startScan21(Protos.ScanSettings scanSettings) throws IllegalStateException {
        BluetoothLeScanner bluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            throw new IllegalStateException("getBluetoothLeScanner() is null. Is the Adapter on?");
        }
        int androidScanMode = scanSettings.getAndroidScanMode();
        int serviceUuidsCount = scanSettings.getServiceUuidsCount();
        ArrayList arrayList = new ArrayList(serviceUuidsCount);
        for (int i = 0; i < serviceUuidsCount; i++) {
            arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(scanSettings.getServiceUuids(i))).build());
        }
        bluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().setScanMode(androidScanMode).build(), getScanCallback21());
    }

    private void stopScan21() {
        this.mBluetoothAdapter.getBluetoothLeScanner().stopScan(getScanCallback21());
    }

    private BluetoothAdapter.LeScanCallback getScanCallback18() {
        if (this.scanCallback18 == null) {
            this.scanCallback18 = new BluetoothAdapter.LeScanCallback() { // from class: com.pauldemarco.flutter_blue.FlutterBluePlugin$$ExternalSyntheticLambda0
                @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
                public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                    FlutterBluePlugin.this.m20x8d633a87(bluetoothDevice, i, bArr);
                }
            };
        }
        return this.scanCallback18;
    }

    /* renamed from: lambda$getScanCallback18$0$com-pauldemarco-flutter_blue-FlutterBluePlugin  reason: not valid java name */
    public /* synthetic */ void m20x8d633a87(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (!this.allowDuplicates && bluetoothDevice != null && bluetoothDevice.getAddress() != null) {
            if (this.macDeviceScanned.contains(bluetoothDevice.getAddress())) {
                return;
            }
            this.macDeviceScanned.add(bluetoothDevice.getAddress());
        }
        invokeMethodUIThread("ScanResult", ProtoMaker.from(bluetoothDevice, bArr, i).toByteArray());
    }

    private void startScan18(Protos.ScanSettings scanSettings) throws IllegalStateException {
        List<String> serviceUuidsList = scanSettings.getServiceUuidsList();
        UUID[] uuidArr = new UUID[serviceUuidsList.size()];
        for (int i = 0; i < serviceUuidsList.size(); i++) {
            uuidArr[i] = UUID.fromString(serviceUuidsList.get(i));
        }
        if (!this.mBluetoothAdapter.startLeScan(uuidArr, getScanCallback18())) {
            throw new IllegalStateException("getBluetoothLeScanner() is null. Is the Adapter on?");
        }
    }

    private void stopScan18() {
        this.mBluetoothAdapter.stopLeScan(getScanCallback18());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(LogLevel logLevel, String str) {
        if (logLevel.ordinal() <= this.logLevel.ordinal()) {
            Log.d(TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeMethodUIThread(final String str, final byte[] bArr) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.pauldemarco.flutter_blue.FlutterBluePlugin.4
            @Override // java.lang.Runnable
            public void run() {
                FlutterBluePlugin.this.channel.invokeMethod(str, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class BluetoothDeviceCache {
        final BluetoothGatt gatt;
        int mtu = 20;
        int state;

        BluetoothDeviceCache(BluetoothGatt bluetoothGatt) {
            this.gatt = bluetoothGatt;
        }
    }
}
