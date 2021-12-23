package com.vinner.codeme.blind75.arrays;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class TwoSum implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
                "\n" +
                "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
                "\n" +
                "You can return the answer in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [2,7,11,15], target = 9\n" +
                "Output: [0,1]\n" +
                "Output: Because nums[0] + nums[1] == 9, we return [0, 1].";
    }


    public int[] execute(int[] arr, int target)
    {
        Map<Integer, Integer> complementIndexMap = new HashMap<>();
        for(int i=0;i<arr.length; i++)
        {
            if(complementIndexMap.containsKey(arr[i]))
                return  new int[] {complementIndexMap.get(arr[i]), i};
            int complement = target-arr[i];
            complementIndexMap.put(complement,i);
        }
        return new int[0];
    }


    @Override
    public String getSolutionNotes() {
        return "We Will Iterate over the array only once. On Each Iteration we store the Compliment of each number from the target" +
                " For Example : [1,4,6.2] , target= 3 " +
                " The Map will store complement as key and Index of number generating the complementing as value" +
                " index = 0 ; comp = 3-2 = 2 , Map {2,0}" +
                " index =1 ; comp = 3-4 = -1, Map {-1,1}" +
                " index = 2 ; comp = 3-6 = -3 , Map {-3, 3}"+
                " index = 3 , value at index 2 which is 2 already exists in comp map" +
                " return map.get(2) {which is index of number generating complement 2}, index 3";
    }

    @Override
    public String getTimeComplexity()
    {
        return "O(n)"; //At max iterate over the array
    }

    @Override
    public String getSpaceComplexity()
    {
        return "O(n)"; //Max Size of Array is O(n)
    }
}
