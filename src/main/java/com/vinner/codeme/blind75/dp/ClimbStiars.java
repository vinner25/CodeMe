package com.vinner.codeme.blind75.dp;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class ClimbStiars implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are climbing a staircase. It takes n steps to reach the top.\n" +
                "\n" +
                "Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 2\n" +
                "Output: 2\n" +
                "Explanation: There are two ways to climb to the top.\n" +
                "1. 1 step + 1 step\n" +
                "2. 2 steps\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 3\n" +
                "Output: 3\n" +
                "Explanation: There are three ways to climb to the top.\n" +
                "1. 1 step + 1 step + 1 step\n" +
                "2. 1 step + 2 steps\n" +
                "3. 2 steps + 1 step\n";
    }


    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return numberOfWays(n, dp);
    }

    private int numberOfWays(int n, int[] dp)
    {
        if(n < 0)
            return 0;
        if(dp[n] > -1)
            return dp[n];
        dp[n] = numberOfWays(n-1, dp) + numberOfWays(n-2, dp);
        return dp[n];

    }


    @Override
    public String getSolutionNotes() {
        return "Implement a very basic DP alogirithm. At nth step the possible ways are ways(n-1) + ways(n-2" +
                "\n Add the Base cases and iterate recursively. The Dynamic programming will bring down the Time complexity" +
                "to linear as compare to exponential if it was plain recusrion";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we iterate each element only once and next time when same is called we fetch results from dp array. " +
                "\n If it was plain recursion with no dp then Time Complexity would have been O(2^n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) - Since we have a dp[] of length N to store results of ways at each value of N";
    }
}
