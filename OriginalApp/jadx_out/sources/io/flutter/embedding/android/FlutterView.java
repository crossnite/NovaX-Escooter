package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.SpellCheckPlugin;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate, KeyboardManager.ViewDelegate {
    private static final String TAG = "FlutterView";
    private AccessibilityBridge accessibilityBridge;
    private AndroidTouchProcessor androidTouchProcessor;
    private FlutterEngine flutterEngine;
    private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    private FlutterImageView flutterImageView;
    private FlutterSurfaceView flutterSurfaceView;
    private FlutterTextureView flutterTextureView;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    private boolean isFlutterUiDisplayed;
    private KeyboardManager keyboardManager;
    private LocalizationPlugin localizationPlugin;
    private MouseCursorPlugin mouseCursorPlugin;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    private RenderSurface previousRenderSurface;
    RenderSurface renderSurface;
    private SpellCheckPlugin spellCheckPlugin;
    private final ContentObserver systemSettingsObserver;
    private TextInputPlugin textInputPlugin;
    private TextServicesManager textServicesManager;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;
    private final Consumer<WindowLayoutInfo> windowInfoListener;
    private WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepo;

    /* loaded from: classes.dex */
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode) {
        super(context, null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                if (FlutterView.this.flutterEngine == null) {
                    return;
                }
                Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                FlutterView.this.sendUserSettingsToFlutter();
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.3
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() { // from class: io.flutter.embedding.android.FlutterView.4
            @Override // androidx.core.util.Consumer
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context);
            this.flutterSurfaceView = flutterSurfaceView;
            this.renderSurface = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
        }
        init();
    }

    @Deprecated
    public FlutterView(Context context, TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(Context context, FlutterSurfaceView flutterSurfaceView) {
        this(context, (AttributeSet) null, flutterSurfaceView);
    }

    public FlutterView(Context context, FlutterTextureView flutterTextureView) {
        this(context, (AttributeSet) null, flutterTextureView);
    }

    public FlutterView(Context context, FlutterImageView flutterImageView) {
        this(context, (AttributeSet) null, flutterImageView);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(Context context, RenderMode renderMode, TransparencyMode transparencyMode) {
        super(context, null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                if (FlutterView.this.flutterEngine == null) {
                    return;
                }
                Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                FlutterView.this.sendUserSettingsToFlutter();
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.3
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() { // from class: io.flutter.embedding.android.FlutterView.4
            @Override // androidx.core.util.Consumer
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent);
            this.flutterSurfaceView = flutterSurfaceView;
            this.renderSurface = flutterSurfaceView;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView;
            this.renderSurface = flutterTextureView;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", renderMode));
        }
        init();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterSurfaceView flutterSurfaceView) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                if (FlutterView.this.flutterEngine == null) {
                    return;
                }
                Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                FlutterView.this.sendUserSettingsToFlutter();
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.3
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() { // from class: io.flutter.embedding.android.FlutterView.4
            @Override // androidx.core.util.Consumer
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterSurfaceView = flutterSurfaceView;
        this.renderSurface = flutterSurfaceView;
        init();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterTextureView flutterTextureView) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                if (FlutterView.this.flutterEngine == null) {
                    return;
                }
                Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                FlutterView.this.sendUserSettingsToFlutter();
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.3
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() { // from class: io.flutter.embedding.android.FlutterView.4
            @Override // androidx.core.util.Consumer
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterTextureView = flutterTextureView;
        this.renderSurface = flutterTextureView;
        init();
    }

    private FlutterView(Context context, AttributeSet attributeSet, FlutterImageView flutterImageView) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() { // from class: io.flutter.embedding.android.FlutterView.1
            @Override // io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener
            public void onAccessibilityChanged(boolean z, boolean z2) {
                FlutterView.this.resetWillNotDraw(z, z2);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: io.flutter.embedding.android.FlutterView.2
            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                if (FlutterView.this.flutterEngine == null) {
                    return;
                }
                Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                FlutterView.this.sendUserSettingsToFlutter();
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.3
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiDisplayed();
                }
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener flutterUiDisplayListener : FlutterView.this.flutterUiDisplayListeners) {
                    flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() { // from class: io.flutter.embedding.android.FlutterView.4
            @Override // androidx.core.util.Consumer
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterImageView = flutterImageView;
        this.renderSurface = flutterImageView;
        init();
    }

    private void init() {
        Log.v(TAG, "Initializing FlutterView");
        if (this.flutterSurfaceView != null) {
            Log.v(TAG, "Internally using a FlutterSurfaceView.");
            addView(this.flutterSurfaceView);
        } else if (this.flutterTextureView != null) {
            Log.v(TAG, "Internally using a FlutterTextureView.");
            addView(this.flutterTextureView);
        } else {
            Log.v(TAG, "Internally using a FlutterImageView.");
            addView(this.flutterImageView);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    public boolean hasRenderedFirstFrame() {
        return this.isFlutterUiDisplayed;
    }

    public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener flutterUiDisplayListener) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.flutterEngine != null) {
            Log.v(TAG, "Configuration changed. Sending locales and user settings to Flutter.");
            this.localizationPlugin.sendLocalesToFlutter(configuration);
            sendUserSettingsToFlutter();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Log.v(TAG, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i3 + " x " + i4 + ", it is now " + i + " x " + i2);
        this.viewportMetrics.width = i;
        this.viewportMetrics.height = i2;
        sendViewportMetricsToFlutter();
    }

    protected WindowInfoRepositoryCallbackAdapterWrapper createWindowInfoRepo() {
        try {
            return new WindowInfoRepositoryCallbackAdapterWrapper(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.windowInfoRepo = createWindowInfoRepo();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.windowInfoRepo;
        if (windowInfoRepositoryCallbackAdapterWrapper == null || activity == null) {
            return;
        }
        windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(getContext()), this.windowInfoListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.windowInfoRepo;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.windowInfoListener);
        }
        this.windowInfoRepo = null;
        super.onDetachedFromWindow();
    }

    protected void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        FlutterRenderer.DisplayFeatureType displayFeatureType;
        FlutterRenderer.DisplayFeatureState displayFeatureState;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature displayFeature : displayFeatures) {
            Log.v(TAG, "WindowInfoTracker Display Feature reported with bounds = " + displayFeature.getBounds().toString() + " and type = " + displayFeature.getClass().getSimpleName());
            if (displayFeature instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) displayFeature;
                if (foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL) {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.HINGE;
                } else {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.FOLD;
                }
                if (foldingFeature.getState() == FoldingFeature.State.FLAT) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_FLAT;
                } else if (foldingFeature.getState() == FoldingFeature.State.HALF_OPENED) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_HALF_OPENED;
                } else {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.UNKNOWN;
                }
                arrayList.add(new FlutterRenderer.DisplayFeature(displayFeature.getBounds(), displayFeatureType, displayFeatureState));
            } else {
                arrayList.add(new FlutterRenderer.DisplayFeature(displayFeature.getBounds(), FlutterRenderer.DisplayFeatureType.UNKNOWN, FlutterRenderer.DisplayFeatureState.UNKNOWN));
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
            for (Rect rect : displayCutout.getBoundingRects()) {
                Log.v(TAG, "DisplayCutout area reported with bounds = " + rect.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(rect, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.viewportMetrics.displayFeatures = arrayList;
        sendViewportMetricsToFlutter();
    }

    private ZeroSides calculateShouldZeroSides() {
        Context context = getContext();
        int i = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? ZeroSides.LEFT : ZeroSides.RIGHT;
            } else if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        if (Build.VERSION.SDK_INT == 29) {
            Insets systemGestureInsets = windowInsets.getSystemGestureInsets();
            this.viewportMetrics.systemGestureInsetTop = systemGestureInsets.top;
            this.viewportMetrics.systemGestureInsetRight = systemGestureInsets.right;
            this.viewportMetrics.systemGestureInsetBottom = systemGestureInsets.bottom;
            this.viewportMetrics.systemGestureInsetLeft = systemGestureInsets.left;
        }
        boolean z = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z2 = (getWindowSystemUiVisibility() & 2) == 0;
        if (Build.VERSION.SDK_INT >= 30) {
            int navigationBars = z2 ? 0 | WindowInsets.Type.navigationBars() : 0;
            if (z) {
                navigationBars |= WindowInsets.Type.statusBars();
            }
            Insets insets = windowInsets.getInsets(navigationBars);
            this.viewportMetrics.viewPaddingTop = insets.top;
            this.viewportMetrics.viewPaddingRight = insets.right;
            this.viewportMetrics.viewPaddingBottom = insets.bottom;
            this.viewportMetrics.viewPaddingLeft = insets.left;
            Insets insets2 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.viewportMetrics.viewInsetTop = insets2.top;
            this.viewportMetrics.viewInsetRight = insets2.right;
            this.viewportMetrics.viewInsetBottom = insets2.bottom;
            this.viewportMetrics.viewInsetLeft = insets2.left;
            Insets insets3 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.viewportMetrics.systemGestureInsetTop = insets3.top;
            this.viewportMetrics.systemGestureInsetRight = insets3.right;
            this.viewportMetrics.systemGestureInsetBottom = insets3.bottom;
            this.viewportMetrics.systemGestureInsetLeft = insets3.left;
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                Insets waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics = this.viewportMetrics;
                viewportMetrics.viewPaddingTop = Math.max(Math.max(viewportMetrics.viewPaddingTop, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
                viewportMetrics2.viewPaddingRight = Math.max(Math.max(viewportMetrics2.viewPaddingRight, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
                viewportMetrics3.viewPaddingBottom = Math.max(Math.max(viewportMetrics3.viewPaddingBottom, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
                viewportMetrics4.viewPaddingLeft = Math.max(Math.max(viewportMetrics4.viewPaddingLeft, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z2) {
                zeroSides = calculateShouldZeroSides();
            }
            this.viewportMetrics.viewPaddingTop = z ? windowInsets.getSystemWindowInsetTop() : 0;
            this.viewportMetrics.viewPaddingRight = (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.viewportMetrics.viewPaddingBottom = (z2 && guessBottomKeyboardInset(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.viewportMetrics.viewPaddingLeft = (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            this.viewportMetrics.viewInsetTop = 0;
            this.viewportMetrics.viewInsetRight = 0;
            this.viewportMetrics.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
            this.viewportMetrics.viewInsetLeft = 0;
        }
        Log.v(TAG, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return onApplyWindowInsets;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT <= 19) {
            this.viewportMetrics.viewPaddingTop = rect.top;
            this.viewportMetrics.viewPaddingRight = rect.right;
            this.viewportMetrics.viewPaddingBottom = 0;
            this.viewportMetrics.viewPaddingLeft = rect.left;
            this.viewportMetrics.viewInsetTop = 0;
            this.viewportMetrics.viewInsetRight = 0;
            this.viewportMetrics.viewInsetBottom = rect.bottom;
            this.viewportMetrics.viewInsetLeft = 0;
            Log.v(TAG, "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
            sendViewportMetricsToFlutter();
            return true;
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.textInputPlugin.createInputConnection(this, this.keyboardManager, editorInfo);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine != null) {
            return flutterEngine.getPlatformViewsController().checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (isAttachedToFlutterEngine() && this.keyboardManager.handleEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            requestUnbufferedDispatch(motionEvent);
        }
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (isAttachedToFlutterEngine() && this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.accessibilityBridge;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    public View findViewByAccessibilityIdTraversal(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            return findViewByAccessibilityIdRootedAtCurrentView(i, this);
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            return (View) declaredMethod.invoke(this, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private View findViewByAccessibilityIdRootedAtCurrentView(int i, View view) {
        int i2;
        Method declaredMethod;
        try {
            i2 = 0;
            declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            declaredMethod.setAccessible(true);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (declaredMethod.invoke(view, new Object[0]).equals(Integer.valueOf(i))) {
            return view;
        }
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    break;
                }
                View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i, viewGroup.getChildAt(i2));
                if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                    return findViewByAccessibilityIdRootedAtCurrentView;
                }
                i2++;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetWillNotDraw(boolean z, boolean z2) {
        boolean z3 = false;
        if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled()) {
            if (!z && !z2) {
                z3 = true;
            }
            setWillNotDraw(z3);
            return;
        }
        setWillNotDraw(false);
    }

    @Override // io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate
    public PointerIcon getSystemPointerIcon(int i) {
        return PointerIcon.getSystemIcon(getContext(), i);
    }

    @Override // io.flutter.embedding.android.KeyboardManager.ViewDelegate
    public BinaryMessenger getBinaryMessenger() {
        return this.flutterEngine.getDartExecutor();
    }

    @Override // io.flutter.embedding.android.KeyboardManager.ViewDelegate
    public boolean onTextInputKeyEvent(KeyEvent keyEvent) {
        return this.textInputPlugin.handleKeyEvent(keyEvent);
    }

    @Override // io.flutter.embedding.android.KeyboardManager.ViewDelegate
    public void redispatch(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    public void attachToFlutterEngine(FlutterEngine flutterEngine) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.flutterEngine = flutterEngine;
        FlutterRenderer renderer = flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
        }
        this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.textServicesManager = textServicesManager;
            this.spellCheckPlugin = new SpellCheckPlugin(textServicesManager, this.flutterEngine.getSpellCheckChannel());
        } catch (Exception unused) {
            Log.e(TAG, "TextServicesManager not supported by device, spell check disabled.");
        }
        this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.keyboardManager = new KeyboardManager(this);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, flutterEngine.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        sendUserSettingsToFlutter();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.systemSettingsObserver);
        sendViewportMetricsToFlutter();
        flutterEngine.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineAttachedToFlutterView(flutterEngine);
        }
        if (this.isFlutterUiDisplayed) {
            this.flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void detachFromFlutterEngine() {
        Log.v(TAG, "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.v(TAG, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener flutterEngineAttachmentListener : this.flutterEngineAttachmentListeners) {
            flutterEngineAttachmentListener.onFlutterEngineDetachedFromFlutterView();
        }
        getContext().getContentResolver().unregisterContentObserver(this.systemSettingsObserver);
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.flutterEngine.getPlatformViewsController().detachAccessibilityBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.textInputPlugin.destroy();
        this.keyboardManager.destroy();
        SpellCheckPlugin spellCheckPlugin = this.spellCheckPlugin;
        if (spellCheckPlugin != null) {
            spellCheckPlugin.destroy();
        }
        MouseCursorPlugin mouseCursorPlugin = this.mouseCursorPlugin;
        if (mouseCursorPlugin != null) {
            mouseCursorPlugin.destroy();
        }
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface = this.previousRenderSurface;
        if (renderSurface != null && this.renderSurface == this.flutterImageView) {
            this.renderSurface = renderSurface;
        }
        this.renderSurface.detachFromRenderer();
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView != null) {
            flutterImageView.closeImageReader();
            removeView(this.flutterImageView);
            this.flutterImageView = null;
        }
        this.previousRenderSurface = null;
        this.flutterEngine = null;
    }

    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public FlutterImageView getCurrentImageSurface() {
        return this.flutterImageView;
    }

    public void convertToImageView() {
        this.renderSurface.pause();
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView == null) {
            FlutterImageView createImageView = createImageView();
            this.flutterImageView = createImageView;
            addView(createImageView);
        } else {
            flutterImageView.resizeIfNeeded(getWidth(), getHeight());
        }
        this.previousRenderSurface = this.renderSurface;
        FlutterImageView flutterImageView2 = this.flutterImageView;
        this.renderSurface = flutterImageView2;
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine != null) {
            flutterImageView2.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public void revertImageView(final Runnable runnable) {
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView == null) {
            Log.v(TAG, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.previousRenderSurface;
        if (renderSurface == null) {
            Log.v(TAG, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.renderSurface = renderSurface;
        this.previousRenderSurface = null;
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine == null) {
            flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine.getRenderer();
        if (renderer == null) {
            this.flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        this.renderSurface.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() { // from class: io.flutter.embedding.android.FlutterView.5
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                if ((FlutterView.this.renderSurface instanceof FlutterImageView) || FlutterView.this.flutterImageView == null) {
                    return;
                }
                FlutterView.this.flutterImageView.detachFromRenderer();
            }
        });
    }

    public void attachOverlaySurfaceToRender(FlutterImageView flutterImageView) {
        FlutterEngine flutterEngine = this.flutterEngine;
        if (flutterEngine != null) {
            flutterImageView.attachToRenderer(flutterEngine.getRenderer());
        }
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView = this.flutterImageView;
        if (flutterImageView != null) {
            return flutterImageView.acquireLatestImage();
        }
        return false;
    }

    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine = this.flutterEngine;
        return flutterEngine != null && flutterEngine.getRenderer() == this.renderSurface.getAttachedRenderer();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
    }

    public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        if (r3 != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void sendUserSettingsToFlutter() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 0
            r2 = 1
            r3 = 32
            if (r0 != r3) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1a
            io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness r0 = io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness.dark
            goto L1c
        L1a:
            io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness r0 = io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness.light
        L1c:
            android.view.textservice.TextServicesManager r3 = r6.textServicesManager
            if (r3 == 0) goto L42
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L40
            android.view.textservice.TextServicesManager r3 = r6.textServicesManager
            java.util.List r3 = r3.getEnabledSpellCheckerInfos()
            java.util.stream.Stream r3 = r3.stream()
            io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0 r4 = new java.util.function.Predicate() { // from class: io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0
                static {
                    /*
                        io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0 r0 = new io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0) io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0.INSTANCE io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0.<init>():void");
                }

                @Override // java.util.function.Predicate
                public final boolean test(java.lang.Object r1) {
                    /*
                        r0 = this;
                        android.view.textservice.SpellCheckerInfo r1 = (android.view.textservice.SpellCheckerInfo) r1
                        boolean r1 = io.flutter.embedding.android.FlutterView.lambda$sendUserSettingsToFlutter$0(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView$$ExternalSyntheticLambda0.test(java.lang.Object):boolean");
                }
            }
            boolean r3 = r3.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.textServicesManager
            boolean r4 = r4.isSpellCheckerEnabled()
            if (r4 == 0) goto L42
            if (r3 == 0) goto L42
        L40:
            r3 = 1
            goto L43
        L42:
            r3 = 0
        L43:
            io.flutter.embedding.engine.FlutterEngine r4 = r6.flutterEngine
            io.flutter.embedding.engine.systemchannels.SettingsChannel r4 = r4.getSettingsChannel()
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.startMessage()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.setTextScaleFactor(r5)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r3 = r4.setNativeSpellCheckServiceDefined(r3)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r2)
            if (r4 != r2) goto L70
            r1 = 1
        L70:
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r3.setBrieflyShowPassword(r1)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r1.setUse24HourFormat(r2)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r0 = r1.setPlatformBrightness(r0)
            r0.send()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.sendUserSettingsToFlutter():void");
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            Log.w(TAG, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.viewportMetrics.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        this.textInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.textInputPlugin.autofill(sparseArray);
    }
}
