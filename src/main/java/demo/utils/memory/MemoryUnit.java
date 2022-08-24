package demo.utils.memory;

import com.sun.istack.internal.NotNull;

public enum MemoryUnit {

    BIT {
        @Override
        public Result toBit(double value) {
            return ResultFactory.valueOf(value);
        }

        @Override
        public Result toByte(double value) {
            return ResultFactory.valueOf(value / (S_BYTE / S_BIT));
        }

        @Override
        public Result toKB(double value) {
            return ResultFactory.valueOf(value / (S_KB / S_BIT));
        }

        @Override
        public Result toMB(double value) {
            return ResultFactory.valueOf(value / (S_MB / S_BIT));
        }

        @Override
        public Result toGB(double value) {
            return ResultFactory.valueOf(value / (S_GB / S_BIT));
        }

        @Override
        public Result toTB(double value) {
            return ResultFactory.valueOf(value / (S_TB / S_BIT));
        }

        @Override
        public Result convert(double value, MemoryUnit u) {
            return u.toBit(value);
        }
    },

    BYTE {
        @Override
        public Result toBit(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_BYTE / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultFactory.valueOf(value);
        }

        @Override
        public Result toKB(double value) {
            return ResultFactory.valueOf(value / (S_KB / S_BYTE));
        }

        @Override
        public Result toMB(double value) {
            return ResultFactory.valueOf(value / (S_MB / S_BYTE));
        }

        @Override
        public Result toGB(double value) {
            return ResultFactory.valueOf(value / (S_GB / S_BYTE));
        }

        @Override
        public Result toTB(double value) {
            return ResultFactory.valueOf(value / (S_TB / S_BYTE));
        }

        @Override
        public Result convert(double value, MemoryUnit u) {
            return u.toByte(value);
        }
    },

    KB {
        @Override
        public Result toBit(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_KB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_KB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultFactory.valueOf(value);
        }

        @Override
        public Result toMB(double value) {
            return ResultFactory.valueOf(value / (S_MB / S_KB));
        }

        @Override
        public Result toGB(double value) {
            return ResultFactory.valueOf(value / (S_GB / S_KB));
        }

        @Override
        public Result toTB(double value) {
            return ResultFactory.valueOf(value / (S_TB / S_KB));
        }

        @Override
        public Result convert(double value, MemoryUnit u) {
            return u.toKB(value);
        }
    },

    MB {
        @Override
        public Result toBit(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_MB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_MB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_MB / S_KB)));
        }

        @Override
        public Result toMB(double value) {
            return ResultFactory.valueOf(value);
        }

        @Override
        public Result toGB(double value) {
            return ResultFactory.valueOf(value / (S_GB / S_MB));
        }

        @Override
        public Result toTB(double value) {
            return ResultFactory.valueOf(value / (S_TB / S_MB));
        }

        @Override
        public Result convert(double value, MemoryUnit u) {
            return u.toMB(value);
        }
    },

    GB {
        @Override
        public Result toBit(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_GB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_GB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_GB / S_KB)));
        }

        @Override
        public Result toMB(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_GB / S_MB)));
        }

        @Override
        public Result toGB(double value) {
            return ResultFactory.valueOf(value);
        }

        @Override
        public Result toTB(double value) {
            return ResultFactory.valueOf(value / (S_TB / S_GB));
        }

        @Override
        public Result convert(double value, MemoryUnit u) {
            return u.toGB(value);
        }
    },

    TB {
        @Override
        public Result toBit(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_TB / S_BIT)));
        }

        @Override
        public Result toByte(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_TB / S_BYTE)));
        }

        @Override
        public Result toKB(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_TB / S_KB)));
        }

        @Override
        public Result toMB(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_TB / S_MB)));
        }

        @Override
        public Result toGB(double value) {
            return ResultFactory.valueOf(safeMultiply(value, (S_TB / S_GB)));
        }

        @Override
        public Result toTB(double value) {
            return ResultFactory.valueOf(value);
        }

        @Override
        public Result convert(double value, MemoryUnit u) {
            return u.toTB(value);
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

    public Result convert(double value, MemoryUnit u) {
        throw new AbstractMethodError();
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
}
