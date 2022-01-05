package com.vinner.codeme.ctci.ds.arrays_and_strings;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class PermuteArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "BACKTRACK PROBLEM: Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3]\n" +
                "Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [0,1]\n" +
                "Output: [[0,1],[1,0]]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1]\n" +
                "Output: [[1]]";
    }


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        addToList(permutation, res, nums, visited);
        return res;
    }


    private void addToList(List<Integer> permutation, List<List<Integer>> mainList, int[] nums, boolean[] visited)
    {
        if(permutation.size() == nums.length)
        {
            mainList.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0; i< nums.length; i++)
        {
            if(visited[i])
                continue;

            visited[i] = true; //BackTracking
            permutation.add(nums[i]);
            addToList(permutation, mainList, nums,visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }

    }

    @Override
    public String getSolutionNotes() {
        return "This solution is solved using Backtracking to recursively iterate over the array and keeping one item in the array at one time.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n*n!) - NUmber of recursive tree is N! which is basically all the permutations. Also since we are deep copying list of N size N! times";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n*n!) - Creating a List of N size  N! permutations times";
    }
}
