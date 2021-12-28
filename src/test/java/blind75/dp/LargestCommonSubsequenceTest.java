package blind75.dp;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.dp.LargestCommonSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class LargestCommonSubsequenceTest {
    LargestCommonSubsequence lcs = new LargestCommonSubsequence();

    @Test
    public void testLCS()
    {
        Assert.assertEquals(3, lcs.lcs("abcde", "abc"));
    }
}
