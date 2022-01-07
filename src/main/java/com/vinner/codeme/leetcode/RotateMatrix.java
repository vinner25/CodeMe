package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class RotateMatrix implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).\n" +
                "\n" +
                "You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]\n" +
                "Output: [[7,4,1],[8,5,2],[9,6,3]]\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n" +
                "Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]";
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int left=0, right = n - 1;
        while(left < right)
        {
            int top = left;
            int bottom = right;

            for( int i= 0 ; i< right - left ; i++)
            {

                //Get Top
                int topVal = matrix[top][left+i];

                //Move Bottom Left to Top
                matrix[top][left+i] = matrix[bottom-i][left];

                //Move bottom right to bottom left
                matrix[bottom - i][left] = matrix[bottom][right-i];

                //Move Top Right to Bottom
                matrix[bottom] [right-i] =  matrix[top+i][right];

                //Set Left top to right top
                matrix[top+i][right] = topVal;
            }
            left++;
            right--;
        }
    }
    @Override
    public String getSolutionNotes() {
        return "We move layer by layer rotating first layer then inner till we reach end of matrix" +
                "Refer: https://www.youtube.com/watch?v=fMSJSS7eO1w";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n^2)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
