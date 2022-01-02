package com.vinner.codeme.blind75.graph;

import com.vinner.codeme.ProblemStatement;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.\n" +
                "\n" +
                "An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: grid = [\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]\n" +
                "Output: 1\n" +
                "Example 2:\n" +
                "\n" +
                "Input: grid = [\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]\n" +
                "Output: 3";
    }
    public int numIslands(char[][] grid) {

        int numOfIslands= 0;
        int numRow = grid.length;
        int numCol = grid[0].length;
        for(int i=0; i<numRow; i++)
        {
            for(int j=0; j<numCol; j++)
            {
                if(grid[i][j] == '1')
                {
                    numOfIslands++;
                    bfs(grid, i, j,numRow,numCol);
                }
            }
        }
        return numOfIslands;


    }

    private void bfs(char[][] grid, int row, int col, int numRow, int numCol)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        grid[row][col] = '0';    //Make this land to water so that it does not get traversed again
        while(!queue.isEmpty())
        {
            int[]  coordinates = queue.poll();
            int i = coordinates[0];
            int j = coordinates[1];
            //Top
            if(i-1 >= 0 && grid[i-1][j] == '1') //Check for Bound and check it is connected land
            {
                grid[i-1][j] = '0';
                queue.add(new int[]{i-1,j});
            }
            //Left
            if(j-1 >= 0 && grid[i][j-1] == '1') //Check for Bound and check it is connected land
            {
                grid[i][j-1] = '0';
                queue.add(new int[]{i,j-1});
            }
            //Bottom
            if(i+1 < numRow && grid[i+1][j] == '1') //Check for Bound and check it is connected land
            {
                grid[i+1][j] = '0';
                queue.add(new int[]{i+1,j});
            }
            // Right
            if(j+1 < numCol && grid[i][j+1] == '1') //Check for Bound and check it is connected land
            {
                grid[i][j+1] = '0';
                queue.add(new int[]{i,j+1});
            }
        }
    }
    @Override
    public String getSolutionNotes() {
        return "The Solution for this is a simple BFS . As soon as we see a 1 in the Grid, we know it is land, after " +
                " that we start traversing ite neighbour and if the neighbor is 1 we add it to queue. Each element we traverse" +
                " we set it to 0 so that we do not add it again in the queue.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m*n) where M is number of Rows and N is number of Columns";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(min(m,n) since we add add only non visited elements to queue and that depends on number of rows or cols and minimum of it";
    }
}
