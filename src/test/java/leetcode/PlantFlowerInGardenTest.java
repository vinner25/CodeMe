package leetcode;

import com.vinner.codeme.leetcode.PlantFlowersInGarden;
import org.junit.Assert;
import org.junit.Test;

public class PlantFlowerInGardenTest {

    PlantFlowersInGarden plantFlowersInGarden = new PlantFlowersInGarden();

    @Test
    public void testPlantFlowers()
    {
        int[] placements = plantFlowersInGarden.gardenNoAdj(3,
                new int[][]{{1,2},{2,3},{3,1}});
        Assert.assertNotNull(placements);
    }
}
