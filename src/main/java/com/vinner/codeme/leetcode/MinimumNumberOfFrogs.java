package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfFrogs implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given the string croakOfFrogs, which represents a combination of the string \"croak\" from different frogs, that is, multiple frogs can croak at the same time, so multiple \"croak\" are mixed.\n" +
                "\n" +
                "Return the minimum number of different frogs to finish all the croaks in the given string.\n" +
                "\n" +
                "A valid \"croak\" means a frog is printing five letters 'c', 'r', 'o', 'a', and 'k' sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of a valid \"croak\" return -1.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: croakOfFrogs = \"croakcroak\"\n" +
                "Output: 1 \n" +
                "Explanation: One frog yelling \"croak\" twice.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: croakOfFrogs = \"crcoakroak\"\n" +
                "Output: 2 \n" +
                "Explanation: The minimum number of frogs is two. \n" +
                "The first frog could yell \"crcoakroak\".\n" +
                "The second frog could yell later \"crcoakroak\".\n" +
                "Example 3:\n" +
                "\n" +
                "Input: croakOfFrogs = \"croakcrook\"\n" +
                "Output: -1\n" +
                "Explanation: The given string is an invalid combination of \"croak\" from different frogs.";
    }
    public int minNumberOfFrogs(String croakOfFrogs) {

        Map<Character, Integer> croakCountsMap = new HashMap<>();
        for(char c : "croak".toCharArray())
        {
            croakCountsMap.put(c,0);
        }

        for(char c : croakOfFrogs.toCharArray())
        {
            char topElement = getTopCharacter(c);

            if(topElement == 'x')
                return -1;
            int currentCount = croakCountsMap.get(c);

            if(croakCountsMap.get(topElement) > 0)
            {
                croakCountsMap.put(topElement, croakCountsMap.get(topElement)-1); //Reduce previous count number for croak
            }
            else if(c != 'c') //means if not start of new croak
            {
                return -1;
            }

            croakCountsMap.put(c,currentCount+1);

        }
        //Validate Map, All  There should not be any other character except K with count > 0
        for(Character key : croakCountsMap.keySet())
        {
            if(key != 'k' && croakCountsMap.get(key) > 0)
                return -1;
        }
        return croakCountsMap.get('k');

    }




    private char getTopCharacter(char c)
    {

        if(c == 'c')
            return 'k';
        else  if(c == 'r')
            return 'c';
        else if(c == 'o')
            return 'r';
        else if(c == 'a')
            return 'o';
        else if (c == 'k')
            return 'a';
        else
            return 'x';
    }


    @Override
    public String getSolutionNotes() {
        return "Iterating over the string and calculating valid croaks";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(5) for hashMap which is like O(1)";
    }
}
