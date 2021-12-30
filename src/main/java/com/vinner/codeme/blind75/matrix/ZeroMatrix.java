package com.vinner.codeme.blind75.matrix;

import com.vinner.codeme.ProblemStatement;

public class ZeroMatrix implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.\n" +
                "\n" +
                "You must do it in place.";
    }
    public void setZeroes(int[][] matrix)
    {
        if(matrix == null)
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean isCol = false;

        for(int i=0; i<m;i++) {
            if(matrix[i][0] == 0)
                isCol = true;
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0; //Setting first element of Row to 0
                    matrix[0][j] = 0; //Setting first element at Column to 0

                }
            }

        }
        // Transform Original Matrix
        for(int i=1; i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        //Check for first Rows and column
        if(matrix[0][0] == 0)
        {
            for(int i=0 ; i< n ; i++)
                matrix[0][i] = 0;


        }

        if(isCol)
        {
            for(int i=0 ; i< m ; i++)
                matrix[i][0] = 0;
        }

    }



    @Override
    public String getSolutionNotes() {
        return "This solution can be easily solved using two boolean arrays holding true value for Row number or column number being zero. Then we traverse" +
                " the matrix again and if any of the rows or columns have zeroes we set the i,j element to zero. The only issue with this approach is that it " +
                " takes O(m+n) space for these placeholders." +
                " A more optimal solution is that we use the matrix itself to mark these flags." +
                " We iterate the matrix from 0th row and 1st colum because if 0,0 position is zero it applies to both rows and columns" +
                " Then if iterate any of the element zero, we set the first row element and column element of matrix to be zero. " +
                " m[i][0] = 0 //firs element in row is zero && m[0][j] - first element at column head is zero" +
                " Then we iterate the matrix from 1st position and compare of the Zero element in the row is zero set i,j to zero" +
                " We will then check if m[0,0] was zero , we set the row to zero (There is a possibility that m[0][0] happened because of some other " +
                " element in the columns. So we cannot 0th column to be zero. For that we maintain a flag initially , if flag is true we set the column also as zero ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(mn)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
