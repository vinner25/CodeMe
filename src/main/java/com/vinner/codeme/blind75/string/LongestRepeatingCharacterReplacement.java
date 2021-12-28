package com.vinner.codeme.blind75.string;

import com.vinner.codeme.ProblemStatement;

public class LongestRepeatingCharacterReplacement implements ProblemStatement {

    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26]; //The Problem statement mentions English UpperCase Letters which is 26
        int leftIndex = 0;
        int rightIndex=0;
        int maxFrequency = 0;
        int maxLength = 0;
        while(rightIndex < s.length())
        {
            char currentChar = s.charAt(rightIndex);
            charCounts[currentChar - 'A']++;
            maxFrequency = Math.max(maxFrequency, charCounts[currentChar - 'A'] );
            int lengthOfWindow = rightIndex - leftIndex + 1;
            int differentCharacters = lengthOfWindow - maxFrequency;
            if(differentCharacters <= k ) //Means Valid Window
            {
                maxLength = Math.max(lengthOfWindow,maxLength );
            }
            else
            {
                charCounts[s.charAt(leftIndex) - 'A']--;
                leftIndex++;

            }
            rightIndex++;

        }
        return maxLength;
    }

    @Override
    public String getDescription() {
        return "You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.\n" +
                "\n" +
                "Return the length of the longest substring containing the same letter you can get after performing the above operations.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"ABAB\", k = 2\n" +
                "Output: 4\n" +
                "Explanation: Replace the two 'A's with two 'B's or vice versa.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"AABABBA\", k = 1\n" +
                "Output: 4\n" +
                "Explanation: Replace the one 'A' in the middle with 'B' and form \"AABBBBA\".\n" +
                "The substring \"BBBB\" has the longest repeating letters, which is 4.";
    }

    @Override
    public String getSolutionNotes() {
        return "This is solved using a sliding window technique by keeping a left pointer and a right pointer. Since the problem mentioned only replacement with UpperCase english characters, we " +
                "will store the count of each character in an int array. Then in a window we will calculate the number of most frequent characters. " +
                "Then we will calculate the number of characters that can be replaced within that window which can be replaced in order to get the string of same characters. If characters that can be replaced" +
                " is less than or equal to characters allowed, it is a valid window. We compare the length of window with the max we have and set the maximum length accordingly. " +
                "If the window is invalid we move the left pointer to next character and remove count of most Left character in new window by 1 and repeat till the end of string";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we iterate only once, we say the run time is 1";
    }

    @Override
    public String getSpaceComplexity() {
        return "Technically it is just O(26) or O(1) since we are iterating over an array of 26 length only";
    }
}
