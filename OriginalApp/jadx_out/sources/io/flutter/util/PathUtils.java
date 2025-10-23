package io.flutter.util;

import android.content.Context;
import android.os.Build;
import java.io.File;
/* loaded from: classes.dex */
public final class PathUtils {
    public static String getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(getDataDirPath(context), "files");
        }
        return filesDir.getPath();
    }

    public static String getDataDirectory(Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(getDataDirPath(context), "app_flutter");
        }
        return dir.getPath();
    }

    public static String getCacheDirectory(Context context) {
        File cacheDir;
        if (Build.VERSION.SDK_INT >= 21) {
            cacheDir = context.getCodeCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getCacheDir();
            }
        } else {
            cacheDir = context.getCacheDir();
        }
        if (cacheDir == null) {
            cacheDir = new File(getDataDirPath(context), "cache");
        }
        return cacheDir.getPath();
    }

    private static String getDataDirPath(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir().getPath();
        }
        return context.getApplicationInfo().dataDir;
    }
}
