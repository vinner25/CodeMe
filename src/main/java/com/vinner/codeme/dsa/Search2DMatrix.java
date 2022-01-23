package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

public class Search2DMatrix implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:\n" +
                "\n" +
                "Integers in each row are sorted from left to right.\n" +
                "The first integer of each row is greater than the last integer of the previous row.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13\n" +
                "Output: false";
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if(m==1 && n == 1)
            return matrix[0][0] == target;

        if(m == 1)
            return binarySearchNumber(matrix[0], target, 0 , n-1);

        int[] rowToFind = findRow ( 0, m-1, matrix, target, n);

        if(null != rowToFind)
        {

            return binarySearchNumber(rowToFind, target, 0 , n-1);
        }
        return false;
    }

    private int[] findRow(int i, int j , int[][] matrix, int target, int n)
    {
        if(i <= j)
        {
            int mid = (i+j)/2;
            if(matrix[mid][0] <= target && matrix[mid][n-1] >= target)
                return matrix[mid];
            else if(matrix[mid][0] > target)  //Means Element is in Up Row
                return findRow(i , mid-1, matrix, target, n);
            else
                return findRow(mid+1, j, matrix, target, n); // Means Element is in low Row
        }
        return null;
    }

    private boolean binarySearchNumber(int[] arr, int num, int i, int j)
    {
        if(i <= j)
        {
            int mid = (i+j)/2;
            if(arr[mid] == num)
                return true;
            else if(arr[mid] > num)
                return binarySearchNumber(arr, num, i , mid-1);
            else
                return binarySearchNumber(arr, num, mid+1 , j);
        }
        return false;
    }
    @Override
    public String getSolutionNotes() {
        return "The Problem is basically a Binary Search. We first identify which row to search based on the value of the target amd then " +
                "perform Binary search on the identified row";    }

    @Override
    public String getTimeComplexity() {
        return "O(logN + logM) - O(LogN) for finding Rows and O(LogM) for finding target in row with value M";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
