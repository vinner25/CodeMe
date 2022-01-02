package blind75.dp;

import com.vinner.codeme.blind75.dp.WordBreak;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class WordBreakTest {

    WordBreak wb = new WordBreak();

    @Test
    public void testWordBreak()
    {
      //  Assert.assertTrue(wb.wordBreak("ABCXYZ", Arrays.asList("ABC", "XYZ")));
    //    Assert.assertFalse(wb.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        Assert.assertFalse(wb.wordBreak("aaab", Arrays.asList("a","aa","aaa")));

     //   Assert.assertTrue(wb.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }
}
