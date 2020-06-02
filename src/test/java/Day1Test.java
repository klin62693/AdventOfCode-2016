package test.java;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import main.java.Day1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class Day1Test {
    @Test
    public void testPartOneSuccess() {
        String puzzle = "R8, R4, R4, R8";
        String[] directions = puzzle.split(", ");

        int res = Day1.partOne(directions);
        int expected = 8;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartOneFail() {
        String puzzle = "T8, R4, R4, R8";
        String[] directions = puzzle.split(", ");

        int res = Day1.partOne(directions);
        int expected = -1;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartTwoSuccess() {
        String puzzle = "R8, R4, R4, R8";
        String[] directions = puzzle.split(", ");

        int res = Day1.partTwo(directions);
        int expected = 4;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartTwoFail() {
        String puzzle = "T8, R4, R4, R8";
        String[] directions = puzzle.split(", ");

        int res = Day1.partTwo(directions);
        int expected = -1;

        Assert.assertEquals(expected, res);
    }
}
