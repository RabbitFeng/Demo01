package demo.utils.memory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberCheck {

    static double getQualityValue(double value, int quality) {
        return BigDecimal.valueOf(value).setScale(quality, RoundingMode.HALF_UP).doubleValue();
    }

    static float getQualityValue(float value, int quality) {
        return BigDecimal.valueOf(value).setScale(quality, RoundingMode.HALF_UP).floatValue();
    }

    /**
     * 检查数字溢出
     *
     * @throws NumberOverflowException 数字溢出
     */
    public static void checkForOverflow(double a, double b) throws NumberOverflowException {
        double max = Double.max(a, b);
        double min = Double.min(a, b);
        if (max > 1 && (Double.MAX_VALUE / max) < min) {
            throw new NumberOverflowException(NumberOverflowException.DOUBLE_OVERFLOW + a + " * " + b);
        }
    }

    public static void checkForOverflow(double a, Class<? extends Number> cls) throws NumberOverflowException {
        if (cls.isAssignableFrom(Long.class)) {
            if (Long.MAX_VALUE < a) {
                throw new NumberOverflowException(String.format(NumberOverflowException.DOUBLE_TO_LONG, a));
            }
        }
        if (cls.isAssignableFrom(Integer.class)) {
            if (Integer.MAX_VALUE < a) {
                throw new NumberOverflowException(String.format(NumberOverflowException.DOUBLE_TO_INTEGER, a));
            }
        }
        if (cls.isAssignableFrom(Float.class)) {
            if (Float.MAX_VALUE < a) {
                throw new NumberOverflowException(String.format(NumberOverflowException.DOUBLE_TO_FLOAT, a));
            }
        }
    }
}