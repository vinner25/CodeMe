package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class ZeroMatrixInPlace implements ProblemStatement {
    @Override
    public String getDescription() {
        return null;
    }
    public void setZeroes(int[][] matrix) {
        boolean isZeroStartRow = false;
        boolean isZeroStartCol = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0 ; i< m ; i++)
        {
            if(matrix[i][0] == 0)
            {
                isZeroStartCol = true;
                break;
            }


        }

        for(int i = 0 ; i< n ; i++)
        {
            if(matrix[0][i] == 0)
            {
                isZeroStartRow = true;
                break;
            }


        }



        for(int i = 1 ; i<m ; i++ )
        {
            for(int j = 1 ; j<n ; j++ )
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0; //Set Row start == 0
                    matrix[0][j] = 0; // Set Column to Zero
                }
            }
        }


        //Set Rows to Zero
        for(int i=1 ; i<m ; i++)
        {
            for(int j = 1 ; j< n ; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }



        if(isZeroStartCol)
        {

            //Set first col to Zero
            for(int i = 0 ; i<m ; i++)
                matrix[i][0] = 0;

        }




        if(isZeroStartRow)
        {

            //Set first Row to Zero
            for(int i = 0 ; i<n ; i++)
                matrix[0][i] = 0;

        }


    }
    @Override
    public String getSolutionNotes() {
        return "The Trick is to mark first col or row element to zero and use it to know which row " +
                "or col can be set to zero. The only consideration is if first row or col is already zero " +
                "then we handle it using flags";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m*n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
