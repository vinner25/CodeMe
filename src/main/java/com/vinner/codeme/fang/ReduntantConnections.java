package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;

public class ReduntantConnections implements ProblemStatement {
    public int[] findRedundantConnection(int[][] edges) {

        int[] result = new int[2];
        int disjointSetsArray[] = new int[edges.length + 1];
        Arrays.fill(disjointSetsArray, -1);

        for(int[] edge : edges)
        {

            int p1 = findParent(disjointSetsArray, edge[0] );
            int p2 = findParent(disjointSetsArray, edge[1]);

            if(p1 == p2 ) //Means both have same parents  Then it is a cycle
            {
                result[0] = edge[0];
                result[1] = edge[1];
            }
            else //Union
            {
                if(disjointSetsArray[p2] <  disjointSetsArray[p1])
                {
                    disjointSetsArray[p1  ] = p2 ;
                    disjointSetsArray[p2]--;
                }
                else
                {
                    disjointSetsArray[p2  ] = p1;
                    disjointSetsArray[p1]--;
                }

            }
        }

        return result;
    }

    private int findParent(int[] disjointSetsArray, int index)
    {
        int val = disjointSetsArray[index];
        if(val  <= -1) //means it is already a Parent
            return index;
        else
        {
            int parent = val;
            while(val > 0)
            {
                parent = val ;
                val = disjointSetsArray[val];
            }
            return parent;
        }
    }

    @Override
    public String getDescription() {
        return "In this problem, a tree is an undirected graph that is connected and has no cycles.\n" +
                "\n" +
                "You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.\n" +
                "\n" +
                "Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: edges = [[1,2],[1,3],[2,3]]\n" +
                "Output: [2,3]\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]\n" +
                "Output: [1,4]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "n == edges.length\n" +
                "3 <= n <= 1000\n" +
                "edges[i].length == 2\n" +
                "1 <= ai < bi <= edges.length\n" +
                "ai != bi\n" +
                "There are no repeated edges.\n" +
                "The given graph is connected.";
    }

    @Override
    public String getSolutionNotes() {
        return "We need to perform a Union Find on the edges given. The Algortihm is explained in detail https://youtu.be/wU6udHRIkcc";
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
