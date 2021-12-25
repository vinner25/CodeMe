package com.vinner.codeme.blind75.dp;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class CoinChange implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.\n" +
                "\n" +
                "Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.\n" +
                "\n" +
                "You may assume that you have an infinite number of each kind of coin.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: coins = [1,2,5], amount = 11\n" +
                "Output: 3\n" +
                "Explanation: 11 = 5 + 5 + 1\n" +
                "Example 2:\n" +
                "\n" +
                "Input: coins = [2], amount = 3\n" +
                "Output: -1\n" +
                "Example 3:\n" +
                "\n" +
                "Input: coins = [1], amount = 0\n" +
                "Output: 0";
    }
    public int coinChange(int[] coins, int amount) {
        if(amount <= 0)
            return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); //Keep Maximum value as dummy value so that when we min this gets replaced with real min value;
        dp[0] = 0;
        for(int i= 1; i<= amount; i++)
        {
            for(int coin : coins)
            {
                if(i >= coin)
                {
                    int  minWays = 1+ dp[i-coin];
                    dp[i] = Math.min(dp[i], minWays);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

    @Override
    public String getSolutionNotes() {
        return "This Problem is solved using Dynamic Problem. We initialize a dp[] of amount+1 length and value of Min ways is dp[amount]. " +
                "\n At each amjount starting from 1 to amountGiven, we calculate 1 + dp[i-coin] ways and add the min ways in the dp array. " +
                "\n the dp[] is initialized at dummy value of amount+1 so that when we calculate ways  , we set with min of ways and what is already" +
                "\n in the array at ith position. If it was filled with -1 then we had to add special check since it will always be minimum." +
                "\n for more : https://www.youtube.com/watch?v=jgiZlGzXMBw ";

    }

    @Override
    public String getTimeComplexity() {
        return "O(A*N) - A is the amount given and C is the number of coins. For any amount we iterate till A amount max and use Maximum C number of coins";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(A) - We will store results of our recursive call stack in array of A+1 which corresponds to A as we know dp[0] = 0";
    }
}
