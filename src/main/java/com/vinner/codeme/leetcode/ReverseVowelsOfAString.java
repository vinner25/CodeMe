package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string s, reverse only all the vowels in the string and return it.\n" +
                "\n" +
                "The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"hello\"\n" +
                "Output: \"holle\"\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"leetcode\"\n" +
                "Output: \"leotcede\"";
    }
    public String reverseVowels(String s) {

        int replaceIndex = -1;
    Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

    StringBuilder sb = new StringBuilder(s);
    int left=0, leftVowel = -1, right = s.length()-1, rightVowel = -1;

    while(left < right)
    {
        if(leftVowel == -1)
        {
            char leftChar = sb.charAt(left);
            if(vowels.contains(leftChar))
                leftVowel = left;
        }

        if(rightVowel == -1)
        {
            char rightChar = sb.charAt(right);
            if(vowels.contains(rightChar))
                rightVowel = right;
        }

        if(leftVowel != -1 && rightVowel != -1) //Swap
        {
            char c = sb.charAt(leftVowel);
            sb.setCharAt(leftVowel, sb.charAt(rightVowel));
            sb.setCharAt(rightVowel,c);
            left++;
            right--;
            leftVowel = -1;
            rightVowel = -1;

        }
        else if(leftVowel == -1)
            left++;
        else if (rightVowel == -1)
            right--;
    }
        return sb.toString();
}
    @Override
    public String getSolutionNotes() {
        return "We have to reverse all the Vowels in the String not the consecutive one's. For Example RACE CAR is RACE CAR because" +
                " vowel AEA are reversed to AEA again. We take two pointer approach.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(N)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
