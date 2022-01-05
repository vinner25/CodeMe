package ctci.ds.dp_recursion_backtracking;

import com.vinner.codeme.ctci.ds.dp_recusrion_backtracking.PowerSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PowerSetTest {

    PowerSet pws = new PowerSet();

    @Test
    public void testGeneratePowerSet()
    {
        List<List<Integer>> subsets = pws.generatePowerSet(new int[]{1,2});
        Assert.assertEquals(4, subsets.size());
    }

    @Test
    public void testGeneratePowerSet2()
    {
        List<List<Integer>> subsets = pws.generatePowerSet(new int[]{1,2,3});
        Assert.assertEquals(8, subsets.size());
    }

    @Test
    public void testGeneratePowerSet3()
    {
        List<List<Integer>> subsets = pws.generatePowerSet(new int[]{1,2,3, 4});
        Assert.assertEquals(16, subsets.size());
    }
}
