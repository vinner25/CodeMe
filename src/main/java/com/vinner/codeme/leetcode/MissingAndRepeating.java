package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class MissingAndRepeating implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 2\n" +
                "Arr[] = {2, 2}\n" +
                "Output: 2 1\n" +
                "Explanation: Repeating number is 2 and \n" +
                "smallest positive missing number is 1.\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "N = 3\n" +
                "Arr[] = {1, 3, 3}\n" +
                "Output: 3 2\n" +
                "Explanation: Repeating number is 3 and \n" +
                "smallest positive missing number is 2.";
    }

    public int[] findTwoElement(int arr[], int n) {
        // code here
        int missingNum =0 ;
        int repeatingNum = 0;

        for(int i =0 ; i<n ; i++)
        {
            int absVal = Math.abs(arr[i]);

            if(arr[absVal-1]>0)
                arr[absVal - 1] = -arr[absVal-1];
            else
                repeatingNum = absVal;
        }

        for(int i=0; i< n; i++)
        {
            if(arr[i] > 0)
            {
                missingNum =  i + 1;
            }
        }

        return new int[]{repeatingNum, missingNum};

    }
    @Override
    public String getSolutionNotes() {
        return "To approach this problem in O(n) and O(1) space we are using the array itself to mark what is visited and waht not" +
                "Traverse the arry and on each element mark the index position as negative from the array value" +
                "If any index position is already negative means array element is traversed" +
                "In the end traverse the array again and when you see any positive value it means that index has value which " +
                "was repated and is holding the missing value you just convert the index to value by adding 1";
    }

    @Override
    public String getTimeComplexity() {
        return "O(N)";
    }

    @Override
    public String getSpaceComplexity() {
        return"O(1)";
    }
}
