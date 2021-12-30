package blind75.string;

import com.vinner.codeme.blind75.string.MinimumWindowSubString;
import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubStringTest {

    MinimumWindowSubString mws = new MinimumWindowSubString();

    @Test
    public void testMinimumWindowSubString()
    {
       // Assert.assertEquals("BANC", mws.minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("BANC", mws.minWindow("bba", "ab"));
    }
}
