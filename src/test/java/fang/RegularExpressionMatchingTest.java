package fang;

import com.vinner.codeme.fang.RegularExpressionMatching;
import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionMatchingTest {

    RegularExpressionMatching reg = new RegularExpressionMatching();

    @Test
    public void testRegExMatch()
    {
        Assert.assertFalse(reg.isMatch("mississippi","mis*is*p*." ));
    }

    @Test
    public void testRegExMatch2()
    {
        Assert.assertFalse(reg.isMatch("aaa","aaaa" ));
    }
}
