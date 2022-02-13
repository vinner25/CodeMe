package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class MaximumAverageSubArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an integer array nums consisting of n elements, and an integer k.\n" +
                "\n" +
                "Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,12,-5,-6,50,3], k = 4\n" +
                "Output: 12.75000\n" +
                "Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [5], k = 1\n" +
                "Output: 5.00000";
    }
    public double findMaxAverage(int[] nums, int k) {

        double prevAverage = 0;
        double maxAverage = Integer.MIN_VALUE;
        for(int i=k-1 ; i< nums.length ; i++)
        {
            double avg = 0;
            if( i == k-1)
            {

                int start = 0;
                while(start<= i)
                    avg+= nums[start++];
                //   avg /= k;
            }
            else
            {
                avg = ((prevAverage) - nums[i-k] + nums[i]);

            }

            prevAverage = avg;
            maxAverage = Math.max(avg, maxAverage);

        }

        return maxAverage/k; //To Optimize the solution we can do Division in the end as Division initially wont affect the max. In other word max sum will have max average

    }
    @Override
    public String getSolutionNotes() {
        return "Simple Sliding Window Problem similar to Rabin Karp Algo";
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
