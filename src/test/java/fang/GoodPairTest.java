package fang;

import com.vinner.codeme.fang.GoodPair;
import org.junit.Test;

public class GoodPairTest {

    GoodPair goodPair = new GoodPair();

    @Test
    public void testGoodPair()
    {
        int goodPairs = goodPair.numIdenticalPairs(new int[]{1,2,3,1,1,3});
    }

}
