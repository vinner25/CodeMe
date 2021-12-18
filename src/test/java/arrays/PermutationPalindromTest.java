package arrays;

import com.vinner.codeme.ds.arrays.PermutationPalindrom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

public class PermutationPalindromTest {

    private PermutationPalindrom permutationPalindrom = new PermutationPalindrom();
    @Test
    public void shouldVerifyPermutationPalindrom()
    {
        Assert.assertTrue(permutationPalindrom.isPalindromPermutation("taco cat"));
        Assert.assertFalse(permutationPalindrom.isPalindromPermutation("taco cati"));
        Assert.assertFalse(permutationPalindrom.isPalindromPermutation("vinay"));
        Assert.assertTrue(permutationPalindrom.isPalindromPermutation("anivavin"));
    }
}
