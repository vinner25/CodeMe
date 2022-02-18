package leetcode;

import com.vinner.codeme.leetcode.IntersectionOfTwoArrays;
import org.junit.Test;

public class IntersectionOfTwoArraysTest {

    private IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();

    @Test
    public void testIntersectionOfArrays()
    {
        int[] res = intersectionOfTwoArrays.intersection(new int[]{1,2,2,1}, new int[]{2,2});
    }
}
