package com.vinner.codeme.projecteuler;

public class LargestPrimeFactor {

    public final String description = "The prime factors of 13195 are 5, 7, 13 and 29.\n" +
            "\n" +
            "What is the largest prime factor of the number 600851475143 ?";

    // Brute Force
    public long largestPrime(long num)
    {
        int count = 2 ;
        long start = num/count; // We Will start in revereseOrder Since we are looking for Max Prime. Once found we return
        // Start with Half first since there is no way a number is divisible after its half
        while(start > 1)
        {
            if(num%start == 0 &&  isPrime(start))
                return  start;
            count++;
            start = num/count; //If Not found we divide the number 3 times  and so on. This drastically reduces the number of comparisons
        }
        return  num;
    }


    public boolean isPrime(long n)
    {
        int counter = 2;
        double max = Math.sqrt(n); // We do Math.SQRT to find prime since it reduces computation since for a prime num if no
        // Division is found till its sqrt then it is definitely a prime.
        while(counter < max)
        {
            if(n % counter == 0)
                return false;

            counter++;
        }
        return true;
    }

    public static void main(String args[])
    {
        LargestPrimeFactor lpf = new LargestPrimeFactor();
        System.out.println(lpf.largestPrime(600851475143l    ));
    }

}
