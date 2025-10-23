package io.flutter.util;

import androidx.tracing.Trace;
/* loaded from: classes.dex */
public final class TraceSection {
    public static void begin(String str) {
        if (str.length() >= 124) {
            str = str.substring(0, 124) + "...";
        }
        Trace.beginSection(str);
    }

    public static void end() throws RuntimeException {
        Trace.endSection();
    }
}
