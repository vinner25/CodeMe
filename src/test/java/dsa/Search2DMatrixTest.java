package dsa;

import com.vinner.codeme.dsa.Search2DMatrix;
import org.junit.Assert;
import org.junit.Test;

public class Search2DMatrixTest {

    Search2DMatrix search2DMatrix = new Search2DMatrix();

    @Test
    public void testSearch2DMatrix()
    {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        Assert.assertFalse( search2DMatrix.searchMatrix(matrix,13));

    }

    @Test
    public void testSearch2DMatrix2()
    {
        int[][] matrix = new int[][]{{1,3}};

        Assert.assertTrue( search2DMatrix.searchMatrix(matrix,3));

    }
}
