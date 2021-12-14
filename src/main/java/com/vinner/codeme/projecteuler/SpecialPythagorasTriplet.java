package com.vinner.codeme.projecteuler;

import com.vinner.codeme.ProblemStatement;

public class SpecialPythagorasTriplet implements ProblemStatement {
    @Override
    public String getDescription() {
        return "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,\n" +
                "\n" +
                "a2 + b2 = c2\n" +
                "For example, 32 + 42 = 9 + 16 = 25 = 52.\n" +
                "\n" +
                "There exists exactly one Pythagorean triplet for which a + b + c = 1000.\n" +
                "Find the product abc.";
    }

    public long execute()
    {
        for(int i=1 ; i<1000 ; i++)
        {
            for(int j = i+1; j < 1000 ; j++)
            {
                double sum = (Math.pow(i,2) + Math.pow(j,2));
                int k =  (int)Math.sqrt( (sum));
                if(  Math.pow(k,2 ) == sum && i + j + k == 1000 )
                    return  i * j * k;

            }
        }

        return  0;
    }
}
