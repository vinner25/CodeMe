package com.vinner.codeme.leetcode;

import com.sun.tracing.Probe;
import com.vinner.codeme.ProblemStatement;

import java.util.Set;
import java.util.TreeSet;

public class ExamRoom implements ProblemStatement {
    @Override
    public String getDescription() {
        return "here is an exam room with n seats in a single row labeled from 0 to n - 1.\n" +
                "\n" +
                "When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there are multiple such seats, they sit in the seat with the lowest number. If no one is in the room, then the student sits at seat number 0.\n" +
                "\n" +
                "Design a class that simulates the mentioned exam room.\n" +
                "\n" +
                "Implement the ExamRoom class:\n" +
                "\n" +
                "ExamRoom(int n) Initializes the object of the exam room with the number of the seats n.\n" +
                "int seat() Returns the label of the seat at which the next student will set.\n" +
                "void leave(int p) Indicates that the student sitting at seat p will leave the room. It is guaranteed that there will be a student sitting at seat p.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input\n" +
                "[\"ExamRoom\", \"seat\", \"seat\", \"seat\", \"seat\", \"leave\", \"seat\"]\n" +
                "[[10], [], [], [], [], [4], []]\n" +
                "Output\n" +
                "[null, 0, 9, 4, 2, null, 5]\n" +
                "\n" +
                "Explanation\n" +
                "ExamRoom examRoom = new ExamRoom(10);\n" +
                "examRoom.seat(); // return 0, no one is in the room, then the student sits at seat number 0.\n" +
                "examRoom.seat(); // return 9, the student sits at the last seat number 9.\n" +
                "examRoom.seat(); // return 4, the student sits at the last seat number 4.\n" +
                "examRoom.seat(); // return 2, the student sits at the last seat number 2.\n" +
                "examRoom.leave(4);\n" +
                "examRoom.seat(); // return 5, the student sits at the last seat number 5.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= n <= 109\n" +
                "It is guaranteed that there is a student sitting at seat p.\n" +
                "At most 104 calls will be made to seat and leave.";
    }
    TreeSet<Integer> seats;
    int n;
    public ExamRoom(int n) {
        this.seats = new TreeSet<>();
        this.n = n;
    }

    public int seat() {

        if(seats.isEmpty())
        {
            seats.add(0); //Marks the first  seat occupied
            return 0;
        }
        int start = 0;
        int maxWindow = 0;

        int i = 0,  j = 0;
        for(int seat: seats)
        {
            int currentWindow = (seat - start)/2;

            if(currentWindow > maxWindow)
            {
                i= start;
                j = seat;

                maxWindow= currentWindow;
            }
            start = seat;
        }
        if(j==0) //Means No student sitting till the last
        {
            System.out.println("Adding at end");
            seats.add(n-1);
            return n-1;
        }
        if(seats.first() != 0 && (seats.first() - 0 )/2 >= maxWindow)
        {
            seats.add(0);
            return 0;
        }
        if((n-1 - seats.last())/2 > maxWindow  ) //Means end is empty , check if it greater than current J
        {
            seats.add(n-1);
            return n-1;

        }
        System.out.println(i+"-"+j);
        int mid = (i+j)/2;
        seats.add(mid);
        return mid;

    }

    public void leave(int p) {

        for(int seat : seats)
        {
            if(seat == p)
            {
                seats.remove(p);
                break;
            }
        }


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
