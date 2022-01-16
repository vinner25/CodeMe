package ctci.ds.sorting_and_searching;

import com.vinner.codeme.ctci.ds.sorting_and_searching.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    public void testMergeSort()
    {
        int[] arr = new int[]{5,4,1,3,2};
        mergeSort.mergeSort(arr);
        Assert.assertEquals(1, arr[0]);
        Assert.assertEquals(2, arr[1]);
    }
}
