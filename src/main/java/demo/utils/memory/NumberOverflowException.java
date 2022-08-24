package demo.utils.memory;

public class NumberOverflowException extends RuntimeException {
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