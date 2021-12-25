package trees.problems;

import com.vinner.codeme.ctci.ds.trees.problems.MinHeapArray;
import org.junit.Assert;
import org.junit.Test;

public class MinHeapArrayTest {


    @Test
    public void checkMinHeapUsingArray()
    {
        Assert.assertEquals(1, new MinHeapArray(new int[]{1,2,3},6).add(4) );
        Assert.assertEquals(3, new MinHeapArray(new int[]{1,2,3},2).add(4) );
    }
}
