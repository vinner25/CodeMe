package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

public class ReversePairs implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array nums, return the number of reverse pairs in the array.\n" +
                "\n" +
                "A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,3,2,3,1]\n" +
                "Output: 2\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [2,4,3,5,1]\n" +
                "Output: 3";
    }
     /* Brute Force
    public int reversePairs(int[] nums) {
        int count = 0;
        for(int i=0; i< nums.length-1; i++)
        {
            int half = nums[i]% 2 == 0 ? nums[i] / 2 : (nums[i]/2)+1;
            for (int j = i+1 ; j< nums.length ; j++)
            {
                if( half > nums[j])
                    count++;
            }
        }
        return count;
    }*/


    public int reversePairs(int[] nums) {


        int[] helper = new int[nums.length];
        return splitAndMerge(nums, 0 , nums.length-1, helper);
    }


    private int splitAndMerge(int[] nums, int i , int j , int[] helper)
    {
        int count  = 0 ;
        if( i < j)
        {
            int mid = (i+j)/2;
            count += splitAndMerge(nums, i , mid, helper);
            count += splitAndMerge(nums, mid+1 , j, helper);
            count +=  mergeArr(nums, i , mid, j, helper);
        }
        return count;
    }

    private int mergeArr(int[] nums, int start, int mid, int end, int[] helper)
    {
        int count = 0;
        int index = start;
        int i = start;
        int j = mid+1;

        //COunt Numbers
        while(i<= mid && j<= end)
        {

            if( nums[i] > 2* (long)nums[j])
            {
                count += (mid - i + 1); //We know since left array is sorted, all elements after current position of I will also satisfy this condition
                j++;
            }
            else
            {
                i++;
            }

        }

        //ReInitiate i & J
        i = start;
        j = mid+1;
        //Sort as well for next Merge
        while(i<= mid && j<= end)
        {
            if(nums[i] > nums[j])
            {
                helper[index] = nums[j];
                j++;
            }
            else
            {
                helper[index] = nums[i];
                i++;
            }
            index++;
        }

        //If Anything left
        while( i <= mid)
        {
            helper[index] = nums[i];
            i++;
            index++;
        }

        //If Anything left
        while( j <= end)
        {
            helper[index] = nums[j];
            j++;
            index++;
        }

        for(int k= start ; k<=end; k++)
        {
            nums[k] = helper[k];
        }

        return count;

    }

    @Override
    public String getSolutionNotes() {
        return "The Problem is optimized by using Merge Sort algorith. On our way to Merge sort when we compare two elements we know " +
                "they are always Left and right so i < j , then we check the second condition to see if num[i] > 2*num[j] " +
                "Since the array is sorted we need not compare the rest of i elements with current J as we know that all the next I's " +
                "will eventually be larger than 2*j, so we move the pointer of J only. This is why sorting is important as well."+
                "";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogN)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
