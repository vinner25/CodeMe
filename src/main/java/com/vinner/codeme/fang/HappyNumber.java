package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class HappyNumber implements ProblemStatement {

    public boolean isHappy(int n) {

        int slowPtr = n ;
        int fastPtr =getNextNum(n);

        while(fastPtr != 1 && slowPtr != fastPtr)
        {
            slowPtr = getNextNum(slowPtr);
            fastPtr = getNextNum(getNextNum(fastPtr));
        }
        return fastPtr == 1;
    }

    private int getNextNum(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            sum += (n%10) * (n%10);
            n /= 10;
        }

        return sum;
    }

    @Override
    public String getDescription() {
        return "Write an algorithm to determine if a number n is happy.\n" +
                "\n" +
                "A happy number is a number defined by the following process:\n" +
                "\n" +
                "Starting with any positive integer, replace the number by the sum of the squares of its digits.\n" +
                "Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.\n" +
                "Those numbers for which this process ends in 1 are happy.\n" +
                "Return true if n is a happy number, and false if not.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 19\n" +
                "Output: true\n" +
                "Explanation:\n" +
                "12 + 92 = 82\n" +
                "82 + 22 = 68\n" +
                "62 + 82 = 100\n" +
                "12 + 02 + 02 = 1\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 2\n" +
                "Output: false";
    }

    @Override
    public String getSolutionNotes() {
        return "Using Floyds Cycle Detetction mechanism , we check whether there is a cycle or not";
    }

    @Override
    public String getTimeComplexity() {
        return "O(logN) for calculating next element";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
