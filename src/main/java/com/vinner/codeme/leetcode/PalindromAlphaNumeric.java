package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class PalindromAlphaNumeric implements ProblemStatement {
    @Override
    public String getDescription() {
        return "A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.\n" +
                "\n" +
                "Given a string s, return true if it is a palindrome, or false otherwise.\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"A man, a plan, a canal: Panama\"\n" +
                "Output: true\n" +
                "Explanation: \"amanaplanacanalpanama\" is a palindrome.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"race a car\"\n" +
                "Output: false\n" +
                "Explanation: \"raceacar\" is not a palindrome.";
    }

    public boolean isPalindrome(String s) {

        int i=0;
        int j= s.length()-1;
        while(i<j)
        {
            char ci = Character.toLowerCase(s.charAt(i));
            if(ci < '0' || (ci > '9' && ci < 97 || ci > 122)) // 97 -a and 122 - 'z'
            {
                i++;
                continue;
            }
            char cj = Character.toLowerCase(s.charAt(j));
            if(cj < '0' || (cj > '9' && cj < 97 || cj > 122))
            {
                j--;
                continue;
            }

            if(ci != cj)
                return false;

            i++;
            j--;
        }
        return true;

    }


    @Override
    public String getSolutionNotes() {
        return "See Solution";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
