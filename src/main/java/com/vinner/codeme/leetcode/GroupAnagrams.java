package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

public class GroupAnagrams implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an array of strings strs, group the anagrams together. You can return the answer in any order.\n" +
                "\n" +
                "An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: strs = [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]\n" +
                "Output: [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: strs = [\"\"]\n" +
                "Output: [[\"\"]]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: strs = [\"a\"]\n" +
                "Output: [[\"a\"]]";
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> strToAnagramMap = new HashMap<>();

        for(String s : strs)
        {
            char[] strArray = s.toCharArray();
            Arrays.sort(strArray);
            String sortedStr = String.valueOf(strArray);
            List<String> anagrams;
            if(strToAnagramMap.containsKey(sortedStr))
                anagrams = strToAnagramMap.get(sortedStr);
            else
                anagrams = new ArrayList<>();
            anagrams.add(s);
            strToAnagramMap.put(sortedStr, anagrams);
        }

        return new ArrayList(strToAnagramMap.values());


    }
    @Override
    public String getSolutionNotes() {
        return "We will create Map of sorted String as Key and List of all occurence of " +
                "anagrams in the given array";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n(mLogm) , where N is number of items in the array and m is the runtime for sorting " +
                "N items of max length M";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N) for hashmap. The List returned is excluded from memory as it is return value";
    }
}
