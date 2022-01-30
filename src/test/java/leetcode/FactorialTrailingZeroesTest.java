package leetcode;

import com.vinner.codeme.leetcode.FactorialTrailingZeroes;
import org.junit.Assert;
import org.junit.Test;

public class FactorialTrailingZeroesTest {

    FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();

    @Test
    public void testFactorialTrailingZeroes()
    {
        Assert.assertEquals(0, factorialTrailingZeroes.trailingZeroes(3));
        Assert.assertEquals(1, factorialTrailingZeroes.trailingZeroes(5));
        Assert.assertEquals(2, factorialTrailingZeroes.trailingZeroes(13));
    }
}
