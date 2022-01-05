package com.vinner.codeme.ctci.ds.dp_recusrion_backtracking;

import com.vinner.codeme.ProblemStatement;

public class MagicIndex implements ProblemStatement {
    @Override
    public String getDescription() {
        return null;
    }

    public int magixIndexWithDups(int[] arr)
    {
        return findMagicIndexNonUnique(arr, 0 , arr.length);
    }
    public int magixIndex(int[] arr)
    {
        return findMagicIndex(arr, 0 , arr.length);
    }

    private int findMagicIndex(int[] arr, int i , int j)
    {
        if(j < i)
            return  -1;
        int mid = (i+j)/2;
        if(arr[mid] == mid)
            return mid;

        else if(arr[mid] > mid)
        {
            return findMagicIndex(arr, i , mid-1);
        }
        else
        {
            return findMagicIndex(arr, mid+1, j);
        }
    }

    /*
     Since the elements are still sorted but no more unique , we will need to search on both sides
     */
    private int findMagicIndexNonUnique(int[] arr, int i , int j)
    {
        if(j < i)
            return  -1;
        int mid = (i+j)/2;
        if(arr[mid] == mid)
            return mid;

        //Search Left : The Rule here is we have to find which next possible elemet can have magic index rather than searching complete left side
        // We do that by calculating the minimum between current Mid -1 and midValue. If Mid Value is less than current Mid Index
        // Then the next immediate left index to be a magic index has to has value atleast equal to or less than mid index
        int left = Math.min(mid-1, arr[mid]);
         int maginIndexFromLeft =  findMagicIndex(arr, i , left);
         if(maginIndexFromLeft >= 0)
             return  maginIndexFromLeft;

        int right = Math.max(mid+1, arr[mid]);
        return findMagicIndex(arr, right, j);

    }

    @Override
    public String getSolutionNotes() {
        return "The Naive solution is to traverse complete array and look for condition when a[i] == i. This takes O(n). An optimized solution is to " +
                "look for elements in the left side and right side by looking at middle and performing a binary search with index/mid value";
    }

    @Override
    public String getTimeComplexity() {
        return "O(log N) - Binary Search run time";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
