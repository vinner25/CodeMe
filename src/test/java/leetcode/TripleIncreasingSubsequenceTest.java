package leetcode;

import com.vinner.codeme.leetcode.TripleIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class TripleIncreasingSubsequenceTest {

    TripleIncreasingSubsequence tripleIncreasingSubsequence = new TripleIncreasingSubsequence();
    @Test
    public void testTrtpleIncreasingSubsequence()
    {
        Assert.assertTrue(tripleIncreasingSubsequence.increasingTriplet(new int[]{2,1,5,1,6,2}));


    }

    @Test
    public void testTrtpleIncreasingSubsequence2()
    {
        Assert.assertTrue(tripleIncreasingSubsequence.increasingTriplet(new int[]{2,4,1,5}));


    }
}
