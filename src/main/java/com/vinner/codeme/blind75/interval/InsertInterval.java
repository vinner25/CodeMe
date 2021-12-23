package com.vinner.codeme.blind75.interval;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.\n" +
                "\n" +
                "Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).\n" +
                "\n" +
                "Return intervals after the insertion.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: intervals = [[1,3],[6,9]], newInterval = [2,5]\n" +
                "Output: [[1,5],[6,9]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]\n" +
                "Output: [[1,2],[3,10],[12,16]]\n" +
                "Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].";
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> intervalsList = new ArrayList<>();
        boolean isIntervalInserted = false;

        for(int i=0; i<intervals.length; i++)
        {
            int[] currentInterval = intervals[i];
            if( !isIntervalInserted && areIntervalsOverlapping(currentInterval,newInterval) || areIntervalsOverlapping(newInterval,currentInterval ))
            {
                newInterval[0] = Math.min(currentInterval[0],newInterval[0] );
                newInterval[1] = Math.max(currentInterval[1],newInterval[1] );

            }
            else if(!isIntervalInserted && currentInterval[0] > newInterval[1]) //means we did not inserted new interval and are past the merge possibilities
            {
                intervalsList.add(newInterval);
                intervalsList.add(currentInterval);
                isIntervalInserted = true;

            }
            else
                intervalsList.add(currentInterval);

        }
        if(!  isIntervalInserted) //Means new interval never inserted
            intervalsList.add(newInterval);

        return intervalsList.toArray(new int[intervalsList.size()][]);
    }

    private boolean areIntervalsOverlapping(int[] currentInterval, int[] newInterval)
    {
        if(currentInterval[0] <= newInterval[0] && currentInterval[1] >= newInterval[0] )
            return true;

        return false;
    }

    @Override
    public String getSolutionNotes() {
        return "The Logic to solve this problems is as follows: " +
                "\n Create a placeholder to store Intervals " +
                "\n The Intervals given is a matrix with one column" +
                "\n Iterate over the matrix and verify if the given interval lies in between the current interval " +
                " or the current interval lies between the given interval" +
                "\n Adjust the newInterval to be adjusted accordingly" +
                "\n Insert the new interval as soon as the iterating new interval is past the end of newInterval to be inserted" +
                "\n Insert rest of the intervals as well which do not lie in the new interval" +
                "\n Return Array version of the list";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we are iterating over N intervals";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) - Since the space taken is maximum of O(n + 1) intervals in case new interval does not overlap which corresponds to O(n) ";
    }
}
