package demo;

public class TimeUtil {
    public static final int MASK_MINUTE = (1 << 8) - 1;

    public static int setTime(int hour, int minute) {
        int timeMask = (hour << 8) + minute;
        System.out.println(timeMask);
        return timeMask;
    }

    public static void getTime(int time) {
        int hour = (time >> 8) & MASK_MINUTE;
        int minute = time & MASK_MINUTE;
        System.out.println(hour + " " + minute);
    }
}
