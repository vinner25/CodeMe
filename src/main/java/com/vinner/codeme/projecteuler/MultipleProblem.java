package com.vinner.codeme.projecteuler;

import com.vinner.codeme.ProblemStatement;

public class MultipleProblem  implements  ProblemStatement {

private final String description = "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\n" +
        "\n" +
        "Find the sum of all the multiples of 3 or 5 below 1000.";

       // this.setDescription(description);



    @Override
    public String getDescription() {
        return this.description;
    }

    //BruteForce
public int sumBruteForce(int n)
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

//Efficient
public int sumEfficient(int n)
{
    int sum = getSum(n-1,3, n) + getSum(n-1 , 5 , 3);

    return sum;
}

    /**
     *
     * @param n
     * @param val
     * @param shouldNotBeOf - This is used to guarantee the same number in picked twice
     *                      For example = 15 is both divisible by 3 & 5 but needed once in SUM
     * @return
     */
    private int getSum(int n, int val , int shouldNotBeOf)
{
    int sum = 0;
    while ( n >= val) {
        if (n % val == 0 && n %shouldNotBeOf != 0) {  //To Guarantee Unique number is picked
            sum += n;
            n = n - val;
        } else
            n--;
    }

    return sum;
}

}
