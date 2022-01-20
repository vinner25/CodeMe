package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class MaxPoints implements ProblemStatement {


    public long mostPoints(int[][] questions) {

        int n = questions.length;
        long[] dp = new long[n+1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            //check if it is not possible to find points after required brainpower
            if(questions[i][1] + i + 1 > n){
                dp[i] = Math.max(dp[i+1], questions[i][0]);
            }
            else{
                //if possible then add in current value and find maximum till now
                dp[i] = Math.max(dp[i+1], questions[i][0] + dp[i + questions[i][1] + 1]);
            }
        }
        return dp[0];
    }

    @Override
    public String getDescription() {
        return "You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].\n" +
                "\n" +
                "The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.\n" +
                "\n" +
                "For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:\n" +
                "If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.\n" +
                "If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.\n" +
                "Return the maximum points you can earn for the exam.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: questions = [[3,2],[4,3],[4,4],[2,5]]\n" +
                "Output: 5\n" +
                "Explanation: The maximum points can be earned by solving questions 0 and 3.\n" +
                "- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions\n" +
                "- Unable to solve questions 1 and 2\n" +
                "- Solve question 3: Earn 2 points\n" +
                "Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]\n" +
                "Output: 7\n" +
                "Explanation: The maximum points can be earned by solving questions 1 and 4.\n" +
                "- Skip question 0\n" +
                "- Solve question 1: Earn 2 points, will be unable to solve the next 2 questions\n" +
                "- Unable to solve questions 2 and 3\n" +
                "- Solve question 4: Earn 5 points\n" +
                "Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.\n" +
                " ";
    }

    @Override
    public String getSolutionNotes() {
        return "We will use Dynamic Programming to solve this problem";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - N is length of questions";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for DP array";
    }
}
