package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class PeakElement implements ProblemStatement {
    @Override
    public String getDescription() {
        return "A peak element is an element that is strictly greater than its neighbors.\n" +
                "\n" +
                "Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.\n" +
                "\n" +
                "You may imagine that nums[-1] = nums[n] = -∞.\n" +
                "\n" +
                "You must write an algorithm that runs in O(log n) time.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,1]\n" +
                "Output: 2\n" +
                "Explanation: 3 is a peak element and your function should return the index number 2.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,2,1,3,5,6,4]\n" +
                "Output: 5\n" +
                "Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= nums.length <= 1000\n" +
                "-231 <= nums[i] <= 231 - 1\n" +
                "nums[i] != nums[i + 1] for all valid i. ";
    }
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;

        if(nums.length == 2)
        {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            int mid = (left+right) /2;

            if(nums[mid] < nums[mid+1]) //Go Right Since if this condition holds true, we are sure the element peak is definitely on the right side
            {
                left = mid + 1;

            }
            else  //We are sure element peak will be at the left side
            {
                right = mid;
            }
        }
        return left;
    }
    @Override
    public String getSolutionNotes() {
        return "Since the problem statement asks for a LogN solution we cannot just do a linear search and find the peak. " +
                "Instead we focus on the constraints. We see that num[i] != num[i+1] and num[-1] == num[n] == -Infinity. This means " +
                "that the element on the left side and right side will always be greater than its boundaries. " +
                "Now the goal is we do a binary search. Now when we see the middle element, we know that the element is either smaller or larger than net element" +
                "If Middle is smaller than next element, it means definitely the peak is on right side because even if we keep increasing the last element will be greater tha" +
                " negative infinity. In case if after next element we keep decreasing , we will have the next element as peak. " +
                " On the other hand if Mid element is greater than right element and smaller than previous element , then we know peak is on the left side beuase if lets " +
                "say left keeps on increasing the last left element will be greater than negative infinity which will be peak or else if left lement decreases at any point, we find a peak" +
                " Other case possible is if Mid element is smaller than left and right, then peak can be on either side. " +
                "Last case is when middle element is greater than both left and right , we know it is peak, we can either return it as it is or we can still do binary search " +
                "based on same conditions and in the end we will be left with peak element as left element";
    }

    @Override
    public String getTimeComplexity() {
        return "O(Logn)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
