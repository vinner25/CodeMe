package com.vinner.codeme.leetcode;

import java.util.Arrays;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * Example 2:
 *
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 */
public class ArrayProblem {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //Sort the first Array
        Arrays.sort(arr1);
        int currentIndex = 0;
        for(int i : arr2)
        {
            //Shuffle Required
            if(arr1[currentIndex] != i)
            {
                String valueToIndexSize = getIndexSize(i,arr1);
                int startIndex = Integer.parseInt(valueToIndexSize.split("-")[0]);
                int size = Integer.parseInt(valueToIndexSize.split("-")[1]);

                while(currentIndex < currentIndex+size)
                {
                    int currentValue = arr1[currentIndex];

                }


            }

        }





    }

    private String getIndexSize(int n, int[] arr1)
    {
        StringBuilder indexAndSize =  new StringBuilder();
        int size = 0;
        int startIndex = -1;
        for(int i= 0 ; i < arr1.length; i++)
        {
            if(arr1[i] == n)
            {
                if(startIndex < 0)
                    startIndex = i
                size++;

            }
            else if(size > 0) //Means already found no need to compare ahead
                break;

        }

        indexAndSize.append(startIndex).append("-").append(size);
        return indexAndSize;

    }
}
