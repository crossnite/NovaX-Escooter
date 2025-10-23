package com.baseflow.permissionhandler;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
final class ServiceManager {

    @FunctionalInterface
    /* loaded from: classes.dex */
    interface SuccessCallback {
        void onSuccess(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkServiceStatus(int i, Context context, SuccessCallback successCallback, ErrorCallback errorCallback) {
        if (context == null) {
            Log.d("permissions_handler", "Context cannot be null.");
            errorCallback.onError("PermissionHandler.ServiceManager", "Android context cannot be null.");
        } else if (i == 3 || i == 4 || i == 5) {
            successCallback.onSuccess(isLocationServiceEnabled(context) ? 1 : 0);
        } else {
            if (i == 21) {
                successCallback.onSuccess(isBluetoothServiceEnabled(context) ? 1 : 0);
            }
            if (i != 8) {
                if (i == 16) {
                    successCallback.onSuccess(Build.VERSION.SDK_INT < 23 ? 2 : 1);
                    return;
                } else {
                    successCallback.onSuccess(2);
                    return;
                }
            }
            PackageManager packageManager = context.getPackageManager();
            if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
                successCallback.onSuccess(2);
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                successCallback.onSuccess(2);
            } else if (getCallAppsList(packageManager).isEmpty()) {
                successCallback.onSuccess(2);
            } else if (telephonyManager.getSimState() != 5) {
                successCallback.onSuccess(0);
            } else {
                successCallback.onSuccess(1);
            }
        }
    }

    private boolean isLocationServiceEnabled(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
            if (locationManager == null) {
                return false;
            }
            return locationManager.isLocationEnabled();
        } else if (Build.VERSION.SDK_INT >= 19) {
            return isLocationServiceEnabledKitKat(context);
        } else {
            return isLocationServiceEnablePreKitKat(context);
        }
    }

    private static boolean isLocationServiceEnabledKitKat(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return false;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean isLocationServiceEnablePreKitKat(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return false;
        }
        return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
    }

    private boolean isBluetoothServiceEnabled(Context context) {
        if (Build.VERSION.SDK_INT < 18) {
            return BluetoothAdapter.getDefaultAdapter().isEnabled();
        }
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }

    private List<ResolveInfo> getCallAppsList(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:123123"));
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L));
        }
        return packageManager.queryIntentActivities(intent, 0);
    }
}
