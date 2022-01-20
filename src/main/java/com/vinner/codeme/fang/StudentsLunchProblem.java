package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class StudentsLunchProblem implements ProblemStatement {
    @Override
    public String getDescription() {
        return "The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.\n" +
                "\n" +
                "The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:\n" +
                "\n" +
                "If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.\n" +
                "Otherwise, they will leave it and go to the queue's end.\n" +
                "This continues until none of the queue students want to take the top sandwich and are thus unable to eat.\n" +
                "\n" +
                "You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i\u200B\u200B\u200B\u200B\u200B\u200Bth sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j\u200B\u200B\u200B\u200B\u200B\u200Bth student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: students = [1,1,0,0], sandwiches = [0,1,0,1]\n" +
                "Output: 0 \n" +
                "Explanation:\n" +
                "- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].\n" +
                "- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].\n" +
                "- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].\n" +
                "- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].\n" +
                "- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].\n" +
                "- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].\n" +
                "- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].\n" +
                "- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].\n" +
                "Hence all students are able to eat.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]\n" +
                "Output: 3";
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int n= students.length;
        int currentIndex = 0;
        while( currentIndex  < n )
        {
            if(students[currentIndex] == sandwiches[currentIndex]) //Student Likes Sandicu at top
            {
                currentIndex++;
            }
            else //Move by 1 step
            {
                if(moveByOneStep(students,currentIndex))
                    return n - currentIndex;
                else
                    continue;
            }
        }
        return 0;


    }
    private boolean moveByOneStep(int[] students, int currentIndex)
    {

        boolean isAllValueSame = true;
        int currentStudentPreference = students[currentIndex];
        for(int i = currentIndex+1; i < students.length ; i++)
        {
            students[i-1] =  students[i];
            if(isAllValueSame && students[i] != currentStudentPreference)
                isAllValueSame = false;
        }

        students[students.length-1] = currentStudentPreference;
        return isAllValueSame;
    }


    @Override
    public String getSolutionNotes() {
        return "We Iterate Over the Students Preference and follow rules of the problem The Breaking part is if we are stuck with a condition when " +
                "all students have same pref as opposed to sandwich on top";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2) - Worst Case if for each student the sandwich at top is not liked and last student in queue likes it. So we will " +
                "have to keep moving ";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
