package com.vinner.codeme.blind75.arrays;

import com.vinner.codeme.ProblemStatement;

public class MaximumSubArray implements ProblemStatement {


    public int maxSubArray(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
        {
            return nums[0];
        }
        int maxSum = nums[0];
        for(int i=1 ; i<nums.length; i++)
        {
            int newSum = nums[i-1] + nums[i];
            if(newSum > nums[i])
                nums[i] = newSum;
            else
            {
                newSum = nums[i];
            }

            maxSum = Math.max(newSum, maxSum);

        }
        return maxSum;
    }

    @Override
    public String getDescription() {
        return "Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.\n" +
                "\n" +
                "A subarray is a contiguous part of an array.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [-2,1,-3,4,-1,2,1,-5,4]\n" +
                "Output: 6\n" +
                "Explanation: [4,-1,2,1] has the largest sum = 6.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1]\n" +
                "Output: 1\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [5,4,-1,7,8]\n" +
                "Output: 23";
    }

    @Override
    public String getSolutionNotes() {
        return "This is dynamic programming problem. The Idea is to get the best sum of contagious subarray at every index of array. Then return the max sum" +
                "achieved at any of the indices of the array. We can create a new DP table or modify the existing nums table as each index of nums table will " +
                "maitain the best sum possible using the sub array from o to n index";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
