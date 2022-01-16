package com.vinner.codeme.ctci.ds.sorting_and_searching;

import com.vinner.codeme.ProblemStatement;

public class BubbleSort implements ProblemStatement {

    public void bubbleSort(int[] arr)
    {
        for(int i=0 ; i< arr.length-1 ; i++)
        {
            for(int j = i+1; j< arr.length ; j++) {


                if(arr[i] > arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    @Override
    public String getDescription() {
        return "Write an algo to implement Bubble Sort";
    }

    @Override
    public String getSolutionNotes() {
        return "Bubble sort uses two for loops where the current element is compared with all the remaining elements";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
