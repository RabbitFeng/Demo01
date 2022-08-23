package demo;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.atomic.AtomicLong;

public class TimeLog {
    private static AtomicLong timeStamp = new AtomicLong();

    public static void rebase() {
        timeStamp.set(System.currentTimeMillis());
    }

    public static void log(@NotNull String msg) {
        long cur = System.currentTimeMillis();
        System.out.println("msg = " + msg + " consume = " + (cur - timeStamp.getAndSet(cur)));
    }
}
