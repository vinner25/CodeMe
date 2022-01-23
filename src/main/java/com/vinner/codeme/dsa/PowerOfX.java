package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

public class PowerOfX implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Implement pow(x, n), which calculates x raised to the power n (i.e., xn).\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: x = 2.00000, n = 10\n" +
                "Output: 1024.00000\n" +
                "Example 2:\n" +
                "\n" +
                "Input: x = 2.10000, n = 3\n" +
                "Output: 9.26100\n" +
                "Example 3:\n" +
                "\n" +
                "Input: x = 2.00000, n = -2\n" +
                "Output: 0.25000\n" +
                "Explanation: 2-2 = 1/22 = 1/4 = 0.25";
    }

    public double myPow(double x, int n) {
        if( x == 0)
            return 0;
        double pow = pow(x , Math.abs(n));
        return n < 0 ?  1/pow : pow;
    }

    private double pow(double x, int n)
    {
        if(n == 1)
            return x;
        if( n == 0)
            return 1;
        else if(n % 2 == 0)
        {
            double p = pow(x , n/2);
            return p * p ;
        }
        else {

            double p =  pow(x , n/2);  // if n is odd like 5 we will do x^2 * x^2 * x
            return x *  p * p ;
        }
    }

    @Override
    public String getSolutionNotes() {
        return "We are applying a divide and conquer approach. If Exponent is negative , a simple way to handle it is do x^n and then divide it by " +
                "1. So basically 1/x^n for negative exponents";
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
