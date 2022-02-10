package blind75.string;

import com.vinner.codeme.blind75.string.LongestRepeatingCharacterReplacement;
import org.junit.Assert;
import org.junit.Test;

public class LongestRepeatingCharacterReplacementTest {

    LongestRepeatingCharacterReplacement lr = new LongestRepeatingCharacterReplacement();

    @Test
    public void testReplaceCharacters()
    {
     //    Assert.assertEquals(4, lr.characterReplacement("ABAB", 2));
         Assert.assertEquals(5, lr.characterReplacement("ABABACC", 2));
//
    }
}
