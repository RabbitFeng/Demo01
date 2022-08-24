package demo.utils.memory;

public interface Result {
    double doubleValue();

    double doubleValue(int quality);

    int intValue();

    long longValue();

    float floatValue();

    float floatValue(int quality);

    String stringValue();

    String stringValue(int precision);
}
