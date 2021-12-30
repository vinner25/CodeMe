package com.vinner.codeme.blind75.string;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString implements ProblemStatement {

    public String minWindow(String s, String t) {
        if(s== null || t == null)
            return "";

        if(s.length() < t.length())
            return "";


        Map<Character,Integer> tCharCounts= countChars(t, 0, t.length() - 1);

        int i = 0 , j;
        int [] minIndices = new int[]{-1, 0};

        for( j = t.length() -1 ; j< s.length(); j++)
        {

            Map<Character,Integer> windowChars = countChars(s, i, j);
            if(!doesCountsMatch(tCharCounts,windowChars )) //Means Window does not has same count then expand the window
                continue;
            else //Try to minimise the window
            {
                if(minIndices[0] == -1) //First time being set
                {
                    minIndices[0]  = i;
                    minIndices[1]  = j;
                }
                else if( (minIndices[1] -  minIndices[0]) > (j-i))
                {
                    minIndices[0]  = i;
                    minIndices[1]  = j;
                }

                //Now we have a valid window need to contract the window till it is valid

                while(i < j  )
                {

                    windowChars.put(s.charAt(i), windowChars.get(s.charAt(i))-1 );
                    i++;
                    if(doesCountsMatch(tCharCounts,windowChars)) //If still valid
                    {
                        if((minIndices[1] -  minIndices[0]) > (j-i)) {
                            minIndices[0] = i;
                            minIndices[1] = j;
                        }
                    }
                    else
                        break;

                }
            }
        }
        if(minIndices[0] == -1) //Means no match ever found
            return "";
        else
            return s.substring(minIndices[0], minIndices[1]+1);

    }


    private Map<Character,Integer> countChars(String s , int i , int j)
    {
        Map<Character,Integer> counts = new HashMap<>();
        while(i <= j)
        {
            char c = s.charAt(i);
            int count = 1;
            if(counts.containsKey(c))
                count += counts.get(c);
            counts.put(c, count);
            i++;
        }
        return counts;

    }

    private boolean doesCountsMatch(Map<Character,Integer> c1 , Map<Character, Integer> c2)
    {
        for(Character key : c1.keySet())
        {
            if( c2.get(key) == null)
                return false;
            if(c1.get(key) >  c2.get(key))
                return false;
        }
        return true;


    }

    @Override
    public String getDescription() {
        return "Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string \"\".\n" +
                "\n" +
                "The testcases will be generated such that the answer is unique.\n" +
                "\n" +
                "A substring is a contiguous sequence of characters within the string.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"ADOBECODEBANC\", t = \"ABC\"\n" +
                "Output: \"BANC\"\n" +
                "Explanation: The minimum window substring \"BANC\" includes 'A', 'B', and 'C' from string t.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"a\", t = \"a\"\n" +
                "Output: \"a\"\n" +
                "Explanation: The entire string s is the minimum window.";
    }

    @Override
    public String getSolutionNotes() {
        return "This problem uses two pointers and the simple approach is we find a valid window and then try to contract the window until the window is valid" +
                "If Window becomes invalid we expand the window and try to find another valid window unless we find the minimum window with all T string characters";
    }

    @Override
    public String getTimeComplexity() {
        return "O(s+t)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(s+t)";
    }
}
