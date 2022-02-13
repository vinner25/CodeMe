package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantFlowersInGarden implements ProblemStatement {

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] placements = new int[n];


        Map<Integer, List<Integer>> graph = buildGraph(paths);
        for(int i= 0 ; i< n ; i++)
        {
            if(placements[i] != 0)
                continue;
            placements[i]=1;
            placeFlowersToNeighbors(placements, 1, graph, i+1);

        }

        return placements;

    }

    private void placeFlowersToNeighbors(int[] placements, int flowerNumber, Map<Integer,List<Integer>> graph, int currentGarden)
    {
        if( graph.get(currentGarden) == null)
        {
            return;
        }
        boolean placementCompleted = false;
        List<Integer> neighbors = graph.get(currentGarden);
        for(int i=0; i< neighbors.size(); i++)
        {
            int neighborGarden = neighbors.get(i);
            if(placements[neighborGarden-1] != 0)
                continue;
            for(int j = 1 ; j< 5; j++)
            {
                if(placements[neighborGarden-1] != 0)
                    continue;
                placements[neighborGarden-1] = j;
                if(isValidPlacement(placements,graph)){
                    placeFlowersToNeighbors(placements,flowerNumber+1,graph,neighborGarden);
                }
                else
                    placements[neighborGarden-1] = 0;
            }
        }

    }

    private boolean isValidPlacement(int[] placements, Map<Integer, List<Integer>> graph)
    {
        for(int i= 0 ; i< placements.length ; i++)
        {
            if(placements[i] != 0)
            {
                if(graph.get(i+1) != null)
                {
                    for( int neightbors : graph.get(i+1))
                    {
                        if(placements[neightbors-1] == placements[i])
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] paths)
    {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] path : paths)
        {
            List<Integer> neighbors;
            if(graph.containsKey(path[0]))
            {
                neighbors = graph.get(path[0]);
            }
            else
                neighbors = new ArrayList<>();
            neighbors.add(path[1]);
            graph.put(path[0], neighbors);


            if(graph.containsKey(path[1]))
            {
                neighbors = graph.get(path[1]);
            }
            else
                neighbors = new ArrayList<>();
            neighbors.add(path[0]);
            graph.put(path[1], neighbors);
        }

        return graph;

    }

    @Override
    public String getDescription() {
        return "You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.\n" +
                "\n" +
                "All gardens have at most 3 paths coming into or leaving it.\n" +
                "\n" +
                "Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.\n" +
                "\n" +
                "Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 3, paths = [[1,2],[2,3],[3,1]]\n" +
                "Output: [1,2,3]\n" +
                "Explanation:\n" +
                "Gardens 1 and 2 have different types.\n" +
                "Gardens 2 and 3 have different types.\n" +
                "Gardens 3 and 1 have different types.\n" +
                "Hence, [1,2,3] is a valid answer. Other valid answers include [1,2,4], [1,4,2], and [3,2,1].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 4, paths = [[1,2],[3,4]]\n" +
                "Output: [1,2,1,2]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]\n" +
                "Output: [1,2,3,4]";
    }

    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
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
