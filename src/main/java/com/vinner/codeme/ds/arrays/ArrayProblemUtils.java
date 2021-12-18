package com.vinner.codeme.ds.arrays;

public class ArrayProblemUtils {

    public static void printMatrix(int[][] matrix)
    {
        for(int i=0; i< matrix.length; i++)
        {
            for(int j=0;j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }

        System.out.println("******************************");
    }
}
