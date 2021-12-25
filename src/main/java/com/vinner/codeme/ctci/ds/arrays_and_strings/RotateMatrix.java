package com.vinner.codeme.ctci.ds.arrays_and_strings;

/**
 *  Rotate a N*N Square Matrix in one place. By One Place ,it means we cannot use additional memory
 *
 *  Time Complexity : 0(n^2) because we have to visit each element of the matrix at-least once
 */
public class RotateMatrix {

    public void rotateMatrix(int[][] m)
    {

        transposeMatrix(m);
        reverseMatrix(m);
    }

    //First Convert All the Rows to column
    private void transposeMatrix(int[][] m)
    {
        for(int i=0;i<m.length; i++)
        {
            for(int j=i+1;j<m.length;j++)
            {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
    }

    //The Last Column become First Column
    private void reverseMatrix(int[][] m)
    {
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m.length/2;j++)
            {
                int temp = m[i][j];
                m[i][j] = m[i][m.length-1-j];
                m[i][m.length-1-j]= temp;
            }

        }

    }


    public static void main(String args[])
    {
        int[][] m = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        ArrayProblemUtils.printMatrix(m);
        RotateMatrix rm = new RotateMatrix();
        rm.rotateMatrix(m);
        ArrayProblemUtils.printMatrix(m);

    }
}
