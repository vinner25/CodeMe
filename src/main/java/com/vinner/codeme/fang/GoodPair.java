package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class GoodPair implements ProblemStatement {

    public int numIdenticalPairs(int[] nums) {

        Map<Integer, Integer> numberToCountMap = new HashMap<>();
        for(int i : nums)
        {
            int count = 1;
            if(numberToCountMap.get(i) != null)
            {
                count += numberToCountMap.get(i);
            }
            numberToCountMap.put(i, count);
        }

        int goodPair = 0;
        for(int count :numberToCountMap.values() )
        {
            if(count>1)
            {
                goodPair+=  (count * (count-1))/2;
            }
        }
        return goodPair;
    }

    @Override
    public String getDescription() {
        return "Given an array of integers nums, return the number of good pairs.\n" +
                "\n" +
                "A pair (i, j) is called good if nums[i] == nums[j] and i < j.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,1,1,3]\n" +
                "Output: 4\n" +
                "Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,1,1,1]\n" +
                "Output: 6\n" +
                "Explanation: Each pair in the array are good.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1,2,3]\n" +
                "Output: 0";
    }

    @Override
    public String getSolutionNotes() {
        return "Take the count of each number in HashMap, then iterate Map to see if there are numbers with more than 1 count. " +
                "Calculate Total number of pairs you can from this";
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
