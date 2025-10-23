package androidx.core.graphics;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import java.util.Objects;
/* loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private static float constrain(float amount, float low, float high) {
        return amount < low ? low : amount > high ? high : amount;
    }

    private static int constrain(int amount, int low, int high) {
        return amount < low ? low : amount > high ? high : amount;
    }

    private ColorUtils() {
    }

    public static int compositeColors(int foreground, int background) {
        int alpha = Color.alpha(background);
        int alpha2 = Color.alpha(foreground);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(foreground), alpha2, Color.red(background), alpha, compositeAlpha), compositeComponent(Color.green(foreground), alpha2, Color.green(background), alpha, compositeAlpha), compositeComponent(Color.blue(foreground), alpha2, Color.blue(background), alpha, compositeAlpha));
    }

    public static Color compositeColors(Color foreground, Color background) {
        if (!Objects.equals(foreground.getModel(), background.getModel())) {
            throw new IllegalArgumentException("Color models must match (" + foreground.getModel() + " vs. " + background.getModel() + ")");
        }
        if (!Objects.equals(background.getColorSpace(), foreground.getColorSpace())) {
            foreground = foreground.convert(background.getColorSpace());
        }
        float[] components = foreground.getComponents();
        float[] components2 = background.getComponents();
        float alpha = foreground.alpha();
        float alpha2 = background.alpha() * (1.0f - alpha);
        int componentCount = background.getComponentCount() - 1;
        components2[componentCount] = alpha + alpha2;
        if (components2[componentCount] > 0.0f) {
            alpha /= components2[componentCount];
            alpha2 /= components2[componentCount];
        }
        for (int i = 0; i < componentCount; i++) {
            components2[i] = (components[i] * alpha) + (components2[i] * alpha2);
        }
        return Color.valueOf(components2, background.getColorSpace());
    }

    private static int compositeAlpha(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / 255);
    }

    private static int compositeComponent(int fgC, int fgA, int bgC, int bgA, int a) {
        if (a == 0) {
            return 0;
        }
        return (((fgC * 255) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a * 255);
    }

    public static double calculateLuminance(int color) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(color, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static double calculateContrast(int foreground, int background) {
        if (Color.alpha(background) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        }
        if (Color.alpha(foreground) < 255) {
            foreground = compositeColors(foreground, background);
        }
        double calculateLuminance = calculateLuminance(foreground) + 0.05d;
        double calculateLuminance2 = calculateLuminance(background) + 0.05d;
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    public static int calculateMinimumAlpha(int foreground, int background, float minContrastRatio) {
        int i = 255;
        if (Color.alpha(background) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        }
        double d = minContrastRatio;
        if (calculateContrast(setAlphaComponent(foreground, 255), background) < d) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 <= 10 && i - i2 > 1; i3++) {
            int i4 = (i2 + i) / 2;
            if (calculateContrast(setAlphaComponent(foreground, i4), background) < d) {
                i2 = i4;
            } else {
                i = i4;
            }
        }
        return i;
    }

    public static void RGBToHSL(int r, int g, int b, float[] outHsl) {
        float f;
        float abs;
        float f2 = r / 255.0f;
        float f3 = g / 255.0f;
        float f4 = b / 255.0f;
        float max = Math.max(f2, Math.max(f3, f4));
        float min = Math.min(f2, Math.min(f3, f4));
        float f5 = max - min;
        float f6 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            abs = 0.0f;
        } else {
            f = max == f2 ? ((f3 - f4) / f5) % 6.0f : max == f3 ? ((f4 - f2) / f5) + 2.0f : 4.0f + ((f2 - f3) / f5);
            abs = f5 / (1.0f - Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        outHsl[0] = constrain(f7, 0.0f, 360.0f);
        outHsl[1] = constrain(abs, 0.0f, 1.0f);
        outHsl[2] = constrain(f6, 0.0f, 1.0f);
    }

    public static void colorToHSL(int color, float[] outHsl) {
        RGBToHSL(Color.red(color), Color.green(color), Color.blue(color), outHsl);
    }

    public static int HSLToColor(float[] hsl) {
        int round;
        int round2;
        int round3;
        float f = hsl[0];
        float f2 = hsl[1];
        float f3 = hsl[2];
        float abs = (1.0f - Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f) / 60) {
            case 0:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round(f4 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round(f4 * 255.0f);
                break;
            case 2:
                round = Math.round(f4 * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            case 3:
                round = Math.round(f4 * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round(f4 * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round(f4 * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    public static int setAlphaComponent(int color, int alpha) {
        if (alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (color & ViewCompat.MEASURED_SIZE_MASK) | (alpha << 24);
    }

    public static void colorToLAB(int color, double[] outLab) {
        RGBToLAB(Color.red(color), Color.green(color), Color.blue(color), outLab);
    }

    public static void RGBToLAB(int r, int g, int b, double[] outLab) {
        RGBToXYZ(r, g, b, outLab);
        XYZToLAB(outLab[0], outLab[1], outLab[2], outLab);
    }

    public static void colorToXYZ(int color, double[] outXyz) {
        RGBToXYZ(Color.red(color), Color.green(color), Color.blue(color), outXyz);
    }

    public static void RGBToXYZ(int r, int g, int b, double[] outXyz) {
        if (outXyz.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = r / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = g / 255.0d;
        double pow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = b / 255.0d;
        double pow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        outXyz[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * XYZ_WHITE_REFERENCE_Y;
        outXyz[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * XYZ_WHITE_REFERENCE_Y;
        outXyz[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
    }

    public static void XYZToLAB(double x, double y, double z, double[] outLab) {
        if (outLab.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double pivotXyzComponent = pivotXyzComponent(x / XYZ_WHITE_REFERENCE_X);
        double pivotXyzComponent2 = pivotXyzComponent(y / XYZ_WHITE_REFERENCE_Y);
        double pivotXyzComponent3 = pivotXyzComponent(z / XYZ_WHITE_REFERENCE_Z);
        outLab[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
        outLab[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
        outLab[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
    }

    public static void LABToXYZ(final double l, final double a, final double b, double[] outXyz) {
        double d = (l + 16.0d) / 116.0d;
        double d2 = (a / 500.0d) + d;
        double d3 = d - (b / 200.0d);
        double pow = Math.pow(d2, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d2 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double pow2 = l > 7.9996247999999985d ? Math.pow(d, 3.0d) : l / XYZ_KAPPA;
        double pow3 = Math.pow(d3, 3.0d);
        if (pow3 <= XYZ_EPSILON) {
            pow3 = ((d3 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        outXyz[0] = pow * XYZ_WHITE_REFERENCE_X;
        outXyz[1] = pow2 * XYZ_WHITE_REFERENCE_Y;
        outXyz[2] = pow3 * XYZ_WHITE_REFERENCE_Z;
    }

    public static int XYZToColor(double x, double y, double z) {
        double d = (((3.2406d * x) + ((-1.5372d) * y)) + ((-0.4986d) * z)) / XYZ_WHITE_REFERENCE_Y;
        double d2 = ((((-0.9689d) * x) + (1.8758d * y)) + (0.0415d * z)) / XYZ_WHITE_REFERENCE_Y;
        double d3 = (((0.0557d * x) + ((-0.204d) * y)) + (1.057d * z)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d > 0.0031308d ? (Math.pow(d, 0.4166666666666667d) * 1.055d) - 0.055d : d * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d2 > 0.0031308d ? (Math.pow(d2, 0.4166666666666667d) * 1.055d) - 0.055d : d2 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d3 > 0.0031308d ? (Math.pow(d3, 0.4166666666666667d) * 1.055d) - 0.055d : d3 * 12.92d) * 255.0d), 0, 255));
    }

    public static int LABToColor(final double l, final double a, final double b) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(l, a, b, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static double distanceEuclidean(double[] labX, double[] labY) {
        return Math.sqrt(Math.pow(labX[0] - labY[0], 2.0d) + Math.pow(labX[1] - labY[1], 2.0d) + Math.pow(labX[2] - labY[2], 2.0d));
    }

    private static double pivotXyzComponent(double component) {
        return component > XYZ_EPSILON ? Math.pow(component, 0.3333333333333333d) : ((component * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    public static int blendARGB(int color1, int color2, float ratio) {
        float f = 1.0f - ratio;
        return Color.argb((int) ((Color.alpha(color1) * f) + (Color.alpha(color2) * ratio)), (int) ((Color.red(color1) * f) + (Color.red(color2) * ratio)), (int) ((Color.green(color1) * f) + (Color.green(color2) * ratio)), (int) ((Color.blue(color1) * f) + (Color.blue(color2) * ratio)));
    }

    public static void blendHSL(float[] hsl1, float[] hsl2, float ratio, float[] outResult) {
        if (outResult.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f = 1.0f - ratio;
        outResult[0] = circularInterpolate(hsl1[0], hsl2[0], ratio);
        outResult[1] = (hsl1[1] * f) + (hsl2[1] * ratio);
        outResult[2] = (hsl1[2] * f) + (hsl2[2] * ratio);
    }

    public static void blendLAB(double[] lab1, double[] lab2, double ratio, double[] outResult) {
        if (outResult.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d = 1.0d - ratio;
        outResult[0] = (lab1[0] * d) + (lab2[0] * ratio);
        outResult[1] = (lab1[1] * d) + (lab2[1] * ratio);
        outResult[2] = (lab1[2] * d) + (lab2[2] * ratio);
    }

    static float circularInterpolate(float a, float b, float f) {
        if (Math.abs(b - a) > 180.0f) {
            if (b > a) {
                a += 360.0f;
            } else {
                b += 360.0f;
            }
        }
        return (a + ((b - a) * f)) % 360.0f;
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }
}
