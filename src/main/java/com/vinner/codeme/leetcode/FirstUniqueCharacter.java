package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class FirstUniqueCharacter implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.\n" +
                "\n" +
                " ";
    }

    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            freq[chars[i]-'a'] = freq[chars[i]-'a']+1;
        }
        for(int i=0;i<chars.length;i++){
            if(freq[chars[i]-'a'] == 1){
                return i;
            }
        }
        return -1;

    }

    @Override
    public String getSolutionNotes() {
        return "Iterate over the String two times in a linear way. First time calculate occurrence of characters and maintain in an array" +
                "Second time check if count is one , if yes then return index of that character ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "o(1) - since the array we are creating is O(26) which is O(1)";
    }
}
