package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

public class InversionCount implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of integers. Find the Inversion Count in the array. \n" +
                "\n" +
                "Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. \n" +
                "Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: N = 5, arr[] = {2, 4, 1, 3, 5}\n" +
                "Output: 3\n" +
                "Explanation: The sequence 2, 4, 1, 3, 5 \n" +
                "has three inversions (2, 1), (4, 1), (4, 3).\n" +
                "Example 2:\n" +
                "\n" +
                "Input: N = 5\n" +
                "arr[] = {2, 3, 4, 5, 6}\n" +
                "Output: 0\n" +
                "Explanation: As the sequence is already \n" +
                "sorted so there is no inversion count.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: N = 3, arr[] = {10, 10, 10}\n" +
                "Output: 0\n" +
                "Explanation: As all the elements of array \n" +
                "are same, so there is no inversion count.\n" +
                "Your Task:\n" +
                "You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.\n" +
                "\n" +
                "Expected Time Complexity: O(NLogN).\n" +
                "Expected Auxiliary Space: O(N).";
    }
    public static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return splitAndMerge(arr,0, arr.length-1, new long[arr.length]);
    }


    static long splitAndMerge(long[] arr, int start, int end, long[] temp)
    {
        long mergeCount = 0;
        if(start < end)
        {
            int mid = (start + end)/2;
            mergeCount+= splitAndMerge(arr,start, mid,temp); //Left side of Array
            mergeCount+= splitAndMerge(arr, mid+1, end,temp); //Right Side of Array
            mergeCount += merge(arr, start, mid, end, temp);
        }
        return mergeCount;
    }

    static long merge(long[] arr, int start, int mid , int end, long[] temp)
    {
        int index = start;
        int leftStart = start;
        int rightStart = mid+1;
        long swapCount = 0;
        while(leftStart <= mid && rightStart <= end)
        {
            if(arr[leftStart] > arr[rightStart]) //Swap Needed
            {
                temp[index] = arr[rightStart];
                rightStart++;
                swapCount+= (mid - leftStart +1); // The Logic here is that All the number of items after current Left element are
                // however greater than element being swapped which means they must also be considered for inversion count
            }
            else
            {
                temp[index] = arr[leftStart];
                leftStart++;
            }
            index++;

        }

        while(leftStart <= mid)
        {
            temp[index] = arr[leftStart];
            index++;
            leftStart++;

        }


        while(rightStart <= end)
        {
            temp[index] = arr[rightStart];
            index++;
            rightStart++;
        }


        for(int i= start; i<=end;i++ )
        {
            arr[i] = temp[i];
        }

        return swapCount;
    }
    @Override
    public String getSolutionNotes() {
        return "We will perform  a merge sort on the array and count how many numbers we have to do a swap. Please note that when we swap" +
                "using merge sort we know the element on right side of current element are also greater than the element on right array being swapped with " +
                "so we count all of them in the inversion count as well.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogN)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N) for Auxillary Array";
    }
}
