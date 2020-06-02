package test.java;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import main.java.Day10;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitQuickcheck.class)
public class Day10Test {
    @Test
    public void testPartOne() {
        List<String> bots = new ArrayList<>();
        bots.add("value 5 goes to bot 2");
        bots.add("bot 2 gives low to bot 1 and high to bot 0");
        bots.add("value 3 goes to bot 1");
        bots.add("bot 1 gives low to output 1 and high to bot 0");
        bots.add("bot 0 gives low to output 2 and high to output 0");
        bots.add("value 2 goes to bot 2");

        int value1 = 5, value2 = 2;
        int res = Day10.partOne(bots, value1, value2);
        int expected = 2;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartOneFail() {
        List<String> bots = new ArrayList<>();
        bots.add("123");

        int value1 = 5, value2 = 2;
        int res = Day10.partOne(bots, value1, value2);
        int expected = -1;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartTwoSuccess() {
        List<String> bots = new ArrayList<>();


    }
}
