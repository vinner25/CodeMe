package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an m x n matrix, return all elements of the matrix in spiral order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]\n" +
                "Output: [1,2,3,6,9,8,7,4,5]\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n" +
                "Output: [1,2,3,4,8,12,11,10,9,5,6,7]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "m == matrix.length\n" +
                "n == matrix[i].length\n" +
                "1 <= m, n <= 10\n" +
                "-100 <= matrix[i][j] <= 100";
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0)
            return result;

        result.add(matrix[0][0]);
        matrix[0][0] = 101; // Updating traversed values with 101 since constraints mention that value lies between -100 and 100
        traverseElement(0 , 0 ,matrix, result, false);
        return result;

    }

    private void traverseElement(int i, int j , int[][] matrix, List<Integer> result, boolean isUp)
    {

        if(isUp) //The UP element has a special scenario becuae if the element is going up it will keep doing that unless not possible then flip to right
        {
            if(i-1 >= 0  && matrix[i-1][j] != 101) //UP
            {
                result.add(matrix[i-1][j]);
                matrix[i-1][j] = 101;
                traverseElement(i-1 , j, matrix, result, true);
            }
        }

        //Right
        if(j+1 < matrix[0].length && matrix[i][j+1] != 101)
        {
            result.add(matrix[i][j+1]);
            matrix[i][j+1] = 101;
            traverseElement(i , j+1, matrix, result, false);
        }
        else if(i+1 < matrix.length && matrix[i+1][j] != 101) //Down
        {
            result.add(matrix[i+1][j]);
            matrix[i+1][j] = 101;
            traverseElement(i+1 , j, matrix, result, false);
        }
        else if(j-1 >= 0  && matrix[i][j-1] != 101) //Left
        {
            result.add(matrix[i][j-1]);
            matrix[i][j-1] = 101;
            traverseElement(i , j-1, matrix, result,false);
        }
        else if(i-1 >= 0  && matrix[i-1][j] != 101) //UP
        {
            result.add(matrix[i-1][j]);
            matrix[i-1][j] = 101;
            traverseElement(i-1 , j, matrix, result, true);
        }

    }


    @Override
    public String getSolutionNotes() {
        return "Traversing the matrix";
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
