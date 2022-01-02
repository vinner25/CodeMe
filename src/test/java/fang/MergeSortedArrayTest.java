package fang;

import com.vinner.codeme.fang.MergeSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrayTest {

    MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @Test
    public void setMergeSortedArray()
    {
        int []  n1= {1,2,3,0,0,0};
        int[] n2 = {2,5,6};

        mergeSortedArray.merge(n1,3,n2,3);
        Assert.assertEquals(2, n1[2]);
    }

    @Test
    public void setMergeSortedArrayCase2()
    {
        int []  n1= {0};
        int[] n2 = {1};

        mergeSortedArray.merge(n1,0,n2,1);
        Assert.assertEquals(1, n1[0]);
    }

    @Test
    public void setMergeSortedArrayCase3()
    {
        int []  n1= {4,5,6,0,0,0};
        int[] n2 = {1,2,3};

        mergeSortedArray.merge(n1,3,n2,3);
        Assert.assertEquals(1, n1[0]);
    }
}
