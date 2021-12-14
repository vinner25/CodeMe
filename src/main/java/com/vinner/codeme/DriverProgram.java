package com.vinner.codeme;

import com.vinner.codeme.projecteuler.NthPrimeNumber;
import com.vinner.codeme.projecteuler.SmallestMultiple;
import com.vinner.codeme.projecteuler.SumSquareDifference;

public class DriverProgram {

    public static void main(String args[])
    {
        NthPrimeNumber mp = new NthPrimeNumber();

        System.out.println(mp.execute());
    }
}
