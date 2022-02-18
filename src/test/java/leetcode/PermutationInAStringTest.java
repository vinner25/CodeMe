package leetcode;

import com.vinner.codeme.leetcode.PermutationInAString;
import org.junit.Assert;
import org.junit.Test;

public class PermutationInAStringTest {

    PermutationInAString permutationInAString = new PermutationInAString();
    @Test
    public void testPermutationInAString()
    {

        Assert.assertTrue(permutationInAString.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void testPermutationInAString2()
    {

        Assert.assertFalse(permutationInAString.checkInclusion("hello", "ooolleoooleh"));
    }
}
