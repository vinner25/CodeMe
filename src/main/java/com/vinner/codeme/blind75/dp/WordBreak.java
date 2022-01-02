package com.vinner.codeme.blind75.dp;

import com.vinner.codeme.ProblemStatement;

import java.util.List;

public class WordBreak implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.\n" +
                "\n" +
                "Note that the same word in the dictionary may be reused multiple times in the segmentation.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"leetcode\", wordDict = [\"leet\",\"code\"]\n" +
                "Output: true\n" +
                "Explanation: Return true because \"leetcode\" can be segmented as \"leet code\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"applepenapple\", wordDict = [\"apple\",\"pen\"]\n" +
                "Output: true\n" +
                "Explanation: Return true because \"applepenapple\" can be segmented as \"apple pen apple\".\n" +
                "Note that you are allowed to reuse a dictionary word.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"catsandog\", wordDict = [\"cats\",\"dog\",\"sand\",\"and\",\"cat\"]\n" +
                "Output: false";
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[] = new Boolean[s.length()];
        return isWordBreak(s, wordDict, 0, dp);
    }

    private boolean isWordBreak(String s, List<String> wordDict, int index, Boolean[] dp)
    {
        if(index == s.length())
            return true;

        if(dp[index] != null )
            return  dp[index];

        for(int end = index+1; end<= s.length(); end++)
        {
            System.out.println("Checking :"+ s.substring(index,end)+" at start index :"+index +", end Index = "+end);
            if(wordDict.contains(s.substring(index, end)) && isWordBreak(s, wordDict, end, dp))
            {
                System.out.println("Setting DP true for index ="+index);
                dp[index] = true;
                return true;
            }
        }
        System.out.println("Setting DP false for index ="+index);
        dp[index] = false;
        return false;
    }

    @Override
    public String getSolutionNotes() {
        return "This is a great problem to understand how DP is being leveraged in this ." +
                " We just optimize the Brute force for this which is starting from 0 index and keep sub-stringing ," +
                " If we find a n element, we can either start a new substring after that or we can still keep expanding" +
                " the original substring if the new substring does not exist in word dictionary. The critical part is understanding " +
                " how DP is working here. Added the System out println here to understand how DP is working";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^3) - Since the Recursion tree can go N^2 levels and the String is of length N , overall time complexity is N^3. If it was plain recusrion it could have " +
                "been 2^n which is much worse";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) the height of the recursion tree for a string of length N";
    }
}
