package com.vinner.codeme.blind75.arrays;

import com.vinner.codeme.ProblemStatement;

class ProductOfArrayExceptSelf implements ProblemStatement {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int leftProduct = 1;
        for(int i=0;i<nums.length; i++)
        {
            output[i] = leftProduct*nums[i];
            leftProduct = output[i];
        }
        int rightProduct = 1;
        for(int i= nums.length-1; i>=0 ; i--)
        {
            if(i==nums.length-1)
                output[i] = output[i-1];

            else if(i==0)
                output[i] = rightProduct;
            else
                output[i] = output[i-1] * rightProduct;

            rightProduct *= nums[i];
        }
        return output;

    }

    @Override
    public String getDescription() {
        return "Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].\n" +
                "\n" +
                "The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.\n" +
                "\n" +
                "You must write an algorithm that runs in O(n) time and without using the division operation.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,2,3,4]\n" +
                "Output: [24,12,8,6]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [-1,1,0,-3,3]\n" +
                "Output: [0,0,9,0,0]" +
                "\n Follow up: Can you solve the problem in O(1) extra space complexity? " +
                "\n (The output array does not count as extra space for space complexity analysis.)";
    }

    @Override
    public String getSolutionNotes() {
        return "To conquer this problem in O(n) and not using division operator we need to design an algorithm" +
                " that first persist a cumulative product of " +
                " all elements from left to right. Once we have cumulative product we start all the way from very right." +
                " Then right most element product excluding itself is cumulativeLeft[topright-1]" +
                " then next right is cumulativeLeft[topright-2] * topright " +
                " and son and the first element does not has anything to multiply from left so product for this is rightProduct." +
                " We will keep on persisting the rightProduct in a variable as we traverse right to left." +
                " For more : https://www.youtube.com/watch?v=gREVHiZjXeQ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(N) - Since iterating over array of N nodes only once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1) - Technically it is O(N) since we are storing output in array N but the question says we can consider output array not as extra memory to " +
                "keep our space complexity to O(1)";
    }
}