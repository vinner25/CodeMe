package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class WildcardMatching implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:\n" +
                "\n" +
                "'?' Matches any single character.\n" +
                "'*' Matches any sequence of characters (including the empty sequence).\n" +
                "The matching should cover the entire input string (not partial).\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"aa\", p = \"a\"\n" +
                "Output: false\n" +
                "Explanation: \"a\" does not match the entire string \"aa\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"aa\", p = \"*\"\n" +
                "Output: true\n" +
                "Explanation: '*' matches any sequence.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"cb\", p = \"?a\"\n" +
                "Output: false\n" +
                "Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.";
    }
    public boolean isMatch(String s, String p) {

        //Optimization
        //ToDo If * is coming together remove it as it does not matter single * or multiple
        if(p.equals("*"))
            return true;

        if(p.equals("") && s.equals(""))
            return true;
        if(p.equals(""))
            return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        //Initial Condtions
        dp[0][0] = true; //When String is empty and Regex is Empty it is a match

        for(int i=1; i< dp[0].length; i++)
        {
            //As part if checking the initial condition our regex will only hold true for empty string when previos dp is true
            // Logically only possible if Regex is all * or starts with *  so that they mathc empty string
            if(p.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-1];
        }

        //There is a hidden false value for first column element starting dp[1][0] -> dp[s.length+1][0] which signifies
        // value is always fast if string is there but no regex is there. Since boolean is default false so no need to set it explicitly

        //Starting the Algortithm
        for(int i=1; i<dp.length; i++) //Starting with first Row where the actual String and Regex beguns
        {
            for(int j=1; j< dp[0].length; j++)  //J is for Regex
            {

                //If it either the current char and regex char matches or regex char is a wildcard '?',
                // we need to take the result at this position before 1 level means we take out current char and current regex
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*') // If it is a * we either ignore this regx (It can be sequence) or we treat the regex as empty char
                // In case 1 if we treat it as stream of characters - it means we need rely on regex result till previous char
                // if we ignore the current character , we rely on result till previous char
                {
                    dp[i][j] = dp[i][j-1] ||  dp[i-1][j];
                }
                else // else characters do not match at this position
                    dp[i][j] = false;

            }
        }
        return dp[s.length()][p.length()];

    }
    @Override
    public String getSolutionNotes() {
        return "Refer: https://www.youtube.com/watch?v=7SHV_QfVROE";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n^2)\"";
    }
}
