package com.vinner.codeme.blind75.arrays;

import com.vinner.codeme.ProblemStatement;

public class BestTimeForStock implements ProblemStatement {


    @Override
    public String getDescription() {
        return "You are given an array prices where prices[i] is the price of a given stock on the ith day.\n" +
                "\n" +
                "You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.\n" +
                "\n" +
                "Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: prices = [7,1,5,3,6,4]\n" +
                "Output: 5\n" +
                "Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.\n" +
                "Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: prices = [7,6,4,3,1]\n" +
                "Output: 0\n" +
                "Explanation: In this case, no transactions are done and the max profit = 0.";
    }

    public int maxProfit(int[] costs)
    {
        int maxProfit = 0;
        int minimumPrice = Integer.MAX_VALUE; //Initialize the Minimum price as the MAX Value

        for(int i=0 ; i<costs.length; i++)
        {
            if(costs[i] < minimumPrice)
                minimumPrice = costs[i];
            else if(costs[i] - minimumPrice > maxProfit)
                maxProfit = costs[i] - minimumPrice;
        }
        return  maxProfit;
    }

    @Override
    public String getSolutionNotes() {
        return "We will traverse the whole array. Capture the minimum value first and if next value is minimum then previous Minumum" +
                "Then Reset Minimum Value" +
                "Else calculate MaxProfit if MaxProfit > previousMax Profit, Reset Max Profit" +
                "It will be like a statistical graph range where you are trying to find the maximum height between minimum and value in a range";
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
