package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array nums of size n, return the majority element.\n" +
                "\n" +
                "The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [3,2,3]\n" +
                "Output: 3\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [2,2,1,1,1,2,2]\n" +
                "Output: 2\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "n == nums.length\n" +
                "1 <= n <= 5 * 104\n" +
                "-231 <= nums[i] <= 231 - 1\n" +
                " \n" +
                "\n" +
                "Follow-up: Could you solve the problem in linear time and in O(1) space?";
    }
    //Boyer Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int ansIndex = 0 ;
        int count = 1;

        for(int i=1; i<nums.length; i++)
        {
            if(nums[i] == nums[ansIndex])
                count++;
            else
                count--;

            if(count == 0)
            {
                ansIndex = i;
                count = 1;
            }
        }
        //Num to check at the end is ansI
        count = 0;
        for(int i= 0 ; i<nums.length ; i++)
        {
            if(nums[i] == nums[ansIndex])
                count++;

        }

        return count > (nums.length/2) ?  nums[ansIndex] : 0;
    }

    public int majorityElementByMap(int[] nums) {
        Map<Integer,Integer> numsCount = new HashMap<Integer,Integer>();

        for(int i= 0 ; i< nums.length; i++)
            numsCount.put(nums[i], 0);


        for(int i= 0 ; i< nums.length; i++)
        {

            numsCount.put(nums[i], numsCount.get(nums[i])+1);
            if(numsCount.get(nums[i]) > (nums.length/2))
                return nums[i];
        }
        return 0;
    }
    @Override
    public String getSolutionNotes() {
        return "The Real question in this problem to be able to do in O(1) space complexity and linear runtime. The answer to this is Boyer Moore Voting Algorithm. " +
                "We term each value as a candidate to be Majority Element and keep a count of it. In the end if we see there is any candidate we check if it s count > n/2" +
                " For More: https://www.youtube.com/watch?v=X0G5jEcvroo";
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
