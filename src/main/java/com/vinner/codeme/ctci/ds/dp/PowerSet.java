package com.vinner.codeme.ctci.ds.dp;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

public class PowerSet implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Write an algorithm to generate subset of all a set of number";
    }

    public List<List<Integer>> generatePowerSet(int[] arr)
    {
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSet.add(new ArrayList<>()); //Empty set if subset of all sets
        for(int i=0; i<arr.length; i++)
        {
            addToCurrentSets(powerSet, arr[i],  powerSet.size());
        }
        return  powerSet;
    }

    private void addToCurrentSets(List<List<Integer>> currentSet , int number , int size)
    {
        for(int i=0; i<size; i++)
        {
            List<Integer> newSet = new ArrayList<>(currentSet.get(i));
            newSet.add(number);
            currentSet.add(newSet);
        }
    }


    @Override
    public String getSolutionNotes() {
        return "The Solution is to iterate the nums array and keep on adding the current element to the existing subsets.";
    }

    @Override
    public String getTimeComplexity() {
        return "Even though this is done iteratively the approach is creating 2^n subsets for n elements. The biggest subset can have N elements so time needed " +
                "to iterate those 2^n for N element, the overall time complexity is O(n*2^n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "The Space Complexity is also O(n*2^n) as we are creating 2n subsets and biggest subset may need n space";
    }
}
