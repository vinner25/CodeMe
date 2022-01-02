package ctci.ds.dp;

import com.vinner.codeme.ctci.ds.dp.MagicIndex;
import org.junit.Assert;
import org.junit.Test;

public class MagicIndexTest {

    MagicIndex magicIndex = new MagicIndex();

    @Test
    public void testMagicIndexWithUniqueElements()
    {
        Assert.assertEquals(2, magicIndex.magixIndex(new int[]{-1,0,2,6,90,91,95,100,101}));
        Assert.assertEquals(-1, magicIndex.magixIndex(new int[]{-1,0,1,6,90,91,95,100,101}));
    }
    @Test
    public void testMagicIndexWithDuplicateElements()
    {
        Assert.assertEquals(6, magicIndex.magixIndexWithDups(new int[]{-1,0,1,2,2,2,6,100,101}));
        Assert.assertEquals(-1, magicIndex.magixIndexWithDups(new int[]{-1,0,0,6,90,91,95,100,101}));
    }
}
