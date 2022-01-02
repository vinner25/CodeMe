package com.vinner.codeme.ctci.ds.dp;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class RobotInAgrid implements ProblemStatement {
    @Override
    public String getDescription() {
        return " [8.2] Robot in a Grid: Imagine a robot sitting on the upper\n" +
                "# left corner of grid with r rows and c columns. The robot can\n" +
                "# only move in two directions, right and down, but certain\n" +
                "# cells are \"off limits\" such that the robot cannot step on\n" +
                "# them. Design an algorithm to find a path for the robot from\n" +
                "# the top left to the bottom right." +
                "Consider a grid of M*N where 1 denotes a valid cell and 0 denotes an obstacle";
    }

    @Override
    public String getSolutionNotes() {
        return "We Will traverse a the m,atrix by either going Right or Down and perform a DFS and maintain the DP table to show if that path takes us anywhere.";
    }

    public List<int[]> validPath(int[][] grid)
    {
        List<int[]> path = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        Boolean[][] traversal = new Boolean[rows][cols];

        fillValidPath(grid,0,0,rows,cols,traversal);


        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(traversal[i][j] != null &&  traversal[i][j] == true)
                {
                    path.add(new int[]{i,j});
                }
            }
        }
        return  path;
    }

    private boolean fillValidPath(int[][] grid, int i, int j, int rows, int cols, Boolean[][] dp)
    {
        if(i== rows-1  && j== cols-1) //Reached Bottom right
            return true;

        if(i == rows || j == cols) //over bounds
            return  false;

        if(dp[i][j] != null)
            return  dp[i][j];

        if(grid[i][j] != 0) //Performing DFS by going either right or down unless we reach bottom right of grid
        {
            dp[i][j] = fillValidPath(grid,i+1,j, rows,cols,dp) || fillValidPath(grid,i, j+1,rows,cols,dp);
        }
        else
            dp[i][j] = false;

        return  dp[i][j];

    }


    @Override
    public String getTimeComplexity() {
        return "O(m*n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(m*n) for the DP table";
    }
}
