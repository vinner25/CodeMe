package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSumSets implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,5,11,5]\n" +
                "Output: true\n" +
                "Explanation: The array can be partitioned as [1, 5, 5] and [11].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,2,3,5]\n" +
                "Output: false\n" +
                "Explanation: The array cannot be partitioned into equal sum subsets.";
    }
    public boolean canPartitionRecursive(int[] nums) {
        int totalSum = 0;
        for( int num : nums)
            totalSum += num;
        if(totalSum % 2 != 0)return false;
        int target = totalSum/2;
        return  calculateSums(nums,0, 0, target);
    }
    /*
    Recursive Solution which will take 2^N Time Complexity
     */
    private boolean calculateSums(int[] nums, int i, int currentSum, int target)
    {
        if(i >= nums.length)
            return  false;

      if(currentSum + nums[i] == target)
          return  true;

        if(currentSum + nums[i] > target )
              return calculateSums(nums, i+1 , currentSum, target);
        else
            return calculateSums(nums, i+1, currentSum+nums[i] , target) ||
                    calculateSums(nums, i+1 , currentSum, target);
    }

    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for( int num : nums)
            totalSum += num;
        if(totalSum % 2 != 0)return false;
        int target = totalSum/2;

        Set<Integer> possibleSums = new HashSet<>();
        possibleSums.add(0);
        for( int i = 0 ; i< nums.length; i++)
        {

            Set<Integer> addSums = new HashSet<>();
            for(int s : possibleSums)
            {
                addSums.add(s+nums[i]);
            }

            possibleSums.addAll(addSums);
            if(possibleSums.contains(target))
                return true;
        }
        return false;
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
