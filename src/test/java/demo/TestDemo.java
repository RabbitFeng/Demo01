package demo;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;

public class TestDemo {
    @Test
    public void test01() {
        ReferenceQueue<User> userReferenceQueue = new ReferenceQueue<>();

        SoftReference<User> userSoftReference;

        User user = new User("Dong", 1);
        userSoftReference = new SoftReference<>(user, userReferenceQueue);

        user = new User("Dong1", 2);
        userSoftReference = new SoftReference<>(user, userReferenceQueue);

        System.out.println(userReferenceQueue.poll());

    }

    @Test
    public void test02() {
        Object o = new Object();

        WeakReference w = new WeakReference(o);

        System.out.println(w.get() == null);

        o = null;

        System.gc();
        System.out.println(w.get() == null);

    }

    @Test
    public void test03() {
        System.out.println(1 >> 1);
    }

    public static final int MASK_OFFSET = 8;
    public static final int MASK_MINUTE = (1 << MASK_OFFSET) - 1;
    public static final int MASK_HOUR = Integer.MAX_VALUE - MASK_MINUTE;

    @Test
    public void test04() {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(MASK_OFFSET));
        System.out.println(Integer.toBinaryString(MASK_MINUTE));
        System.out.println(Integer.toBinaryString(MASK_HOUR));
        int hour = 10 << 8;
        System.out.println(Integer.toBinaryString(hour));
        hour = (hour & MASK_HOUR) >> 8;
        System.out.println(Integer.toBinaryString(hour));
    }

    @Test
    public void test05() {
        int i = TimeUtil.setTime(10, 20);
        TimeUtil.getTime(i);
    }

    @Test
    public void test06() {
        System.out.println(Math.floor(0.5));
        System.out.println(Math.floor(0.3));
        System.out.println(Math.floor(0.6));

    }

    @Test
    public void test07() {
        double sinVal = Math.sin(Math.toRadians(90));
        System.out.println(sinVal);

        double angle = Math.asin(sinVal);
        System.out.println(Math.toDegrees(Math.asin(sinVal)));
    }

    @Test
    public void test08() {
        long a1 = 1;
        for (int i = 2; i <= 20; i++) {
            a1 *= i;
        }
        System.out.println("a1 = " + a1);
    }

    @Test
    public void test09() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.append(3);
        stringBuilder.append(4);

        stringBuilder.setLength(0);
        System.out.println(stringBuilder.toString());
    }
}
