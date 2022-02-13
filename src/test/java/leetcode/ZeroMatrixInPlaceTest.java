package leetcode;

import com.vinner.codeme.leetcode.ZeroMatrixInPlace;
import org.junit.Test;

public class ZeroMatrixInPlaceTest {

    ZeroMatrixInPlace zeroMatrixInPlace = new ZeroMatrixInPlace();

    @Test
    public void testZeroMatrix()
    {
        int matrix[][] = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        zeroMatrixInPlace.setZeroes(matrix);
    }
}
