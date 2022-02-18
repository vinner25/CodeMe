package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class PermutationInAString implements ProblemStatement {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;
        int[] s1Counts = new int[26];
        for(char c : s1.toCharArray())
        {

            s1Counts[c-'a']++;
        }
        int[] s2Counts = new int[26];
        for( int i = 0 ; i<s1.length(); i++)
        {
            s2Counts[s2.charAt(i) - 'a']++;
        }
        if(isMatch(s1Counts, s2Counts))
            return true;

        for( int i= s1.length() ; i< s2.length(); i++)
        {
            s2Counts[s2.charAt(i-s1.length())-'a']--;
            s2Counts[s2.charAt(i) - 'a']++;
            if(isMatch(s1Counts, s2Counts))
                return true;
        }

        return false;

    }

    private boolean isMatch(int[] s1Arr, int s2Arr[])
    {
        for(int i = 0 ; i < s1Arr.length; i++)
        {
            if(s1Arr[i] != s2Arr[i])
                return false;

        }
        return true;

    }

    @Override
    public String getDescription() {
        return "Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.\n" +
                "\n" +
                "In other words, return true if one of s1's permutations is the substring of s2.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s1 = \"ab\", s2 = \"eidbaooo\"\n" +
                "Output: true\n" +
                "Explanation: s2 contains one permutation of s1 (\"ba\").\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s1 = \"ab\", s2 = \"eidboaoo\"\n" +
                "Output: false";
    }

    @Override
    public String getSolutionNotes() {
        return "The Technique for this problem is performing a sliding window initially and then based on what character we are taking out , we will decrement count in the array and add new count and again match";
    }

    @Override
    public String getTimeComplexity() {
        return "O(26*N) + O(m) where N is the length of the bigger string M is length of small String";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N+M)";
    }
}
