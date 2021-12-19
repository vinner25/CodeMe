package fang;

import com.vinner.codeme.fang.KLargest;
import org.junit.Assert;
import org.junit.Test;

public class KLargestTest {

    @Test
    public void shouldReturnCorrectKthLargest()
    {

        Assert.assertEquals(3, new KLargest(new int[]{1,2,3}, 2).add(4));
        Assert.assertEquals(55, new KLargest(new int[]{4,8,1,3,15}, 1).add(55));


    }
}
