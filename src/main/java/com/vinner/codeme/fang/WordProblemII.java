package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

public class WordProblemII implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.\n" +
                "\n" +
                "Note that the same word in the dictionary may be reused multiple times in the segmentation.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"catsanddog\", wordDict = [\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]\n" +
                "Output: [\"cats and dog\",\"cat sand dog\"]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"pineapplepenapple\", wordDict = [\"apple\",\"pen\",\"applepen\",\"pine\",\"pineapple\"]\n" +
                "Output: [\"pine apple pen apple\",\"pineapple pen apple\",\"pine applepen apple\"]\n" +
                "Explanation: Note that you are allowed to reuse a dictionary word.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"catsandog\", wordDict = [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]\n" +
                "Output: []\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= s.length <= 20\n" +
                "1 <= wordDict.length <= 1000\n" +
                "1 <= wordDict[i].length <= 10\n" +
                "s and wordDict[i] consist of only lowercase English letters.\n" +
                "All the strings of wordDict are unique.";
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>(wordDict);
        return wordBreakHelper(s, 0, hs, hm);
    }

    private List<String> wordBreakHelper(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> hm ) {

        if (hm.containsKey(start))
            return hm.get(start);

        List<String> validSubstr = new ArrayList<>();

        if (start == s.length())
            validSubstr.add("");

        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (dict.contains(prefix)) {
                List<String> suffixes = wordBreakHelper(s, end, dict, hm);
                for (String suffix : suffixes)
                    validSubstr.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
            }
        }

        hm.put(start, validSubstr);
        return validSubstr;
    }

    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }
}
