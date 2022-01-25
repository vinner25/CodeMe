package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:\n" +
                "\n" +
                "0 <= a, b, c, d < n\n" +
                "a, b, c, and d are distinct.\n" +
                "nums[a] + nums[b] + nums[c] + nums[d] == target\n" +
                "You may return the answer in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,0,-1,0,-2,2], target = 0\n" +
                "Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [2,2,2,2,2], target = 8\n" +
                "Output: [[2,2,2,2]]";
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); //Sorting is required becausue when we add it to hashset , it will avoid duplicates. Also for TWO pointer technique to work
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length - 3 ; i++)
        {
            for(int j=i+1; j< nums.length - 2  ; j++)
            {
                int left = j+1;
                int right = nums.length-1;

                while(left < right)
                {

                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum > target)
                        right--;
                    else if (sum < target)
                        left++;
                    else
                    {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[left]);
                        res.add(nums[right]);
                        if(!result.contains(res))
                            result.add(res);
                        left++;
                        right--;
                    }
                }
            }
        }
        return  result;
    }

    @Override
    public String getSolutionNotes() {
        return "The Problem follows a two pointer approach where we first sort the given Array " +
                "and then stats two loops for i and j . And since afterwards the array is sorted we follow two poiter " +
                "approach. " +
                "Other less intuitive way is two for loops and hashing the sum of squares. Whenever a square sum matches " +
                "target - square sum , we have possibility of quadruples and we chek for the indexes. " ;
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2 * n ) * logN + nLogN --> n^2 for two for loop , n for two pointers and logN for inserting into set or list using contains";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1) taking out the space for array which holds results";
    }
}
