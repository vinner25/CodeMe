package com.vinner.codeme.blind75.dp;

import com.vinner.codeme.ProblemStatement;

public class MinCostClimbingStairs implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.\n" +
                "\n" +
                "You can either start from the step with index 0, or the step with index 1.\n" +
                "\n" +
                "Return the minimum cost to reach the top of the floor.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: cost = [10,15,20]\n" +
                "Output: 15\n" +
                "Explanation: You will start at index 1.\n" +
                "- Pay 15 and climb two steps to reach the top.\n" +
                "The total cost is 15.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: cost = [1,100,1,1,1,100,1,1,100,1]\n" +
                "Output: 6\n" +
                "Explanation: You will start at index 0.\n" +
                "- Pay 1 and climb two steps to reach index 2.\n" +
                "- Pay 1 and climb two steps to reach index 4.\n" +
                "- Pay 1 and climb two steps to reach index 6.\n" +
                "- Pay 1 and climb one step to reach index 7.\n" +
                "- Pay 1 and climb two steps to reach index 9.\n" +
                "- Pay 1 and climb one step to reach the top.\n" +
                "The total cost is 6.";
    }
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length < 0 )
            return 0;
        int[] dp = new int[cost.length+1]; //We chose array+1 since we know that the top is out of bounds of cost array
        dp[cost.length] = 0; //No cost at top floor
        dp[cost.length - 1] = cost[cost.length-1]; //We know the cost from Last step to reach top is always the cost at last step
        for(int i= cost.length -2 ; i>=0 ; i--)
        {
            dp[i] =  Math.min(dp[i+1]+cost[i], dp[i+2]+cost[i]); //We chose the minimum option

        }
        return Math.min(dp[0], dp[1]); //Since we can start from either step 1 or step 0 we can chose the minimum value from both
    }
    @Override
    public String getSolutionNotes() {
        return "We will start from the last stair as we know anyhow cost from last stair to top is cost at last stair and we go from their";
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
