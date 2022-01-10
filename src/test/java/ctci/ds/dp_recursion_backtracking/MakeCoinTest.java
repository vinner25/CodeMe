package ctci.ds.dp_recursion_backtracking;

import com.vinner.codeme.ctci.ds.dp_recusrion_backtracking.MakeCoins;
import org.junit.Assert;
import org.junit.Test;

public class MakeCoinTest {

    MakeCoins coin = new MakeCoins();

    @Test
    public void testNumberOfWays()
    {
        Assert.assertEquals(2, coin.ways(7));
        Assert.assertEquals(4, coin.ways(10));
    }
}
