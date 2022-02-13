package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class BuySellStockWithCooldown implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an array prices where prices[i] is the price of a given stock on the ith day.\n" +
                "\n" +
                "Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:\n" +
                "\n" +
                "After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).\n" +
                "Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: prices = [1,2,3,0,2]\n" +
                "Output: 3\n" +
                "Explanation: transactions = [buy, sell, cooldown, buy, sell]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: prices = [1]\n" +
                "Output: 0";
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][prices.length];
        for(int i=0;i<prices.length; i++)
            Arrays.fill(dp[i], -1);

        return getMaxProfit(prices, Integer.MAX_VALUE,0, -1, dp);
    }

    public int getMaxProfit(int[] prices, int minPrice,int index, int minPriceIndex, int[][] dp)
    {

        if(index >= prices.length)
            return 0;

        if(minPriceIndex > -1 && dp[minPriceIndex][index] != -1)
        {
            return dp[minPriceIndex][index];
        }

        if(minPrice > prices[index])
        {
            minPrice = prices[index];
            minPriceIndex = index;
            return getMaxProfit(prices, minPrice, index+1, minPriceIndex, dp);
        }
        else
        {
            int profit = prices[index] - minPrice;
            int totalProfit =  Math.max(profit + getMaxProfit(prices,Integer.MAX_VALUE,index+2, -1, dp),
                    getMaxProfit(prices,minPrice,index+1, minPriceIndex, dp));
            dp[minPriceIndex][index] = totalProfit;
            return totalProfit;
        }
    }

    @Override
    public String getSolutionNotes() {
        return "The Decision Tree is based on two conditions. If Stock is bought, whether to sell it or not. if Sold skip the next day " +
                " We have to calculate which decision will yield max profit, therefore we have to explore all possible actions. " +
                " Optimization is we keep a DP array which gives you max Profit yielded based on the min Price bought. " ;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) since we are calculating profit at day , if already calculated we are using dp array";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n*n) - for DP array";
    }
}
