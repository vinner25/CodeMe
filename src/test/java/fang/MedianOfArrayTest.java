package fang;

import com.vinner.codeme.fang.MedianOfArray;
import org.junit.Assert;
import org.junit.Test;

public class MedianOfArrayTest {

    MedianOfArray medianOfArray = new MedianOfArray();

    @Test
    public void testMedianOfArray()
    {
       Assert.assertEquals(2.5, medianOfArray.median(new int[]{1,2}, new int[]{3,4}), 0);
        Assert.assertEquals(2,medianOfArray.median(new int[]{1,2}, new int[]{3}), 0);
        Assert.assertEquals(2,medianOfArray.median(new int[]{1,3}, new int[]{2}), 0);
    }
}
