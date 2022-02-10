package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestValueReArrange implements ProblemStatement {

    public long smallestNumber(long num) {

        if(num == 0)
            return 0;

        List<Long> digits = new ArrayList<>();
        boolean isNegative = num < 0 ? true : false;
        num = Math.abs(num);
        while(num > 0)
        {
            digits.add(num%10);
            num = num/10;
        }
        Collections.sort(digits);
        StringBuilder sb = new StringBuilder();

        if(!isNegative) //Positive
        {
            int indexToIgnore = -1;
            for(int i=0 ; i< digits.size(); i++)
            {
                if(digits.get(i) > 0)
                {
                    sb.append(digits.get(i));
                    indexToIgnore = i;
                    break;
                }

            }
            for(int i=0 ; i< digits.size(); i++)
            {
                if(i != indexToIgnore)
                {
                    sb.append(digits.get(i));
                }
            }


        }
        else //Negative
        {

            for(int i=digits.size()-1 ; i>=0; i--)
            {
                sb.append(digits.get(i));
            }
        }
        long res =  Long.parseLong(sb.toString());
        res = isNegative ? res*-1 : res;
        return res;


    }


    @Override
    public String getDescription() {
        return "You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.\n" +
                "\n" +
                "Return the rearranged number with minimal value.\n" +
                "\n" +
                "Note that the sign of the number does not change after rearranging the digits.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: num = 310\n" +
                "Output: 103\n" +
                "Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310. \n" +
                "The arrangement with the smallest value that does not contain any leading zeros is 103.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: num = -7605\n" +
                "Output: -7650\n" +
                "Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.\n" +
                "The arrangement with the smallest value that does not contain any leading zeros is -7650.";
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
