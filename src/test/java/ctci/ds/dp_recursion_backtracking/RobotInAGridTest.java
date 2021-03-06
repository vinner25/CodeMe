package ctci.ds.dp_recursion_backtracking;

import com.vinner.codeme.ctci.ds.dp_recusrion_backtracking.RobotInAgrid;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RobotInAGridTest {

    RobotInAgrid robotInAgrid = new RobotInAgrid();

    @Test
    public void testValidPaths()
    {
        int[][] matrix = new int[][]{{1,0,0}, {1,1,1}, {1,0,1}};

        List<int[]> paths = robotInAgrid.validPath(matrix);

        Assert.assertTrue(paths.size()> 0);


    }


}
