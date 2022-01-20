package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class FindDuplicateNumber implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.\n" +
                "\n" +
                "There is only one repeated number in nums, return this repeated number.\n" +
                "\n" +
                "You must solve the problem without modifying the array nums and uses only constant extra space.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,3,4,2,2]\n" +
                "Output: 2\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,1,3,4,2]\n" +
                "Output: 3";
    }
    public int findDuplicate(int[] arr) {

        int slow = arr[0];
        int fast = arr[0];
        do{ //We do the DO loop because initially both value are same so we move fast pointer before. Other way
            // is we move the fast Pointer already while initializing which will arr[arr[arr[0]]]
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        while(slow != fast);

        fast = arr[0];

        while(slow != fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    @Override
    public String getSolutionNotes() {
        return "Treat it as a cycled Linked List where each value in the array is pointing to a new index and that index's value is pointing to a new index and so on" +
                "Since we know the array has a cycle repetition so at one point the series of few index will start pointing to same index and form a cycle." +
                "Therefore we will use Floyd's algo or tortoise hare algorithm to solve this by moving using two pointers";
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
