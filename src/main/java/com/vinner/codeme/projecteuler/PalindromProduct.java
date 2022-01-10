package com.vinner.codeme.projecteuler;

import com.vinner.codeme.ProblemStatement;

public class PalindromProduct implements ProblemStatement {

    public int getPalindromProduct()
    {
        int last = 999; int first = 100;
        int product = 0;

        for(int i= last ; i>= first ; i--)
        {
            for(int j = i ; j >= first ; j--)
            {
                int p = i*j;
                if( p > product && isPalindrom(p))
                    product = p;
            }
        }
        return product;

    }

    // Tried an approach with DS but did not work
   /* public int getPalindromProd(int product , int i , int j, int[][] ds)
    {

        if(i < 10 || j < 10)
            return  product;

        if(ds[i][j]  == 0 && ds[j][i] ==0) {
            int newProduct = i * j;
            ds[i][j] = newProduct;
            ds[j][i] = newProduct;
            if (isPalindrom(newProduct))
                product = Integer.max(product, newProduct);
        }
        return  Integer.max(getPalindromProd(product, i-1,j,ds), getPalindromProd(product,i, j-1,ds));

    }*/

    public boolean isPalindrom(int p)
    {
        char[] numArr = Integer.toString(p).toCharArray();
        int half = 0;
        if(numArr.length % 2 ==0)
            half = numArr.length / 2;
        else
            half =  ( numArr.length /2 ) + 1;

        for(int i = numArr.length - 1 ; i>= half ; i--)
        {
            if(numArr[i] != numArr[(numArr.length-1) - i])
                return false;
        }
        return true;
    }

    @Override
    public String getDescription() {
        return "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\\n\" +\n" +
                "            \"\\n\" +\n" +
                "            \"Find the largest palindrome made from the product of two 3-digit numbers.";
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
