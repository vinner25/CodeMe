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
        Assert.assertEquals(3, lcs.lcs("abcde", "ace"));
        Assert.assertEquals(2, lcs.lcs("oxcpqrsvwf", "shmtulqrypy"));
        Assert.assertEquals(1, lcs.lcs("bl", "yby"));
        Assert.assertEquals(1, lcs.lcs("bsbininm", "jmjkbkjkv"));
    }
}
