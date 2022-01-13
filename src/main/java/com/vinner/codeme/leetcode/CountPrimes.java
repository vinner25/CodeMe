package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class CountPrimes implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer n, return the number of prime numbers that are strictly less than n.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 10\n" +
                "Output: 4\n" +
                "Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 0\n" +
                "Output: 0\n" +
                "Example 3:\n" +
                "\n" +
                "Input: n = 1\n" +
                "Output: 0";
    }

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        for(int i = 2; i <isPrimes.length; i++)
            isPrimes[i] = true;

        int count = 0;
        for(int i = 2; i <= Math.sqrt(n); i++){ //A Number is always a multiple of a number less than equals its Sqrt and a number greater than equal to its sqrt. Hence for a number all the primes that can be there can be checked
            // by just iterating over to its square root instead of iterating over to N
            if( isPrimes[i] ){
                for(int j = i*i; j < n; j= j+i) //We have optimised the number where it starts to set the multipliers by directly jumping to i*i instead of i*2 because elements before i*i would have been marked
                    //accordingly by the previous numbers in the iterations
                    isPrimes[j] = false;
            }
        }

        for(boolean isPrime : isPrimes)
        {
            if(isPrime)
                count++;
        }

        return count;
    }

    @Override
    public String getSolutionNotes() {
        return "This is an implementation of sieve of eratosthenes. This basically means we first initialize a boolean array starting from N and set it to true for all values starting from 2. So initially " +
                "every value from 2 to N is considered a Prime. Then we filter out which one's wont be a prime unless we reach N. The logic to mark numbers not N is if we see a number is prime in the array (eg 2 will be at start)" +
                " we set all the multiples of that number to false because we know that the multiples of this prime number are not prime. That is why this algorithm is called Sieve of eratosthenes who was an astronomer who " +
                "invented this technique which is similar to filtering dust from material just like using a strainer and in the end we have what we need. " +
                "For more : https://www.youtube.com/watch?v=pKvGYOnO9Ao";
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }
}
