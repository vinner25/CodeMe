package leetcode;

import com.vinner.codeme.leetcode.RotateArray;
import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {

    RotateArray ra = new RotateArray();

    @Test
    public void testArrayRotation()
    {
        int nums [] = new int[]{1,2,3,4,5,6,7};
        ra.rotate(nums,3);
        Assert.assertNotNull(nums);
    }
}
