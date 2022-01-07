package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class HouseRobber implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.\n" +
                "\n" +
                "Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,1]\n" +
                "Output: 4\n" +
                "Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).\n" +
                "Total amount you can rob = 1 + 3 = 4.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [2,7,9,3,1]\n" +
                "Output: 12\n" +
                "Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).\n" +
                "Total amount you can rob = 2 + 9 + 1 = 12.";
    }
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0; //Nothing to Rob

        if(nums.length == 1)
            return nums[0]; //Only 1 house to ROB
        if(nums.length == 2) //Only two houses
            return Math.max(nums[0], nums[1]);

        if(nums.length == 3) //If just three houses, there are only two possibilities. Either you pick House 1 and 3 or just house 2
            return Math.max(nums[0]+nums[2], nums[1]);

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0]+nums[2];

        int max =  dp[2] ;
        for(int i = 3 ; i< nums.length; i++)
        {
            dp[i] = Math.max(nums[i]+dp[i-2], nums[i]+dp[i-3] );

            max = Math.max(dp[i], max);

        }
        return max;
    }

    @Override
    public String getSolutionNotes() {
        return "We will use Dynamic Programming to keep track of what the each of house will yield us. Then we calculate the maximum profit yielded by an house";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n-3) => O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) - For the DP table";
    }
}
