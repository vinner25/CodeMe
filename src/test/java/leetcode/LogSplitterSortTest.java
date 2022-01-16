package leetcode;

import com.vinner.codeme.leetcode.LogSplitterSort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class LogSplitterSortTest {

    LogSplitterSort lps = new LogSplitterSort();

    @Test
    public void testLogSplit()
    {
        String[] s = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        String[] res = lps.reorderLogFiles(s);
        Assert.assertNotNull(res);
    }
}
