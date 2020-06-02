package test.java;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import main.java.Day4;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitQuickcheck.class)
public class Day4Test {
    @Test
    public void testPartOneSuccess() {
        List<String> rooms = new ArrayList<>();
        rooms.add("aaaaa-bbbb-ccc-dd-e-f-123[abcdef]");
        rooms.add("zzzzz-yyyy-xxx-ww-uu-v-456[zyxuwv]");
        rooms.add("aaa-bbb-ccc-ddd-eee-789[fjsdlj]");

        int res = Day4.partOne(rooms);
        int expected = 579;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartOneFail() {
        List<String> rooms = new ArrayList<>();
        rooms.add("123");

        int res = Day4.partOne(rooms);
        int expected = -1;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartTwoSuccess() {
        List<String> rooms = new ArrayList<>();
        rooms.add("aaaaa-bbbb-ccc-dd-e-f-123[abcdef]");
        rooms.add("qzmt-zixmtkozy-ivhz-343[vxcbvn]");

        String target = "veryencryptedname";
        int res = Day4.partTwo(rooms, target);
        int expected = 343;

        Assert.assertEquals(expected, res);
    }

    @Test
    public void testPartTwoFail() {
        List<String> rooms = new ArrayList<>();
        rooms.add("123");

        String target = "veryencryptedname";
        int res = Day4.partTwo(rooms, target);
        int expected = -1;

        Assert.assertEquals(expected, res);
    }
}
