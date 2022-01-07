package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidateSudoku implements ProblemStatement {
    public boolean isValidSudoku(char[][] board) {

        return validateRowsAndColumnAndBox(board);


    }
    private boolean validateRowsAndColumnAndBox(char[][] board)
    {
        Map<Integer, int[]> columnCountsMap = new HashMap<>();
        Map<Integer, int[]> boxCountMap = new HashMap<>();
        for( int i=0;i<9;i++)
        {
            int[] rowCounts = new int[9];
            for( int j =0  ; j<9; j++)
            {
                char val = board[i][j];
                int boxNum = 3 * (i/3) + (j/3) + 1; //The Trick here is to calculate what box NUmber we are currently in
                if(val == '\0'  || val == '.')
                    continue;

                int[] columnCounts;
                if(columnCountsMap.get(j) == null)
                    columnCounts = new int[9];
                else
                    columnCounts = columnCountsMap.get(j);

                int[] boxCount;
                if(boxCountMap.get(boxNum) == null)
                    boxCount = new int[9];
                else
                    boxCount = boxCountMap.get(boxNum);

                int value = Character.getNumericValue(val);

                if(value < 1 || value > 9 || rowCounts[value-1] > 0 ||columnCounts[value-1] > 0 ||
                        boxCount[value-1] > 0)
                    return false;
                rowCounts[value-1]++;
                columnCounts[value-1]++;
                boxCount[value-1]++;
                columnCountsMap.put(j,columnCounts );
                boxCountMap.put(boxNum, boxCount);
            }
        }
        return true;
    }

    /*private boolean validateGrid(char[][] board)
    {
        for( int i = 0 ; i<9 ; i+=3)
        {
            for( int j = 0 ; j<9 ; j+=3)
            {
                if(!validateGrid(board, i , j))
                    return  false;
            }
        }
        return true;
    }

    private boolean validateGrid(char[][] grid, int rowIndex , int colIndex)
    {
        int[] counts = new int[9];
        for( int i = rowIndex ; i< rowIndex+3; i++ )
        {
            for(int j= colIndex ; j< colIndex+3; j++)
            {
                char val = grid[i][j];
                if (val == '\0' || val == '.')
                    continue;
                int value = Character.getNumericValue(val);
                if (counts[value - 1] > 0)
                    return false;
                counts[value - 1]++;
            }
        }
        return true;
    }

    private boolean validateRowsAndColumn(char[][] board)
    {
        Map<Integer, int[]> columnCountsMap = new HashMap<>();

        for( int i=0;i<9;i++)
        {
            int[] rowCounts = new int[9];
            for( int j =0  ; j<9; j++)
            {
                char val = board[i][j];
                if(val == '\0'  || val == '.')
                    continue;

                int[] columnCounts;
                if(columnCountsMap.get(j) == null)
                    columnCounts = new int[9];
                else
                    columnCounts = columnCountsMap.get(j);

                int value = Character.getNumericValue(val);

                if(value < 1 || value > 9 || rowCounts[value-1] > 0 ||columnCounts[value-1] > 0 )
                    return false;
                rowCounts[value-1]++;
                columnCounts[value-1]++;

                columnCountsMap.put(j,columnCounts );
            }
        }
        return true;
    }*/

    @Override
    public String getDescription() {
        return "Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:\n" +
                "\n" +
                "Each row must contain the digits 1-9 without repetition.\n" +
                "Each column must contain the digits 1-9 without repetition.\n" +
                "Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.\n" +
                "Note:\n" +
                "\n" +
                "A Sudoku board (partially filled) could be valid but is not necessarily solvable.\n" +
                "Only the filled cells need to be validated according to the mentioned rules.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: board = \n" +
                "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: board = \n" +
                "[[\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"]\n" +
                ",[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"]\n" +
                ",[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"]\n" +
                ",[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"]\n" +
                ",[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"]\n" +
                ",[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"]\n" +
                ",[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"]\n" +
                ",[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"]\n" +
                ",[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n" +
                "Output: false\n" +
                "Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.\n" +
                " ";
    }

    @Override
    public String getSolutionNotes() {
        return "We Iterate over each element in the matrix and validate the rules on the go";
    }

    @Override
    public String getTimeComplexity() {
        return "O(9^2) which is constant";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(9^2) - 3 memory units  of size 9 where each can hold upto 9 elements";
    }
}
