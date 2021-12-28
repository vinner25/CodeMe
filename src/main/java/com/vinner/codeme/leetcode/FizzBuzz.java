package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz implements ProblemStatement {

    public List<String> fizzBuzz(int n) {

        List<String> res = new ArrayList<>();
        int start = 1;
        while(n>0)
        {
            if(n%15 ==0)
                res.add(n-1,"FizzBuzz");

            else if(n%5==0)
                res.add(n-1,"Buzz");

            else if(n%3 == 0)
                res.add(n-1,"Fizz");
            else
                res.add(n-1,n+"");
            n--;
        }
        return res;

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
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
