package com.vinner.codeme.projecteuler;

import com.vinner.codeme.ProblemStatement;

import java.util.HashSet;
import java.util.Set;

public class SummationOfPrime implements ProblemStatement {

    public long sumOfPrimes(int n)
    {
        long sum = 2;
        Set<Integer> numbersNotToCheck = new HashSet<>();
        for(int i=3; i<=n;i+=2) //We Are Incrementing by two after first number as we know that the Even numbers are never prime so
            // Skipping alll even numbers
        {
            if(!numbersNotToCheck.contains(i)) {
                if (isPrime(i))
                    sum += i;
                else //Add all its multiple not to be checked again
                {
                    addMultiple(numbersNotToCheck, (int) Math.sqrt(n), i);
                }
            }
        }

        return sum;

    }

    private void addMultiple(Set<Integer> numbersNotToCheck, int max, int number)
    {
        int start = 2;

        while(true)
        {
            int multiple = number*start;
            if(multiple > max)
                return;
            else if(multiple%2 != 0) //Only add Non even nummbers, unnecessary to maintain even numbers as we are skipping them
                numbersNotToCheck.add(multiple);
            start++;
        }
    }

    private boolean isPrime(int num)
    {
        int start = 2;
        while(start <= Math.sqrt(num))
        {
            if(num%start == 0)
                return false;
            start++;
        }
        return true;
    }

    public static void main(String args[])
    {
        SummationOfPrime sp = new SummationOfPrime();
        System.out.println(sp.sumOfPrimes(2000000));
    }

    @Override
    public String getDescription() {
        return "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.\n" +
                "\n" +
                "Find the sum of all the primes below two million.";
    }
}

