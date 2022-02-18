package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class TripleIncreasingSubsequence implements ProblemStatement {


    public boolean increasingTriplet(int[] nums) {

            int firstNum = Integer.MAX_VALUE;
            int  secondNum  = Integer.MAX_VALUE;
            for(int num : nums)
            {
                if( num <= firstNum)
                    firstNum = num;
                else if( num <= secondNum)
                    secondNum = num;
                else
                    return true;
            }
            return false;
    }

    @Override
    public String getDescription() {
        return "Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,4,5]\n" +
                "Output: true\n" +
                "Explanation: Any triplet where i < j < k is valid.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [5,4,3,2,1]\n" +
                "Output: false\n" +
                "Explanation: No triplet exists.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [2,1,5,0,4,6]\n" +
                "Output: true\n" +
                "Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= nums.length <= 5 * 105\n" +
                "-231 <= nums[i] <= 231 - 1\n" +
                " \n" +
                "\n" +
                "Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?";
    }

    @Override
    public String getSolutionNotes() {
        return "We will use two variables to keep track of Increasing Sequence and if we come across a triplet we return true";
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
