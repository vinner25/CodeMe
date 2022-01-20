package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array nums that may contain duplicates, return all possible subsets (the power set).\n" +
                "\n" +
                "The solution set must not contain duplicate subsets. Return the solution in any order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,2]\n" +
                "Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [0]\n" +
                "Output: [[],[0]]";
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums == null || nums.length == 0)
            return new ArrayList<>();


        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        Arrays.sort(nums);
        int prevElement = 0;
        int listProcessedSize=0;
        for(int i= 0 ; i<nums.length; i++)
        {

            int currentSizeOfList = res.size();
            if(i==0 || prevElement != nums[i])
            {
                listProcessedSize = 0; //We have to add new element all the way
            }

            addToList(res, nums[i], listProcessedSize);
            listProcessedSize = currentSizeOfList;  //Keep track of index since where the list is processed by this element
            prevElement = nums[i];
        }
        return res;

    }

    private void addToList(List<List<Integer>> res, int element, int indexToStart)
    {

        int listSize = res.size();
        for( int i=indexToStart; i<listSize; i++ )
        {
            List<Integer> newList = new ArrayList<>(res.get(i));
            newList.add(element);
            res.add(newList);
        }
    }
    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }
}
