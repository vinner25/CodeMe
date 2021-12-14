package com.vinner.codeme.projecteuler;

public class SumSquareDifference {



    public int execute()
    {
        int sumOFSquares = 0;
        int sumOfNumbers = 0;
        for (int i= 1 ; i <=100 ; i++)
        {
            sumOFSquares += i*i;
            sumOfNumbers += i;
        }

        return   (sumOfNumbers*sumOfNumbers) - sumOFSquares;

    }
}
