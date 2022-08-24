package demo.utils.memory;

public class ResultFactory {
    public static Result valueOf(double value) {
        return ResultImpl.valueOf(value);
    }
}
