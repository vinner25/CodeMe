package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class HashCodeString implements ProblemStatement {


    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

        for(int i= 0 ; i<=s.length() - k ; i++)
        {
            String sub = s.substring(i, i+k);
            if(calculateHash(sub, power, modulo) == hashValue)
                return sub;

        }
        return null;
    }

    private int calculateHash(String str, int power, int modulo)
    {
        int hashcode = 0;
        int index=0;
        for(char c : str.toCharArray())
        {
            hashcode +=   ( (int)c-'a' + 1 )*Math.pow(power,index);
            index++;

        }
        System.out.println(str + " -" + hashcode);
        return hashcode%modulo;



    }

    @Override
    public String getDescription() {
        return "The hash of a 0-indexed string s of length k, given integers p and m, is computed using the following function:\n" +
                "\n" +
                "hash(s, p, m) = (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1) mod m.\n" +
                "Where val(s[i]) represents the index of s[i] in the alphabet from val('a') = 1 to val('z') = 26.\n" +
                "\n" +
                "You are given a string s and the integers power, modulo, k, and hashValue. Return sub, the first substring of s of length k such that hash(sub, power, modulo) == hashValue.\n" +
                "\n" +
                "The test cases will be generated such that an answer always exists.\n" +
                "\n" +
                "A substring is a contiguous non-empty sequence of characters within a string.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"leetcode\", power = 7, modulo = 20, k = 2, hashValue = 0\n" +
                "Output: \"ee\"\n" +
                "Explanation: The hash of \"ee\" can be computed to be hash(\"ee\", 7, 20) = (5 * 1 + 5 * 7) mod 20 = 40 mod 20 = 0. \n" +
                "\"ee\" is the first substring of length 2 with hashValue 0. Hence, we return \"ee\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"fbxzaad\", power = 31, modulo = 100, k = 3, hashValue = 32\n" +
                "Output: \"fbx\"\n" +
                "Explanation: The hash of \"fbx\" can be computed to be hash(\"fbx\", 31, 100) = (6 * 1 + 2 * 31 + 24 * 312) mod 100 = 23132 mod 100 = 32. \n" +
                "The hash of \"bxz\" can be computed to be hash(\"bxz\", 31, 100) = (2 * 1 + 24 * 31 + 26 * 312) mod 100 = 25732 mod 100 = 32. \n" +
                "\"fbx\" is the first substring of length 3 with hashValue 32. Hence, we return \"fbx\".\n" +
                "Note that \"bxz\" also has a hash of 32 but it appears later than \"fbx\".\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= k <= s.length <= 2 * 104\n" +
                "1 <= power, modulo <= 109\n" +
                "0 <= hashValue < modulo\n" +
                "s consists of lowercase English letters only.\n" +
                "The test cases are generated such that an answer always exists.";
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
