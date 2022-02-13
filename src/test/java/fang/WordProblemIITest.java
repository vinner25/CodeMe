package fang;

import com.vinner.codeme.fang.WordProblemII;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordProblemIITest {

    WordProblemII wordProblemII = new WordProblemII();
    @Test
    public void testWordProblemsII()
    {
        String s = "catsanddog";
        List<String> dict = Arrays.asList(new String[]{"cat","cats","and","sand","dog"});
        wordProblemII.wordBreak(s,dict);
    }
}
