package com.vinner.codeme.ctci.ds.sorting_and_searching;

import com.vinner.codeme.ProblemStatement;

public class SortColors implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.\n" +
                "\n" +
                "We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.\n" +
                "\n" +
                "You must solve this problem without using the library's sort function.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [2,0,2,1,1,0]\n" +
                "Output: [0,0,1,1,2,2]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [2,0,1]\n" +
                "Output: [0,1,2]";
    }

    public void sortColors(int[] nums) {
        //We Will implement a Bucket Sort as we know the possible values is always 3 ranging from 0 to 2

        int[] bucketCount = new int[3];
        for(int num : nums)
        {
            bucketCount[num]++;
        }

        int index=0;
        for(int i=0; i<bucketCount.length; i++)
        {

            int count = bucketCount[i];
            while(count > 0)
            {
                nums[index] = i;
                count--;
                index++;
            }
        }
    }

    @Override
    public String getSolutionNotes() {
        return "We will implement a Bucket list with count of each colors and then add to our original array";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - since each bucket will maximum pass the Size of array only";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(3) for buckets for 3 colors which is technically O(1)";
    }
}
