package blind75.string;

import com.vinner.codeme.blind75.string.LongestSubstringWithoutRepeating;
import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingTest {

    LongestSubstringWithoutRepeating ls= new LongestSubstringWithoutRepeating();

    @Test
    public void shouldCalculateLongestSubStringWithoutRepeatingChar()
    {
        //Assert.assertEquals(5, ls.lengthOfLongestSubstring("tmmzuxt"));


        Assert.assertEquals(3, ls.lengthOfLongestSubstring("abcabcbb"));

    }
}
