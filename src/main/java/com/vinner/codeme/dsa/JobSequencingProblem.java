package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a set of N jobs where each jobi has a deadline and profit associated with it.\n" +
                "\n" +
                "Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.\n" +
                "\n" +
                "Find the number of jobs done and the maximum profit.\n" +
                "\n" +
                "Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.\n" +
                "\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 4\n" +
                "Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}\n" +
                "Output:\n" +
                "2 60\n" +
                "Explanation:\n" +
                "Job1 and Job3 can be done with\n" +
                "maximum profit of 60 (20+40).\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "N = 5\n" +
                "Jobs = {(1,2,100),(2,1,19),(3,2,27),\n" +
                "        (4,1,25),(5,1,15)}\n" +
                "Output:\n" +
                "2 127\n" +
                "Explanation:\n" +
                "2 jobs can be done with\n" +
                "maximum profit of 127 (100+27).\n" +
                "\n" +
                "Your Task :\n" +
                "You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit.\n" +
                "\n" +
                "\n" +
                "Expected Time Complexity: O(NlogN)\n" +
                "Expected Auxilliary Space: O(N)";
    }
    class Job{
        int id,profit,deadline;

    }


class Comp implements Comparator<JobSequencingProblem.Job> {

    @Override
    public int compare(JobSequencingProblem.Job j1, JobSequencingProblem.Job j2)
    {
        if( j1.profit < j2.profit)
            return 1;
        else  if( j1.profit > j2.profit)
            return -1;
        else
            return 0;
    }

}

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(JobSequencingProblem.Job arr[], int n)
    {
        // Your code here
        Comp comp = new Comp();
        Arrays.sort(arr, comp); //Sort in terms of Profit

        int maxTimeLimit = 0;
        for(JobSequencingProblem.Job j : arr)
        {
            maxTimeLimit = Math.max(maxTimeLimit, j.deadline);
        }

        boolean[] slots = new boolean[maxTimeLimit+1]; //Creating a Slot array start with 0 to Max duration expected
        //We will assum 0 is always false and first job can be done at 1.

        int profit = 0;
        int jobsDone = 0;
        for(JobSequencingProblem.Job j : arr)
        {

            int profitFromThisJob = j.profit;
            int deadlineOfThisJob = j.deadline;

            if(slots[deadlineOfThisJob] == false ) //Means slot available for this Job
            {
                slots[deadlineOfThisJob] = true;
                profit+= profitFromThisJob;
                jobsDone++;
            }
            else { //Else check if any previous slot is available for this Job
                int indexAvailableOnLeft = checkSlotsBefore(slots,deadlineOfThisJob-1 );
                if(indexAvailableOnLeft > 0)
                {
                    slots[indexAvailableOnLeft] = true;
                    profit+= profitFromThisJob;
                    jobsDone++;
                }
            }
        }
        return new int[]{jobsDone, profit};


    }

    private int checkSlotsBefore(boolean[] slots , int index)
    {
        while(index > 0 )
        {
            if(slots[index] == false)
            {
                return index;
            }
            index--;
        }
        return -1;
    }
    @Override
    public String getSolutionNotes() {
        return "We Will follow a Greedy approach and first sort by profit. Now while iterating over profit we will try to finish as much jobs as we can";
    }

    @Override
    public String getTimeComplexity() {
        return "O(nlogN) for sort. Other Iteration of O(n) are smaller than OlogN so ignored";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for slots array";
    }
}
