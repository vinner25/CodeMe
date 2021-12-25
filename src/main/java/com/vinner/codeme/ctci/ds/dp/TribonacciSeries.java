package com.vinner.codeme.ctci.ds.dp;

import java.util.Arrays;

public class TribonacciSeries {

    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return getTribonnaci(n, dp);

    }
    private int getTribonnaci(int n, int[] dp)
    {
        if(n <= 0)
            return 0;
        if(n > 0 && n < 3)
            return 1;

        if(dp[n] == -1)
        {
            dp[n] =  getTribonnaci(n-1, dp) + getTribonnaci(n-2 , dp) +  getTribonnaci(n-3 , dp);
        }
        return dp[n];
    }
}
