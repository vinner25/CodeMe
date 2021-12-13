package com.vinner.codeme;

import com.vinner.codeme.projecteuler.MultipleProblem;

public class DriverProgram {

    public static void main(String args[])
    {
        MultipleProblem mp = new MultipleProblem();
        System.out.println(mp.sumEfficient(1000));
        System.out.println(mp.sumBruteForce(1000));
    }
}
