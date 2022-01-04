package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class RotateArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array, rotate the array to the right by k steps, where k is non-negative.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,4,5,6,7], k = 3\n" +
                "Output: [5,6,7,1,2,3,4]\n" +
                "Explanation:\n" +
                "rotate 1 steps to the right: [7,1,2,3,4,5,6]\n" +
                "rotate 2 steps to the right: [6,7,1,2,3,4,5]\n" +
                "rotate 3 steps to the right: [5,6,7,1,2,3,4]";
    }

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverseArray(0, nums.length -1 , nums);

        reverseArray(0, k-1, nums);
        reverseArray(k, nums.length-1, nums);
    }

    private void reverseArray(int startIndex, int endIndex, int [] nums)
    {
        while(startIndex < endIndex)
        {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;

        }

    }


  /*  public void rotate(int[] nums, int k) {
         k = k%nums.length;
        rotateArrayRight(nums, k);
    }

    private void rotateArrayRight(int[] nums, int k)
    {
        int[] newNums = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            int indexToReplace = i+k;
            if(indexToReplace >= nums.length)
                indexToReplace = indexToReplace -  nums.length;

            newNums[indexToReplace] = nums[i];

        }

      for(int j=0; j< nums.length;j++)
          nums[j] = newNums[j];

    }*/
    @Override
    public String getSolutionNotes() {
        return "The Simplest solution is just to create a copyArray and right shift elements upto K times. The issue with this is that it ends up take O(n) space as well" +
                " The Tricky solution is we reverse the original array and then reverse first K elements and then the next K elements. The Final state of array" +
                " is our output";
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
