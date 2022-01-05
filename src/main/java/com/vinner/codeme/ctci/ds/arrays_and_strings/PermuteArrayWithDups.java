package com.vinner.codeme.ctci.ds.arrays_and_strings;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermuteArrayWithDups implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,1,2]\n" +
                "Output:\n" +
                "[[1,1,2],\n" +
                " [1,2,1],\n" +
                " [2,1,1]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1,2,3]\n" +
                "Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]";
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> numbersCounts = new HashMap<>();

        for(int num: nums) //Count Number of elements and their counts so that we iterate only once per dups
        {
            numbersCounts.put(num, numbersCounts.getOrDefault(num,0) + 1);
        }

        List<Integer> permutation = new ArrayList<>();
        addToList(permutation, res, nums, numbersCounts);
        return res;
    }


    private void addToList(List<Integer> permutation, List<List<Integer>> res, int[] nums, Map<Integer,Integer> numbersCounts)
    {

        if(permutation.size() == nums.length)
        {
            res.add(new ArrayList<>(permutation)); //Deep Copy
            return;
        }

        for(int num: numbersCounts.keySet())
        {
            int count = numbersCounts.get(num);
            if(count == 0)
                continue;
            numbersCounts.put(num, count - 1); //BackTracking Decrement Count by 1
            permutation.add(num);
            addToList(permutation, res, nums, numbersCounts);
            permutation.remove(permutation.size() - 1);
            numbersCounts.put(num, count); //Making the Num available again for next Permutation
        }

    }

    @Override
    public String getSolutionNotes() {
        return "We will backtrack this problem using a Hashmap of counts of each dup number. The Goal is we iterate the dups such that they do not overlap with each " +
                "other as separate entity. For example if I have 1,1,2 - I only have two choice 1 & 2 to start with.";
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
