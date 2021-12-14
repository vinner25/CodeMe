package com.vinner.codeme.projecteuler;

public class NthPrimeNumber {

    public int execute()
    {
        int start = 2;
        int primeCount = 0;
        while (true)
        {
            if(isPrime(start)  )
            {
                primeCount++;
                if(primeCount == 10001)
                    return  start;
            }
            start++;
        }

    }

    private boolean isPrime(int n)
    {
        double num = Math.sqrt(n);

        for(int i=2 ; i<=num; i++)
        {
            if(n%i == 0)
                return false;
        }
        return true;


    }


}
