package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class GuessNumberHighOrLow implements ProblemStatement {
    @Override
    public String getDescription() {
        return "We are playing the Guess Game. The game is as follows:\n" +
                "\n" +
                "I pick a number from 1 to n. You have to guess which number I picked.\n" +
                "\n" +
                "Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.\n" +
                "\n" +
                "You call a pre-defined API int guess(int num), which returns three possible results:\n" +
                "\n" +
                "-1: Your guess is higher than the number I picked (i.e. num > pick).\n" +
                "1: Your guess is lower than the number I picked (i.e. num < pick).\n" +
                "0: your guess is equal to the number I picked (i.e. num == pick).\n" +
                "Return the number that I picked.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 10, pick = 6\n" +
                "Output: 6\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 1, pick = 1\n" +
                "Output: 1\n" +
                "Example 3:\n" +
                "\n" +
                "Input: n = 2, pick = 1\n" +
                "Output: 1\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= n <= 231 - 1\n" +
                "1 <= pick <= n";
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int guess(int num){
        return (int)Math.random();
    }
    @Override
    public String getSolutionNotes() {
        return "Perform Binary Search";
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
