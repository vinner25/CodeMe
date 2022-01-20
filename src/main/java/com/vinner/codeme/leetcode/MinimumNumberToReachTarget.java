package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class MinimumNumberToReachTarget implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.\n" +
                "\n" +
                "In one move, you can either:\n" +
                "\n" +
                "Increment the current integer by one (i.e., x = x + 1).\n" +
                "Double the current integer (i.e., x = 2 * x).\n" +
                "You can use the increment operation any number of times, however, you can only use the double operation at most maxDoubles times.\n" +
                "\n" +
                "Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target starting with 1.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: target = 5, maxDoubles = 0\n" +
                "Output: 4\n" +
                "Explanation: Keep incrementing by 1 until you reach target.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: target = 19, maxDoubles = 2\n" +
                "Output: 7\n" +
                "Explanation: Initially, x = 1\n" +
                "Increment 3 times so x = 4\n" +
                "Double once so x = 8\n" +
                "Increment once so x = 9\n" +
                "Double again so x = 18\n" +
                "Increment once so x = 19\n" +
                "Example 3:\n" +
                "\n" +
                "Input: target = 10, maxDoubles = 4\n" +
                "Output: 4\n" +
                "Explanation: Initially, x = 1\n" +
                "Increment once so x = 2\n" +
                "Double once so x = 4\n" +
                "Increment once so x = 5\n" +
                "Double again so x = 10";
    }
    public int minMoves(int target, int maxDoubles) {

        return waysToReachTarget(target, maxDoubles, 0);

    }

    private int waysToReachTarget(int currentNum, int doublesLeft, int iteration)
    {
        if(currentNum==1)
            return iteration;

        if(doublesLeft == 0) // Means can never be doubled , so total of currentNUm - 1 steps have to be permofrmed
            return iteration+ (currentNum-1);

        if(currentNum % 2 == 0 )
        {
            return waysToReachTarget(currentNum/2, doublesLeft-1, iteration+1);
        }
        else
            return waysToReachTarget(currentNum-1, doublesLeft, iteration+1);

    }
    @Override
    public String getSolutionNotes() {
        return "The Min Moves can be achieved only be doubling the maximum number we can. So we start at the very end and see if we can double it " +
                "If we can double it we do and move with left over unless we reach 1. If there is no scope of doubling we simply return num -1 ways as " +
                "we can only add ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(logN)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
