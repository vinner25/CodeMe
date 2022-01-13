package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class NextPermutation implements ProblemStatement {
    @Override
    public String getDescription() {
        return "" +
                "Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.\n" +
                "\n" +
                "If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e., sorted in ascending order).\n" +
                "\n" +
                "The replacement must be in place and use only constant extra memory.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3]\n" +
                "Output: [1,3,2]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,2,1]\n" +
                "Output: [1,2,3]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1,1,5]\n" +
                "Output: [1,5,1]";
    }
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;

        int indexOfElementNotExhausted = getIndexOfElementNotExhausted(nums);
        if(indexOfElementNotExhausted == -1) //We are already at the maximum Permutation
        {
            //reverse the original array
            reverseArray(nums, 0 , nums.length-1);
        }
        else //Compute next Permutation
        {
            // first find the minimum element  after the element which is not exhausted
            int j = indexOfElementNotExhausted+1;
            for( int i= indexOfElementNotExhausted+1; i< nums.length; i++)
            {
                if( nums[i] <= nums[j] && nums[i] > nums[indexOfElementNotExhausted])
                {
                    j = i;
                }
            }
            int temp = nums[j];
            nums[j] = nums[indexOfElementNotExhausted];
            nums[indexOfElementNotExhausted] = temp;
            //Then Reverse the Array after indexOfElementNotExhausted is replace with min value as the rest of the array will be in descending order
            reverseArray(nums,indexOfElementNotExhausted+1, nums.length-1);
        }
    }

    /*
     The Goal is to find the element which is less than the last element in the array. That array will have option to form
     a new permutation
    */
    private int getIndexOfElementNotExhausted(int[] nums)
    {
        int lastElement = nums[nums.length-1];
        for(int i=nums.length-2 ; i>= 0; i--)
        {
            if(nums[i] < lastElement)
                return i;
            lastElement = nums[i];

        }
        return -1;
    }

    private void reverseArray(int[] nums, int i , int j)
    {
        while(i < j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
            i++;
        }
    }


    @Override
    public String getSolutionNotes() {
        return "This is great problem to learn the basic of Back tracking. The Brute force could be generate all possible permutations of the " +
                "given number and then return the one after the asked permutation. The Good way is to understand how exactly backtracking is working in this question." +
                "Refer: https://www.youtube.com/watch?v=quAS1iydq7U ";
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
