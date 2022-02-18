package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class BestDaysToApplyCream implements ProblemStatement {


    final String[] WEEK_DAYS = new String[]{"Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

    @Override
    public String getDescription() {
        return "You are given a condition where you have to apply lotion as per belows" +
                "Week 1 : Apply 2 times - At Max Days Separate" +
                "Week 2 : Apply 3 Times - With Max Gap possible" +
                "Week 3 - Apply 4 Times - With Max Gap Possible " +
                "Week 5 - Apply 5 Times " +
                "Week 6 - Apply 6 Times" +
                "Week 7 - Apply 7 Times" +
                "Write an algorithm which suggest what days to apply cream given " +
                " the week starts on a Tuesday" +
                "Output : List of Week Days " +
                " Tuesday, Friday "+
                " Tuesday, Thursday, Saturday";
    }

    public List<List<String>> getWeekDays(int startDaySchedule)
    {
        List<List<String>> res = new ArrayList<>();
        int numberOfDays = 2;
        for( int i = 1 ; i < 7 ; i++)
        {
            res.add(creamDays(numberOfDays, startDaySchedule));
            numberOfDays++;
        }

        int weekNumber = 1;
        for(List week : res)
        {
            System.out.println("Week - "+weekNumber++  + " : " +week);
        }
        return  res;
    }

    public List<String>  creamDays(int numberOfDays, int startDay)
    {
        List<String> weekDays = new ArrayList<>();

        int gap =  7/numberOfDays;
        weekDays.add(WEEK_DAYS[startDay-1]);
        numberOfDays--;
        int prevDay = startDay;
        while(numberOfDays > 0)
        {
            if(prevDay + gap > 7) {
                weekDays.add(WEEK_DAYS[0]);
                prevDay = 0;
            }
            else {
                weekDays.add(WEEK_DAYS[prevDay + gap - 1]);
                prevDay = prevDay + gap;
            }
            numberOfDays--;
        }
        return weekDays;
    }



    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }
}
