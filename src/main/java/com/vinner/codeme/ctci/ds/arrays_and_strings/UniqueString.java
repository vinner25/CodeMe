package com.vinner.codeme.ctci.ds.arrays_and_strings;

import com.vinner.codeme.ProblemStatement;

/**
 *  Write an algo to determine if a string has all unique characters
 *  What is you cannot use any data structure
 *
 */
public class UniqueString  implements ProblemStatement {

    /**
     *  Time COmplexity : O(n)
     *  Space Complexity : O(1) -> Constant because we create an array
     * @param s
     * @return
     */
    public boolean isUnique(String s)
    {
        char[] strArr = s.toCharArray();
        if(strArr.length > 128)
            return  false; //Since ASCII has total 128 characters, if more than that means duplicate
        //Considering ASCII characters in String
        int[] allChar = new int[128];
        int val;
        for(char  c : strArr)
        {
            val = (int)c;
            if(allChar[val] == 1)
                return false;

            allChar[val] = 1;

        }
        return true;
    }

    /**
     *  Iterate over the string twice and compare current element with rest of String, if dup found return false
     *  Time Complexity : O(n ^ 2) - Two For Loops
     *  Space Complexity : O(1)
     * @param s
     * @return
     */
    public boolean isUniqueNoDataStructure(String s)
    {
        for(int i=0; i<s.length()-1; i++)
        {
            for(int j = i+1; j< s.length(); j++)
            {
                if(s.charAt(i) == s.charAt(j))
                    return false;


            }

        }

        return true;




    }

    @Override
    public String getDescription() {
        return "  Write an algo to determine if a string has all unique characters\n" +
                " *  What is you cannot use any data structure";
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
