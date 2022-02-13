package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class SearchForARange implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.\n" +
                "\n" +
                "If target is not found in the array, return [-1, -1].\n" +
                "\n" +
                "You must write an algorithm with O(log n) runtime complexity.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [5,7,7,8,8,10], target = 8\n" +
                "Output: [3,4]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [5,7,7,8,8,10], target = 6\n" +
                "Output: [-1,-1]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [], target = 0\n" +
                "Output: [-1,-1]";
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res= new int[] {-1,-1};
        binarySearch(0, nums.length-1, res, target, nums);
        return res;
    }

    private void binarySearch(int left, int right, int[] res, int target, int[] nums)
    {
        if(left <= right)
        {
            int mid = (left+ right)/2;

            if(nums[mid] < target) //Go Right
            {
                binarySearch(mid+1, right, res, target, nums);
            }
            else if(nums[mid] > target){ //Go Left{
                binarySearch(left, mid-1, res, target, nums);
            }
            else if(nums[mid] == target)  //Check if boundaries found
            {

                if((mid -1) < 0 || nums[mid-1] != nums[mid])
                    res[0] = mid;
                if( (mid + 1) >= nums.length || nums[mid+1] != nums[mid])
                    res[1] = mid;

                if(res[0] == -1) //Means start Not found
                {
                    binarySearch(left, mid-1, res, target, nums);
                }
                if(res[1] == -1)//means right not found
                {
                    binarySearch(mid+1, right, res, target, nums);
                }
            }
        }

    }
    @Override
    public String getSolutionNotes() {
        return "We will use a Binary Search to find the range. There can be only three possibilities. " +
                "Either Num > Target then go Left " +
                " num < Target , Go right " +
                " num == target - Depending on Boundaries and adjacent elements , we might have to go both sides to find range ";
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
