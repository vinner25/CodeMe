package blind75.dp;

import com.vinner.codeme.blind75.dp.CoinChange;
import org.junit.Assert;
import org.junit.Test;

public class CoinChangeTest {

    CoinChange coinChange = new CoinChange();

    @Test
    public void testCoinChange()
    {
        int ways = coinChange.coinChange(new int[]{2,5,10,1}, 27);
        Assert.assertEquals(4, ways);
    }
}
