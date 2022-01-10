package com.vinner.codeme.ctci.ds.dp_recusrion_backtracking;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class MakeCoins implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an Infinite Number of Quarters(25 Cents) , dimes (10 cents), nickels (5 cents) , and pennies(1 cent) , write code to calculate " +
                "number of ways to represent n cents";
    }

    public int ways(int cents)
    {
        int[] coins = new int[]{1,5,10,25};
       // return  makeChange(cents, coins, 0);

        int[][] dp = new int[coins.length+1][cents+1];

        for(int i= 0 ; i<=cents ; i++)
        {
            dp[0][i] = 0;

        }

        for(int i=0 ; i<=coins.length; i++)
        {
            dp[i][0] = 1;
        }

        for(int row = 1; row<dp.length; row++)
        {
            for(int column = 1; column< dp[0].length; column++)
            {
                int coin = coins[row-1];
                int amount = column;
                if(amount - coin >= 0)
                    dp[row][column] = dp[row-1][column ] + dp[row][amount - coin];
                else
                    dp[row][column] = dp[row-1][column];
            }

        }
        return  dp[coins.length][cents];
    }





    @Override
    public String getSolutionNotes() {
        return "This problem is a classic DP problem and can be tackled by a Bottom Up approach" +
                "For Refer: https://www.youtube.com/watch?v=DJ4a7cmjZY0: ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m*n)";
    }

    @Override
    public String getSpaceComplexity() {
         return "O(m*n)";
    }
}
