package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class FindMaxInSortedRotatedArrayII implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:\n" +
                "\n" +
                "[4,5,6,7,0,1,4] if it was rotated 4 times.\n" +
                "[0,1,4,4,5,6,7] if it was rotated 7 times.\n" +
                "Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].\n" +
                "\n" +
                "Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.\n" +
                "\n" +
                "You must decrease the overall operation steps as much as possible.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,3,5]\n" +
                "Output: 1\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [2,2,2,0,1]\n" +
                "Output: 0";
    }
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        return getMin(0, nums.length-1, nums);
    }


    private int getMin(int start, int end, int[] nums)
    {

        if(start == end)
            return nums[start];

        if(nums[start] < nums[end]) //In a sorted array the first element is smaller than last. If this happens, We can just return here rather than completing full Binary search
            return nums[start];
        else{
            int mid = (start + end)/2;

            if(nums[mid] > nums[start]) //Means the element i definitely on the right side
                return getMin(mid+1, end, nums);
            else if(nums[mid] < nums[start])//Means the element i definitely on the right side
                return getMin(start+1,mid, nums);
            else if(nums[mid] == nums[start])//We will recalculate our search and increase just either start or end pointer so that the duplicate is avoided
                return getMin( start+1,  end,  nums);
        }
        return -1;
    }
    @Override
    public String getSolutionNotes() {
        return "We perform a basic Binary Search to find minimum element";
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
