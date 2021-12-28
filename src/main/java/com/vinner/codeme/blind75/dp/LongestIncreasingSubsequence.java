package com.vinner.codeme.blind75.dp;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class LongestIncreasingSubsequence implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array nums, return the length of the longest strictly increasing subsequence.\n" +
                "\n" +
                "A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [10,9,2,5,3,7,101,18]\n" +
                "Output: 4\n" +
                "Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [0,1,0,3,2,3]\n" +
                "Output: 4";
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); //By Default length of increasing subsequence is 1 at each index
        int max =1;
        for(int i= 1 ; i< nums.length; i++)
        {
            for(int j=0 ; j<i;j++)
            {
                int longestSubsequence = 1;
                if(nums[i] > nums[j]) { //Only if the new number is longer than number at J then can be added to the subsequence
                    longestSubsequence = dp[j] + 1;
                    dp[i] =Math.max(longestSubsequence, dp[i]);
                    max = Math.max(max,longestSubsequence );
                }

            }
        }
        return max;
    }
    @Override
    public String getSolutionNotes() {
        return "A very amazing Dynamic Programming problem. THis can be solved by tackling the subproblems in the problem" +
                " We will add the max length at each index of our DP array. Every time we move in the array we will compare with previous elements" +
                " and if at any point current value is greater than previous value, we add +1 to the value of Longest length at that position as we are adding the " +
                "current number as well to the previous list" +
                "Then at current position we store the max length possible." +
                "" +
                "https://www.youtube.com/watch?v=fV-TF4OvZpk ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2) - Since we have two for loops";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N) - The array for DP";
    }
}
