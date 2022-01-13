package leetcode;

import com.vinner.codeme.leetcode.MyAtoi;
import org.junit.Assert;
import org.junit.Test;

public class MyAtoiTest {

    MyAtoi myAtoi = new MyAtoi();

    @Test
    public void testmyAtoi1()
    {
        Assert.assertEquals(-3354, myAtoi.myAtoi("-3354 4"));
    }
    @Test
    public void testmyAtoi2()
    {
        Assert.assertEquals(2147483647, myAtoi.myAtoi("21474836460"));
    }
}
