package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 8\n" +
                "A[] = {15,-2,2,-8,1,7,10,23}\n" +
                "Output: 5\n" +
                "Explanation: The largest subarray with\n" +
                "sum 0 will be -2 2 -8 1 7.\n" +
                "Your Task:\n" +
                "You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.";
    }
    int maxLen(int arr[], int n)
    {
        // Your code here
        int sum = 0;
        Map<Integer,Integer> currentSumToIndex = new HashMap<>();
        int longestLength = 0;
        for(int i = 0 ; i< n ; i++)
        {

            sum+= arr[i];
            if(sum == 0)
            {
                longestLength =  i+1; //Since we are talking about lengths here so incrementing the index by 1

            }
            else if(currentSumToIndex.containsKey(sum)) //if sum we currently have was previously before tooo
            // Then elements where currentSum was previously found and current position is also 0
            {
                int length =  i - currentSumToIndex.get(sum) + 1;
                longestLength = Math.max(longestLength, length);
            }
            else
            {
                currentSumToIndex.put(sum, i+1);
            }
        }

        return  longestLength;

    }
    @Override
    public String getSolutionNotes() {
        return "The brute force for this solution is two have two for loop and keep on adding elements and see what max length makes sum 0. " +
                "The Optimal solution is using hashmaps. We are basically maintaining a running sum of values in array. Now if either the running sum becomes zero that ith " +
                "position is maximum sum else if a sum repeats itself it means all the elements after the repeating element so we repeat it.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
