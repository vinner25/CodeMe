package ctci.ds.sorting_and_searching;

import com.vinner.codeme.ctci.ds.sorting_and_searching.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    BubbleSort bs = new BubbleSort();

    @Test
    public void bubbleSort()
    {
        int[] arr = new int[]{5,24,3,5,2,1,15,0};
        bs.bubbleSort(arr);
        Assert.assertEquals(0, arr[0]);
        Assert.assertEquals(1, arr[1]);
    }
}
