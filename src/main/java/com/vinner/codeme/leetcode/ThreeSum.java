package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.\n" +
                "\n" +
                "Notice that the solution set must not contain duplicate triplets.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [-1,0,1,2,-1,-4]\n" +
                "Output: [[-1,-1,2],[-1,0,1]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = []\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [0]\n" +
                "Output: []";
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 )
            return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length -2 ; i++)
        {
            if(i == 0 || (i!= 0 && nums[i-1] != nums[i]))
            {
                int target = nums[i];
                findTwoSum(target, nums, i+1, nums.length-1, results);
            }

        }
        return results;
    }

    private void findTwoSum(int target, int[] nums, int startIndex , int endIndex , List<List<Integer>> result)
    {

        int compliment = 0-target;

        while(startIndex < endIndex)
        {
            int sum = nums[startIndex] + nums[endIndex];

            if(sum == compliment)
            {
                result.add(Arrays.asList(target, nums[startIndex], nums[endIndex]));
                startIndex++;
                while(nums[startIndex] == nums[startIndex-1] && startIndex < endIndex) //We can only adjust one of the indexes as the while loop conditions will anyhow adjust
                    // the other one
                    startIndex++;
            }
            if( sum > compliment)
                endIndex--;
            else if(sum < compliment)
                startIndex++;

        }

    }


    @Override
    public String getSolutionNotes() {
        return "The Brute Force is to iterate over every element and we end up having 3 for loops trying to find such a pair. To get rid of duplicates" +
                "we can sort the original array and then once we scan possible pairs for a num, when we increment we make sure it is not the same elemt as previous." +
                " Two find the pair we can use two pointer approach with the indexes and once we find a pair, And we are iterating the indexes" +
                "We can run a little while loop to see if the next element of the incremental index is not same as previous. " +
                "Refer : https://www.youtube.com/watch?v=jzZsG8n2R9A ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2) - Technically it is O(nlogn) + o(n^2) - for sorting and double iterations. But o(nlogn) less than o(n^2) we can just take it into conisderation ";
    }

    @Override
    public String getSpaceComplexity() {
        return  "O(N) - List of N sets maximum each set holding max 3 elements which is constant";
    }
}
