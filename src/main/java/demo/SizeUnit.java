package demo;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum SizeUnit {

    BIT {
        @Override
        public Result toBit(double value, int quality) {
            return ResultImpl.valueOf(value, quality);
        }

        @Override
        public Result toByte(double value, int quality) {
            return ResultImpl.valueOf(value / (S_BYTE / S_BIT), quality);
        }

        @Override
        public Result toKB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_KB / S_BIT), quality);
        }

        @Override
        public Result toMB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_MB / S_BIT), quality);
        }

        @Override
        public Result toGB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_GB / S_BIT), quality);
        }

        @Override
        public Result toTB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_BIT), quality);
        }
    },

    BYTE {
        @Override
        public Result toBit(double value, int quality) {
            return ResultImpl.valueOf(value * (S_BYTE / S_BIT), quality);
        }

        @Override
        public Result toByte(double value, int quality) {
            return ResultImpl.valueOf(value, quality);
        }

        @Override
        public Result toKB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_KB / S_BYTE), quality);
        }

        @Override
        public Result toMB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_MB / S_BYTE), quality);
        }

        @Override
        public Result toGB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_GB / S_BYTE), quality);
        }

        @Override
        public Result toTB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_BYTE), quality);
        }
    },

    KB {
        @Override
        public Result toBit(double value, int quality) {
            return ResultImpl.valueOf(value * (S_KB / S_BIT), quality);
        }

        @Override
        public Result toByte(double value, int quality) {
            return ResultImpl.valueOf(value * (S_KB / S_BYTE), quality);
        }

        @Override
        public Result toKB(double value, int quality) {
            return ResultImpl.valueOf(value, quality);
        }

        @Override
        public Result toMB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_MB / S_KB), quality);
        }

        @Override
        public Result toGB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_GB / S_KB), quality);
        }

        @Override
        public Result toTB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_KB), quality);
        }
    },

    MB {
        @Override
        public Result toBit(double value, int quality) {
            return ResultImpl.valueOf(value * (S_MB / S_BIT), quality);
        }

        @Override
        public Result toByte(double value, int quality) {
            return ResultImpl.valueOf(value * (S_MB / S_BYTE), quality);
        }

        @Override
        public Result toKB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_MB / S_KB), quality);
        }

        @Override
        public Result toMB(double value, int quality) {
            return ResultImpl.valueOf(value, quality);
        }

        @Override
        public Result toGB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_GB / S_MB), quality);
        }

        @Override
        public Result toTB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_MB), quality);
        }
    },

    GB {
        @Override
        public Result toBit(double value, int quality) {
            return ResultImpl.valueOf(value * (S_GB / S_BIT), quality);
        }

        @Override
        public Result toByte(double value, int quality) {
            return ResultImpl.valueOf(value * (S_GB / S_BYTE), quality);
        }

        @Override
        public Result toKB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_GB / S_KB), quality);
        }

        @Override
        public Result toMB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_GB / S_MB), quality);
        }

        @Override
        public Result toGB(double value, int quality) {
            return ResultImpl.valueOf(value, quality);
        }

        @Override
        public Result toTB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_GB), quality);
        }
    },

    TB {
        @Override
        public Result toBit(double value, int quality) {
            return ResultImpl.valueOf(value * (S_TB / S_BIT), quality);
        }

        @Override
        public Result toByte(double value, int quality) {
            return ResultImpl.valueOf(value * (S_TB / S_BYTE), quality);
        }

        @Override
        public Result toKB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_KB), quality);
        }

        @Override
        public Result toMB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_MB), quality);
        }

        @Override
        public Result toGB(double value, int quality) {
            return ResultImpl.valueOf(value / (S_TB / S_GB), quality);
        }

        @Override
        public Result toTB(double value, int quality) {
            return ResultImpl.valueOf(value, quality);
        }
    };

    static final double S_BIT = 1L;
    static final double S_BYTE = S_BIT * 8L;
    static final double S_KB = S_BYTE * 1024L;
    static final double S_MB = S_KB * 1024L;
    static final double S_GB = S_MB * 1024L;
    static final double S_TB = S_GB * 1024L;

    @NotNull
    public Result toBit(double value, int quality) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toByte(double value, int quality) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toKB(double value, int quality) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toMB(double value, int quality) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toGB(double value, int quality) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toTB(double value, int quality) {
        throw new AbstractMethodError();
    }

    static double getQualityValue(double value, int quality) {
        return BigDecimal.valueOf(value).setScale(quality, RoundingMode.HALF_UP).doubleValue();
    }

    static double safeMultiply(double a, double b) {
        double result = 0;
        try {
            NumberCheck.multiplyOverflow(a, b);
            result = a * b;
        } catch (NumberOverflowException e) {
            e.printStackTrace();
            result = Double.MAX_VALUE;
        }
        return result;
    }

    interface Result {
        double toDouble();

        int toInt();

        long toLong();
    }

    static class ResultImpl implements Cloneable, Result {
        public static ResultImpl valueOf(double value, int quality) {
            return newInstance(getQualityValue(value, quality));
        }

        private static ResultImpl newInstance(double value) {
            ResultImpl clone = null;
            try {
                clone = (ResultImpl) INSTANCE.clone();
            } catch (CloneNotSupportedException | ClassCastException e) {
                e.printStackTrace();
            }
            if (clone == null) {
                clone = new ResultImpl();
            }
            clone.value = value;
            return clone;
        }

        private static final ResultImpl INSTANCE = new ResultImpl();

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        double value;

        @Override
        public double toDouble() {
            return value;
        }

        @Override
        public int toInt() {
            return (int) value;
        }

        @Override
        public long toLong() {
            return (long) value;
        }

        @Override
        public String toString() {
            return "ResultImpl{" +
                    "value=" + value +
                    '}';
        }
    }

    public static class NumberOverflowException extends Exception {
        public static String NUMBER_OVERFLOW = "Number overflow; Caused by ";
        public static String DOUBLE_OVERFLOW = "Double overflow; Caused by";
        public static String DOUBLE_TO_INTEGER = "convert double to int";
        public static String DOUBLE_TO_FLOAT = "convert double to float";
        public static String DOUBLE_TO_LONG = "convert double to long";

        public NumberOverflowException() {
            this(NUMBER_OVERFLOW);
        }

        public NumberOverflowException(String message) {
            super(message);
        }
    }

    public static class NumberCheck {
        // ????????????
        public static void multiplyOverflow(double a, double b) throws NumberOverflowException {
            if ((Double.MAX_VALUE / a) < b) {
                throw new NumberOverflowException(NumberOverflowException.DOUBLE_OVERFLOW);
            }
        }
    }
}
