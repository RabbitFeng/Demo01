package demo;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum MemoryUnit {

    BIT {
        @Override
        public Result toBit(double value) {
            return ResultImpl.valueOf(value);
        }

        @Override
        public Result toByte(double value) {
            return ResultImpl.valueOf(value / (S_BYTE / S_BIT));
        }

        @Override
        public Result toKB(double value) {
            return ResultImpl.valueOf(value / (S_KB / S_BIT));
        }

        @Override
        public Result toMB(double value) {
            return ResultImpl.valueOf(value / (S_MB / S_BIT));
        }

        @Override
        public Result toGB(double value) {
            return ResultImpl.valueOf(value / (S_GB / S_BIT));
        }

        @Override
        public Result toTB(double value) {
            return ResultImpl.valueOf(value / (S_TB / S_BIT));
        }
    },

    BYTE {
        @Override
        public Result toBit(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_BYTE / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultImpl.valueOf(value);
        }

        @Override
        public Result toKB(double value) {
            return ResultImpl.valueOf(value / (S_KB / S_BYTE));
        }

        @Override
        public Result toMB(double value) {
            return ResultImpl.valueOf(value / (S_MB / S_BYTE));
        }

        @Override
        public Result toGB(double value) {
            return ResultImpl.valueOf(value / (S_GB / S_BYTE));
        }

        @Override
        public Result toTB(double value) {
            return ResultImpl.valueOf(value / (S_TB / S_BYTE));
        }
    },

    KB {
        @Override
        public Result toBit(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_KB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_KB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultImpl.valueOf(value);
        }

        @Override
        public Result toMB(double value) {
            return ResultImpl.valueOf(value / (S_MB / S_KB));
        }

        @Override
        public Result toGB(double value) {
            return ResultImpl.valueOf(value / (S_GB / S_KB));
        }

        @Override
        public Result toTB(double value) {
            return ResultImpl.valueOf(value / (S_TB / S_KB));
        }
    },

    MB {
        @Override
        public Result toBit(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_MB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_MB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_MB / S_KB)));
        }

        @Override
        public Result toMB(double value) {
            return ResultImpl.valueOf(value);
        }

        @Override
        public Result toGB(double value) {
            return ResultImpl.valueOf(value / (S_GB / S_MB));
        }

        @Override
        public Result toTB(double value) {
            return ResultImpl.valueOf(value / (S_TB / S_MB));
        }
    },

    GB {
        @Override
        public Result toBit(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_GB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_GB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_GB / S_KB)));
        }

        @Override
        public Result toMB(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_GB / S_MB)));
        }

        @Override
        public Result toGB(double value) {
            return ResultImpl.valueOf(value);
        }

        @Override
        public Result toTB(double value) {
            return ResultImpl.valueOf(value / (S_TB / S_GB));
        }
    },

    TB {
        @Override
        public Result toBit(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_TB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_TB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_TB / S_KB)));
        }

        @Override
        public Result toMB(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_TB / S_MB)));
        }

        @Override
        public Result toGB(double value) {
            return ResultImpl.valueOf(safeMultiply(value, (S_TB / S_GB)));
        }

        @Override
        public Result toTB(double value) {
            return ResultImpl.valueOf(value);
        }
    };

    static final double S_BIT = 1L;
    static final double S_BYTE = S_BIT * 8L;
    static final double S_KB = S_BYTE * 1024L;
    static final double S_MB = S_KB * 1024L;
    static final double S_GB = S_MB * 1024L;
    static final double S_TB = S_GB * 1024L;

    @NotNull
    public Result toBit(double value) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toByte(double value) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toKB(double value) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toMB(double value) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toGB(double value) {
        throw new AbstractMethodError();
    }

    @NotNull
    public Result toTB(double value) {
        throw new AbstractMethodError();
    }

    static double getQualityValue(double value, int quality) {
        return BigDecimal.valueOf(value).setScale(quality, RoundingMode.HALF_UP).doubleValue();
    }

    static float getQualityValue(float value, int quality) {
        return BigDecimal.valueOf(value).setScale(quality, RoundingMode.HALF_UP).floatValue();
    }

    static double safeMultiply(double a, double b) {
        double result = 0;
        try {
            NumberCheck.checkForOverflow(a, b);
            result = a * b;
        } catch (NumberOverflowException e) {
            e.printStackTrace();
            result = Double.MAX_VALUE;
        }
        return result;
    }

    interface Result {
        double doubleValue();

        double doubleValue(int quality);

        int intValue();

        long longValue();

        float floatValue();

        float floatValue(int quality);
    }

    static class ResultImpl implements Cloneable, Result {
        public static ResultImpl valueOf(double value) {
            return newInstance(value);
        }

        private static ResultImpl newInstance(double value) {
            ResultImpl result = new ResultImpl();
            result.value = value;
            return result;
//            ResultImpl clone = null;
//            try {
//                clone = (ResultImpl) INSTANCE.clone();
//            } catch (CloneNotSupportedException | ClassCastException e) {
//                e.printStackTrace();
//            }
//            if (clone == null) {
//                clone = new ResultImpl();
//            }
//            clone.value = value;
//            return clone;
        }

        private static final ResultImpl INSTANCE = new ResultImpl();

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        double value;

        @Override
        public double doubleValue() {
            return value;
        }

        @Override
        public double doubleValue(int quality) {
            return getQualityValue(value, quality);
        }

        @Override
        public int intValue() {
            int intVal = 0;
            try {
                NumberCheck.checkForOverflow(value, Integer.class);
                intVal = (int) value;
            } catch (NumberOverflowException e) {
                e.printStackTrace();
                intVal = Integer.MAX_VALUE;
            }
            return intVal;
        }

        @Override
        public long longValue() {
            long longVal = 0L;
            try {
                NumberCheck.checkForOverflow(value, Integer.class);
                longVal = (long) value;
            } catch (NumberOverflowException e) {
                e.printStackTrace();
                longVal = Long.MAX_VALUE;
            }
            return longVal;
        }

        @Override
        public float floatValue() {
            float floatVal = 0f;
            try {
                NumberCheck.checkForOverflow(value, Float.class);
                floatVal = (float) value;
            } catch (NumberOverflowException e) {
                e.printStackTrace();
                floatVal = Float.MAX_VALUE;
            }
            return floatVal;
        }

        @Override
        public float floatValue(int quality) {
            return getQualityValue(floatValue(), quality);
        }

        @Override
        public String toString() {
            return "ResultImpl{" +
                    "value=" + value +
                    '}';
        }
    }

    public static class NumberOverflowException extends RuntimeException {
        public static String NUMBER_OVERFLOW = "Number overflow; Caused by ";
        public static String DOUBLE_OVERFLOW = "Double overflow; Caused by";
        public static String DOUBLE_TO_INTEGER = NUMBER_OVERFLOW + "convert double %f to int";
        public static String DOUBLE_TO_FLOAT = NUMBER_OVERFLOW + "convert double %f to float";
        public static String DOUBLE_TO_LONG = NUMBER_OVERFLOW + "convert double %f to long";

        public NumberOverflowException() {
            this(NUMBER_OVERFLOW);
        }

        public NumberOverflowException(String message) {
            super(message);
        }
    }

    public static class NumberCheck {
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
}
