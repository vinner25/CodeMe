package ctci.ds.sorting_and_searching;

import com.vinner.codeme.ctci.ds.sorting_and_searching.SelectionSort;
import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {

    SelectionSort ss = new SelectionSort();
    @Test
    public void testSelectionSort()
    {
        int[] arr = new int[]{5,1,66,4,2,6,1,2};
        ss.selectionSort(arr);
        Assert.assertEquals(1,arr[0] );
    }

}
