package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

class Pair {

    int start;
    int end;
    Pair(int _start, int _end)
    {
        this.start = _start;
        this.end = _end;
    }
}
public class MeetingRoom  implements ProblemStatement {

    @Override
    public String getDescription() {
        return "There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.\n" +
                "What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?\n" +
                "\n" +
                "Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 6\n" +
                "start[] = {1,3,0,5,8,5}\n" +
                "end[] =  {2,4,6,7,9,9}\n" +
                "Output: \n" +
                "4\n" +
                "Explanation:\n" +
                "Maximum four meetings can be held with\n" +
                "given start and end timings.\n" +
                "The meetings are - (1, 2),(3, 4), (5,7) and (8,9)\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "N = 3\n" +
                "start[] = {10, 12, 20}\n" +
                "end[] = {20, 25, 30}\n" +
                "Output: \n" +
                "1\n" +
                "Explanation:\n" +
                "Only one meetings can be held\n" +
                "with given start and end timings.";
    }

    @Override
    public String getSolutionNotes() {
        return "This algorithm uses Greedy approach where we sort all the meeting on their end times. If their end times are same then we do the sorting based on their " +
                "start time. Then we compare that next meeting's start time is greater than pre meeting then we consider it. We have to build a custom " +
                "sort and comparator for this ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogN)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N)";
    }

    static class Comp implements Comparator<Pair>
    {
        @Override
        public int compare(Pair o1, Pair o2) {
        if(o1.end > o2.end)
            return 1; //Swap so that minimum End time comes first
        else if(o1.end < o2.end)
            return -1; //Do not Swap
        else if(o1.start > o2.start) //If End time are same make sure minimum start time comes first
            return 1;

        return 0;
    }
    }

    public static int maxMeetings(int start[], int end[], int n)
    {
        List<Pair> meetingList = new ArrayList<>();

        for(int i= 0 ; i< n ; i++)
        {
            Pair p = new Pair(start[i] , end[i]);
            meetingList.add(p);
        }
        Comp comp = new Comp();
        Collections.sort(meetingList, comp);

        Pair prevMeeting = meetingList.get(0);
        int count = 1;
        for( int i= 1 ; i< meetingList.size(); i++)
        {
           Pair currentMeeting = meetingList.get(i);

           if(currentMeeting.start > prevMeeting.end)
           {
               count++;
               prevMeeting = currentMeeting; //Meeting to compare to
           }
        }
        return count;
    }
}