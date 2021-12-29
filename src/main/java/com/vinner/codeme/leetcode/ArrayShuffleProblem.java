package com.vinner.codeme.leetcode;

import java.util.Arrays;

/**
 * Given two ctci.ds.arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
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
//Brute Force but works
public class ArrayShuffleProblem {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //Sort the first Array
        Arrays.sort(arr1);
        int currentIndex = 0;
        for(int i : arr2)
        {
            String valueToIndexSize = getIndexSize(i,arr1);
            int startIndex = Integer.parseInt(valueToIndexSize.split("-")[0]);
            int size = Integer.parseInt(valueToIndexSize.split("-")[1]);

            //Shuffle Required
            if(arr1[currentIndex] != i)
            {
                int max = startIndex+size;
                while(startIndex < max)
                {
                    int currentValue = arr1[currentIndex];
                    arr1[currentIndex] = arr1[startIndex];
                    arr1[startIndex] = currentValue;
                    startIndex++;
                    currentIndex++;
                }
            }
            else
            {
                currentIndex = currentIndex + size;
            }

        }
        int[] temp = new int[arr1.length];
        for(int i= currentIndex ; i<arr1.length; i++)
        {
            temp[i] = arr1[i];
        }
        Arrays.sort(temp);
        for(int i= currentIndex ; i<arr1.length; i++)
        {
            arr1[i]=   temp[i] ;
        }


        return arr1;



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
                    startIndex = i;
                size++;

            }
            else if(size > 0) //Means already found no need to compare ahead
                break;

        }

        indexAndSize.append(startIndex).append("-").append(size);
        return indexAndSize.toString();

    }

    public static void main(String args[])
    {
        //[]
        //[]


        int arr1[] = new int[]{33,22,48,4,39,36,41,47,15,45};
        int arr2[] = new int[]{22,33,48,4};
        ArrayShuffleProblem ap = new ArrayShuffleProblem();
        ap.relativeSortArray(arr1,arr2);
    }
}
