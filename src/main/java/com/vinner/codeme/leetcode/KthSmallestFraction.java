package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.PriorityQueue;

public class KthSmallestFraction implements ProblemStatement {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
                (a,b) -> {
                 double x = (double) a[0]/a[1];
                 double y = (double)b[0]/b[1];

                 if(x > y )
                     return -1;
                 else
                     return 1;
                });


        for(int i=0; i< arr.length - 1 ; i++)
        {
            for(int j = i+1 ; j < arr.length ; j++)
            {
                queue.add(new int[] {arr[i], arr[j]});
                if(queue.size() > k)
                    queue.poll();
            }
        }
        return queue.poll();
    }

    @Override
    public String getDescription() {
        return "You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.\n" +
                "\n" +
                "For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].\n" +
                "\n" +
                "Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: arr = [1,2,3,5], k = 3\n" +
                "Output: [2,5]\n" +
                "Explanation: The fractions to be considered in sorted order are:\n" +
                "1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.\n" +
                "The third fraction is 2/5.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: arr = [1,7], k = 1\n" +
                "Output: [1,7]";
    }

    @Override
    public String getSolutionNotes() {
        return "We will use a Max Heap to solve this problem. We will compare on the basis of Numerator/Denominator and will keep maxmum value at top. " +
                "As soon as the size increases given number K we will chop of the top element. In the end at Top element at heap is Kth larest";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2*logN) n3 for loop and logN for heapify";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(k) for heap of size K";
    }
}
