package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class NQueenII implements ProblemStatement {

    public int totalNQueens(int n) {
        int[] count = new int[1];
        placeQueen(0, n, count, new ArrayList<>());
        return count[0];
    }


    private void placeQueen(int rowCount, int n,  int[] count, List<Integer> colPlacements)
    {
        if(rowCount == n)
        {
            count[0] = count[0] + 1;
        }

        for(int i= 0 ; i< n ; i++)
        {

            colPlacements.add(i); //Placed a Queen
            if(validateQueenPosition(rowCount, colPlacements))
                placeQueen(rowCount+1, n , count, colPlacements);

            colPlacements.remove(colPlacements.size() -1);
        }


    }

    private boolean validateQueenPosition(int rowCount,List<Integer> colPlacements)
    {
        int lastRowPosition = colPlacements.get(colPlacements.size() -1 );
        for( int i=0 ; i< rowCount; i++)
        {
            int diff = Math.abs(colPlacements.get(i) - lastRowPosition);
            if(diff == 0 || diff == Math.abs( rowCount-i))
                return false;
        }
        return true;
    }

    @Override
    public String getDescription() {
        return "The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.\n" +
                "\n" +
                "Given an integer n, return the number of distinct solutions to the n-queens puzzle.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: n = 4\n" +
                "Output: 2\n" +
                "Explanation: There are two distinct solutions to the 4-queens puzzle as shown.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 1\n" +
                "Output: 1";
    }

    @Override
    public String getSolutionNotes() {
        return "This is a classic backtracking problem. We basically start with first row and try all the possible combinations. " +
                "For Details : https://www.youtube.com/watch?v=wGbuCyNpxIg";
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
