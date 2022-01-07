package fang;

import com.vinner.codeme.fang.PartitionEqualSumSets;
import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSumSetsTest {

    PartitionEqualSumSets partitionEqualSumSets = new PartitionEqualSumSets();

    @Test
    public void testPartitionSumSets()
    {
        Assert.assertTrue(partitionEqualSumSets.canPartition(new int[]{14,9,8,4,3,2}));
    }
}
