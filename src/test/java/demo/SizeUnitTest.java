package demo;

import demo.utils.memory.MemoryUnit;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

public class SizeUnitTest {
    @Test
    public void test01() {
        // BigDecimal.ROUND_UP | RoundingMode.UP : 向远离0舍入
        System.out.println("--- RoundingMode.UP ---");
        System.out.println(BigDecimal.valueOf(2.501).setScale(1, RoundingMode.UP));
        System.out.println(BigDecimal.valueOf(-2.501).setScale(1, RoundingMode.UP));
        System.out.println(BigDecimal.valueOf(0).setScale(1, RoundingMode.UP));
        System.out.println();

        // BigDecimal.ROUND_DOWN | RoundingMode.DOWN : 向接近0舍入
        System.out.println("--- RoundingMode.DOWN ---");
        System.out.println(BigDecimal.valueOf(2.501).setScale(1, RoundingMode.DOWN));
        System.out.println(BigDecimal.valueOf(-2.501).setScale(1, RoundingMode.DOWN));
        System.out.println();

        // BigDecimal.ROUND_CEILING | RoundingMode.CEILING : 向无穷大舍入
        System.out.println("--- RoundingMode.CEILING ---");
        System.out.println(BigDecimal.valueOf(2.501).setScale(1, RoundingMode.CEILING));
        System.out.println(BigDecimal.valueOf(-2.501).setScale(1, RoundingMode.CEILING));
        System.out.println();

        // BigDecimal.ROUND_FLOOR | RoundingMode.FLOOR : 向无穷小舍入
        System.out.println("--- RoundingMode.CEILING ---");
        System.out.println(BigDecimal.valueOf(2.501).setScale(1, RoundingMode.FLOOR));
        System.out.println(BigDecimal.valueOf(-2.501).setScale(1, RoundingMode.FLOOR));
        System.out.println();

        // BigDecimal.ROUND_HALF_UP | RoundingMode.HALF_UP : 向最接近的数字舍入(四舍五入)
        System.out.println("--- RoundingMode.HALF_UP ---");
        System.out.println(BigDecimal.valueOf(2.501).setScale(1, RoundingMode.HALF_UP));
        System.out.println(BigDecimal.valueOf(-2.550).setScale(1, RoundingMode.HALF_UP));
        System.out.println();

        // BigDecimal.ROUND_HALF_DOWN | RoundingMode.HALF_DOWN : 向最接近的数字舍入(类似四舍五入，但是不包含5)
        System.out.println("--- RoundingMode.HALF_DOWN ---");
        System.out.println(BigDecimal.valueOf(2.501).setScale(1, RoundingMode.HALF_DOWN));
        System.out.println(BigDecimal.valueOf(-2.55).setScale(1, RoundingMode.HALF_DOWN));
        System.out.println();


    }

    @Test
    public void test02() {
//        System.out.println(SizeUnit.BIT.toByte(7, 0));
        System.out.println(Double.MAX_VALUE);
        System.out.println((long) Double.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println((int) Double.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test03() {
        System.out.println(MemoryUnit.MB.toByte(1.1212).doubleValue(10));
    }

    @Test
    public void test04() {

        System.out.println("continue");
    }

    public void check(Object o) {
        if (o instanceof Number) {
            System.out.println("Number");
        }
        if (o instanceof Double) {
            System.out.println("Double");
        }
    }

    @Test
    public void test05() {
        System.out.println(MemoryUnit.KB.toByte(1).intValue());
    }
}
