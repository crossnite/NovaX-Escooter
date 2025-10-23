package io.flutter.plugins;

import com.baseflow.permissionhandler.PermissionHandlerPlugin;
import com.pauldemarco.flutter_blue.FlutterBluePlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
/* loaded from: classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add(new FlutterBluePlugin());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin flutter_blue, com.pauldemarco.flutter_blue.FlutterBluePlugin", e);
        }
        try {
            flutterEngine.getPlugins().add(new PermissionHandlerPlugin());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e2);
        }
    }
}
