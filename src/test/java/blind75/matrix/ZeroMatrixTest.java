package blind75.matrix;

import com.vinner.codeme.blind75.matrix.ZeroMatrix;
import org.junit.Assert;
import org.junit.Test;

public class ZeroMatrixTest {

    ZeroMatrix zeroMatrix = new ZeroMatrix();

    @Test
    public void testZeroMatrix()
    {
        int[][] m = new int[][] {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        zeroMatrix.setZeroes(m);
        Assert.assertEquals(0, m[0][0]);
        Assert.assertEquals(0, m[0][1]);
        Assert.assertEquals(0, m[0][2]);
        Assert.assertEquals(0, m[0][3]);

    }
}
