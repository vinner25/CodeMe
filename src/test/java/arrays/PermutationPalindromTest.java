package arrays;

import com.vinner.codeme.ds.arrays_and_strings.PermutationPalindrom;
import org.junit.Assert;
import org.junit.Test;

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
