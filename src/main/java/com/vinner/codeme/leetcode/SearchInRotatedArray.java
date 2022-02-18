package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class SearchInRotatedArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "There is an integer array nums sorted in ascending order (with distinct values).\n" +
                "\n" +
                "Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].\n" +
                "\n" +
                "Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.\n" +
                "\n" +
                "You must write an algorithm with O(log n) runtime complexity.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [4,5,6,7,0,1,2], target = 0\n" +
                "Output: 4\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [4,5,6,7,0,1,2], target = 3\n" +
                "Output: -1\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1], target = 0\n" +
                "Output: -1\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= nums.length <= 5000\n" +
                "-104 <= nums[i] <= 104\n" +
                "All values of nums are unique.\n" +
                "nums is an ascending array that is possibly rotated.\n" +
                "-104 <= target <= 104";
    }
    public int search(int[] nums, int target) {

        return findElement(0, nums.length-1, nums, target);

    }

    private int findElement ( int start, int end, int[] nums, int target)
    {
        if(start <= end)
        {
            int mid = (start + end)/2;

            if(nums[mid] == target)
                return mid;

            if(nums[mid] >= nums[start]) //We ar on left Pilot
            {
                if(target > nums[mid] || target < nums[start])
                {
                    return findElement(mid+1, end , nums, target);
                }
                else
                {
                    return findElement(start, mid-1 , nums, target);
                }


            }
            else // We are on the right side
            {
                if(target < nums[mid] || target > nums[end] )
                    return findElement(start, mid-1 , nums, target);
                else
                    return findElement(mid+1, end , nums, target);
            }


        }
        return -1;

    }
    @Override
    public String getSolutionNotes() {
        return "The Main idea is using Binary search and making decision on where to continue our search. We have to deterimn which portion of array we are using some comparisons.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(logN) ";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
