package com.vinner.codeme.leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int uniqueLetterString(String s) {
        
        
        List<String> substringList = new ArrayList<>();
        substringList.add("");
        
        
        int uniqueCounts = 0;
        for(int i=0; i<s.length(); i++)
        {
            uniqueCounts += addToList(substringList, substringList.size(), s.charAt(i));
           
        }
        return uniqueCounts;
        
    }
    
    private int addToList(List<String> sets, int size, char element)
    {
        int count = 0;
        for(int i=0; i<size; i++)
        {
            String newSet = sets.get(i)+element;
            sets.add(newSet);
            count+= countUniqueChars(newSet);
           
        }

        for(int i=0 ; i<size;i++)
            sets.remove(0);
        sets.add(""); //Empty is Substring everytime
        return count;
        
    }
    
    private int countUniqueChars(String t)
    {
        int[] count = new int[26];
        int uniqueCounts = 0;
        for(int i=0;i<t.length();i++)
        {
            count[t.charAt(i) - 'A']++;
        }
         
        for(int i=0 ; i<count.length; i++)
        {
            if(count[i] == 1)
                uniqueCounts+=1;
        }
        return uniqueCounts;
    }

    public static void main(String args[])
    {
        new Solution().uniqueLetterString("ABC");
    }
}