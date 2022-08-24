package demo.utils.memory;

public class ResultImpl implements Cloneable, Result {
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
        return NumberCheck.getQualityValue(value, quality);
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
        return NumberCheck.getQualityValue(floatValue(), quality);
    }

    @Override
    public String toString() {
        return "ResultImpl{" +
                "value=" + value +
                '}';
    }
}