package ctci.ds.arrays;

import com.vinner.codeme.ctci.ds.arrays_and_strings.PermuteArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PermuteArrayTest {

    PermuteArray permuteArray = new PermuteArray();

    @Test
    public void testPermuteArray()
    {
        List<List<Integer>> permutations = permuteArray.permute(new int[]{1,2,3});
        Assert.assertEquals(6, permutations.size());
    }
}
