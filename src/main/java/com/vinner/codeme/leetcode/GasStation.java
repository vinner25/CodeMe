package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class GasStation implements ProblemStatement {
    @Override
    public String getDescription() {
        return "134. Gas Station\n" +
                "Medium\n" +
                "\n" +
                "4330\n" +
                "\n" +
                "517\n" +
                "\n" +
                "Add to List\n" +
                "\n" +
                "Share\n" +
                "There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].\n" +
                "\n" +
                "You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.\n" +
                "\n" +
                "Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]\n" +
                "Output: 3\n" +
                "Explanation:\n" +
                "Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4\n" +
                "Travel to station 4. Your tank = 4 - 1 + 5 = 8\n" +
                "Travel to station 0. Your tank = 8 - 2 + 1 = 7\n" +
                "Travel to station 1. Your tank = 7 - 3 + 2 = 6\n" +
                "Travel to station 2. Your tank = 6 - 4 + 3 = 5\n" +
                "Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.\n" +
                "Therefore, return 3 as the starting index.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: gas = [2,3,4], cost = [3,4,3]\n" +
                "Output: -1\n" +
                "Explanation:\n" +
                "You can't start at station 0 or 1, as there is not enough gas to travel to the next station.\n" +
                "Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4\n" +
                "Travel to station 0. Your tank = 4 - 3 + 2 = 3\n" +
                "Travel to station 1. Your tank = 3 - 3 + 3 = 3\n" +
                "You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.\n" +
                "Therefore, you can't travel around the circuit once no matter where you start.";
    }

    @Override
    public String getSolutionNotes() {
        return "The Brute Force algo is we start at each station and see if it can take us any further means " +
                "if cost <= gas we get at that station. Then we keep on checking while the tank has some gas to move further" +
                "If not we start with next station" +
                "The More Optimal solution is we loop through each station and calculate total cost and total gas we get" +
                " AT each iteration we keep on checking if our total gas in tank >=0 so that we can move to next station" +
                " if not we know that the current station wont let us go any further. " +
                " In the end we check if total gas we have is greater than equal to total sum . If yes we return the index" +
                " which started a positive tank and kept it that way. These kind of problems are called greedy problems";
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
