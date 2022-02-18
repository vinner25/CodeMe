package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums1 = [1,2,2,1], nums2 = [2,2]\n" +
                "Output: [2]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]\n" +
                "Output: [9,4]\n" +
                "Explanation: [4,9] is also accepted.\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= nums1.length, nums2.length <= 1000\n" +
                "0 <= nums1[i], nums2[i] <= 1000";
    }
    public int[] intersection(int[] nums1, int[] nums2) {

        int[] queryArray = nums1.length > nums2.length ? nums1: nums2;

        int[] smallArray = queryArray == nums1 ? nums2 : nums1;


        Set<Integer> queryArraySet = new HashSet<>();
        for(int j : queryArray)
            queryArraySet.add(j);

        System.out.println(queryArray.length+ " - "+queryArraySet.size());
        Set<Integer> res = new HashSet<>();

        for(int i: smallArray )
        {
            if(queryArraySet.contains(i))
                res.add(i);

        }

        int[] resArr = new int[res.size()];
        int index = 0;
        for(int j : res)
        {
            resArr[index++] = j;


        }
        return resArr;
    }



    @Override
    public String getSolutionNotes() {
        return "We will leverage hashset to avoid iterating over complete arrays. ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n+m)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n+m) for hashsets";
    }
}
