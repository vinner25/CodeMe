package com.vinner.codeme.blind75.graph;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow implements ProblemStatement {



        public List<List<Integer>> pacificAtlantic(int[][] heights) {

            if(heights.length <=0)
                return new ArrayList<>();

            int m = heights.length;
            int n = heights[0].length;

            //Placeholder for coordinates which can connect to Pacific Ocean
            boolean[][] pacific = new boolean[m][n];

            //Placeholder for coordinates which can connect to Atlantic Ocean
            boolean[][] atlantic = new boolean[m][n];


            for(int i=0; i<m; i++)
            {
                // From Top to  bottom . all the left indices of heights grid touch the Pacific Ocean so we traverse
                // From top to bottom at 0th column and set all adjacent coordinates which can connect as well to true
                // in the pacific grid
                bfsTraverse(i, 0, heights, pacific);

                //Also from top to bottom all the Matrix Grid on right side touch the atlantic ocean as well
                //So we do the same traversal for atlantic coordinates as well
                bfsTraverse(i, n-1, heights, atlantic);


            }


            for(int i=0; i<n; i++)
            {
                // From Top to  bottom . all the left indices of heights grid touch the Pacific Ocean so we traverse
                // From top to bottom at 0th column and set all adjacent coordinates which can connect as well to true
                // in the pacific grid
                bfsTraverse(0, i, heights, pacific);

                //Also from top to bottom all the Matrix Grid on right side touch the atlantic ocean as well
                //So we do the same traversal for atlantic coordinates as well
                bfsTraverse(m-1, i, heights, atlantic);


            }

            //Result is node intersecting those points which lead to both atlantic and pacific ocean
            List<List<Integer>> result = new ArrayList<>();


            for(int i=0 ; i<m ; i++)
            {
                for(int j=0; j< n; j++)
                {
                    if(pacific[i][j] && atlantic[i][j])
                    {
                        List<Integer> coord = new ArrayList<>();
                        coord.add(i);
                        coord.add(j);
                        result.add(coord);
                    }
                }
            }

            return result;



        }

        private void bfsTraverse(int i, int j , int[][] heights , boolean[][] ocean)
        {
            if(ocean[i][j]) //If it is already verified that water connectivity is good at this coordinate
                return;

            Queue<int[]> bfsQueue = new LinkedList<int[]>();
            bfsQueue.add(new int[]{i,j});

            while(!bfsQueue.isEmpty())
            {
                int[] point = bfsQueue.poll();

                int x = point[0];
                int y = point[1];

                if(ocean[x][y])
                    continue; //In case if the coordinate is already traversed as at each
                //adjoining coordinate we do left , right , top and bottom so coordinate will repeat

                ocean[x][y] = true; //Water connectivity is good here (Initially it the edges)

                int currentHeight = heights[x][y];
                //Top
                if(x-1 >= 0 && heights[x-1][y] >= currentHeight && !ocean[x-1][y])
                    bfsQueue.add(new int[]{x-1, y});


                //Bottom
                if(x+1 < heights.length && heights[x+1][y] >= currentHeight  && !ocean[x+1][y])
                    bfsQueue.add(new int[]{x+1, y});


                //Left
                if(y-1 >= 0 && heights[x][y-1] >= currentHeight && !ocean[x][y-1])
                    bfsQueue.add(new int[]{x, y-1});

                //Right
                if(y+1 < heights[0].length &&  heights[x][y+1] >= currentHeight && !ocean[x][y+1])
                    bfsQueue.add(new int[]{x, y+1});

            }

        }

    @Override
    public String getDescription() {
        return "There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.\n" +
                "\n" +
                "The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).\n" +
                "\n" +
                "The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.\n" +
                "\n" +
                "Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]\n" +
                "Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: heights = [[2,1],[1,2]]\n" +
                "Output: [[0,0],[0,1],[1,0],[1,1]]\n" +
                "Refer : https://leetcode.com/problems/pacific-atlantic-water-flow/" +
                "";

    }

    @Override
    public String getSolutionNotes() {
        return "This is very intuitive problem. The Logic is that all the adjacent nodes can touch either Pacific Ocean or Atlantic Ocean. " +
                "Top and Left touch Pacific Ocean so if we traverse from top to bottom only coordinates which are greater in height from these edgse nodes" +
                "can draw water to pacific ocean. " +
                "Similarly Right and Bottom edges touch Atlantic Ocean, therefore all the nodes nodes traversing up and left which are greater than adjacent nodes can draw " +
                "water to atlantic ocean. " +
                "Therefore we will traverse all thw way in all direction in this grid and we will create two more grid. One Grid for Pacific ocean and points where " +
                "pacific ocean will connect with coordinates and one for atlantic ocean." +
                "The final answer will be points which can connect with both pacific and atlantic ocean. We will use BFS, We can use a DFS too!";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m*n) - Since we traversing the whole grid.";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(m*n) for storing the grid for pacific and atlantic ocean. The result at max can have all coodinates so its space complexity too is not more than O(m*n)";
    }
}
