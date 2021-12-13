package com.vinner.codeme.projecteuler;

public class MultipleProblem {

public final String description = "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\n" +
        "\n" +
        "Find the sum of all the multiples of 3 or 5 below 1000.";

public int sum(int n)
{
    n = n -1; //Excluding last value
    int sum = 0;

    //BruteForce
    while(n >= 3)
    {
        if(n%3 == 0 || n%5==0)
            sum += n;

        n--;

    }

return sum;

}


}
