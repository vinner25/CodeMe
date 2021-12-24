package com.vinner.codeme.blind75.string;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string s, find the length of the longest substring without repeating characters.\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"abcabcbb\"\n" +
                "Output: 3\n" +
                "Explanation: The answer is \"abc\", with the length of 3.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"bbbbb\"\n" +
                "Output: 1\n" +
                "Explanation: The answer is \"b\", with the length of 1.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"pwwkew\"\n" +
                "Output: 3\n" +
                "Explanation: The answer is \"wke\", with the length of 3.\n" +
                "Notice that the answer must be a substring, \"pwke\" is a subsequence and not a substring.";
    }

    public int lengthOfLongestSubstring(String s)
    {
        if(s == null)
            return 0;
        if(s.length() <= 1)
            return s.length();

        Map<Character,Integer> traversedCharactersMap = new HashMap<>();

        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i=0; i<s.length(); i++)
        {
            char currentChar = s.charAt(i);
            if (traversedCharactersMap.containsKey(currentChar)) {
                //Only consider index of found character as start index if it is after the current start index that is it belongs in between else
                // compute length using current value of start index
                startIndex = traversedCharactersMap.get(currentChar) >= startIndex ? traversedCharactersMap.get(currentChar) + 1 : startIndex;
            }
            traversedCharactersMap.put(currentChar,i);
            endIndex++;
            maxLength = Math.max(maxLength , endIndex-startIndex);
        }
        return maxLength;
    }

   /*
   Solution without using HashMap : Even though below solution has to use for loop inside to
   find index of character visited but it was 92% faster in leetcode rather than with hashmap which was only 86% faster

   public int lengthOfLongestSubstring(String s) {
       if(s == null)
           return 0;
       if(s.length() <= 1)
           return s.length();

       boolean[] traversedCharacters = new boolean[128];

       int maxLength = 0;
       int startIndex = 0;
       int endIndex = 0;

       for(int i=0; i<s.length(); i++)
       {
           char currentChar = s.charAt(i);
           if(!traversedCharacters[currentChar]) //means being traversed first time
           {
               traversedCharacters[currentChar] = true;
               endIndex++;
           }
           else //If has already been visited - adjust the startIndex to be new Start Index
           {
               startIndex = findIndexOfChar(s,startIndex, i, currentChar);
               endIndex++;
           }
           maxLength = Math.max(maxLength , endIndex-startIndex);



       }
       return maxLength;
   } */

    private int findIndexOfChar(String s, int rangeStart, int rangeEnd, char c)
    {
        for(int i=rangeStart; i<rangeEnd; i++)
        {
            if(s.charAt(i) == c)
                return i+1;
        }
        return rangeStart;

    }

    @Override
    public String getSolutionNotes() {
        return "This problem is best solved using two pointers." +
                "\n One pointer holds the start index and other end index" +
                "\n Based on if a character is again found , we will update the value of start index and end index" +
                "\n we will always keep max value of maxLength of characters with no repeating characters";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)"; // n is the length of the String
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)" ; //Space is just for indexes and max length. We are also storing a Map with N keys containing index of each character
    }
}
