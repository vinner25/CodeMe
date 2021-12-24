package blind75.dp;

import com.vinner.codeme.blind75.dp.ClimbStiars;
import org.junit.Assert;
import org.junit.Test;

public class ClimbStairsTest {

    ClimbStiars cs = new ClimbStiars();

    @Test
    public void testClimbStairs()
    {
        Assert.assertEquals (2, cs.climbStairs(2));
    }

}
