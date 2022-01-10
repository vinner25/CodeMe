package com.vinner.codeme.fang;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        int j=p.length()-1;
        boolean wasNextAStar = false;
        for(int i=s.length()-1;i>=0; i--)
        {
            if(j < 0) //Overrun RegEx
                return false;

            char currentChar = s.charAt(i);
            char currentRegEx = p.charAt(j);

            if(currentRegEx == '.') //Means Anything matches
            {
                if(!wasNextAStar)
                    j--;
                continue;
            }

            else if(currentRegEx == '*')
            {
                j--;
                wasNextAStar = true;
                i++;
            }
            else if (currentRegEx != currentChar)
            {
                if(j+1 < p.length() && wasNextAStar)//Means Possibility the current Char has to match with Previous
                {
                    j--;
                    i++;
                    wasNextAStar = false;
                }
                else
                    return false;
            }
            else if(!wasNextAStar){
                j--;
            }

        }
        return true;
    }
}
