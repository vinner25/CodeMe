package com.vinner.codeme.ctci.ds.sorting_and_searching;

public class SelectionSort {


    public void selectionSort(int[] arr)
    {
        int index = 0 ;

        while(index < arr.length-1)
        {
            int minIndex = index;
            for( int i = index ; i< arr.length ; i++ )
            {
              if(arr[minIndex] > arr[i])
              {
                  minIndex = i;
              }
            }
            int temp = arr[index];
            arr[index ] = arr[minIndex];
            arr[minIndex] = temp;
            index++;
        }
    }
}
