package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class MergeSortedArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.\n" +
                "\n" +
                "Merge nums1 and nums2 into a single array sorted in non-decreasing order.\n" +
                "\n" +
                "The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.";
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int currentIndex = m+n -1;
       m--; //We reduce the m and n since they will be used as indices
       n--;
       while(currentIndex >= 0)
       {
           if(n  <0) //Nothing to compare
               break;
           if(m <0) //If Arr 1 has nothing left in it then just pop elements from num2 and add in num1
           {
               nums1[currentIndex] = nums2[n--];
           }
           else if(nums1[m] >= nums2[n]) //if value of element in num1 at end is greater than element in num2 last element
           {
               nums1[currentIndex] = nums1[m];
               nums1[m--] = 0;
           }
           else if(nums1[m] < nums2[n] ) //if num2 element is smaller then it must be inserted in num1
           {
               nums1[currentIndex] = nums2[n--];
           }
           currentIndex--;
       }
    }

    @Override
    public String getSolutionNotes() {
        return "Since both the arrays are already sorted amongst themselves, so this solution makes use of three pointers. Instead of comparing elements from beginning we compare " +
                "the elements from end as in arr1 we have empty space in the end only.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m+n) - M is respective length of arr 1 and arr 2 without the buffer space in arr1";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
