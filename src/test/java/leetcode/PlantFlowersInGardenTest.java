package leetcode;

import com.vinner.codeme.leetcode.PlantFlowersInGarden;
import org.junit.Assert;
import org.junit.Test;

public class PlantFlowersInGardenTest {

    PlantFlowersInGarden plantFlowersInGarden = new PlantFlowersInGarden();

    @Test
    public void testPlantFlowersInGarden()
    {
        int[][] paths = new int[][]{{2,1},{3,7},{1,3},{7,2},{2,3},{6,1},{4,8},{6,4},{5,7},{4,5}};

        int[] placements = plantFlowersInGarden.gardenNoAdj(8,paths);
        Assert.assertNotNull(placements);
    }
}
