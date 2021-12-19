package com.vinner.codeme.ds.arrays_and_strings;
/*
Give a M*N Matrix, Set the respective Row and Column to Zero if element is Zero
 */
public class ZeroMatrix {

    public int[][] zeroMatrix(int[][] matrix) {

        boolean[] rows = new boolean[matrix.length]; // Arr To Flag rows with Zeroes
        boolean[] columns = new boolean[matrix[0].length]; // Arr to flag columns with Zeroes

        for(int i=0; i<rows.length;i++)
        {
            for(int j=0;j<columns.length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows[i] = true;
                    columns[j] = true;

                }

            }
        }

        for(int i=0; i<rows.length ; i++)
            if(rows[i]) nullifyRow(matrix,i);

        for(int i=0; i<columns.length ; i++)
            if(columns[i]) nullifyColumn(matrix,i);


        return matrix;
    }

    private void nullifyRow(int[][] matrix, int rowNum)
    {
        for(int i=0; i<matrix[0].length; i++)
        {
            matrix[rowNum][i] = 0;
        }
    }


    private void nullifyColumn(int[][] matrix, int columnNum)
    {
        for(int i=0; i<matrix.length; i++)
        {
            matrix[i][columnNum] = 0;
        }
    }



    public static void main(String args[])
    {
        ZeroMatrix zm = new ZeroMatrix();
        int[][] matrix = new int[][]{{1,0,2},{4,5,0}, {9,1,1}};
        ArrayProblemUtils.printMatrix(matrix);
        ArrayProblemUtils.printMatrix(zm.zeroMatrix(matrix));
    }

}
