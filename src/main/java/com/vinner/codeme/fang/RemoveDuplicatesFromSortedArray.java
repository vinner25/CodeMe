package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class RemoveDuplicatesFromSortedArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.\n" +
                "\n" +
                "Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.\n" +
                "\n" +
                "Return k after placing the final result in the first k slots of nums.\n" +
                "\n" +
                "Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory." +
                "Input: nums = [1,1,2]\n" +
                "Output: 2, nums = [1,2,_]\n" +
                "Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.\n" +
                "It does not matter what you leave beyond the returned k (hence they are underscores).\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [0,0,1,1,1,2,2,3,3,4]\n" +
                "Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]\n" +
                "Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.\n" +
                "It does not matter what you leave beyond the returned k (hence they are underscores).";
    }
    public int removeDuplicates(int[] nums) {

        if(nums.length < 2)
            return nums.length;


        int i=0;
        int j=1;
        int dupIndex = -1;
        int res = 1;

        while(j < nums.length)
        {
            if(nums[i] != nums[j]) //No Duplicate element
            {
                if(dupIndex > -1)
                    nums[dupIndex++] = nums[j]; //Increment dup index so that in case any more unique elements are found they are inserted after this index

                res++;
                i++;
            }
            else if(nums[i] == nums[j]) //Duplicate Found
            {
                if(dupIndex == -1)
                    dupIndex = j;

            }

            j++;
        }
        return res;
    }

    @Override
    public String getSolutionNotes() {
        return " We will use three pointers two to traverse and and one for keeping track of Duplicate index encountered";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Technically we are iterating only n-1 times as we start from j=1 but amortized value is o(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
