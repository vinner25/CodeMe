package com.vinner.codeme.blind75.arrays;

import com.vinner.codeme.ProblemStatement;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate implements ProblemStatement {

    @Override
    public String getDescription() {
        return "Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,1]\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,2,3,4]\n" +
                "Output: false\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1,1,1,3,3,4,3,2,4,2]\n" +
                "Output: true";
    }

    public boolean containsDuplicates(int[] nums)
    {
        Set<Integer> hs = new HashSet<>();
        for (int i : nums) {
            if (!hs.add(i)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String getSolutionNotes() {
        return "Iterate the array and maintain seen elements in a hashset. If Seen twice return false;";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
