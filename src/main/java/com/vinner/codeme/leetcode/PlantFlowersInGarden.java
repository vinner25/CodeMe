package com.vinner.codeme.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantFlowersInGarden {

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
        if(flowerNumber > 4 || graph.get(currentGarden) == null)
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
}
