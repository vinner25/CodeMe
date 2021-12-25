package com.vinner.codeme.ctci.ds.arrays_and_strings;

/**
 * Given Two Strings , Find if a String is a permutation of another
 */
public class PermutationString {

    /**
     * Sorting the Array and then Comparing
     * But this Solution is not very optimal in terms of Time Complexity
     * Time Complexity : 0(n ^ 2)
     * @param s1
     * @param s2
     * @return
     */
    public boolean isPermutation(String s1, String s2)
    {
        if(s1 == null && s2 == null)
            return true;

        if(s1.length() != s2.length())
            return false;

        char[] s1Arr = sortString(s1);
        char[] s2Arr= sortString(s2);

        for(int i=0; i< s1Arr.length; i++)
        {
            if(s1Arr[i] != s2Arr[i])
                return false;
        }
        return true;
    }

    private char[] sortString(String s)
    {
        char[] strArr = s.toCharArray();
        for(int i=0; i< s.length() - 1; i++)
        {
            for(int j = i+1; j< s.length() ; j++)
            {
                if(strArr[j] < strArr[i])
                {
                    char temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;

                }

            }

        }
        return strArr;
    }

    // # Approach 2:  Iterate using character count since the Permutations will have same number of characters
    public boolean isPermutationOptimal(String s1, String s2)
    {
        if(s1 == null && s2 == null)
            return true;

        if(s1.length() != s2.length())
            return false;

        //Assuming Strings are encoded in ASCII characters
        int[] charCount = new int[128];

         // Initialize the character count for any of the String
        for(int i=0; i < s1.length(); i++)
        {
            charCount[s1.charAt(i)]++;
        }

        for(int i=0; i< s2.length(); i++)
        {
            int c = charCount[s2.charAt(i)];
            c--; //Decrement the count as we visited this word from Second String if after decrementing the count is less than 0
            // Means that character was not sufficient number of times in first String
            if(c < 0)
                return  false;
            charCount[s2.charAt(i)] = c;
        }

        return  true;

    }

    public static  void main(String args[])
    {
        PermutationString ps = new PermutationString();
        System.out.println(ps.isPermutation("vinay", "yaniv"));
        System.out.println(ps.isPermutation("anu", "yaniv"));
        System.out.println(ps.isPermutation("anu", "nuo"));


        System.out.println(ps.isPermutationOptimal("vinay", "yaniv"));
        System.out.println(ps.isPermutationOptimal("anu", "yaniv"));
        System.out.println(ps.isPermutationOptimal("anu", "nuo"));
    }
}
