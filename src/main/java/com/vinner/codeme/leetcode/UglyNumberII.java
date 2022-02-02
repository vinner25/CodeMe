package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class UglyNumberII implements ProblemStatement {

    public int nthUglyNumber(int n) {
        if(n== 1)
            return 1;
        int[] pf = new int[]{2,3,5};

        int[] pointers = new int[pf.length];
        Arrays.fill(pointers, 0);

        int[] dp = new int[n];
        dp[0] = 1;
        int count = 1;
        while(count < n)
        {
            int minValue = Integer.MAX_VALUE;
            for(int i= 0 ; i<pointers.length; i++)
            {
                int num = dp[pointers[i]] * pf[i];
                minValue = Math.min(num, minValue);
            }

            for(int i= 0 ; i<pointers.length; i++)
            {
                if(dp[pointers[i]] * pf[i] == minValue)
                {
                    pointers[i]++;
                }
            }
            dp[count++] = minValue;
        }

        return dp[n-1];
    }


    @Override
    public String getDescription() {
        return "An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.\n" +
                "\n" +
                "Given an integer n, return the nth ugly number.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 10\n" +
                "Output: 12\n" +
                "Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 1\n" +
                "Output: 1\n" +
                "Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= n <= 1690";
    }

    @Override
    public String getSolutionNotes() {
        return "The Naive approach is we keep on incrementing 1 to N and keep updating count whenever any number is a ugly nummber" +
                "The Optimal solution is to use DP. The DP solution is to calculate multiple of each of the given prime factors " +
                "and keep the minimum multiple as the next in the dp list. The trick is not to blindly increment the prime factor number once done because " +
                "there are few element which may have prime factor not given in the list. For Example : if keep on multiplying " +
                "2 after every time we calculate its next. At some point we will reach 2*7 = 14 and Look closley 14 has 7 as prime factor which " +
                "is not in the given list. Therefore we have to multiply/increment only from the given list. Therefire we will have a pointer array" +
                "which will point to element in the dp array and dp array only holds valid multiples";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
