package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,1,1], k = 2\n" +
                "Output: 2\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,2,3], k = 3\n" +
                "Output: 2\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= nums.length <= 2 * 104\n" +
                "-1000 <= nums[i] <= 1000\n" +
                "-107 <= k <= 107";
    }

    public int subarraySum(int[] nums, int k) {

        int count =0 ;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum+= nums[i];
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    @Override
    public String getSolutionNotes() {
        return "We are doing a cumulative sum approach and storing the frequency of repeated sum in a hashmap. Whenever cumulative Sum - K " +
                "is found in hashmap, we add the frequency of that found sum in our total count.";
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
