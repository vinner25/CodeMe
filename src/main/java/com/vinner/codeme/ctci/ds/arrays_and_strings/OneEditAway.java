package com.vinner.codeme.ctci.ds.arrays_and_strings;

/**
 *  Given Two Strings , Find if they are only edit away from each other.
 *  Edit can be Addition, Removal or Replace of one character
 *  Pale , Bale // True
 *  Pales, Pale// True
 *  Cake, Bake // True
 *  Make , Rade // False
 */
public class OneEditAway {

    public boolean isOneEditAway(String s1, String s2)
    {
        if(s1 == null || s2 == null)
            return  false;

        // If Length difference is more than 1 , return false
        if(Math.abs(s1.length() - s2.length()) > 1)
            return  false;

        if(s1.length() == s2.length())
            return checkIfOneReplaceAway(s1,s2);

        else
            return checkIfOneAddAway(s1.length() < s2.length() ? s1 : s2, s1.length() > s2.length() ? s1 : s2);
    }

    private boolean checkIfOneAddAway(String small, String large)
    {
        int diffCount = 0;
        int largeStringIndex = 0;
        for(int i=0; i<small.length();i++)
        {

            // Since we are iterating over smaller String, We will have to re check that next element matches Largest string
            if(small.charAt(i) != large.charAt(largeStringIndex)) // means large character does not exist , Mark it as edit required
            {
                diffCount ++;
                if(diffCount > 1)
                    return  false;
                // We wont iterate large Index in case of mismatch as we still want to verify the large string element with rest of small string and it should match
            }
            else
                largeStringIndex++;

        }
        return  true;
    }

    private boolean checkIfOneReplaceAway(String s1, String s2)
    {
        int diffCount = 0;
        for(int i=0; i< s1.length(); i++)
        {
             if(s1.charAt(i) != s2.charAt(i))
             {
                 diffCount++;
                 if(diffCount > 1)
                     return false;
             }
        }
        return true;
    }

    public static void main(String args[])
    {
        OneEditAway editAway = new OneEditAway();
        System.out.println(editAway.isOneEditAway("Pale", "Bale"));
        System.out.println(editAway.isOneEditAway("Pales", "Pale"));
        System.out.println(editAway.isOneEditAway("Pale", "Pales"));
        System.out.println(editAway.isOneEditAway("Pale", "BaKe"));
        System.out.println(editAway.isOneEditAway("Pale", "aleP"));
    }



}
