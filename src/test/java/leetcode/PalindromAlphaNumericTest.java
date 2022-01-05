package leetcode;

import com.vinner.codeme.leetcode.PalindromAlphaNumeric;
import org.junit.Assert;
import org.junit.Test;

public class PalindromAlphaNumericTest {

    PalindromAlphaNumeric pa = new PalindromAlphaNumeric();

    @Test
    public void testPalindromString()
    {
        Assert.assertFalse(pa.isPalindrome("0P"));
    }
}
