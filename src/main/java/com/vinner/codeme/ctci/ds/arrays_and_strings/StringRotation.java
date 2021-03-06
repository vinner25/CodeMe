package com.vinner.codeme.ctci.ds.arrays_and_strings;

import com.vinner.codeme.ProblemStatement;

/**
 *  You are given a method isSubstring() which checks whether a string is part of another String.
 *  Find if String s2 is rotation of String s1 by only using one call to isSubstring() method
 *  Eg : erbottlewat is a rotation of waterbottle
 *
 *
 */
public class StringRotation implements ProblemStatement {

    /*
     We will just double the length of STring s2 and then S2 should be part of S1 if it is rotated.
     We can check that using isSubstring()
     We will imagine that isSubstring(A,B) runs in O(A+B) then our total time complexity is O(n)
     */

    public boolean isRotation (String s1, String s2)
    {
        if(s1 == null || s2 == null)
            return  false;

        if(s1.length() != s2.length())
            return false;
        String s3= s2+s2;
        return  isSubstring(s3,s2);
    }

    private boolean isSubstring(String s1, String s2)
    {
        return s1.contains(s2);
    }


    @Override
    public String getDescription() {
        return "*  You are given a method isSubstring() which checks whether a string is part of another String.\n" +
                " *  Find if String s2 is rotation of String s1 by only using one call to isSubstring() method\n" +
                " *  Eg : erbottlewat is a rotation of waterbottle\n" +
                " *\n" +
                " *";
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
