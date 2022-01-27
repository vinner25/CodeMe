package leetcode;

import com.vinner.codeme.leetcode.NQueenII;
import org.junit.Assert;
import org.junit.Test;

public class NQueenIITest {

    NQueenII nQueenII = new NQueenII();

    @Test
    public void testNQueensProblem()
    {
        Assert.assertEquals(2, nQueenII.totalNQueens(4));
    }
}
