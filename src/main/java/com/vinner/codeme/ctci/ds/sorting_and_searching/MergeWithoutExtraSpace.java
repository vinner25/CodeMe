package com.vinner.codeme.ctci.ds.sorting_and_searching;

import com.vinner.codeme.ProblemStatement;

public class MergeWithoutExtraSpace implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: \n" +
                "n = 4, arr1[] = [1 3 5 7] \n" +
                "m = 5, arr2[] = [0 2 6 8 9]\n" +
                "Output: \n" +
                "arr1[] = [0 1 2 3]\n" +
                "arr2[] = [5 6 7 8 9]\n" +
                "Explanation:\n" +
                "After merging the two \n" +
                "non-decreasing arrays, we get, \n" +
                "0 1 2 3 5 6 7 8 9.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: \n" +
                "n = 2, arr1[] = [10, 12] \n" +
                "m = 3, arr2[] = [5 18 20]\n" +
                "Output: \n" +
                "arr1[] = [5 10]\n" +
                "arr2[] = [12 18 20]\n" +
                "Explanation:\n" +
                "After merging two sorted arrays \n" +
                "we get 5 10 12 18 20.\n" +
                "\n" +
                "\n" +
                "Your Task:\n" +
                "You don't need to read input or print anything. You only need to complete the function merge() that takes arr1, arr2, n and m as input parameters and modifies them in-place so that they look like the sorted merged array when concatenated.\n" +
                " \n" +
                "\n" +
                "Expected Time Complexity:  O((n+m) log(n+m))\n" +
                "Expected Auxilliary Space: O(1)";
    }

    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        // code here
        int i=0;

        while( i < n)
        {
            if(arr1[i] > arr2[0])
            {
                long temp = arr1[i];
                arr1[i] = arr2[0];
                if(arr2.length < 2 || temp < arr2[1])
                    arr2[0] = temp; //Insert at start
                else
                {
                    int j = 1;
                    boolean isInserted = false;
                    while ( j< m)
                    {
                        if(arr2[j] < temp)
                            arr2[j-1] = arr2[j];
                        else
                        {
                            arr2[j-1] = temp;
                            isInserted = true;
                            break;
                        }
                        j++;
                    }
                    if(!isInserted)
                        arr2[m-1] = temp; //Insert at last

                }
            }
            i++;
        }


    }

    @Override
    public String getSolutionNotes() {
        return "The idea is: We will traverse the first array and compare it with the first element of the second array. If the first element of the second array is smaller than the first array, we will swap and then sort the second array. ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n*m)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
