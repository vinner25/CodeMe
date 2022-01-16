package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;
import java.util.Comparator;

public class LogSplitterSort implements ProblemStatement {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override public int compare(String s1, String s2) {
                //Splitting the words into two arrays, first by identifier, then by contents
                String[] first = s1.split(" ", 2);
                String[] second = s2.split(" ", 2);

                //Checking first character of second word in array
                boolean isFirstDigit = Character.isDigit(first[1].charAt(0));
                boolean isSecondDigit = Character.isDigit(second[1].charAt(0));

                if(isFirstDigit && !isSecondDigit)
                    return 1; //We want to prioritize digits
                if(!isFirstDigit && isSecondDigit)
                    return -1; //deprioritize first.
                if(isFirstDigit && isSecondDigit)
                    return 0; //Don't matter if they're both digits, they are equal

                int score = first[1].compareTo(second[1]);//Calculate if first is bigger than second.

                if(score == 0)//If they are equal, sort by identifier.
                    return first[0].compareTo(second[0]);

                return score;//else return score;
            }
        });

        return logs;
    }

    @Override
    public String getDescription() {
        return "You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.\n" +
                "\n" +
                "There are two types of logs:\n" +
                "\n" +
                "Letter-logs: All words (except the identifier) consist of lowercase English letters.\n" +
                "Digit-logs: All words (except the identifier) consist of digits.\n" +
                "Reorder these logs so that:\n" +
                "\n" +
                "The letter-logs come before all digit-logs.\n" +
                "The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.\n" +
                "The digit-logs maintain their relative ordering.\n" +
                "Return the final order of the logs.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: logs = [\"dig1 8 1 5 1\",\"let1 art can\",\"dig2 3 6\",\"let2 own kit dig\",\"let3 art zero\"]\n" +
                "Output: [\"let1 art can\",\"let3 art zero\",\"let2 own kit dig\",\"dig1 8 1 5 1\",\"dig2 3 6\"]\n" +
                "Explanation:\n" +
                "The letter-log contents are all different, so their ordering is \"art can\", \"art zero\", \"own kit dig\".\n" +
                "The digit-logs have a relative order of \"dig1 8 1 5 1\", \"dig2 3 6\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: logs = [\"a1 9 2 3 1\",\"g1 act car\",\"zo4 4 7\",\"ab1 off key dog\",\"a8 act zoo\"]\n" +
                "Output: [\"g1 act car\",\"a8 act zoo\",\"ab1 off key dog\",\"a1 9 2 3 1\",\"zo4 4 7\"]\n" +
                " ";
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
