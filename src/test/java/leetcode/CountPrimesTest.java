package leetcode;

import com.vinner.codeme.leetcode.CountPrimes;
import org.junit.Assert;
import org.junit.Test;

public class CountPrimesTest {

    CountPrimes countPrimes = new CountPrimes();

    @Test
    public void countPrimes()
    {
        Assert.assertEquals(4, countPrimes.countPrimes(10));
    }
}
