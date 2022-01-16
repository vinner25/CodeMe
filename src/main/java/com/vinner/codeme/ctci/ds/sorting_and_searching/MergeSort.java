package com.vinner.codeme.ctci.ds.sorting_and_searching;

import com.vinner.codeme.ProblemStatement;

public class MergeSort implements ProblemStatement {


    public void mergeSort(int[] arr)
    {
        int[] temp = new int[arr.length];
        splitAndMerge(arr, 0 , arr.length-1, temp);
    }

    public void splitAndMerge(int[] arr, int start, int end , int[] temp)
    {
        if(start < end)
        {
            int mid = (start + end)/2;
            splitAndMerge(arr, start, mid, temp);
            splitAndMerge(arr, mid+1, end, temp);
            merge(arr, start, mid, end, temp);
        }
    }

    public void merge(int[] arr, int start, int mid,  int end, int[] temp)
    {
        int index = start;

        int leftStart = start;
        int rightStart = mid+1;

        while(leftStart <= mid && rightStart <= end)
        {
            if(arr[leftStart] > arr[rightStart])
            {
                temp[index] = arr[rightStart];
                rightStart++;
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

        for(int i= start; i<= end ; i++)
        {
            arr[i] = temp[i];
        }

    }


    @Override
    public String getDescription() {
        return "Implement Merge Sort Algortithm";
    }

    @Override
    public String getSolutionNotes() {
        return "Pseudo code is " +
                "1) Divide array " +
                "2) Reach End of recursion tree where we have one element each in Left and Right arrays" +
                "3) Sort them (Make use of Temp array) " +
                "4) Then the left and right arrays will increase as we move up recursion tree but they will sorted amongst themselves. Repeat 2 & 3" +
                "5) Compare the arrays and add whatever is left at the end of each array" +
                "6)) In the end everything would have been sorted";
    }

    @Override
    public String getTimeComplexity() {
        return "O(nlog(n))";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) - Space used by the Helper Array";
    }
}
