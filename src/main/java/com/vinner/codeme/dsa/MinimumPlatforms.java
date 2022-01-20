package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

class TrainTimings{
    int arrival;
    int departure;
    TrainTimings(int _arrival, int _departure)
    {
        this.arrival = _arrival;
        this.departure = _departure;
    }

}
public class MinimumPlatforms implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.\n" +
                "Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 6 \n" +
                "arr[] = {0900, 0940, 0950, 1100, 1500, 1800}\n" +
                "dep[] = {0910, 1200, 1120, 1130, 1900, 2000}\n" +
                "Output: 3\n" +
                "Explanation: \n" +
                "Minimum 3 platforms are required to \n" +
                "safely arrive and depart all trains.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 3\n" +
                "arr[] = {0900, 1100, 1235}\n" +
                "dep[] = {1000, 1200, 1240}\n" +
                "Output: 1\n" +
                "Explanation: Only 1 platform is required to \n" +
                "safely manage the arrival and departure \n" +
                "of all trains. \n" +
                "\n" +
                "Your Task:\n" +
                "You don't need to read input or print anything. Your task is to complete the function findPlatform() which takes the array arr[] (denoting the arrival times), array dep[] (denoting the departure times) and the size of the array as inputs and returns the minimum number of platforms required at the railway station such that no train waits.\n" +
                "\n" +
                "Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this may be > 59).\n" +
                "\n" +
                "\n" +
                "Expected Time Complexity: O(nLogn)\n" +
                "Expected Auxiliary Space: O(n)";
    }
    static class Comp implements Comparator<TrainTimings> {

        @Override
        public int compare(TrainTimings t1, TrainTimings t2)
        {
            if(t1.arrival > t2.arrival)
                return 1;
            else if(t1.arrival < t2.arrival)
                return -1;
            else if(t1.departure > t2.departure)
                return 1;

            return 0;

        }

    }
    static int findPlatform(int arr[], int dep[], int n)
    {
        if(n <= 1) //For 0 to 1 train at most N platforms are needed
            return n;

        // add your code here
        List<TrainTimings> timings = new ArrayList<>();
        for(int i=0; i<n ; i++) //Add Both Timings to Train Timings
        {
            TrainTimings timing = new TrainTimings(arr[i], dep[i]);
            timings.add(timing);
        }

        Collections.sort(timings, new Comp()); //Sort on the bases of departure times
        int platforms = 1;
        Queue<Integer> departureTimings = new PriorityQueue<>();
        departureTimings.add(timings.get(0).departure);
        for(int i=1; i<timings.size() ; i++)
        {

            if(departureTimings.peek() >= timings.get(i).arrival)// if new train arrives before old has left , new
            // platform is needed
            {
                platforms++;
            }
            else
            {
                departureTimings.poll(); //Means the Train at top has left and station is availabe
            }

            departureTimings.add( timings.get(i).departure);
        }
        return platforms;
    }



    @Override
    public String getSolutionNotes() {
        return "We are going to sort on the basis of arrival time of trains since every time a train arrives, we need to make a decision so sorting " +
                "on arrival time is good. After sorting we apply greedy approach. The only highlight is we are using a Priority Queue " +
                "to mark the Trains departure. so the train which will leave first will always me at first place in queue. Now once the arrival time " +
                " of train is greater than first departure time, we reuse the platform and also remove that departure time from queue since that train " +
                "has already left. The PQ uses O(n) space complexity. To get rid of this we can sort the arrival time and departure time in their own " +
                "And use a two pointer approach to compare the arrival time with current departure time. ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogN)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N)";
    }
}
