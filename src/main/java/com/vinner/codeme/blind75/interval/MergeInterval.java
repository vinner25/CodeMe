package com.vinner.codeme.blind75.interval;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeInterval implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: intervals = [[1,3],[2,6],[8,10],[15,18]]\n" +
                "Output: [[1,6],[8,10],[15,18]]\n" +
                "Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: intervals = [[1,4],[4,5]]\n" +
                "Output: [[1,5]]\n" +
                "Explanation: Intervals [1,4] and [4,5] are considered overlapping.";
    }

    @Override
    public String getSolutionNotes() {
        return "The best Solution is sort the Intervals in ascending order of start time and then compare if there is overlapping interval. " +
                "\n Keep on expanding the last Inserted Interval into the linkedList until you reach a non overlapping interval";
    }


    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0)
            return new int[0][];
        if(intervals.length < 2)
            return intervals;
        LinkedList<int[]> mergedIntervals = new LinkedList<>();

        //We first need to sort on the basis of start timing of each interval
        Arrays.sort(intervals , (a, b) -> Integer.compare(a[0], b[0]));


        for(int[] interval : intervals)
        {
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0] ) //Either it is first time insert
                // or the the interval we are iterating is non overlapping interval compared to last inserted interval
            {
                mergedIntervals.add(interval);
            }
            else //It is overlapping interval , add the end time of last inserted interval as max of current interval and last inserted value
            {
                mergedIntervals.getLast()[1] = Math.max( mergedIntervals.getLast()[1], interval[1]);
            }

        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogN) - N is number of intervals. The total time for iteration is O(N) but since we are sorting the sorting " +
                "time is O(NlogN) which adds to grand time of O(NLogN) + O(N) -> O(N(LogN+1)) -> O(NLogN) ";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N) - Since we are maintaining a List which can be maximum of N elements if there is no overlapping intervals";
    }
}
