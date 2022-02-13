package blind75.heap;

import com.vinner.codeme.blind75.heap.TopKFrequentElements;
import org.junit.Assert;
import org.junit.Test;

public class TopKFrequentElementsTest {

    TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

    @Test
    public void testTopKFrequentElements()
    {
        int[] arr = new int[]{4,5,6,12,2,2,1,1,1};
        int[] res = topKFrequentElements.topKFrequent(arr,2);
        Assert.assertNotNull(res);
    }
}
