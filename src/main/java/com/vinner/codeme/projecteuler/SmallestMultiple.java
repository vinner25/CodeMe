package com.vinner.codeme.projecteuler;

public class SmallestMultiple {

    public int execute()
    {
        int start = 100;
        while(true)
        {
            if(isDivisibleBy1TO20(start))
                return  start;
            start++;
        }

    }

    private boolean isDivisibleBy1TO20(int n)
    {

        for(int i=2;i<20;i++)
        {
            if(n % i != 0)
                return false;
        }

        return true;

    }

}
