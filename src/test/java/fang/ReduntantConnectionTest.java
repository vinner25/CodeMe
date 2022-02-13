package fang;

import com.vinner.codeme.fang.ReduntantConnections;
import org.junit.Assert;
import org.junit.Test;

public class ReduntantConnectionTest {

    ReduntantConnections reduntantConnections = new ReduntantConnections();

    @Test
    public void testConnections()
    {
        int[][] arr = new int[][]{{3,4},{1,2},{2,4},{3,5},{2,5}};
        int[] res = reduntantConnections.findRedundantConnection(arr);
        Assert.assertNotNull(res);
    }
}
