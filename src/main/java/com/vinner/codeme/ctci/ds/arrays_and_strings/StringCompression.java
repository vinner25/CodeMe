package com.vinner.codeme.ctci.ds.arrays_and_strings;

public class StringCompression {


    public String compressString(String s)
    {

        if(s== null || s.length() < 3)
            return  s;

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i< s.length()-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                 count++;
            }
            else  {
                   sb.append(s.charAt(i)).append(count+1);
                   count = 0;
            }


        }
        //Adding Last Character
        sb.append(s.charAt(s.length()-1)).append(count+1);

        return  sb.length() < s.length() ? sb.toString() : s;
    }
}
