package numbergame;

import demo.TimeLog;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class NumberTest {
    private int[][] row1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 0, 0, 0, 0, 0, 0}
    };

    private NumberDemo numberDemo;

    @Before
    public void init() {
        numberDemo = new NumberDemo();
        numberDemo.init(row1);
    }

    @Test
    public void testRow() {
        TimeLog.rebase();
        try {
            System.out.println(numberDemo.judgeForRow(-1));
        } catch (NumberDemo.NumberException.RowBoundsException e) {
            e.printStackTrace();
        }
        TimeLog.log("testRow");
    }

    @Test
    public void testCol() {
        TimeLog.rebase();
        try {
            System.out.println(numberDemo.judgeForCol(-1));
        } catch (NumberDemo.NumberException.ColBoundsException e) {
            e.printStackTrace();
        }
        TimeLog.log("testCol");
    }

    @Test
    public void testGetAreaNumForPosition() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.println(numberDemo.getAreaNumForPosition(row, col));
            }
            System.out.println();
        }
    }

    @Test
    public void testGetAreaNumForPosition_1() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(Arrays.toString(numberDemo.getStartPositionForArea(i)));
        }

    }

    @Test
    public void testJudgeArea() {
        try {
            System.out.println(numberDemo.judgeForArea(9));
        } catch (NumberDemo.NumberException.AreaBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObtainPossibleNumberForRow() {
        try {
            System.out.println(numberDemo.obtainPossibleNumberForRow(8));
        } catch (NumberDemo.NumberException.RowBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObtainPossibleNumberForCol() {
        try {
            System.out.println(numberDemo.obtainPossibleNumberForCol(1));
        } catch (NumberDemo.NumberException.ColBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObtainPossibleNumberForArea() {
        try {
            System.out.println(numberDemo.obtainPossibleNumberForArea(2));
        } catch (NumberDemo.NumberException.AreaBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrint() {
        numberDemo.printPossibleRecord();
    }

}
