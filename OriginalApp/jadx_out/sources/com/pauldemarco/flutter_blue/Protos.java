package com.pauldemarco.flutter_blue;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class Protos {

    /* loaded from: classes.dex */
    public interface BluetoothCharacteristicOrBuilder extends MessageLiteOrBuilder {
        BluetoothDescriptor getDescriptors(int i);

        int getDescriptorsCount();

        List<BluetoothDescriptor> getDescriptorsList();

        CharacteristicProperties getProperties();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getSecondaryServiceUuid();

        ByteString getSecondaryServiceUuidBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();

        String getUuid();

        ByteString getUuidBytes();

        ByteString getValue();

        boolean hasProperties();
    }

    /* loaded from: classes.dex */
    public interface BluetoothDescriptorOrBuilder extends MessageLiteOrBuilder {
        String getCharacteristicUuid();

        ByteString getCharacteristicUuidBytes();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();

        String getUuid();

        ByteString getUuidBytes();

        ByteString getValue();
    }

    /* loaded from: classes.dex */
    public interface BluetoothDeviceOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        BluetoothDevice.Type getType();

        int getTypeValue();
    }

    /* loaded from: classes.dex */
    public interface BluetoothServiceOrBuilder extends MessageLiteOrBuilder {
        BluetoothCharacteristic getCharacteristics(int i);

        int getCharacteristicsCount();

        List<BluetoothCharacteristic> getCharacteristicsList();

        BluetoothService getIncludedServices(int i);

        int getIncludedServicesCount();

        List<BluetoothService> getIncludedServicesList();

        boolean getIsPrimary();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getUuid();

        ByteString getUuidBytes();
    }

    /* loaded from: classes.dex */
    public interface BluetoothStateOrBuilder extends MessageLiteOrBuilder {
        BluetoothState.State getState();

        int getStateValue();
    }

    /* loaded from: classes.dex */
    public interface CharacteristicPropertiesOrBuilder extends MessageLiteOrBuilder {
        boolean getAuthenticatedSignedWrites();

        boolean getBroadcast();

        boolean getExtendedProperties();

        boolean getIndicate();

        boolean getIndicateEncryptionRequired();

        boolean getNotify();

        boolean getNotifyEncryptionRequired();

        boolean getRead();

        boolean getWrite();

        boolean getWriteWithoutResponse();
    }

    /* loaded from: classes.dex */
    public interface ConnectRequestOrBuilder extends MessageLiteOrBuilder {
        boolean getAndroidAutoConnect();

        String getRemoteId();

        ByteString getRemoteIdBytes();
    }

    /* loaded from: classes.dex */
    public interface ConnectedDevicesResponseOrBuilder extends MessageLiteOrBuilder {
        BluetoothDevice getDevices(int i);

        int getDevicesCount();

        List<BluetoothDevice> getDevicesList();
    }

    /* loaded from: classes.dex */
    public interface DeviceStateResponseOrBuilder extends MessageLiteOrBuilder {
        String getRemoteId();

        ByteString getRemoteIdBytes();

        DeviceStateResponse.BluetoothDeviceState getState();

        int getStateValue();
    }

    /* loaded from: classes.dex */
    public interface DiscoverServicesResultOrBuilder extends MessageLiteOrBuilder {
        String getRemoteId();

        ByteString getRemoteIdBytes();

        BluetoothService getServices(int i);

        int getServicesCount();

        List<BluetoothService> getServicesList();
    }

    /* loaded from: classes.dex */
    public interface Int32ValueOrBuilder extends MessageLiteOrBuilder {
        int getValue();
    }

    /* loaded from: classes.dex */
    public interface MtuSizeRequestOrBuilder extends MessageLiteOrBuilder {
        int getMtu();

        String getRemoteId();

        ByteString getRemoteIdBytes();
    }

    /* loaded from: classes.dex */
    public interface MtuSizeResponseOrBuilder extends MessageLiteOrBuilder {
        int getMtu();

        String getRemoteId();

        ByteString getRemoteIdBytes();
    }

    /* loaded from: classes.dex */
    public interface OnCharacteristicChangedOrBuilder extends MessageLiteOrBuilder {
        BluetoothCharacteristic getCharacteristic();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        boolean hasCharacteristic();
    }

    /* loaded from: classes.dex */
    public interface ReadCharacteristicRequestOrBuilder extends MessageLiteOrBuilder {
        String getCharacteristicUuid();

        ByteString getCharacteristicUuidBytes();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getSecondaryServiceUuid();

        ByteString getSecondaryServiceUuidBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();
    }

    /* loaded from: classes.dex */
    public interface ReadCharacteristicResponseOrBuilder extends MessageLiteOrBuilder {
        BluetoothCharacteristic getCharacteristic();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        boolean hasCharacteristic();
    }

    /* loaded from: classes.dex */
    public interface ReadDescriptorRequestOrBuilder extends MessageLiteOrBuilder {
        String getCharacteristicUuid();

        ByteString getCharacteristicUuidBytes();

        String getDescriptorUuid();

        ByteString getDescriptorUuidBytes();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getSecondaryServiceUuid();

        ByteString getSecondaryServiceUuidBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();
    }

    /* loaded from: classes.dex */
    public interface ReadDescriptorResponseOrBuilder extends MessageLiteOrBuilder {
        ReadDescriptorRequest getRequest();

        ByteString getValue();

        boolean hasRequest();
    }

    /* loaded from: classes.dex */
    public interface ScanResultOrBuilder extends MessageLiteOrBuilder {
        BluetoothDevice getDevice();

        ByteString getManufacturerData();

        int getRssi();

        boolean hasDevice();
    }

    /* loaded from: classes.dex */
    public interface ScanSettingsOrBuilder extends MessageLiteOrBuilder {
        boolean getAllowDuplicates();

        int getAndroidScanMode();

        String getServiceUuids(int i);

        ByteString getServiceUuidsBytes(int i);

        int getServiceUuidsCount();

        List<String> getServiceUuidsList();
    }

    /* loaded from: classes.dex */
    public interface SetNotificationRequestOrBuilder extends MessageLiteOrBuilder {
        String getCharacteristicUuid();

        ByteString getCharacteristicUuidBytes();

        boolean getEnable();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getSecondaryServiceUuid();

        ByteString getSecondaryServiceUuidBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();
    }

    /* loaded from: classes.dex */
    public interface SetNotificationResponseOrBuilder extends MessageLiteOrBuilder {
        BluetoothCharacteristic getCharacteristic();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        boolean getSuccess();

        boolean hasCharacteristic();
    }

    /* loaded from: classes.dex */
    public interface WriteCharacteristicRequestOrBuilder extends MessageLiteOrBuilder {
        String getCharacteristicUuid();

        ByteString getCharacteristicUuidBytes();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getSecondaryServiceUuid();

        ByteString getSecondaryServiceUuidBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();

        ByteString getValue();

        WriteCharacteristicRequest.WriteType getWriteType();

        int getWriteTypeValue();
    }

    /* loaded from: classes.dex */
    public interface WriteCharacteristicResponseOrBuilder extends MessageLiteOrBuilder {
        WriteCharacteristicRequest getRequest();

        boolean getSuccess();

        boolean hasRequest();
    }

    /* loaded from: classes.dex */
    public interface WriteDescriptorRequestOrBuilder extends MessageLiteOrBuilder {
        String getCharacteristicUuid();

        ByteString getCharacteristicUuidBytes();

        String getDescriptorUuid();

        ByteString getDescriptorUuidBytes();

        String getRemoteId();

        ByteString getRemoteIdBytes();

        String getSecondaryServiceUuid();

        ByteString getSecondaryServiceUuidBytes();

        String getServiceUuid();

        ByteString getServiceUuidBytes();

        ByteString getValue();
    }

    /* loaded from: classes.dex */
    public interface WriteDescriptorResponseOrBuilder extends MessageLiteOrBuilder {
        WriteDescriptorRequest getRequest();

        boolean getSuccess();

        boolean hasRequest();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Protos() {
    }

    /* loaded from: classes.dex */
    public static final class Int32Value extends GeneratedMessageLite<Int32Value, Builder> implements Int32ValueOrBuilder {
        private static final Int32Value DEFAULT_INSTANCE;
        private static volatile Parser<Int32Value> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;
        private int value_;

        private Int32Value() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.Int32ValueOrBuilder
        public int getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(int i) {
            this.value_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = 0;
        }

        public static Int32Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Int32Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Int32Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Int32Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Int32Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Int32Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Int32Value parseFrom(InputStream inputStream) throws IOException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Int32Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Int32Value parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Int32Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Int32Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Int32Value) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Int32Value parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Int32Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Int32Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Int32Value int32Value) {
            return DEFAULT_INSTANCE.createBuilder(int32Value);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Int32Value, Builder> implements Int32ValueOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Int32Value.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.Int32ValueOrBuilder
            public int getValue() {
                return ((Int32Value) this.instance).getValue();
            }

            public Builder setValue(int i) {
                copyOnWrite();
                ((Int32Value) this.instance).setValue(i);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Int32Value) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Int32Value();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Int32Value> parser = PARSER;
                    if (parser == null) {
                        synchronized (Int32Value.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Int32Value int32Value = new Int32Value();
            DEFAULT_INSTANCE = int32Value;
            GeneratedMessageLite.registerDefaultInstance(Int32Value.class, int32Value);
        }

        public static Int32Value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Int32Value> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.pauldemarco.flutter_blue.Protos$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class BluetoothState extends GeneratedMessageLite<BluetoothState, Builder> implements BluetoothStateOrBuilder {
        private static final BluetoothState DEFAULT_INSTANCE;
        private static volatile Parser<BluetoothState> PARSER = null;
        public static final int STATE_FIELD_NUMBER = 1;
        private int state_;

        private BluetoothState() {
        }

        /* loaded from: classes.dex */
        public enum State implements Internal.EnumLite {
            UNKNOWN(0),
            UNAVAILABLE(1),
            UNAUTHORIZED(2),
            TURNING_ON(3),
            ON(4),
            TURNING_OFF(5),
            OFF(6),
            UNRECOGNIZED(-1);
            
            public static final int OFF_VALUE = 6;
            public static final int ON_VALUE = 4;
            public static final int TURNING_OFF_VALUE = 5;
            public static final int TURNING_ON_VALUE = 3;
            public static final int UNAUTHORIZED_VALUE = 2;
            public static final int UNAVAILABLE_VALUE = 1;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<State> internalValueMap = new Internal.EnumLiteMap<State>() { // from class: com.pauldemarco.flutter_blue.Protos.BluetoothState.State.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public State findValueByNumber(int i) {
                    return State.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }

            @Deprecated
            public static State valueOf(int i) {
                return forNumber(i);
            }

            public static State forNumber(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return UNAVAILABLE;
                    case 2:
                        return UNAUTHORIZED;
                    case 3:
                        return TURNING_ON;
                    case 4:
                        return ON;
                    case 5:
                        return TURNING_OFF;
                    case 6:
                        return OFF;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<State> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return StateVerifier.INSTANCE;
            }

            /* loaded from: classes.dex */
            private static final class StateVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new StateVerifier();

                private StateVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return State.forNumber(i) != null;
                }
            }

            State(int i) {
                this.value = i;
            }
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothStateOrBuilder
        public int getStateValue() {
            return this.state_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothStateOrBuilder
        public State getState() {
            State forNumber = State.forNumber(this.state_);
            return forNumber == null ? State.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStateValue(int i) {
            this.state_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setState(State state) {
            this.state_ = state.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            this.state_ = 0;
        }

        public static BluetoothState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BluetoothState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BluetoothState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BluetoothState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BluetoothState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BluetoothState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BluetoothState parseFrom(InputStream inputStream) throws IOException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BluetoothState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothState) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothState parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BluetoothState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BluetoothState bluetoothState) {
            return DEFAULT_INSTANCE.createBuilder(bluetoothState);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BluetoothState, Builder> implements BluetoothStateOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BluetoothState.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothStateOrBuilder
            public int getStateValue() {
                return ((BluetoothState) this.instance).getStateValue();
            }

            public Builder setStateValue(int i) {
                copyOnWrite();
                ((BluetoothState) this.instance).setStateValue(i);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothStateOrBuilder
            public State getState() {
                return ((BluetoothState) this.instance).getState();
            }

            public Builder setState(State state) {
                copyOnWrite();
                ((BluetoothState) this.instance).setState(state);
                return this;
            }

            public Builder clearState() {
                copyOnWrite();
                ((BluetoothState) this.instance).clearState();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BluetoothState();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"state_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BluetoothState> parser = PARSER;
                    if (parser == null) {
                        synchronized (BluetoothState.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BluetoothState bluetoothState = new BluetoothState();
            DEFAULT_INSTANCE = bluetoothState;
            GeneratedMessageLite.registerDefaultInstance(BluetoothState.class, bluetoothState);
        }

        public static BluetoothState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BluetoothState> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ScanSettings extends GeneratedMessageLite<ScanSettings, Builder> implements ScanSettingsOrBuilder {
        public static final int ALLOW_DUPLICATES_FIELD_NUMBER = 3;
        public static final int ANDROID_SCAN_MODE_FIELD_NUMBER = 1;
        private static final ScanSettings DEFAULT_INSTANCE;
        private static volatile Parser<ScanSettings> PARSER = null;
        public static final int SERVICE_UUIDS_FIELD_NUMBER = 2;
        private boolean allowDuplicates_;
        private int androidScanMode_;
        private Internal.ProtobufList<String> serviceUuids_ = GeneratedMessageLite.emptyProtobufList();

        private ScanSettings() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
        public int getAndroidScanMode() {
            return this.androidScanMode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAndroidScanMode(int i) {
            this.androidScanMode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAndroidScanMode() {
            this.androidScanMode_ = 0;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
        public List<String> getServiceUuidsList() {
            return this.serviceUuids_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
        public int getServiceUuidsCount() {
            return this.serviceUuids_.size();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
        public String getServiceUuids(int i) {
            return this.serviceUuids_.get(i);
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
        public ByteString getServiceUuidsBytes(int i) {
            return ByteString.copyFromUtf8(this.serviceUuids_.get(i));
        }

        private void ensureServiceUuidsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.serviceUuids_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.serviceUuids_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuids(int i, String str) {
            str.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addServiceUuids(String str) {
            str.getClass();
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllServiceUuids(Iterable<String> iterable) {
            ensureServiceUuidsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.serviceUuids_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuids() {
            this.serviceUuids_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addServiceUuidsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureServiceUuidsIsMutable();
            this.serviceUuids_.add(byteString.toStringUtf8());
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
        public boolean getAllowDuplicates() {
            return this.allowDuplicates_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAllowDuplicates(boolean z) {
            this.allowDuplicates_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAllowDuplicates() {
            this.allowDuplicates_ = false;
        }

        public static ScanSettings parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ScanSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ScanSettings parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ScanSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ScanSettings parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ScanSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ScanSettings parseFrom(InputStream inputStream) throws IOException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScanSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScanSettings parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ScanSettings) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScanSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScanSettings) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScanSettings parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ScanSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScanSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ScanSettings scanSettings) {
            return DEFAULT_INSTANCE.createBuilder(scanSettings);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ScanSettings, Builder> implements ScanSettingsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ScanSettings.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
            public int getAndroidScanMode() {
                return ((ScanSettings) this.instance).getAndroidScanMode();
            }

            public Builder setAndroidScanMode(int i) {
                copyOnWrite();
                ((ScanSettings) this.instance).setAndroidScanMode(i);
                return this;
            }

            public Builder clearAndroidScanMode() {
                copyOnWrite();
                ((ScanSettings) this.instance).clearAndroidScanMode();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
            public List<String> getServiceUuidsList() {
                return Collections.unmodifiableList(((ScanSettings) this.instance).getServiceUuidsList());
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
            public int getServiceUuidsCount() {
                return ((ScanSettings) this.instance).getServiceUuidsCount();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
            public String getServiceUuids(int i) {
                return ((ScanSettings) this.instance).getServiceUuids(i);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
            public ByteString getServiceUuidsBytes(int i) {
                return ((ScanSettings) this.instance).getServiceUuidsBytes(i);
            }

            public Builder setServiceUuids(int i, String str) {
                copyOnWrite();
                ((ScanSettings) this.instance).setServiceUuids(i, str);
                return this;
            }

            public Builder addServiceUuids(String str) {
                copyOnWrite();
                ((ScanSettings) this.instance).addServiceUuids(str);
                return this;
            }

            public Builder addAllServiceUuids(Iterable<String> iterable) {
                copyOnWrite();
                ((ScanSettings) this.instance).addAllServiceUuids(iterable);
                return this;
            }

            public Builder clearServiceUuids() {
                copyOnWrite();
                ((ScanSettings) this.instance).clearServiceUuids();
                return this;
            }

            public Builder addServiceUuidsBytes(ByteString byteString) {
                copyOnWrite();
                ((ScanSettings) this.instance).addServiceUuidsBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanSettingsOrBuilder
            public boolean getAllowDuplicates() {
                return ((ScanSettings) this.instance).getAllowDuplicates();
            }

            public Builder setAllowDuplicates(boolean z) {
                copyOnWrite();
                ((ScanSettings) this.instance).setAllowDuplicates(z);
                return this;
            }

            public Builder clearAllowDuplicates() {
                copyOnWrite();
                ((ScanSettings) this.instance).clearAllowDuplicates();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ScanSettings();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ț\u0003\u0007", new Object[]{"androidScanMode_", "serviceUuids_", "allowDuplicates_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ScanSettings> parser = PARSER;
                    if (parser == null) {
                        synchronized (ScanSettings.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ScanSettings scanSettings = new ScanSettings();
            DEFAULT_INSTANCE = scanSettings;
            GeneratedMessageLite.registerDefaultInstance(ScanSettings.class, scanSettings);
        }

        public static ScanSettings getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScanSettings> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ScanResult extends GeneratedMessageLite<ScanResult, Builder> implements ScanResultOrBuilder {
        private static final ScanResult DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 1;
        public static final int MANUFACTURER_DATA_FIELD_NUMBER = 2;
        private static volatile Parser<ScanResult> PARSER = null;
        public static final int RSSI_FIELD_NUMBER = 3;
        private BluetoothDevice device_;
        private ByteString manufacturerData_ = ByteString.EMPTY;
        private int rssi_;

        private ScanResult() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
        public boolean hasDevice() {
            return this.device_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
        public BluetoothDevice getDevice() {
            BluetoothDevice bluetoothDevice = this.device_;
            return bluetoothDevice == null ? BluetoothDevice.getDefaultInstance() : bluetoothDevice;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(BluetoothDevice bluetoothDevice) {
            bluetoothDevice.getClass();
            this.device_ = bluetoothDevice;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDevice(BluetoothDevice bluetoothDevice) {
            bluetoothDevice.getClass();
            BluetoothDevice bluetoothDevice2 = this.device_;
            if (bluetoothDevice2 != null && bluetoothDevice2 != BluetoothDevice.getDefaultInstance()) {
                this.device_ = BluetoothDevice.newBuilder(this.device_).mergeFrom((BluetoothDevice.Builder) bluetoothDevice).buildPartial();
            } else {
                this.device_ = bluetoothDevice;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevice() {
            this.device_ = null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
        public ByteString getManufacturerData() {
            return this.manufacturerData_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setManufacturerData(ByteString byteString) {
            byteString.getClass();
            this.manufacturerData_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearManufacturerData() {
            this.manufacturerData_ = getDefaultInstance().getManufacturerData();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
        public int getRssi() {
            return this.rssi_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRssi(int i) {
            this.rssi_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRssi() {
            this.rssi_ = 0;
        }

        public static ScanResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ScanResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ScanResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ScanResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ScanResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ScanResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ScanResult parseFrom(InputStream inputStream) throws IOException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScanResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScanResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ScanResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ScanResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScanResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ScanResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ScanResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ScanResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ScanResult scanResult) {
            return DEFAULT_INSTANCE.createBuilder(scanResult);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ScanResult, Builder> implements ScanResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ScanResult.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
            public boolean hasDevice() {
                return ((ScanResult) this.instance).hasDevice();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
            public BluetoothDevice getDevice() {
                return ((ScanResult) this.instance).getDevice();
            }

            public Builder setDevice(BluetoothDevice bluetoothDevice) {
                copyOnWrite();
                ((ScanResult) this.instance).setDevice(bluetoothDevice);
                return this;
            }

            public Builder setDevice(BluetoothDevice.Builder builder) {
                copyOnWrite();
                ((ScanResult) this.instance).setDevice(builder.build());
                return this;
            }

            public Builder mergeDevice(BluetoothDevice bluetoothDevice) {
                copyOnWrite();
                ((ScanResult) this.instance).mergeDevice(bluetoothDevice);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((ScanResult) this.instance).clearDevice();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
            public ByteString getManufacturerData() {
                return ((ScanResult) this.instance).getManufacturerData();
            }

            public Builder setManufacturerData(ByteString byteString) {
                copyOnWrite();
                ((ScanResult) this.instance).setManufacturerData(byteString);
                return this;
            }

            public Builder clearManufacturerData() {
                copyOnWrite();
                ((ScanResult) this.instance).clearManufacturerData();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ScanResultOrBuilder
            public int getRssi() {
                return ((ScanResult) this.instance).getRssi();
            }

            public Builder setRssi(int i) {
                copyOnWrite();
                ((ScanResult) this.instance).setRssi(i);
                return this;
            }

            public Builder clearRssi() {
                copyOnWrite();
                ((ScanResult) this.instance).clearRssi();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ScanResult();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\n\u0003\u0004", new Object[]{"device_", "manufacturerData_", "rssi_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ScanResult> parser = PARSER;
                    if (parser == null) {
                        synchronized (ScanResult.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ScanResult scanResult = new ScanResult();
            DEFAULT_INSTANCE = scanResult;
            GeneratedMessageLite.registerDefaultInstance(ScanResult.class, scanResult);
        }

        public static ScanResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScanResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ConnectRequest extends GeneratedMessageLite<ConnectRequest, Builder> implements ConnectRequestOrBuilder {
        public static final int ANDROID_AUTO_CONNECT_FIELD_NUMBER = 2;
        private static final ConnectRequest DEFAULT_INSTANCE;
        private static volatile Parser<ConnectRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        private boolean androidAutoConnect_;
        private String remoteId_ = "";

        private ConnectRequest() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ConnectRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ConnectRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ConnectRequestOrBuilder
        public boolean getAndroidAutoConnect() {
            return this.androidAutoConnect_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAndroidAutoConnect(boolean z) {
            this.androidAutoConnect_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAndroidAutoConnect() {
            this.androidAutoConnect_ = false;
        }

        public static ConnectRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConnectRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConnectRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConnectRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(InputStream inputStream) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConnectRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConnectRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConnectRequest connectRequest) {
            return DEFAULT_INSTANCE.createBuilder(connectRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ConnectRequest, Builder> implements ConnectRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ConnectRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ConnectRequestOrBuilder
            public String getRemoteId() {
                return ((ConnectRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ConnectRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((ConnectRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ConnectRequestOrBuilder
            public boolean getAndroidAutoConnect() {
                return ((ConnectRequest) this.instance).getAndroidAutoConnect();
            }

            public Builder setAndroidAutoConnect(boolean z) {
                copyOnWrite();
                ((ConnectRequest) this.instance).setAndroidAutoConnect(z);
                return this;
            }

            public Builder clearAndroidAutoConnect() {
                copyOnWrite();
                ((ConnectRequest) this.instance).clearAndroidAutoConnect();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConnectRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0007", new Object[]{"remoteId_", "androidAutoConnect_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConnectRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ConnectRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ConnectRequest connectRequest = new ConnectRequest();
            DEFAULT_INSTANCE = connectRequest;
            GeneratedMessageLite.registerDefaultInstance(ConnectRequest.class, connectRequest);
        }

        public static ConnectRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConnectRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class BluetoothDevice extends GeneratedMessageLite<BluetoothDevice, Builder> implements BluetoothDeviceOrBuilder {
        private static final BluetoothDevice DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<BluetoothDevice> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 3;
        private int type_;
        private String remoteId_ = "";
        private String name_ = "";

        private BluetoothDevice() {
        }

        /* loaded from: classes.dex */
        public enum Type implements Internal.EnumLite {
            UNKNOWN(0),
            CLASSIC(1),
            LE(2),
            DUAL(3),
            UNRECOGNIZED(-1);
            
            public static final int CLASSIC_VALUE = 1;
            public static final int DUAL_VALUE = 3;
            public static final int LE_VALUE = 2;
            public static final int UNKNOWN_VALUE = 0;
            private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.pauldemarco.flutter_blue.Protos.BluetoothDevice.Type.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Type findValueByNumber(int i) {
                    return Type.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }

            @Deprecated
            public static Type valueOf(int i) {
                return forNumber(i);
            }

            public static Type forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                return null;
                            }
                            return DUAL;
                        }
                        return LE;
                    }
                    return CLASSIC;
                }
                return UNKNOWN;
            }

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return TypeVerifier.INSTANCE;
            }

            /* loaded from: classes.dex */
            private static final class TypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new TypeVerifier();

                private TypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Type.forNumber(i) != null;
                }
            }

            Type(int i) {
                this.value = i;
            }
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
        public Type getType() {
            Type forNumber = Type.forNumber(this.type_);
            return forNumber == null ? Type.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeValue(int i) {
            this.type_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(Type type) {
            this.type_ = type.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        public static BluetoothDevice parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BluetoothDevice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BluetoothDevice parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BluetoothDevice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BluetoothDevice parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BluetoothDevice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BluetoothDevice parseFrom(InputStream inputStream) throws IOException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothDevice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothDevice parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BluetoothDevice) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothDevice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothDevice) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothDevice parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BluetoothDevice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BluetoothDevice bluetoothDevice) {
            return DEFAULT_INSTANCE.createBuilder(bluetoothDevice);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BluetoothDevice, Builder> implements BluetoothDeviceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BluetoothDevice.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
            public String getRemoteId() {
                return ((BluetoothDevice) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((BluetoothDevice) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((BluetoothDevice) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((BluetoothDevice) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDevice) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
            public String getName() {
                return ((BluetoothDevice) this.instance).getName();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
            public ByteString getNameBytes() {
                return ((BluetoothDevice) this.instance).getNameBytes();
            }

            public Builder setName(String str) {
                copyOnWrite();
                ((BluetoothDevice) this.instance).setName(str);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((BluetoothDevice) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDevice) this.instance).setNameBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
            public int getTypeValue() {
                return ((BluetoothDevice) this.instance).getTypeValue();
            }

            public Builder setTypeValue(int i) {
                copyOnWrite();
                ((BluetoothDevice) this.instance).setTypeValue(i);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDeviceOrBuilder
            public Type getType() {
                return ((BluetoothDevice) this.instance).getType();
            }

            public Builder setType(Type type) {
                copyOnWrite();
                ((BluetoothDevice) this.instance).setType(type);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((BluetoothDevice) this.instance).clearType();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BluetoothDevice();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f", new Object[]{"remoteId_", "name_", "type_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BluetoothDevice> parser = PARSER;
                    if (parser == null) {
                        synchronized (BluetoothDevice.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BluetoothDevice bluetoothDevice = new BluetoothDevice();
            DEFAULT_INSTANCE = bluetoothDevice;
            GeneratedMessageLite.registerDefaultInstance(BluetoothDevice.class, bluetoothDevice);
        }

        public static BluetoothDevice getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BluetoothDevice> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class BluetoothService extends GeneratedMessageLite<BluetoothService, Builder> implements BluetoothServiceOrBuilder {
        public static final int CHARACTERISTICS_FIELD_NUMBER = 4;
        private static final BluetoothService DEFAULT_INSTANCE;
        public static final int INCLUDED_SERVICES_FIELD_NUMBER = 5;
        public static final int IS_PRIMARY_FIELD_NUMBER = 3;
        private static volatile Parser<BluetoothService> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 2;
        public static final int UUID_FIELD_NUMBER = 1;
        private boolean isPrimary_;
        private String uuid_ = "";
        private String remoteId_ = "";
        private Internal.ProtobufList<BluetoothCharacteristic> characteristics_ = emptyProtobufList();
        private Internal.ProtobufList<BluetoothService> includedServices_ = emptyProtobufList();

        private BluetoothService() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public String getUuid() {
            return this.uuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public ByteString getUuidBytes() {
            return ByteString.copyFromUtf8(this.uuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUuid(String str) {
            str.getClass();
            this.uuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUuid() {
            this.uuid_ = getDefaultInstance().getUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.uuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public boolean getIsPrimary() {
            return this.isPrimary_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsPrimary(boolean z) {
            this.isPrimary_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsPrimary() {
            this.isPrimary_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public List<BluetoothCharacteristic> getCharacteristicsList() {
            return this.characteristics_;
        }

        public List<? extends BluetoothCharacteristicOrBuilder> getCharacteristicsOrBuilderList() {
            return this.characteristics_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public int getCharacteristicsCount() {
            return this.characteristics_.size();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public BluetoothCharacteristic getCharacteristics(int i) {
            return this.characteristics_.get(i);
        }

        public BluetoothCharacteristicOrBuilder getCharacteristicsOrBuilder(int i) {
            return this.characteristics_.get(i);
        }

        private void ensureCharacteristicsIsMutable() {
            Internal.ProtobufList<BluetoothCharacteristic> protobufList = this.characteristics_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.characteristics_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristics(int i, BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.set(i, bluetoothCharacteristic);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCharacteristics(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.add(bluetoothCharacteristic);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCharacteristics(int i, BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            ensureCharacteristicsIsMutable();
            this.characteristics_.add(i, bluetoothCharacteristic);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCharacteristics(Iterable<? extends BluetoothCharacteristic> iterable) {
            ensureCharacteristicsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.characteristics_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristics() {
            this.characteristics_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCharacteristics(int i) {
            ensureCharacteristicsIsMutable();
            this.characteristics_.remove(i);
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public List<BluetoothService> getIncludedServicesList() {
            return this.includedServices_;
        }

        public List<? extends BluetoothServiceOrBuilder> getIncludedServicesOrBuilderList() {
            return this.includedServices_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public int getIncludedServicesCount() {
            return this.includedServices_.size();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
        public BluetoothService getIncludedServices(int i) {
            return this.includedServices_.get(i);
        }

        public BluetoothServiceOrBuilder getIncludedServicesOrBuilder(int i) {
            return this.includedServices_.get(i);
        }

        private void ensureIncludedServicesIsMutable() {
            Internal.ProtobufList<BluetoothService> protobufList = this.includedServices_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.includedServices_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncludedServices(int i, BluetoothService bluetoothService) {
            bluetoothService.getClass();
            ensureIncludedServicesIsMutable();
            this.includedServices_.set(i, bluetoothService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIncludedServices(BluetoothService bluetoothService) {
            bluetoothService.getClass();
            ensureIncludedServicesIsMutable();
            this.includedServices_.add(bluetoothService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIncludedServices(int i, BluetoothService bluetoothService) {
            bluetoothService.getClass();
            ensureIncludedServicesIsMutable();
            this.includedServices_.add(i, bluetoothService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllIncludedServices(Iterable<? extends BluetoothService> iterable) {
            ensureIncludedServicesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.includedServices_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIncludedServices() {
            this.includedServices_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeIncludedServices(int i) {
            ensureIncludedServicesIsMutable();
            this.includedServices_.remove(i);
        }

        public static BluetoothService parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BluetoothService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BluetoothService parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BluetoothService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BluetoothService parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BluetoothService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BluetoothService parseFrom(InputStream inputStream) throws IOException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothService parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BluetoothService) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothService) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothService parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BluetoothService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BluetoothService bluetoothService) {
            return DEFAULT_INSTANCE.createBuilder(bluetoothService);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BluetoothService, Builder> implements BluetoothServiceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BluetoothService.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public String getUuid() {
                return ((BluetoothService) this.instance).getUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public ByteString getUuidBytes() {
                return ((BluetoothService) this.instance).getUuidBytes();
            }

            public Builder setUuid(String str) {
                copyOnWrite();
                ((BluetoothService) this.instance).setUuid(str);
                return this;
            }

            public Builder clearUuid() {
                copyOnWrite();
                ((BluetoothService) this.instance).clearUuid();
                return this;
            }

            public Builder setUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothService) this.instance).setUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public String getRemoteId() {
                return ((BluetoothService) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((BluetoothService) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((BluetoothService) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((BluetoothService) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothService) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public boolean getIsPrimary() {
                return ((BluetoothService) this.instance).getIsPrimary();
            }

            public Builder setIsPrimary(boolean z) {
                copyOnWrite();
                ((BluetoothService) this.instance).setIsPrimary(z);
                return this;
            }

            public Builder clearIsPrimary() {
                copyOnWrite();
                ((BluetoothService) this.instance).clearIsPrimary();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public List<BluetoothCharacteristic> getCharacteristicsList() {
                return Collections.unmodifiableList(((BluetoothService) this.instance).getCharacteristicsList());
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public int getCharacteristicsCount() {
                return ((BluetoothService) this.instance).getCharacteristicsCount();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public BluetoothCharacteristic getCharacteristics(int i) {
                return ((BluetoothService) this.instance).getCharacteristics(i);
            }

            public Builder setCharacteristics(int i, BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((BluetoothService) this.instance).setCharacteristics(i, bluetoothCharacteristic);
                return this;
            }

            public Builder setCharacteristics(int i, BluetoothCharacteristic.Builder builder) {
                copyOnWrite();
                ((BluetoothService) this.instance).setCharacteristics(i, builder.build());
                return this;
            }

            public Builder addCharacteristics(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((BluetoothService) this.instance).addCharacteristics(bluetoothCharacteristic);
                return this;
            }

            public Builder addCharacteristics(int i, BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((BluetoothService) this.instance).addCharacteristics(i, bluetoothCharacteristic);
                return this;
            }

            public Builder addCharacteristics(BluetoothCharacteristic.Builder builder) {
                copyOnWrite();
                ((BluetoothService) this.instance).addCharacteristics(builder.build());
                return this;
            }

            public Builder addCharacteristics(int i, BluetoothCharacteristic.Builder builder) {
                copyOnWrite();
                ((BluetoothService) this.instance).addCharacteristics(i, builder.build());
                return this;
            }

            public Builder addAllCharacteristics(Iterable<? extends BluetoothCharacteristic> iterable) {
                copyOnWrite();
                ((BluetoothService) this.instance).addAllCharacteristics(iterable);
                return this;
            }

            public Builder clearCharacteristics() {
                copyOnWrite();
                ((BluetoothService) this.instance).clearCharacteristics();
                return this;
            }

            public Builder removeCharacteristics(int i) {
                copyOnWrite();
                ((BluetoothService) this.instance).removeCharacteristics(i);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public List<BluetoothService> getIncludedServicesList() {
                return Collections.unmodifiableList(((BluetoothService) this.instance).getIncludedServicesList());
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public int getIncludedServicesCount() {
                return ((BluetoothService) this.instance).getIncludedServicesCount();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothServiceOrBuilder
            public BluetoothService getIncludedServices(int i) {
                return ((BluetoothService) this.instance).getIncludedServices(i);
            }

            public Builder setIncludedServices(int i, BluetoothService bluetoothService) {
                copyOnWrite();
                ((BluetoothService) this.instance).setIncludedServices(i, bluetoothService);
                return this;
            }

            public Builder setIncludedServices(int i, Builder builder) {
                copyOnWrite();
                ((BluetoothService) this.instance).setIncludedServices(i, builder.build());
                return this;
            }

            public Builder addIncludedServices(BluetoothService bluetoothService) {
                copyOnWrite();
                ((BluetoothService) this.instance).addIncludedServices(bluetoothService);
                return this;
            }

            public Builder addIncludedServices(int i, BluetoothService bluetoothService) {
                copyOnWrite();
                ((BluetoothService) this.instance).addIncludedServices(i, bluetoothService);
                return this;
            }

            public Builder addIncludedServices(Builder builder) {
                copyOnWrite();
                ((BluetoothService) this.instance).addIncludedServices(builder.build());
                return this;
            }

            public Builder addIncludedServices(int i, Builder builder) {
                copyOnWrite();
                ((BluetoothService) this.instance).addIncludedServices(i, builder.build());
                return this;
            }

            public Builder addAllIncludedServices(Iterable<? extends BluetoothService> iterable) {
                copyOnWrite();
                ((BluetoothService) this.instance).addAllIncludedServices(iterable);
                return this;
            }

            public Builder clearIncludedServices() {
                copyOnWrite();
                ((BluetoothService) this.instance).clearIncludedServices();
                return this;
            }

            public Builder removeIncludedServices(int i) {
                copyOnWrite();
                ((BluetoothService) this.instance).removeIncludedServices(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BluetoothService();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u001b\u0005\u001b", new Object[]{"uuid_", "remoteId_", "isPrimary_", "characteristics_", BluetoothCharacteristic.class, "includedServices_", BluetoothService.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BluetoothService> parser = PARSER;
                    if (parser == null) {
                        synchronized (BluetoothService.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BluetoothService bluetoothService = new BluetoothService();
            DEFAULT_INSTANCE = bluetoothService;
            GeneratedMessageLite.registerDefaultInstance(BluetoothService.class, bluetoothService);
        }

        public static BluetoothService getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BluetoothService> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class BluetoothCharacteristic extends GeneratedMessageLite<BluetoothCharacteristic, Builder> implements BluetoothCharacteristicOrBuilder {
        private static final BluetoothCharacteristic DEFAULT_INSTANCE;
        public static final int DESCRIPTORS_FIELD_NUMBER = 5;
        private static volatile Parser<BluetoothCharacteristic> PARSER = null;
        public static final int PROPERTIES_FIELD_NUMBER = 6;
        public static final int REMOTE_ID_FIELD_NUMBER = 2;
        public static final int SECONDARYSERVICEUUID_FIELD_NUMBER = 4;
        public static final int SERVICEUUID_FIELD_NUMBER = 3;
        public static final int UUID_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 7;
        private CharacteristicProperties properties_;
        private String uuid_ = "";
        private String remoteId_ = "";
        private String serviceUuid_ = "";
        private String secondaryServiceUuid_ = "";
        private Internal.ProtobufList<BluetoothDescriptor> descriptors_ = emptyProtobufList();
        private ByteString value_ = ByteString.EMPTY;

        private BluetoothCharacteristic() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public String getUuid() {
            return this.uuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public ByteString getUuidBytes() {
            return ByteString.copyFromUtf8(this.uuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUuid(String str) {
            str.getClass();
            this.uuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUuid() {
            this.uuid_ = getDefaultInstance().getUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.uuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public String getSecondaryServiceUuid() {
            return this.secondaryServiceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public ByteString getSecondaryServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.secondaryServiceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuid(String str) {
            str.getClass();
            this.secondaryServiceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryServiceUuid() {
            this.secondaryServiceUuid_ = getDefaultInstance().getSecondaryServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.secondaryServiceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public List<BluetoothDescriptor> getDescriptorsList() {
            return this.descriptors_;
        }

        public List<? extends BluetoothDescriptorOrBuilder> getDescriptorsOrBuilderList() {
            return this.descriptors_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public int getDescriptorsCount() {
            return this.descriptors_.size();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public BluetoothDescriptor getDescriptors(int i) {
            return this.descriptors_.get(i);
        }

        public BluetoothDescriptorOrBuilder getDescriptorsOrBuilder(int i) {
            return this.descriptors_.get(i);
        }

        private void ensureDescriptorsIsMutable() {
            Internal.ProtobufList<BluetoothDescriptor> protobufList = this.descriptors_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.descriptors_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescriptors(int i, BluetoothDescriptor bluetoothDescriptor) {
            bluetoothDescriptor.getClass();
            ensureDescriptorsIsMutable();
            this.descriptors_.set(i, bluetoothDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDescriptors(BluetoothDescriptor bluetoothDescriptor) {
            bluetoothDescriptor.getClass();
            ensureDescriptorsIsMutable();
            this.descriptors_.add(bluetoothDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDescriptors(int i, BluetoothDescriptor bluetoothDescriptor) {
            bluetoothDescriptor.getClass();
            ensureDescriptorsIsMutable();
            this.descriptors_.add(i, bluetoothDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDescriptors(Iterable<? extends BluetoothDescriptor> iterable) {
            ensureDescriptorsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.descriptors_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDescriptors() {
            this.descriptors_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDescriptors(int i) {
            ensureDescriptorsIsMutable();
            this.descriptors_.remove(i);
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public boolean hasProperties() {
            return this.properties_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public CharacteristicProperties getProperties() {
            CharacteristicProperties characteristicProperties = this.properties_;
            return characteristicProperties == null ? CharacteristicProperties.getDefaultInstance() : characteristicProperties;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProperties(CharacteristicProperties characteristicProperties) {
            characteristicProperties.getClass();
            this.properties_ = characteristicProperties;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeProperties(CharacteristicProperties characteristicProperties) {
            characteristicProperties.getClass();
            CharacteristicProperties characteristicProperties2 = this.properties_;
            if (characteristicProperties2 != null && characteristicProperties2 != CharacteristicProperties.getDefaultInstance()) {
                this.properties_ = CharacteristicProperties.newBuilder(this.properties_).mergeFrom((CharacteristicProperties.Builder) characteristicProperties).buildPartial();
            } else {
                this.properties_ = characteristicProperties;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProperties() {
            this.properties_ = null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            byteString.getClass();
            this.value_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static BluetoothCharacteristic parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BluetoothCharacteristic parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BluetoothCharacteristic parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BluetoothCharacteristic parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BluetoothCharacteristic parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BluetoothCharacteristic parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BluetoothCharacteristic parseFrom(InputStream inputStream) throws IOException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothCharacteristic parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothCharacteristic parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BluetoothCharacteristic) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothCharacteristic parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothCharacteristic) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothCharacteristic parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BluetoothCharacteristic parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BluetoothCharacteristic bluetoothCharacteristic) {
            return DEFAULT_INSTANCE.createBuilder(bluetoothCharacteristic);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BluetoothCharacteristic, Builder> implements BluetoothCharacteristicOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BluetoothCharacteristic.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public String getUuid() {
                return ((BluetoothCharacteristic) this.instance).getUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public ByteString getUuidBytes() {
                return ((BluetoothCharacteristic) this.instance).getUuidBytes();
            }

            public Builder setUuid(String str) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setUuid(str);
                return this;
            }

            public Builder clearUuid() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearUuid();
                return this;
            }

            public Builder setUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public String getRemoteId() {
                return ((BluetoothCharacteristic) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((BluetoothCharacteristic) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public String getServiceUuid() {
                return ((BluetoothCharacteristic) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((BluetoothCharacteristic) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public String getSecondaryServiceUuid() {
                return ((BluetoothCharacteristic) this.instance).getSecondaryServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public ByteString getSecondaryServiceUuidBytes() {
                return ((BluetoothCharacteristic) this.instance).getSecondaryServiceUuidBytes();
            }

            public Builder setSecondaryServiceUuid(String str) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setSecondaryServiceUuid(str);
                return this;
            }

            public Builder clearSecondaryServiceUuid() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearSecondaryServiceUuid();
                return this;
            }

            public Builder setSecondaryServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setSecondaryServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public List<BluetoothDescriptor> getDescriptorsList() {
                return Collections.unmodifiableList(((BluetoothCharacteristic) this.instance).getDescriptorsList());
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public int getDescriptorsCount() {
                return ((BluetoothCharacteristic) this.instance).getDescriptorsCount();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public BluetoothDescriptor getDescriptors(int i) {
                return ((BluetoothCharacteristic) this.instance).getDescriptors(i);
            }

            public Builder setDescriptors(int i, BluetoothDescriptor bluetoothDescriptor) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setDescriptors(i, bluetoothDescriptor);
                return this;
            }

            public Builder setDescriptors(int i, BluetoothDescriptor.Builder builder) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setDescriptors(i, builder.build());
                return this;
            }

            public Builder addDescriptors(BluetoothDescriptor bluetoothDescriptor) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).addDescriptors(bluetoothDescriptor);
                return this;
            }

            public Builder addDescriptors(int i, BluetoothDescriptor bluetoothDescriptor) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).addDescriptors(i, bluetoothDescriptor);
                return this;
            }

            public Builder addDescriptors(BluetoothDescriptor.Builder builder) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).addDescriptors(builder.build());
                return this;
            }

            public Builder addDescriptors(int i, BluetoothDescriptor.Builder builder) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).addDescriptors(i, builder.build());
                return this;
            }

            public Builder addAllDescriptors(Iterable<? extends BluetoothDescriptor> iterable) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).addAllDescriptors(iterable);
                return this;
            }

            public Builder clearDescriptors() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearDescriptors();
                return this;
            }

            public Builder removeDescriptors(int i) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).removeDescriptors(i);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public boolean hasProperties() {
                return ((BluetoothCharacteristic) this.instance).hasProperties();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public CharacteristicProperties getProperties() {
                return ((BluetoothCharacteristic) this.instance).getProperties();
            }

            public Builder setProperties(CharacteristicProperties characteristicProperties) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setProperties(characteristicProperties);
                return this;
            }

            public Builder setProperties(CharacteristicProperties.Builder builder) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setProperties(builder.build());
                return this;
            }

            public Builder mergeProperties(CharacteristicProperties characteristicProperties) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).mergeProperties(characteristicProperties);
                return this;
            }

            public Builder clearProperties() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearProperties();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothCharacteristicOrBuilder
            public ByteString getValue() {
                return ((BluetoothCharacteristic) this.instance).getValue();
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).setValue(byteString);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((BluetoothCharacteristic) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BluetoothCharacteristic();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u001b\u0006\t\u0007\n", new Object[]{"uuid_", "remoteId_", "serviceUuid_", "secondaryServiceUuid_", "descriptors_", BluetoothDescriptor.class, "properties_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BluetoothCharacteristic> parser = PARSER;
                    if (parser == null) {
                        synchronized (BluetoothCharacteristic.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BluetoothCharacteristic bluetoothCharacteristic = new BluetoothCharacteristic();
            DEFAULT_INSTANCE = bluetoothCharacteristic;
            GeneratedMessageLite.registerDefaultInstance(BluetoothCharacteristic.class, bluetoothCharacteristic);
        }

        public static BluetoothCharacteristic getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BluetoothCharacteristic> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class BluetoothDescriptor extends GeneratedMessageLite<BluetoothDescriptor, Builder> implements BluetoothDescriptorOrBuilder {
        public static final int CHARACTERISTICUUID_FIELD_NUMBER = 4;
        private static final BluetoothDescriptor DEFAULT_INSTANCE;
        private static volatile Parser<BluetoothDescriptor> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 2;
        public static final int SERVICEUUID_FIELD_NUMBER = 3;
        public static final int UUID_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 5;
        private String uuid_ = "";
        private String remoteId_ = "";
        private String serviceUuid_ = "";
        private String characteristicUuid_ = "";
        private ByteString value_ = ByteString.EMPTY;

        private BluetoothDescriptor() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public String getUuid() {
            return this.uuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public ByteString getUuidBytes() {
            return ByteString.copyFromUtf8(this.uuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUuid(String str) {
            str.getClass();
            this.uuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUuid() {
            this.uuid_ = getDefaultInstance().getUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.uuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public String getCharacteristicUuid() {
            return this.characteristicUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public ByteString getCharacteristicUuidBytes() {
            return ByteString.copyFromUtf8(this.characteristicUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuid(String str) {
            str.getClass();
            this.characteristicUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = getDefaultInstance().getCharacteristicUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.characteristicUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            byteString.getClass();
            this.value_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static BluetoothDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static BluetoothDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static BluetoothDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static BluetoothDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static BluetoothDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static BluetoothDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static BluetoothDescriptor parseFrom(InputStream inputStream) throws IOException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BluetoothDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static BluetoothDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static BluetoothDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static BluetoothDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BluetoothDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BluetoothDescriptor bluetoothDescriptor) {
            return DEFAULT_INSTANCE.createBuilder(bluetoothDescriptor);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<BluetoothDescriptor, Builder> implements BluetoothDescriptorOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(BluetoothDescriptor.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public String getUuid() {
                return ((BluetoothDescriptor) this.instance).getUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public ByteString getUuidBytes() {
                return ((BluetoothDescriptor) this.instance).getUuidBytes();
            }

            public Builder setUuid(String str) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setUuid(str);
                return this;
            }

            public Builder clearUuid() {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).clearUuid();
                return this;
            }

            public Builder setUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public String getRemoteId() {
                return ((BluetoothDescriptor) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((BluetoothDescriptor) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public String getServiceUuid() {
                return ((BluetoothDescriptor) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((BluetoothDescriptor) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public String getCharacteristicUuid() {
                return ((BluetoothDescriptor) this.instance).getCharacteristicUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public ByteString getCharacteristicUuidBytes() {
                return ((BluetoothDescriptor) this.instance).getCharacteristicUuidBytes();
            }

            public Builder setCharacteristicUuid(String str) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setCharacteristicUuid(str);
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder setCharacteristicUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setCharacteristicUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.BluetoothDescriptorOrBuilder
            public ByteString getValue() {
                return ((BluetoothDescriptor) this.instance).getValue();
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).setValue(byteString);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((BluetoothDescriptor) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new BluetoothDescriptor();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\n", new Object[]{"uuid_", "remoteId_", "serviceUuid_", "characteristicUuid_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BluetoothDescriptor> parser = PARSER;
                    if (parser == null) {
                        synchronized (BluetoothDescriptor.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            BluetoothDescriptor bluetoothDescriptor = new BluetoothDescriptor();
            DEFAULT_INSTANCE = bluetoothDescriptor;
            GeneratedMessageLite.registerDefaultInstance(BluetoothDescriptor.class, bluetoothDescriptor);
        }

        public static BluetoothDescriptor getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BluetoothDescriptor> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class CharacteristicProperties extends GeneratedMessageLite<CharacteristicProperties, Builder> implements CharacteristicPropertiesOrBuilder {
        public static final int AUTHENTICATED_SIGNED_WRITES_FIELD_NUMBER = 7;
        public static final int BROADCAST_FIELD_NUMBER = 1;
        private static final CharacteristicProperties DEFAULT_INSTANCE;
        public static final int EXTENDED_PROPERTIES_FIELD_NUMBER = 8;
        public static final int INDICATE_ENCRYPTION_REQUIRED_FIELD_NUMBER = 10;
        public static final int INDICATE_FIELD_NUMBER = 6;
        public static final int NOTIFY_ENCRYPTION_REQUIRED_FIELD_NUMBER = 9;
        public static final int NOTIFY_FIELD_NUMBER = 5;
        private static volatile Parser<CharacteristicProperties> PARSER = null;
        public static final int READ_FIELD_NUMBER = 2;
        public static final int WRITE_FIELD_NUMBER = 4;
        public static final int WRITE_WITHOUT_RESPONSE_FIELD_NUMBER = 3;
        private boolean authenticatedSignedWrites_;
        private boolean broadcast_;
        private boolean extendedProperties_;
        private boolean indicateEncryptionRequired_;
        private boolean indicate_;
        private boolean notifyEncryptionRequired_;
        private boolean notify_;
        private boolean read_;
        private boolean writeWithoutResponse_;
        private boolean write_;

        private CharacteristicProperties() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getBroadcast() {
            return this.broadcast_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBroadcast(boolean z) {
            this.broadcast_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBroadcast() {
            this.broadcast_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getRead() {
            return this.read_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRead(boolean z) {
            this.read_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRead() {
            this.read_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getWriteWithoutResponse() {
            return this.writeWithoutResponse_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWriteWithoutResponse(boolean z) {
            this.writeWithoutResponse_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWriteWithoutResponse() {
            this.writeWithoutResponse_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getWrite() {
            return this.write_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWrite(boolean z) {
            this.write_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWrite() {
            this.write_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getNotify() {
            return this.notify_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotify(boolean z) {
            this.notify_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNotify() {
            this.notify_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getIndicate() {
            return this.indicate_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndicate(boolean z) {
            this.indicate_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndicate() {
            this.indicate_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getAuthenticatedSignedWrites() {
            return this.authenticatedSignedWrites_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuthenticatedSignedWrites(boolean z) {
            this.authenticatedSignedWrites_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuthenticatedSignedWrites() {
            this.authenticatedSignedWrites_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getExtendedProperties() {
            return this.extendedProperties_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtendedProperties(boolean z) {
            this.extendedProperties_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtendedProperties() {
            this.extendedProperties_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getNotifyEncryptionRequired() {
            return this.notifyEncryptionRequired_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotifyEncryptionRequired(boolean z) {
            this.notifyEncryptionRequired_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNotifyEncryptionRequired() {
            this.notifyEncryptionRequired_ = false;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
        public boolean getIndicateEncryptionRequired() {
            return this.indicateEncryptionRequired_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndicateEncryptionRequired(boolean z) {
            this.indicateEncryptionRequired_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndicateEncryptionRequired() {
            this.indicateEncryptionRequired_ = false;
        }

        public static CharacteristicProperties parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CharacteristicProperties parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CharacteristicProperties parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CharacteristicProperties parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CharacteristicProperties parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CharacteristicProperties parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CharacteristicProperties parseFrom(InputStream inputStream) throws IOException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CharacteristicProperties parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CharacteristicProperties parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CharacteristicProperties) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CharacteristicProperties parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CharacteristicProperties) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CharacteristicProperties parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CharacteristicProperties parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CharacteristicProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CharacteristicProperties characteristicProperties) {
            return DEFAULT_INSTANCE.createBuilder(characteristicProperties);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CharacteristicProperties, Builder> implements CharacteristicPropertiesOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(CharacteristicProperties.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getBroadcast() {
                return ((CharacteristicProperties) this.instance).getBroadcast();
            }

            public Builder setBroadcast(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setBroadcast(z);
                return this;
            }

            public Builder clearBroadcast() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearBroadcast();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getRead() {
                return ((CharacteristicProperties) this.instance).getRead();
            }

            public Builder setRead(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setRead(z);
                return this;
            }

            public Builder clearRead() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearRead();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getWriteWithoutResponse() {
                return ((CharacteristicProperties) this.instance).getWriteWithoutResponse();
            }

            public Builder setWriteWithoutResponse(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setWriteWithoutResponse(z);
                return this;
            }

            public Builder clearWriteWithoutResponse() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearWriteWithoutResponse();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getWrite() {
                return ((CharacteristicProperties) this.instance).getWrite();
            }

            public Builder setWrite(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setWrite(z);
                return this;
            }

            public Builder clearWrite() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearWrite();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getNotify() {
                return ((CharacteristicProperties) this.instance).getNotify();
            }

            public Builder setNotify(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setNotify(z);
                return this;
            }

            public Builder clearNotify() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearNotify();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getIndicate() {
                return ((CharacteristicProperties) this.instance).getIndicate();
            }

            public Builder setIndicate(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setIndicate(z);
                return this;
            }

            public Builder clearIndicate() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearIndicate();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getAuthenticatedSignedWrites() {
                return ((CharacteristicProperties) this.instance).getAuthenticatedSignedWrites();
            }

            public Builder setAuthenticatedSignedWrites(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setAuthenticatedSignedWrites(z);
                return this;
            }

            public Builder clearAuthenticatedSignedWrites() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearAuthenticatedSignedWrites();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getExtendedProperties() {
                return ((CharacteristicProperties) this.instance).getExtendedProperties();
            }

            public Builder setExtendedProperties(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setExtendedProperties(z);
                return this;
            }

            public Builder clearExtendedProperties() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearExtendedProperties();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getNotifyEncryptionRequired() {
                return ((CharacteristicProperties) this.instance).getNotifyEncryptionRequired();
            }

            public Builder setNotifyEncryptionRequired(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setNotifyEncryptionRequired(z);
                return this;
            }

            public Builder clearNotifyEncryptionRequired() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearNotifyEncryptionRequired();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.CharacteristicPropertiesOrBuilder
            public boolean getIndicateEncryptionRequired() {
                return ((CharacteristicProperties) this.instance).getIndicateEncryptionRequired();
            }

            public Builder setIndicateEncryptionRequired(boolean z) {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).setIndicateEncryptionRequired(z);
                return this;
            }

            public Builder clearIndicateEncryptionRequired() {
                copyOnWrite();
                ((CharacteristicProperties) this.instance).clearIndicateEncryptionRequired();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CharacteristicProperties();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003\u0007\u0004\u0007\u0005\u0007\u0006\u0007\u0007\u0007\b\u0007\t\u0007\n\u0007", new Object[]{"broadcast_", "read_", "writeWithoutResponse_", "write_", "notify_", "indicate_", "authenticatedSignedWrites_", "extendedProperties_", "notifyEncryptionRequired_", "indicateEncryptionRequired_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CharacteristicProperties> parser = PARSER;
                    if (parser == null) {
                        synchronized (CharacteristicProperties.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            CharacteristicProperties characteristicProperties = new CharacteristicProperties();
            DEFAULT_INSTANCE = characteristicProperties;
            GeneratedMessageLite.registerDefaultInstance(CharacteristicProperties.class, characteristicProperties);
        }

        public static CharacteristicProperties getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CharacteristicProperties> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class DiscoverServicesResult extends GeneratedMessageLite<DiscoverServicesResult, Builder> implements DiscoverServicesResultOrBuilder {
        private static final DiscoverServicesResult DEFAULT_INSTANCE;
        private static volatile Parser<DiscoverServicesResult> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SERVICES_FIELD_NUMBER = 2;
        private String remoteId_ = "";
        private Internal.ProtobufList<BluetoothService> services_ = emptyProtobufList();

        private DiscoverServicesResult() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
        public List<BluetoothService> getServicesList() {
            return this.services_;
        }

        public List<? extends BluetoothServiceOrBuilder> getServicesOrBuilderList() {
            return this.services_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
        public int getServicesCount() {
            return this.services_.size();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
        public BluetoothService getServices(int i) {
            return this.services_.get(i);
        }

        public BluetoothServiceOrBuilder getServicesOrBuilder(int i) {
            return this.services_.get(i);
        }

        private void ensureServicesIsMutable() {
            Internal.ProtobufList<BluetoothService> protobufList = this.services_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.services_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServices(int i, BluetoothService bluetoothService) {
            bluetoothService.getClass();
            ensureServicesIsMutable();
            this.services_.set(i, bluetoothService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addServices(BluetoothService bluetoothService) {
            bluetoothService.getClass();
            ensureServicesIsMutable();
            this.services_.add(bluetoothService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addServices(int i, BluetoothService bluetoothService) {
            bluetoothService.getClass();
            ensureServicesIsMutable();
            this.services_.add(i, bluetoothService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllServices(Iterable<? extends BluetoothService> iterable) {
            ensureServicesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.services_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServices() {
            this.services_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeServices(int i) {
            ensureServicesIsMutable();
            this.services_.remove(i);
        }

        public static DiscoverServicesResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DiscoverServicesResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DiscoverServicesResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DiscoverServicesResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DiscoverServicesResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DiscoverServicesResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DiscoverServicesResult parseFrom(InputStream inputStream) throws IOException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoverServicesResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DiscoverServicesResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DiscoverServicesResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DiscoverServicesResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DiscoverServicesResult) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DiscoverServicesResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DiscoverServicesResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DiscoverServicesResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DiscoverServicesResult discoverServicesResult) {
            return DEFAULT_INSTANCE.createBuilder(discoverServicesResult);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DiscoverServicesResult, Builder> implements DiscoverServicesResultOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DiscoverServicesResult.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
            public String getRemoteId() {
                return ((DiscoverServicesResult) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((DiscoverServicesResult) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
            public List<BluetoothService> getServicesList() {
                return Collections.unmodifiableList(((DiscoverServicesResult) this.instance).getServicesList());
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
            public int getServicesCount() {
                return ((DiscoverServicesResult) this.instance).getServicesCount();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DiscoverServicesResultOrBuilder
            public BluetoothService getServices(int i) {
                return ((DiscoverServicesResult) this.instance).getServices(i);
            }

            public Builder setServices(int i, BluetoothService bluetoothService) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).setServices(i, bluetoothService);
                return this;
            }

            public Builder setServices(int i, BluetoothService.Builder builder) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).setServices(i, builder.build());
                return this;
            }

            public Builder addServices(BluetoothService bluetoothService) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).addServices(bluetoothService);
                return this;
            }

            public Builder addServices(int i, BluetoothService bluetoothService) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).addServices(i, bluetoothService);
                return this;
            }

            public Builder addServices(BluetoothService.Builder builder) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).addServices(builder.build());
                return this;
            }

            public Builder addServices(int i, BluetoothService.Builder builder) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).addServices(i, builder.build());
                return this;
            }

            public Builder addAllServices(Iterable<? extends BluetoothService> iterable) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).addAllServices(iterable);
                return this;
            }

            public Builder clearServices() {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).clearServices();
                return this;
            }

            public Builder removeServices(int i) {
                copyOnWrite();
                ((DiscoverServicesResult) this.instance).removeServices(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DiscoverServicesResult();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"remoteId_", "services_", BluetoothService.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DiscoverServicesResult> parser = PARSER;
                    if (parser == null) {
                        synchronized (DiscoverServicesResult.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DiscoverServicesResult discoverServicesResult = new DiscoverServicesResult();
            DEFAULT_INSTANCE = discoverServicesResult;
            GeneratedMessageLite.registerDefaultInstance(DiscoverServicesResult.class, discoverServicesResult);
        }

        public static DiscoverServicesResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DiscoverServicesResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ReadCharacteristicRequest extends GeneratedMessageLite<ReadCharacteristicRequest, Builder> implements ReadCharacteristicRequestOrBuilder {
        public static final int CHARACTERISTIC_UUID_FIELD_NUMBER = 2;
        private static final ReadCharacteristicRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadCharacteristicRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SECONDARY_SERVICE_UUID_FIELD_NUMBER = 4;
        public static final int SERVICE_UUID_FIELD_NUMBER = 3;
        private String remoteId_ = "";
        private String characteristicUuid_ = "";
        private String serviceUuid_ = "";
        private String secondaryServiceUuid_ = "";

        private ReadCharacteristicRequest() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public String getCharacteristicUuid() {
            return this.characteristicUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public ByteString getCharacteristicUuidBytes() {
            return ByteString.copyFromUtf8(this.characteristicUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuid(String str) {
            str.getClass();
            this.characteristicUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = getDefaultInstance().getCharacteristicUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.characteristicUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public String getSecondaryServiceUuid() {
            return this.secondaryServiceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
        public ByteString getSecondaryServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.secondaryServiceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuid(String str) {
            str.getClass();
            this.secondaryServiceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryServiceUuid() {
            this.secondaryServiceUuid_ = getDefaultInstance().getSecondaryServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.secondaryServiceUuid_ = byteString.toStringUtf8();
        }

        public static ReadCharacteristicRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadCharacteristicRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadCharacteristicRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadCharacteristicRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadCharacteristicRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadCharacteristicRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadCharacteristicRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadCharacteristicRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadCharacteristicRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadCharacteristicRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadCharacteristicRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadCharacteristicRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadCharacteristicRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadCharacteristicRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadCharacteristicRequest readCharacteristicRequest) {
            return DEFAULT_INSTANCE.createBuilder(readCharacteristicRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadCharacteristicRequest, Builder> implements ReadCharacteristicRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadCharacteristicRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public String getRemoteId() {
                return ((ReadCharacteristicRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((ReadCharacteristicRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public String getCharacteristicUuid() {
                return ((ReadCharacteristicRequest) this.instance).getCharacteristicUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public ByteString getCharacteristicUuidBytes() {
                return ((ReadCharacteristicRequest) this.instance).getCharacteristicUuidBytes();
            }

            public Builder setCharacteristicUuid(String str) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setCharacteristicUuid(str);
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder setCharacteristicUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setCharacteristicUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public String getServiceUuid() {
                return ((ReadCharacteristicRequest) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((ReadCharacteristicRequest) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public String getSecondaryServiceUuid() {
                return ((ReadCharacteristicRequest) this.instance).getSecondaryServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicRequestOrBuilder
            public ByteString getSecondaryServiceUuidBytes() {
                return ((ReadCharacteristicRequest) this.instance).getSecondaryServiceUuidBytes();
            }

            public Builder setSecondaryServiceUuid(String str) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setSecondaryServiceUuid(str);
                return this;
            }

            public Builder clearSecondaryServiceUuid() {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).clearSecondaryServiceUuid();
                return this;
            }

            public Builder setSecondaryServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadCharacteristicRequest) this.instance).setSecondaryServiceUuidBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadCharacteristicRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"remoteId_", "characteristicUuid_", "serviceUuid_", "secondaryServiceUuid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadCharacteristicRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadCharacteristicRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ReadCharacteristicRequest readCharacteristicRequest = new ReadCharacteristicRequest();
            DEFAULT_INSTANCE = readCharacteristicRequest;
            GeneratedMessageLite.registerDefaultInstance(ReadCharacteristicRequest.class, readCharacteristicRequest);
        }

        public static ReadCharacteristicRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadCharacteristicRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ReadCharacteristicResponse extends GeneratedMessageLite<ReadCharacteristicResponse, Builder> implements ReadCharacteristicResponseOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 2;
        private static final ReadCharacteristicResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadCharacteristicResponse> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        private BluetoothCharacteristic characteristic_;
        private String remoteId_ = "";

        private ReadCharacteristicResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
        public BluetoothCharacteristic getCharacteristic() {
            BluetoothCharacteristic bluetoothCharacteristic = this.characteristic_;
            return bluetoothCharacteristic == null ? BluetoothCharacteristic.getDefaultInstance() : bluetoothCharacteristic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            this.characteristic_ = bluetoothCharacteristic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            BluetoothCharacteristic bluetoothCharacteristic2 = this.characteristic_;
            if (bluetoothCharacteristic2 != null && bluetoothCharacteristic2 != BluetoothCharacteristic.getDefaultInstance()) {
                this.characteristic_ = BluetoothCharacteristic.newBuilder(this.characteristic_).mergeFrom((BluetoothCharacteristic.Builder) bluetoothCharacteristic).buildPartial();
            } else {
                this.characteristic_ = bluetoothCharacteristic;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        public static ReadCharacteristicResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadCharacteristicResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadCharacteristicResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadCharacteristicResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadCharacteristicResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadCharacteristicResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadCharacteristicResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadCharacteristicResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadCharacteristicResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadCharacteristicResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadCharacteristicResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadCharacteristicResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadCharacteristicResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadCharacteristicResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadCharacteristicResponse readCharacteristicResponse) {
            return DEFAULT_INSTANCE.createBuilder(readCharacteristicResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadCharacteristicResponse, Builder> implements ReadCharacteristicResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadCharacteristicResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
            public String getRemoteId() {
                return ((ReadCharacteristicResponse) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((ReadCharacteristicResponse) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
            public boolean hasCharacteristic() {
                return ((ReadCharacteristicResponse) this.instance).hasCharacteristic();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadCharacteristicResponseOrBuilder
            public BluetoothCharacteristic getCharacteristic() {
                return ((ReadCharacteristicResponse) this.instance).getCharacteristic();
            }

            public Builder setCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).setCharacteristic(bluetoothCharacteristic);
                return this;
            }

            public Builder setCharacteristic(BluetoothCharacteristic.Builder builder) {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).setCharacteristic(builder.build());
                return this;
            }

            public Builder mergeCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).mergeCharacteristic(bluetoothCharacteristic);
                return this;
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((ReadCharacteristicResponse) this.instance).clearCharacteristic();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadCharacteristicResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"remoteId_", "characteristic_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadCharacteristicResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadCharacteristicResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ReadCharacteristicResponse readCharacteristicResponse = new ReadCharacteristicResponse();
            DEFAULT_INSTANCE = readCharacteristicResponse;
            GeneratedMessageLite.registerDefaultInstance(ReadCharacteristicResponse.class, readCharacteristicResponse);
        }

        public static ReadCharacteristicResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadCharacteristicResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ReadDescriptorRequest extends GeneratedMessageLite<ReadDescriptorRequest, Builder> implements ReadDescriptorRequestOrBuilder {
        public static final int CHARACTERISTIC_UUID_FIELD_NUMBER = 5;
        private static final ReadDescriptorRequest DEFAULT_INSTANCE;
        public static final int DESCRIPTOR_UUID_FIELD_NUMBER = 2;
        private static volatile Parser<ReadDescriptorRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SECONDARY_SERVICE_UUID_FIELD_NUMBER = 4;
        public static final int SERVICE_UUID_FIELD_NUMBER = 3;
        private String remoteId_ = "";
        private String descriptorUuid_ = "";
        private String serviceUuid_ = "";
        private String secondaryServiceUuid_ = "";
        private String characteristicUuid_ = "";

        private ReadDescriptorRequest() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public String getDescriptorUuid() {
            return this.descriptorUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public ByteString getDescriptorUuidBytes() {
            return ByteString.copyFromUtf8(this.descriptorUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescriptorUuid(String str) {
            str.getClass();
            this.descriptorUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDescriptorUuid() {
            this.descriptorUuid_ = getDefaultInstance().getDescriptorUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescriptorUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.descriptorUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public String getSecondaryServiceUuid() {
            return this.secondaryServiceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public ByteString getSecondaryServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.secondaryServiceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuid(String str) {
            str.getClass();
            this.secondaryServiceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryServiceUuid() {
            this.secondaryServiceUuid_ = getDefaultInstance().getSecondaryServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.secondaryServiceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public String getCharacteristicUuid() {
            return this.characteristicUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
        public ByteString getCharacteristicUuidBytes() {
            return ByteString.copyFromUtf8(this.characteristicUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuid(String str) {
            str.getClass();
            this.characteristicUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = getDefaultInstance().getCharacteristicUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.characteristicUuid_ = byteString.toStringUtf8();
        }

        public static ReadDescriptorRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDescriptorRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDescriptorRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDescriptorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDescriptorRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDescriptorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDescriptorRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDescriptorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDescriptorRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDescriptorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDescriptorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDescriptorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDescriptorRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDescriptorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDescriptorRequest readDescriptorRequest) {
            return DEFAULT_INSTANCE.createBuilder(readDescriptorRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadDescriptorRequest, Builder> implements ReadDescriptorRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDescriptorRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public String getRemoteId() {
                return ((ReadDescriptorRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((ReadDescriptorRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public String getDescriptorUuid() {
                return ((ReadDescriptorRequest) this.instance).getDescriptorUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public ByteString getDescriptorUuidBytes() {
                return ((ReadDescriptorRequest) this.instance).getDescriptorUuidBytes();
            }

            public Builder setDescriptorUuid(String str) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setDescriptorUuid(str);
                return this;
            }

            public Builder clearDescriptorUuid() {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).clearDescriptorUuid();
                return this;
            }

            public Builder setDescriptorUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setDescriptorUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public String getServiceUuid() {
                return ((ReadDescriptorRequest) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((ReadDescriptorRequest) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public String getSecondaryServiceUuid() {
                return ((ReadDescriptorRequest) this.instance).getSecondaryServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public ByteString getSecondaryServiceUuidBytes() {
                return ((ReadDescriptorRequest) this.instance).getSecondaryServiceUuidBytes();
            }

            public Builder setSecondaryServiceUuid(String str) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setSecondaryServiceUuid(str);
                return this;
            }

            public Builder clearSecondaryServiceUuid() {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).clearSecondaryServiceUuid();
                return this;
            }

            public Builder setSecondaryServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setSecondaryServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public String getCharacteristicUuid() {
                return ((ReadDescriptorRequest) this.instance).getCharacteristicUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorRequestOrBuilder
            public ByteString getCharacteristicUuidBytes() {
                return ((ReadDescriptorRequest) this.instance).getCharacteristicUuidBytes();
            }

            public Builder setCharacteristicUuid(String str) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setCharacteristicUuid(str);
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder setCharacteristicUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((ReadDescriptorRequest) this.instance).setCharacteristicUuidBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDescriptorRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"remoteId_", "descriptorUuid_", "serviceUuid_", "secondaryServiceUuid_", "characteristicUuid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDescriptorRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDescriptorRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ReadDescriptorRequest readDescriptorRequest = new ReadDescriptorRequest();
            DEFAULT_INSTANCE = readDescriptorRequest;
            GeneratedMessageLite.registerDefaultInstance(ReadDescriptorRequest.class, readDescriptorRequest);
        }

        public static ReadDescriptorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDescriptorRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ReadDescriptorResponse extends GeneratedMessageLite<ReadDescriptorResponse, Builder> implements ReadDescriptorResponseOrBuilder {
        private static final ReadDescriptorResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadDescriptorResponse> PARSER = null;
        public static final int REQUEST_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        private ReadDescriptorRequest request_;
        private ByteString value_ = ByteString.EMPTY;

        private ReadDescriptorResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorResponseOrBuilder
        public boolean hasRequest() {
            return this.request_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorResponseOrBuilder
        public ReadDescriptorRequest getRequest() {
            ReadDescriptorRequest readDescriptorRequest = this.request_;
            return readDescriptorRequest == null ? ReadDescriptorRequest.getDefaultInstance() : readDescriptorRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequest(ReadDescriptorRequest readDescriptorRequest) {
            readDescriptorRequest.getClass();
            this.request_ = readDescriptorRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRequest(ReadDescriptorRequest readDescriptorRequest) {
            readDescriptorRequest.getClass();
            ReadDescriptorRequest readDescriptorRequest2 = this.request_;
            if (readDescriptorRequest2 != null && readDescriptorRequest2 != ReadDescriptorRequest.getDefaultInstance()) {
                this.request_ = ReadDescriptorRequest.newBuilder(this.request_).mergeFrom((ReadDescriptorRequest.Builder) readDescriptorRequest).buildPartial();
            } else {
                this.request_ = readDescriptorRequest;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequest() {
            this.request_ = null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorResponseOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            byteString.getClass();
            this.value_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static ReadDescriptorResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ReadDescriptorResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadDescriptorResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReadDescriptorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadDescriptorResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReadDescriptorResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadDescriptorResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDescriptorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDescriptorResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadDescriptorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadDescriptorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDescriptorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadDescriptorResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadDescriptorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDescriptorResponse readDescriptorResponse) {
            return DEFAULT_INSTANCE.createBuilder(readDescriptorResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadDescriptorResponse, Builder> implements ReadDescriptorResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ReadDescriptorResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorResponseOrBuilder
            public boolean hasRequest() {
                return ((ReadDescriptorResponse) this.instance).hasRequest();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorResponseOrBuilder
            public ReadDescriptorRequest getRequest() {
                return ((ReadDescriptorResponse) this.instance).getRequest();
            }

            public Builder setRequest(ReadDescriptorRequest readDescriptorRequest) {
                copyOnWrite();
                ((ReadDescriptorResponse) this.instance).setRequest(readDescriptorRequest);
                return this;
            }

            public Builder setRequest(ReadDescriptorRequest.Builder builder) {
                copyOnWrite();
                ((ReadDescriptorResponse) this.instance).setRequest(builder.build());
                return this;
            }

            public Builder mergeRequest(ReadDescriptorRequest readDescriptorRequest) {
                copyOnWrite();
                ((ReadDescriptorResponse) this.instance).mergeRequest(readDescriptorRequest);
                return this;
            }

            public Builder clearRequest() {
                copyOnWrite();
                ((ReadDescriptorResponse) this.instance).clearRequest();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ReadDescriptorResponseOrBuilder
            public ByteString getValue() {
                return ((ReadDescriptorResponse) this.instance).getValue();
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((ReadDescriptorResponse) this.instance).setValue(byteString);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((ReadDescriptorResponse) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadDescriptorResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\n", new Object[]{"request_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadDescriptorResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDescriptorResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ReadDescriptorResponse readDescriptorResponse = new ReadDescriptorResponse();
            DEFAULT_INSTANCE = readDescriptorResponse;
            GeneratedMessageLite.registerDefaultInstance(ReadDescriptorResponse.class, readDescriptorResponse);
        }

        public static ReadDescriptorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDescriptorResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class WriteCharacteristicRequest extends GeneratedMessageLite<WriteCharacteristicRequest, Builder> implements WriteCharacteristicRequestOrBuilder {
        public static final int CHARACTERISTIC_UUID_FIELD_NUMBER = 2;
        private static final WriteCharacteristicRequest DEFAULT_INSTANCE;
        private static volatile Parser<WriteCharacteristicRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SECONDARY_SERVICE_UUID_FIELD_NUMBER = 4;
        public static final int SERVICE_UUID_FIELD_NUMBER = 3;
        public static final int VALUE_FIELD_NUMBER = 6;
        public static final int WRITE_TYPE_FIELD_NUMBER = 5;
        private int writeType_;
        private String remoteId_ = "";
        private String characteristicUuid_ = "";
        private String serviceUuid_ = "";
        private String secondaryServiceUuid_ = "";
        private ByteString value_ = ByteString.EMPTY;

        private WriteCharacteristicRequest() {
        }

        /* loaded from: classes.dex */
        public enum WriteType implements Internal.EnumLite {
            WITH_RESPONSE(0),
            WITHOUT_RESPONSE(1),
            UNRECOGNIZED(-1);
            
            public static final int WITHOUT_RESPONSE_VALUE = 1;
            public static final int WITH_RESPONSE_VALUE = 0;
            private static final Internal.EnumLiteMap<WriteType> internalValueMap = new Internal.EnumLiteMap<WriteType>() { // from class: com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequest.WriteType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public WriteType findValueByNumber(int i) {
                    return WriteType.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }

            @Deprecated
            public static WriteType valueOf(int i) {
                return forNumber(i);
            }

            public static WriteType forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        return null;
                    }
                    return WITHOUT_RESPONSE;
                }
                return WITH_RESPONSE;
            }

            public static Internal.EnumLiteMap<WriteType> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return WriteTypeVerifier.INSTANCE;
            }

            /* loaded from: classes.dex */
            private static final class WriteTypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new WriteTypeVerifier();

                private WriteTypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return WriteType.forNumber(i) != null;
                }
            }

            WriteType(int i) {
                this.value = i;
            }
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public String getCharacteristicUuid() {
            return this.characteristicUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public ByteString getCharacteristicUuidBytes() {
            return ByteString.copyFromUtf8(this.characteristicUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuid(String str) {
            str.getClass();
            this.characteristicUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = getDefaultInstance().getCharacteristicUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.characteristicUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public String getSecondaryServiceUuid() {
            return this.secondaryServiceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public ByteString getSecondaryServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.secondaryServiceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuid(String str) {
            str.getClass();
            this.secondaryServiceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryServiceUuid() {
            this.secondaryServiceUuid_ = getDefaultInstance().getSecondaryServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.secondaryServiceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public int getWriteTypeValue() {
            return this.writeType_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public WriteType getWriteType() {
            WriteType forNumber = WriteType.forNumber(this.writeType_);
            return forNumber == null ? WriteType.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWriteTypeValue(int i) {
            this.writeType_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWriteType(WriteType writeType) {
            this.writeType_ = writeType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWriteType() {
            this.writeType_ = 0;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            byteString.getClass();
            this.value_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static WriteCharacteristicRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WriteCharacteristicRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WriteCharacteristicRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WriteCharacteristicRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WriteCharacteristicRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WriteCharacteristicRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WriteCharacteristicRequest parseFrom(InputStream inputStream) throws IOException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteCharacteristicRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WriteCharacteristicRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteCharacteristicRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteCharacteristicRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WriteCharacteristicRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteCharacteristicRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WriteCharacteristicRequest writeCharacteristicRequest) {
            return DEFAULT_INSTANCE.createBuilder(writeCharacteristicRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<WriteCharacteristicRequest, Builder> implements WriteCharacteristicRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(WriteCharacteristicRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public String getRemoteId() {
                return ((WriteCharacteristicRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((WriteCharacteristicRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public String getCharacteristicUuid() {
                return ((WriteCharacteristicRequest) this.instance).getCharacteristicUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public ByteString getCharacteristicUuidBytes() {
                return ((WriteCharacteristicRequest) this.instance).getCharacteristicUuidBytes();
            }

            public Builder setCharacteristicUuid(String str) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setCharacteristicUuid(str);
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder setCharacteristicUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setCharacteristicUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public String getServiceUuid() {
                return ((WriteCharacteristicRequest) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((WriteCharacteristicRequest) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public String getSecondaryServiceUuid() {
                return ((WriteCharacteristicRequest) this.instance).getSecondaryServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public ByteString getSecondaryServiceUuidBytes() {
                return ((WriteCharacteristicRequest) this.instance).getSecondaryServiceUuidBytes();
            }

            public Builder setSecondaryServiceUuid(String str) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setSecondaryServiceUuid(str);
                return this;
            }

            public Builder clearSecondaryServiceUuid() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearSecondaryServiceUuid();
                return this;
            }

            public Builder setSecondaryServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setSecondaryServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public int getWriteTypeValue() {
                return ((WriteCharacteristicRequest) this.instance).getWriteTypeValue();
            }

            public Builder setWriteTypeValue(int i) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setWriteTypeValue(i);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public WriteType getWriteType() {
                return ((WriteCharacteristicRequest) this.instance).getWriteType();
            }

            public Builder setWriteType(WriteType writeType) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setWriteType(writeType);
                return this;
            }

            public Builder clearWriteType() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearWriteType();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicRequestOrBuilder
            public ByteString getValue() {
                return ((WriteCharacteristicRequest) this.instance).getValue();
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).setValue(byteString);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((WriteCharacteristicRequest) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WriteCharacteristicRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f\u0006\n", new Object[]{"remoteId_", "characteristicUuid_", "serviceUuid_", "secondaryServiceUuid_", "writeType_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WriteCharacteristicRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (WriteCharacteristicRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            WriteCharacteristicRequest writeCharacteristicRequest = new WriteCharacteristicRequest();
            DEFAULT_INSTANCE = writeCharacteristicRequest;
            GeneratedMessageLite.registerDefaultInstance(WriteCharacteristicRequest.class, writeCharacteristicRequest);
        }

        public static WriteCharacteristicRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WriteCharacteristicRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class WriteCharacteristicResponse extends GeneratedMessageLite<WriteCharacteristicResponse, Builder> implements WriteCharacteristicResponseOrBuilder {
        private static final WriteCharacteristicResponse DEFAULT_INSTANCE;
        private static volatile Parser<WriteCharacteristicResponse> PARSER = null;
        public static final int REQUEST_FIELD_NUMBER = 1;
        public static final int SUCCESS_FIELD_NUMBER = 2;
        private WriteCharacteristicRequest request_;
        private boolean success_;

        private WriteCharacteristicResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicResponseOrBuilder
        public boolean hasRequest() {
            return this.request_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicResponseOrBuilder
        public WriteCharacteristicRequest getRequest() {
            WriteCharacteristicRequest writeCharacteristicRequest = this.request_;
            return writeCharacteristicRequest == null ? WriteCharacteristicRequest.getDefaultInstance() : writeCharacteristicRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequest(WriteCharacteristicRequest writeCharacteristicRequest) {
            writeCharacteristicRequest.getClass();
            this.request_ = writeCharacteristicRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRequest(WriteCharacteristicRequest writeCharacteristicRequest) {
            writeCharacteristicRequest.getClass();
            WriteCharacteristicRequest writeCharacteristicRequest2 = this.request_;
            if (writeCharacteristicRequest2 != null && writeCharacteristicRequest2 != WriteCharacteristicRequest.getDefaultInstance()) {
                this.request_ = WriteCharacteristicRequest.newBuilder(this.request_).mergeFrom((WriteCharacteristicRequest.Builder) writeCharacteristicRequest).buildPartial();
            } else {
                this.request_ = writeCharacteristicRequest;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequest() {
            this.request_ = null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z) {
            this.success_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        public static WriteCharacteristicResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WriteCharacteristicResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WriteCharacteristicResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WriteCharacteristicResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WriteCharacteristicResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WriteCharacteristicResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WriteCharacteristicResponse parseFrom(InputStream inputStream) throws IOException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteCharacteristicResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WriteCharacteristicResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteCharacteristicResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteCharacteristicResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteCharacteristicResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WriteCharacteristicResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteCharacteristicResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WriteCharacteristicResponse writeCharacteristicResponse) {
            return DEFAULT_INSTANCE.createBuilder(writeCharacteristicResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<WriteCharacteristicResponse, Builder> implements WriteCharacteristicResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(WriteCharacteristicResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicResponseOrBuilder
            public boolean hasRequest() {
                return ((WriteCharacteristicResponse) this.instance).hasRequest();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicResponseOrBuilder
            public WriteCharacteristicRequest getRequest() {
                return ((WriteCharacteristicResponse) this.instance).getRequest();
            }

            public Builder setRequest(WriteCharacteristicRequest writeCharacteristicRequest) {
                copyOnWrite();
                ((WriteCharacteristicResponse) this.instance).setRequest(writeCharacteristicRequest);
                return this;
            }

            public Builder setRequest(WriteCharacteristicRequest.Builder builder) {
                copyOnWrite();
                ((WriteCharacteristicResponse) this.instance).setRequest(builder.build());
                return this;
            }

            public Builder mergeRequest(WriteCharacteristicRequest writeCharacteristicRequest) {
                copyOnWrite();
                ((WriteCharacteristicResponse) this.instance).mergeRequest(writeCharacteristicRequest);
                return this;
            }

            public Builder clearRequest() {
                copyOnWrite();
                ((WriteCharacteristicResponse) this.instance).clearRequest();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteCharacteristicResponseOrBuilder
            public boolean getSuccess() {
                return ((WriteCharacteristicResponse) this.instance).getSuccess();
            }

            public Builder setSuccess(boolean z) {
                copyOnWrite();
                ((WriteCharacteristicResponse) this.instance).setSuccess(z);
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((WriteCharacteristicResponse) this.instance).clearSuccess();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WriteCharacteristicResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0007", new Object[]{"request_", "success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WriteCharacteristicResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (WriteCharacteristicResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            WriteCharacteristicResponse writeCharacteristicResponse = new WriteCharacteristicResponse();
            DEFAULT_INSTANCE = writeCharacteristicResponse;
            GeneratedMessageLite.registerDefaultInstance(WriteCharacteristicResponse.class, writeCharacteristicResponse);
        }

        public static WriteCharacteristicResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WriteCharacteristicResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class WriteDescriptorRequest extends GeneratedMessageLite<WriteDescriptorRequest, Builder> implements WriteDescriptorRequestOrBuilder {
        public static final int CHARACTERISTIC_UUID_FIELD_NUMBER = 5;
        private static final WriteDescriptorRequest DEFAULT_INSTANCE;
        public static final int DESCRIPTOR_UUID_FIELD_NUMBER = 2;
        private static volatile Parser<WriteDescriptorRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SECONDARY_SERVICE_UUID_FIELD_NUMBER = 4;
        public static final int SERVICE_UUID_FIELD_NUMBER = 3;
        public static final int VALUE_FIELD_NUMBER = 6;
        private String remoteId_ = "";
        private String descriptorUuid_ = "";
        private String serviceUuid_ = "";
        private String secondaryServiceUuid_ = "";
        private String characteristicUuid_ = "";
        private ByteString value_ = ByteString.EMPTY;

        private WriteDescriptorRequest() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public String getDescriptorUuid() {
            return this.descriptorUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public ByteString getDescriptorUuidBytes() {
            return ByteString.copyFromUtf8(this.descriptorUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescriptorUuid(String str) {
            str.getClass();
            this.descriptorUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDescriptorUuid() {
            this.descriptorUuid_ = getDefaultInstance().getDescriptorUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDescriptorUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.descriptorUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public String getSecondaryServiceUuid() {
            return this.secondaryServiceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public ByteString getSecondaryServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.secondaryServiceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuid(String str) {
            str.getClass();
            this.secondaryServiceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryServiceUuid() {
            this.secondaryServiceUuid_ = getDefaultInstance().getSecondaryServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.secondaryServiceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public String getCharacteristicUuid() {
            return this.characteristicUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public ByteString getCharacteristicUuidBytes() {
            return ByteString.copyFromUtf8(this.characteristicUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuid(String str) {
            str.getClass();
            this.characteristicUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = getDefaultInstance().getCharacteristicUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.characteristicUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            byteString.getClass();
            this.value_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public static WriteDescriptorRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WriteDescriptorRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WriteDescriptorRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WriteDescriptorRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WriteDescriptorRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WriteDescriptorRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WriteDescriptorRequest parseFrom(InputStream inputStream) throws IOException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteDescriptorRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteDescriptorRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WriteDescriptorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteDescriptorRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteDescriptorRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteDescriptorRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WriteDescriptorRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteDescriptorRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WriteDescriptorRequest writeDescriptorRequest) {
            return DEFAULT_INSTANCE.createBuilder(writeDescriptorRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<WriteDescriptorRequest, Builder> implements WriteDescriptorRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(WriteDescriptorRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public String getRemoteId() {
                return ((WriteDescriptorRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((WriteDescriptorRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public String getDescriptorUuid() {
                return ((WriteDescriptorRequest) this.instance).getDescriptorUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public ByteString getDescriptorUuidBytes() {
                return ((WriteDescriptorRequest) this.instance).getDescriptorUuidBytes();
            }

            public Builder setDescriptorUuid(String str) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setDescriptorUuid(str);
                return this;
            }

            public Builder clearDescriptorUuid() {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).clearDescriptorUuid();
                return this;
            }

            public Builder setDescriptorUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setDescriptorUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public String getServiceUuid() {
                return ((WriteDescriptorRequest) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((WriteDescriptorRequest) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public String getSecondaryServiceUuid() {
                return ((WriteDescriptorRequest) this.instance).getSecondaryServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public ByteString getSecondaryServiceUuidBytes() {
                return ((WriteDescriptorRequest) this.instance).getSecondaryServiceUuidBytes();
            }

            public Builder setSecondaryServiceUuid(String str) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setSecondaryServiceUuid(str);
                return this;
            }

            public Builder clearSecondaryServiceUuid() {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).clearSecondaryServiceUuid();
                return this;
            }

            public Builder setSecondaryServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setSecondaryServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public String getCharacteristicUuid() {
                return ((WriteDescriptorRequest) this.instance).getCharacteristicUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public ByteString getCharacteristicUuidBytes() {
                return ((WriteDescriptorRequest) this.instance).getCharacteristicUuidBytes();
            }

            public Builder setCharacteristicUuid(String str) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setCharacteristicUuid(str);
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder setCharacteristicUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setCharacteristicUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorRequestOrBuilder
            public ByteString getValue() {
                return ((WriteDescriptorRequest) this.instance).getValue();
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).setValue(byteString);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((WriteDescriptorRequest) this.instance).clearValue();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WriteDescriptorRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\n", new Object[]{"remoteId_", "descriptorUuid_", "serviceUuid_", "secondaryServiceUuid_", "characteristicUuid_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WriteDescriptorRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (WriteDescriptorRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            WriteDescriptorRequest writeDescriptorRequest = new WriteDescriptorRequest();
            DEFAULT_INSTANCE = writeDescriptorRequest;
            GeneratedMessageLite.registerDefaultInstance(WriteDescriptorRequest.class, writeDescriptorRequest);
        }

        public static WriteDescriptorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WriteDescriptorRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class WriteDescriptorResponse extends GeneratedMessageLite<WriteDescriptorResponse, Builder> implements WriteDescriptorResponseOrBuilder {
        private static final WriteDescriptorResponse DEFAULT_INSTANCE;
        private static volatile Parser<WriteDescriptorResponse> PARSER = null;
        public static final int REQUEST_FIELD_NUMBER = 1;
        public static final int SUCCESS_FIELD_NUMBER = 2;
        private WriteDescriptorRequest request_;
        private boolean success_;

        private WriteDescriptorResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorResponseOrBuilder
        public boolean hasRequest() {
            return this.request_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorResponseOrBuilder
        public WriteDescriptorRequest getRequest() {
            WriteDescriptorRequest writeDescriptorRequest = this.request_;
            return writeDescriptorRequest == null ? WriteDescriptorRequest.getDefaultInstance() : writeDescriptorRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRequest(WriteDescriptorRequest writeDescriptorRequest) {
            writeDescriptorRequest.getClass();
            this.request_ = writeDescriptorRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRequest(WriteDescriptorRequest writeDescriptorRequest) {
            writeDescriptorRequest.getClass();
            WriteDescriptorRequest writeDescriptorRequest2 = this.request_;
            if (writeDescriptorRequest2 != null && writeDescriptorRequest2 != WriteDescriptorRequest.getDefaultInstance()) {
                this.request_ = WriteDescriptorRequest.newBuilder(this.request_).mergeFrom((WriteDescriptorRequest.Builder) writeDescriptorRequest).buildPartial();
            } else {
                this.request_ = writeDescriptorRequest;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRequest() {
            this.request_ = null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z) {
            this.success_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        public static WriteDescriptorResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static WriteDescriptorResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static WriteDescriptorResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WriteDescriptorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WriteDescriptorResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WriteDescriptorResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WriteDescriptorResponse parseFrom(InputStream inputStream) throws IOException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteDescriptorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteDescriptorResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WriteDescriptorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WriteDescriptorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteDescriptorResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WriteDescriptorResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WriteDescriptorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WriteDescriptorResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(WriteDescriptorResponse writeDescriptorResponse) {
            return DEFAULT_INSTANCE.createBuilder(writeDescriptorResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<WriteDescriptorResponse, Builder> implements WriteDescriptorResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(WriteDescriptorResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorResponseOrBuilder
            public boolean hasRequest() {
                return ((WriteDescriptorResponse) this.instance).hasRequest();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorResponseOrBuilder
            public WriteDescriptorRequest getRequest() {
                return ((WriteDescriptorResponse) this.instance).getRequest();
            }

            public Builder setRequest(WriteDescriptorRequest writeDescriptorRequest) {
                copyOnWrite();
                ((WriteDescriptorResponse) this.instance).setRequest(writeDescriptorRequest);
                return this;
            }

            public Builder setRequest(WriteDescriptorRequest.Builder builder) {
                copyOnWrite();
                ((WriteDescriptorResponse) this.instance).setRequest(builder.build());
                return this;
            }

            public Builder mergeRequest(WriteDescriptorRequest writeDescriptorRequest) {
                copyOnWrite();
                ((WriteDescriptorResponse) this.instance).mergeRequest(writeDescriptorRequest);
                return this;
            }

            public Builder clearRequest() {
                copyOnWrite();
                ((WriteDescriptorResponse) this.instance).clearRequest();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.WriteDescriptorResponseOrBuilder
            public boolean getSuccess() {
                return ((WriteDescriptorResponse) this.instance).getSuccess();
            }

            public Builder setSuccess(boolean z) {
                copyOnWrite();
                ((WriteDescriptorResponse) this.instance).setSuccess(z);
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((WriteDescriptorResponse) this.instance).clearSuccess();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WriteDescriptorResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0007", new Object[]{"request_", "success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<WriteDescriptorResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (WriteDescriptorResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            WriteDescriptorResponse writeDescriptorResponse = new WriteDescriptorResponse();
            DEFAULT_INSTANCE = writeDescriptorResponse;
            GeneratedMessageLite.registerDefaultInstance(WriteDescriptorResponse.class, writeDescriptorResponse);
        }

        public static WriteDescriptorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WriteDescriptorResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class SetNotificationRequest extends GeneratedMessageLite<SetNotificationRequest, Builder> implements SetNotificationRequestOrBuilder {
        public static final int CHARACTERISTIC_UUID_FIELD_NUMBER = 4;
        private static final SetNotificationRequest DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 5;
        private static volatile Parser<SetNotificationRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SECONDARY_SERVICE_UUID_FIELD_NUMBER = 3;
        public static final int SERVICE_UUID_FIELD_NUMBER = 2;
        private boolean enable_;
        private String remoteId_ = "";
        private String serviceUuid_ = "";
        private String secondaryServiceUuid_ = "";
        private String characteristicUuid_ = "";

        private SetNotificationRequest() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public String getServiceUuid() {
            return this.serviceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public ByteString getServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.serviceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuid(String str) {
            str.getClass();
            this.serviceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServiceUuid() {
            this.serviceUuid_ = getDefaultInstance().getServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.serviceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public String getSecondaryServiceUuid() {
            return this.secondaryServiceUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public ByteString getSecondaryServiceUuidBytes() {
            return ByteString.copyFromUtf8(this.secondaryServiceUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuid(String str) {
            str.getClass();
            this.secondaryServiceUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecondaryServiceUuid() {
            this.secondaryServiceUuid_ = getDefaultInstance().getSecondaryServiceUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecondaryServiceUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.secondaryServiceUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public String getCharacteristicUuid() {
            return this.characteristicUuid_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public ByteString getCharacteristicUuidBytes() {
            return ByteString.copyFromUtf8(this.characteristicUuid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuid(String str) {
            str.getClass();
            this.characteristicUuid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristicUuid() {
            this.characteristicUuid_ = getDefaultInstance().getCharacteristicUuid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristicUuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.characteristicUuid_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
        public boolean getEnable() {
            return this.enable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnable(boolean z) {
            this.enable_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnable() {
            this.enable_ = false;
        }

        public static SetNotificationRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SetNotificationRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SetNotificationRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SetNotificationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SetNotificationRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SetNotificationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SetNotificationRequest parseFrom(InputStream inputStream) throws IOException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetNotificationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetNotificationRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SetNotificationRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetNotificationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetNotificationRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetNotificationRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SetNotificationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetNotificationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SetNotificationRequest setNotificationRequest) {
            return DEFAULT_INSTANCE.createBuilder(setNotificationRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<SetNotificationRequest, Builder> implements SetNotificationRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SetNotificationRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public String getRemoteId() {
                return ((SetNotificationRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((SetNotificationRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public String getServiceUuid() {
                return ((SetNotificationRequest) this.instance).getServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public ByteString getServiceUuidBytes() {
                return ((SetNotificationRequest) this.instance).getServiceUuidBytes();
            }

            public Builder setServiceUuid(String str) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setServiceUuid(str);
                return this;
            }

            public Builder clearServiceUuid() {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).clearServiceUuid();
                return this;
            }

            public Builder setServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public String getSecondaryServiceUuid() {
                return ((SetNotificationRequest) this.instance).getSecondaryServiceUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public ByteString getSecondaryServiceUuidBytes() {
                return ((SetNotificationRequest) this.instance).getSecondaryServiceUuidBytes();
            }

            public Builder setSecondaryServiceUuid(String str) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setSecondaryServiceUuid(str);
                return this;
            }

            public Builder clearSecondaryServiceUuid() {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).clearSecondaryServiceUuid();
                return this;
            }

            public Builder setSecondaryServiceUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setSecondaryServiceUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public String getCharacteristicUuid() {
                return ((SetNotificationRequest) this.instance).getCharacteristicUuid();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public ByteString getCharacteristicUuidBytes() {
                return ((SetNotificationRequest) this.instance).getCharacteristicUuidBytes();
            }

            public Builder setCharacteristicUuid(String str) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setCharacteristicUuid(str);
                return this;
            }

            public Builder clearCharacteristicUuid() {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).clearCharacteristicUuid();
                return this;
            }

            public Builder setCharacteristicUuidBytes(ByteString byteString) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setCharacteristicUuidBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationRequestOrBuilder
            public boolean getEnable() {
                return ((SetNotificationRequest) this.instance).getEnable();
            }

            public Builder setEnable(boolean z) {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).setEnable(z);
                return this;
            }

            public Builder clearEnable() {
                copyOnWrite();
                ((SetNotificationRequest) this.instance).clearEnable();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SetNotificationRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0007", new Object[]{"remoteId_", "serviceUuid_", "secondaryServiceUuid_", "characteristicUuid_", "enable_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SetNotificationRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (SetNotificationRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SetNotificationRequest setNotificationRequest = new SetNotificationRequest();
            DEFAULT_INSTANCE = setNotificationRequest;
            GeneratedMessageLite.registerDefaultInstance(SetNotificationRequest.class, setNotificationRequest);
        }

        public static SetNotificationRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetNotificationRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class SetNotificationResponse extends GeneratedMessageLite<SetNotificationResponse, Builder> implements SetNotificationResponseOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 2;
        private static final SetNotificationResponse DEFAULT_INSTANCE;
        private static volatile Parser<SetNotificationResponse> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int SUCCESS_FIELD_NUMBER = 3;
        private BluetoothCharacteristic characteristic_;
        private String remoteId_ = "";
        private boolean success_;

        private SetNotificationResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
        public BluetoothCharacteristic getCharacteristic() {
            BluetoothCharacteristic bluetoothCharacteristic = this.characteristic_;
            return bluetoothCharacteristic == null ? BluetoothCharacteristic.getDefaultInstance() : bluetoothCharacteristic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            this.characteristic_ = bluetoothCharacteristic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            BluetoothCharacteristic bluetoothCharacteristic2 = this.characteristic_;
            if (bluetoothCharacteristic2 != null && bluetoothCharacteristic2 != BluetoothCharacteristic.getDefaultInstance()) {
                this.characteristic_ = BluetoothCharacteristic.newBuilder(this.characteristic_).mergeFrom((BluetoothCharacteristic.Builder) bluetoothCharacteristic).buildPartial();
            } else {
                this.characteristic_ = bluetoothCharacteristic;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
        public boolean getSuccess() {
            return this.success_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSuccess(boolean z) {
            this.success_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSuccess() {
            this.success_ = false;
        }

        public static SetNotificationResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SetNotificationResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SetNotificationResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SetNotificationResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SetNotificationResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SetNotificationResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SetNotificationResponse parseFrom(InputStream inputStream) throws IOException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetNotificationResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetNotificationResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SetNotificationResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SetNotificationResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetNotificationResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SetNotificationResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SetNotificationResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SetNotificationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SetNotificationResponse setNotificationResponse) {
            return DEFAULT_INSTANCE.createBuilder(setNotificationResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<SetNotificationResponse, Builder> implements SetNotificationResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(SetNotificationResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
            public String getRemoteId() {
                return ((SetNotificationResponse) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((SetNotificationResponse) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
            public boolean hasCharacteristic() {
                return ((SetNotificationResponse) this.instance).hasCharacteristic();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
            public BluetoothCharacteristic getCharacteristic() {
                return ((SetNotificationResponse) this.instance).getCharacteristic();
            }

            public Builder setCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).setCharacteristic(bluetoothCharacteristic);
                return this;
            }

            public Builder setCharacteristic(BluetoothCharacteristic.Builder builder) {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).setCharacteristic(builder.build());
                return this;
            }

            public Builder mergeCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).mergeCharacteristic(bluetoothCharacteristic);
                return this;
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).clearCharacteristic();
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.SetNotificationResponseOrBuilder
            public boolean getSuccess() {
                return ((SetNotificationResponse) this.instance).getSuccess();
            }

            public Builder setSuccess(boolean z) {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).setSuccess(z);
                return this;
            }

            public Builder clearSuccess() {
                copyOnWrite();
                ((SetNotificationResponse) this.instance).clearSuccess();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new SetNotificationResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u0007", new Object[]{"remoteId_", "characteristic_", "success_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SetNotificationResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (SetNotificationResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SetNotificationResponse setNotificationResponse = new SetNotificationResponse();
            DEFAULT_INSTANCE = setNotificationResponse;
            GeneratedMessageLite.registerDefaultInstance(SetNotificationResponse.class, setNotificationResponse);
        }

        public static SetNotificationResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetNotificationResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class OnCharacteristicChanged extends GeneratedMessageLite<OnCharacteristicChanged, Builder> implements OnCharacteristicChangedOrBuilder {
        public static final int CHARACTERISTIC_FIELD_NUMBER = 2;
        private static final OnCharacteristicChanged DEFAULT_INSTANCE;
        private static volatile Parser<OnCharacteristicChanged> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        private BluetoothCharacteristic characteristic_;
        private String remoteId_ = "";

        private OnCharacteristicChanged() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
        public boolean hasCharacteristic() {
            return this.characteristic_ != null;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
        public BluetoothCharacteristic getCharacteristic() {
            BluetoothCharacteristic bluetoothCharacteristic = this.characteristic_;
            return bluetoothCharacteristic == null ? BluetoothCharacteristic.getDefaultInstance() : bluetoothCharacteristic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            this.characteristic_ = bluetoothCharacteristic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
            bluetoothCharacteristic.getClass();
            BluetoothCharacteristic bluetoothCharacteristic2 = this.characteristic_;
            if (bluetoothCharacteristic2 != null && bluetoothCharacteristic2 != BluetoothCharacteristic.getDefaultInstance()) {
                this.characteristic_ = BluetoothCharacteristic.newBuilder(this.characteristic_).mergeFrom((BluetoothCharacteristic.Builder) bluetoothCharacteristic).buildPartial();
            } else {
                this.characteristic_ = bluetoothCharacteristic;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCharacteristic() {
            this.characteristic_ = null;
        }

        public static OnCharacteristicChanged parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static OnCharacteristicChanged parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OnCharacteristicChanged parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static OnCharacteristicChanged parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OnCharacteristicChanged parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static OnCharacteristicChanged parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OnCharacteristicChanged parseFrom(InputStream inputStream) throws IOException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnCharacteristicChanged parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnCharacteristicChanged parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OnCharacteristicChanged) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static OnCharacteristicChanged parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnCharacteristicChanged) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OnCharacteristicChanged parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OnCharacteristicChanged parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OnCharacteristicChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OnCharacteristicChanged onCharacteristicChanged) {
            return DEFAULT_INSTANCE.createBuilder(onCharacteristicChanged);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<OnCharacteristicChanged, Builder> implements OnCharacteristicChangedOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(OnCharacteristicChanged.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
            public String getRemoteId() {
                return ((OnCharacteristicChanged) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((OnCharacteristicChanged) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
            public boolean hasCharacteristic() {
                return ((OnCharacteristicChanged) this.instance).hasCharacteristic();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.OnCharacteristicChangedOrBuilder
            public BluetoothCharacteristic getCharacteristic() {
                return ((OnCharacteristicChanged) this.instance).getCharacteristic();
            }

            public Builder setCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).setCharacteristic(bluetoothCharacteristic);
                return this;
            }

            public Builder setCharacteristic(BluetoothCharacteristic.Builder builder) {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).setCharacteristic(builder.build());
                return this;
            }

            public Builder mergeCharacteristic(BluetoothCharacteristic bluetoothCharacteristic) {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).mergeCharacteristic(bluetoothCharacteristic);
                return this;
            }

            public Builder clearCharacteristic() {
                copyOnWrite();
                ((OnCharacteristicChanged) this.instance).clearCharacteristic();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new OnCharacteristicChanged();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"remoteId_", "characteristic_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OnCharacteristicChanged> parser = PARSER;
                    if (parser == null) {
                        synchronized (OnCharacteristicChanged.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            OnCharacteristicChanged onCharacteristicChanged = new OnCharacteristicChanged();
            DEFAULT_INSTANCE = onCharacteristicChanged;
            GeneratedMessageLite.registerDefaultInstance(OnCharacteristicChanged.class, onCharacteristicChanged);
        }

        public static OnCharacteristicChanged getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnCharacteristicChanged> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class DeviceStateResponse extends GeneratedMessageLite<DeviceStateResponse, Builder> implements DeviceStateResponseOrBuilder {
        private static final DeviceStateResponse DEFAULT_INSTANCE;
        private static volatile Parser<DeviceStateResponse> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        public static final int STATE_FIELD_NUMBER = 2;
        private String remoteId_ = "";
        private int state_;

        private DeviceStateResponse() {
        }

        /* loaded from: classes.dex */
        public enum BluetoothDeviceState implements Internal.EnumLite {
            DISCONNECTED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            UNRECOGNIZED(-1);
            
            public static final int CONNECTED_VALUE = 2;
            public static final int CONNECTING_VALUE = 1;
            public static final int DISCONNECTED_VALUE = 0;
            public static final int DISCONNECTING_VALUE = 3;
            private static final Internal.EnumLiteMap<BluetoothDeviceState> internalValueMap = new Internal.EnumLiteMap<BluetoothDeviceState>() { // from class: com.pauldemarco.flutter_blue.Protos.DeviceStateResponse.BluetoothDeviceState.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public BluetoothDeviceState findValueByNumber(int i) {
                    return BluetoothDeviceState.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }

            @Deprecated
            public static BluetoothDeviceState valueOf(int i) {
                return forNumber(i);
            }

            public static BluetoothDeviceState forNumber(int i) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                return null;
                            }
                            return DISCONNECTING;
                        }
                        return CONNECTED;
                    }
                    return CONNECTING;
                }
                return DISCONNECTED;
            }

            public static Internal.EnumLiteMap<BluetoothDeviceState> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return BluetoothDeviceStateVerifier.INSTANCE;
            }

            /* loaded from: classes.dex */
            private static final class BluetoothDeviceStateVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new BluetoothDeviceStateVerifier();

                private BluetoothDeviceStateVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return BluetoothDeviceState.forNumber(i) != null;
                }
            }

            BluetoothDeviceState(int i) {
                this.value = i;
            }
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
        public int getStateValue() {
            return this.state_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
        public BluetoothDeviceState getState() {
            BluetoothDeviceState forNumber = BluetoothDeviceState.forNumber(this.state_);
            return forNumber == null ? BluetoothDeviceState.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStateValue(int i) {
            this.state_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setState(BluetoothDeviceState bluetoothDeviceState) {
            this.state_ = bluetoothDeviceState.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            this.state_ = 0;
        }

        public static DeviceStateResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static DeviceStateResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DeviceStateResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DeviceStateResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DeviceStateResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DeviceStateResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DeviceStateResponse parseFrom(InputStream inputStream) throws IOException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceStateResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeviceStateResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DeviceStateResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DeviceStateResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceStateResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DeviceStateResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DeviceStateResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DeviceStateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeviceStateResponse deviceStateResponse) {
            return DEFAULT_INSTANCE.createBuilder(deviceStateResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DeviceStateResponse, Builder> implements DeviceStateResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(DeviceStateResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
            public String getRemoteId() {
                return ((DeviceStateResponse) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((DeviceStateResponse) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((DeviceStateResponse) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((DeviceStateResponse) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((DeviceStateResponse) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
            public int getStateValue() {
                return ((DeviceStateResponse) this.instance).getStateValue();
            }

            public Builder setStateValue(int i) {
                copyOnWrite();
                ((DeviceStateResponse) this.instance).setStateValue(i);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.DeviceStateResponseOrBuilder
            public BluetoothDeviceState getState() {
                return ((DeviceStateResponse) this.instance).getState();
            }

            public Builder setState(BluetoothDeviceState bluetoothDeviceState) {
                copyOnWrite();
                ((DeviceStateResponse) this.instance).setState(bluetoothDeviceState);
                return this;
            }

            public Builder clearState() {
                copyOnWrite();
                ((DeviceStateResponse) this.instance).clearState();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new DeviceStateResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"remoteId_", "state_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DeviceStateResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (DeviceStateResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DeviceStateResponse deviceStateResponse = new DeviceStateResponse();
            DEFAULT_INSTANCE = deviceStateResponse;
            GeneratedMessageLite.registerDefaultInstance(DeviceStateResponse.class, deviceStateResponse);
        }

        public static DeviceStateResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeviceStateResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class ConnectedDevicesResponse extends GeneratedMessageLite<ConnectedDevicesResponse, Builder> implements ConnectedDevicesResponseOrBuilder {
        private static final ConnectedDevicesResponse DEFAULT_INSTANCE;
        public static final int DEVICES_FIELD_NUMBER = 1;
        private static volatile Parser<ConnectedDevicesResponse> PARSER;
        private Internal.ProtobufList<BluetoothDevice> devices_ = emptyProtobufList();

        private ConnectedDevicesResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ConnectedDevicesResponseOrBuilder
        public List<BluetoothDevice> getDevicesList() {
            return this.devices_;
        }

        public List<? extends BluetoothDeviceOrBuilder> getDevicesOrBuilderList() {
            return this.devices_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ConnectedDevicesResponseOrBuilder
        public int getDevicesCount() {
            return this.devices_.size();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.ConnectedDevicesResponseOrBuilder
        public BluetoothDevice getDevices(int i) {
            return this.devices_.get(i);
        }

        public BluetoothDeviceOrBuilder getDevicesOrBuilder(int i) {
            return this.devices_.get(i);
        }

        private void ensureDevicesIsMutable() {
            Internal.ProtobufList<BluetoothDevice> protobufList = this.devices_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.devices_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevices(int i, BluetoothDevice bluetoothDevice) {
            bluetoothDevice.getClass();
            ensureDevicesIsMutable();
            this.devices_.set(i, bluetoothDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDevices(BluetoothDevice bluetoothDevice) {
            bluetoothDevice.getClass();
            ensureDevicesIsMutable();
            this.devices_.add(bluetoothDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDevices(int i, BluetoothDevice bluetoothDevice) {
            bluetoothDevice.getClass();
            ensureDevicesIsMutable();
            this.devices_.add(i, bluetoothDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDevices(Iterable<? extends BluetoothDevice> iterable) {
            ensureDevicesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.devices_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevices() {
            this.devices_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDevices(int i) {
            ensureDevicesIsMutable();
            this.devices_.remove(i);
        }

        public static ConnectedDevicesResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ConnectedDevicesResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ConnectedDevicesResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ConnectedDevicesResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ConnectedDevicesResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ConnectedDevicesResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ConnectedDevicesResponse parseFrom(InputStream inputStream) throws IOException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectedDevicesResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectedDevicesResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ConnectedDevicesResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ConnectedDevicesResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectedDevicesResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ConnectedDevicesResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ConnectedDevicesResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ConnectedDevicesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConnectedDevicesResponse connectedDevicesResponse) {
            return DEFAULT_INSTANCE.createBuilder(connectedDevicesResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ConnectedDevicesResponse, Builder> implements ConnectedDevicesResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(ConnectedDevicesResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ConnectedDevicesResponseOrBuilder
            public List<BluetoothDevice> getDevicesList() {
                return Collections.unmodifiableList(((ConnectedDevicesResponse) this.instance).getDevicesList());
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ConnectedDevicesResponseOrBuilder
            public int getDevicesCount() {
                return ((ConnectedDevicesResponse) this.instance).getDevicesCount();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.ConnectedDevicesResponseOrBuilder
            public BluetoothDevice getDevices(int i) {
                return ((ConnectedDevicesResponse) this.instance).getDevices(i);
            }

            public Builder setDevices(int i, BluetoothDevice bluetoothDevice) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).setDevices(i, bluetoothDevice);
                return this;
            }

            public Builder setDevices(int i, BluetoothDevice.Builder builder) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).setDevices(i, builder.build());
                return this;
            }

            public Builder addDevices(BluetoothDevice bluetoothDevice) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).addDevices(bluetoothDevice);
                return this;
            }

            public Builder addDevices(int i, BluetoothDevice bluetoothDevice) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).addDevices(i, bluetoothDevice);
                return this;
            }

            public Builder addDevices(BluetoothDevice.Builder builder) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).addDevices(builder.build());
                return this;
            }

            public Builder addDevices(int i, BluetoothDevice.Builder builder) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).addDevices(i, builder.build());
                return this;
            }

            public Builder addAllDevices(Iterable<? extends BluetoothDevice> iterable) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).addAllDevices(iterable);
                return this;
            }

            public Builder clearDevices() {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).clearDevices();
                return this;
            }

            public Builder removeDevices(int i) {
                copyOnWrite();
                ((ConnectedDevicesResponse) this.instance).removeDevices(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ConnectedDevicesResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"devices_", BluetoothDevice.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConnectedDevicesResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ConnectedDevicesResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ConnectedDevicesResponse connectedDevicesResponse = new ConnectedDevicesResponse();
            DEFAULT_INSTANCE = connectedDevicesResponse;
            GeneratedMessageLite.registerDefaultInstance(ConnectedDevicesResponse.class, connectedDevicesResponse);
        }

        public static ConnectedDevicesResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConnectedDevicesResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class MtuSizeRequest extends GeneratedMessageLite<MtuSizeRequest, Builder> implements MtuSizeRequestOrBuilder {
        private static final MtuSizeRequest DEFAULT_INSTANCE;
        public static final int MTU_FIELD_NUMBER = 2;
        private static volatile Parser<MtuSizeRequest> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        private int mtu_;
        private String remoteId_ = "";

        private MtuSizeRequest() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeRequestOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeRequestOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeRequestOrBuilder
        public int getMtu() {
            return this.mtu_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMtu(int i) {
            this.mtu_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMtu() {
            this.mtu_ = 0;
        }

        public static MtuSizeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MtuSizeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MtuSizeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MtuSizeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MtuSizeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MtuSizeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MtuSizeRequest parseFrom(InputStream inputStream) throws IOException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MtuSizeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MtuSizeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MtuSizeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MtuSizeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MtuSizeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MtuSizeRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MtuSizeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MtuSizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MtuSizeRequest mtuSizeRequest) {
            return DEFAULT_INSTANCE.createBuilder(mtuSizeRequest);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MtuSizeRequest, Builder> implements MtuSizeRequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MtuSizeRequest.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeRequestOrBuilder
            public String getRemoteId() {
                return ((MtuSizeRequest) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeRequestOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((MtuSizeRequest) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((MtuSizeRequest) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((MtuSizeRequest) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((MtuSizeRequest) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeRequestOrBuilder
            public int getMtu() {
                return ((MtuSizeRequest) this.instance).getMtu();
            }

            public Builder setMtu(int i) {
                copyOnWrite();
                ((MtuSizeRequest) this.instance).setMtu(i);
                return this;
            }

            public Builder clearMtu() {
                copyOnWrite();
                ((MtuSizeRequest) this.instance).clearMtu();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MtuSizeRequest();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u000b", new Object[]{"remoteId_", "mtu_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MtuSizeRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (MtuSizeRequest.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            MtuSizeRequest mtuSizeRequest = new MtuSizeRequest();
            DEFAULT_INSTANCE = mtuSizeRequest;
            GeneratedMessageLite.registerDefaultInstance(MtuSizeRequest.class, mtuSizeRequest);
        }

        public static MtuSizeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MtuSizeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes.dex */
    public static final class MtuSizeResponse extends GeneratedMessageLite<MtuSizeResponse, Builder> implements MtuSizeResponseOrBuilder {
        private static final MtuSizeResponse DEFAULT_INSTANCE;
        public static final int MTU_FIELD_NUMBER = 2;
        private static volatile Parser<MtuSizeResponse> PARSER = null;
        public static final int REMOTE_ID_FIELD_NUMBER = 1;
        private int mtu_;
        private String remoteId_ = "";

        private MtuSizeResponse() {
        }

        @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeResponseOrBuilder
        public String getRemoteId() {
            return this.remoteId_;
        }

        @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeResponseOrBuilder
        public ByteString getRemoteIdBytes() {
            return ByteString.copyFromUtf8(this.remoteId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteId(String str) {
            str.getClass();
            this.remoteId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemoteId() {
            this.remoteId_ = getDefaultInstance().getRemoteId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemoteIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.remoteId_ = byteString.toStringUtf8();
        }

        @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeResponseOrBuilder
        public int getMtu() {
            return this.mtu_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMtu(int i) {
            this.mtu_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMtu() {
            this.mtu_ = 0;
        }

        public static MtuSizeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MtuSizeResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MtuSizeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MtuSizeResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MtuSizeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MtuSizeResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MtuSizeResponse parseFrom(InputStream inputStream) throws IOException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MtuSizeResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MtuSizeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MtuSizeResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MtuSizeResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MtuSizeResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MtuSizeResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MtuSizeResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MtuSizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MtuSizeResponse mtuSizeResponse) {
            return DEFAULT_INSTANCE.createBuilder(mtuSizeResponse);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MtuSizeResponse, Builder> implements MtuSizeResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MtuSizeResponse.DEFAULT_INSTANCE);
            }

            @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeResponseOrBuilder
            public String getRemoteId() {
                return ((MtuSizeResponse) this.instance).getRemoteId();
            }

            @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeResponseOrBuilder
            public ByteString getRemoteIdBytes() {
                return ((MtuSizeResponse) this.instance).getRemoteIdBytes();
            }

            public Builder setRemoteId(String str) {
                copyOnWrite();
                ((MtuSizeResponse) this.instance).setRemoteId(str);
                return this;
            }

            public Builder clearRemoteId() {
                copyOnWrite();
                ((MtuSizeResponse) this.instance).clearRemoteId();
                return this;
            }

            public Builder setRemoteIdBytes(ByteString byteString) {
                copyOnWrite();
                ((MtuSizeResponse) this.instance).setRemoteIdBytes(byteString);
                return this;
            }

            @Override // com.pauldemarco.flutter_blue.Protos.MtuSizeResponseOrBuilder
            public int getMtu() {
                return ((MtuSizeResponse) this.instance).getMtu();
            }

            public Builder setMtu(int i) {
                copyOnWrite();
                ((MtuSizeResponse) this.instance).setMtu(i);
                return this;
            }

            public Builder clearMtu() {
                copyOnWrite();
                ((MtuSizeResponse) this.instance).clearMtu();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MtuSizeResponse();
                case 2:
                    return new Builder(null);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u000b", new Object[]{"remoteId_", "mtu_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MtuSizeResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (MtuSizeResponse.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            MtuSizeResponse mtuSizeResponse = new MtuSizeResponse();
            DEFAULT_INSTANCE = mtuSizeResponse;
            GeneratedMessageLite.registerDefaultInstance(MtuSizeResponse.class, mtuSizeResponse);
        }

        public static MtuSizeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MtuSizeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
