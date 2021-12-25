package com.vinner.codeme.ctci.ds.dp;

import java.util.Arrays;

public class FibonacciSeries {

    class Solution {
        public int fib(int n) {

            if(n > 1) {
                int[] dp = new int[n + 1];
                Arrays.fill(dp, -1);
                return getFibb(n, dp);
            }
            else return n;
        }

        private int getFibb(int n, int[] dp)
        {
            if(dp[n] == -1)
            {
                dp[n] =  getFibb(n-1, dp) + getFibb(n-2 , dp);
            }
            return dp[n];
        }
    }
}
