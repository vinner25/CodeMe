package com.vinner.codeme.blind75.dp;

import com.vinner.codeme.ProblemStatement;

public class LargestCommonSubsequence implements ProblemStatement {
    @Override
    public String getDescription() {
        return null;
    }

    //Recursive
    public int lcs(String s1, String s2)
    {

        if(s1 == null || s2 == null)
            return  0;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0 ; i<dp.length; i++)
        {
            dp[i][0] = 0;
        }

        for(int i=0 ; i<dp[0].length; i++)
        {
            dp[0][i] = 0;

        }
        return findLcsDP(s1,s2,dp);
       // return findLcs(s1, s2, s1.length()-1, s2.length()-1);
    }

    //DP
    private int findLcsDP(String s1, String s2, int[][] dp)
    {
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j <  dp[0].length; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
       return dp[s1.length()][s2.length()];
    }


    private int findLcs(String s1, String s2, int i, int j)
    {
        if(i<0 || j <0)
            return 0;

        if(s1.charAt(i) == s2.charAt(j))
            return  1+ findLcs(s1, s2, i-1, j-1);

        else
            return Math.max(findLcs(s1, s2, i-1, j), findLcs(s1, s2, i, j-1));
    }





    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }
}
