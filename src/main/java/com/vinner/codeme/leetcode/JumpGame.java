package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class JumpGame implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.\n" +
                "\n" +
                "Return true if you can reach the last index, or false otherwise.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [2,3,1,1,4]\n" +
                "Output: true\n" +
                "Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,2,1,0,4]\n" +
                "Output: false\n" +
                "Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.\n" +
                " ";
    }
    public boolean canJumpUsingDP(int[] nums) { //

        if(nums.length <= 1)
            return true;

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for(int i = nums.length-2; i >= 0 ; i--)
        {
            int jumpsAllowed = nums[i];

            while(jumpsAllowed > 0 )
            {
                if(i + jumpsAllowed > nums.length -1 || dp[i+jumpsAllowed])
                {
                    dp[i] = true;
                    break;
                }
                jumpsAllowed--;

            }
        }
        return dp[0];
    }

    public boolean canJumpOptimised(int[] nums) //Using Cross Valley Approach - Watch Youtube video for more details in the solution notes
    {
        int reachable = 0; //Initialize Reachability to 0
        for(int i = 0 ; i<nums.length; i++)
        {
            if(reachable < i) //means we are past our max Reachability.
                return false;

            reachable = Math.max(reachable, i+nums[i]); //Always keep the max reachability
        }
        return true; //If we are over the complete array and our reachability was never less than index it means we can reach end of array
    }

    @Override
    public String getSolutionNotes() {
        return "The DP approach is basically doing a bottom up solution to set flag which indexes can let us reach end and then other indexes get value from it" +
                "The more optimized approach is using Valley cross technique where we keep maximum reachability from start as we traverse. If at any point our index becomes " +
                " greater than max reachability it means we can no longer reach end";
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
