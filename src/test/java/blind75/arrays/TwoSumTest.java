package blind75.arrays;

import com.vinner.codeme.blind75.arrays.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    public TwoSum twoSum = new TwoSum();

    @Test
    public void checkTwoSum()
    {
        int[] indices = twoSum.execute(new int[]{1,2,3,7,5,19}, 10);
        Assert.assertEquals(2,indices[0]);
        Assert.assertEquals(3,indices[1]);
        Assert.assertNotNull(twoSum.getSpaceComplexity());
        Assert.assertNotNull(twoSum.getTimeComplexity());
        Assert.assertNotNull(twoSum.getSolutionNotes());
    }

}
