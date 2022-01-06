package leetcode;

import com.vinner.codeme.leetcode.ValidateSudoku;
import org.junit.Assert;
import org.junit.Test;

public class ValidateSudokuTest {

    ValidateSudoku vs = new ValidateSudoku();

    @Test
    public void validateSudoku()
    {
        char[][] arr = new char[][] {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        Assert.assertTrue(vs.isValidSudoku(arr));

    }
}
