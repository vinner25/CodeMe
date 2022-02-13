package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given two strings s and t, determine if they are isomorphic.\n" +
                "\n" +
                "Two strings s and t are isomorphic if the characters in s can be replaced to get t.\n" +
                "\n" +
                "All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"egg\", t = \"add\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"foo\", t = \"bar\"\n" +
                "Output: false\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"paper\", t = \"title\"\n" +
                "Output: true\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= s.length <= 5 * 104\n" +
                "t.length == s.length\n" +
                "s and t consist of any valid ascii character.";
    }
    public boolean isIsomorphic(String s, String t) {


        Map<Character,Character> sToTMap = new HashMap<>();
        Map<Character,Character> tToSMap = new HashMap<>();
        for(int i=0; i< s.length(); i++)
        {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!sToTMap.containsKey(sChar) && !tToSMap.containsKey(tChar))
            {
                sToTMap.put(sChar, tChar);
                tToSMap.put(tChar, sChar);
            }
            else
            {
                if(sToTMap.get(sChar) == null || sToTMap.get(sChar) != tChar)
                    return false;

                if(tToSMap.get(tChar) == null || tToSMap.get(tChar) != sChar)
                    return false;

            }

        }
        return true;


    }
    @Override
    public String getSolutionNotes() {
        return "Create two maps of ongoing mapping applied if not exist. If they exist already verify if they are correct";
    }

    @Override
    public String getTimeComplexity() {
        return "O(s.length)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(s.length) + O(t.length)";
    }
}
