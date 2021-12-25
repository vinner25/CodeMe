package blind75.graph;

import com.vinner.codeme.blind75.graph.PacificAtlanticWaterFlow;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PacificAtlanticWaterFlowTest {

    PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();

    @Test
    public void testPacificAtlanticWaterFlow()
    {
        int[][] heights = new int[][]{{2,1}, {1,2}};


        List<List<Integer>> points = pacificAtlanticWaterFlow.pacificAtlantic(heights);
        Assert.assertNotNull(points);
    }
}
