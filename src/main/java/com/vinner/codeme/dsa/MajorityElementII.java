package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElementII implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [3,2,3]\n" +
                "Output: [3]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1]\n" +
                "Output: [1]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1,2]\n" +
                "Output: [1,2]";
    }

    public List<Integer> majorityElement(int[] nums) {

        if(nums.length <= 2) // n/3 == 0 , so anything greater than o which is 1 should be in result
        {
            Set<Integer> res = new HashSet<>();
            for( int n : nums)
            {
                res.add(n);
            }
            return new ArrayList<>(res);

        }
        List<Integer> result = new ArrayList<>();

        int ans1Index = 0;
        int count1= 0;
        int count2 = 0;
        int ans2Index = 1;

        for(int i= 0 ; i< nums.length; i++)
        {
            if(nums[i] == nums[ans1Index])
                count1++;
            else if(nums[i] == nums[ans2Index])
                count2++;
            else  if(count1 == 0)
            {
                count1 = 1;
                ans1Index = i;
            }
            else if(count2 == 0)
            {
                count2 = 1;
                ans2Index = i;
            }
            else {
                count2--;
                count1--;

            }

        }

        if(count1 > 0 )
            checkIfNumberIsTrue(nums, ans1Index, result);

        if(count2 > 0 )
            checkIfNumberIsTrue(nums, ans2Index, result);

        return result;
    }


    private void checkIfNumberIsTrue(int nums[], int ansIndex, List<Integer> result)
    {
        int targetCount=0;
        for(int i= 0 ; i< nums.length; i++)
        {
            if(nums[i] == nums[ansIndex])
                targetCount++;

            if(targetCount > (nums.length/3))
            {
                result.add(nums[ansIndex]);
                return;
            }
        }
    }
    @Override
    public String getSolutionNotes() {
        return "Extended Boyer Moore Algorithm";
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
