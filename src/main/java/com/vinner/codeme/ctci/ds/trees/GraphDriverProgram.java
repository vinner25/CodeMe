package com.vinner.codeme.ctci.ds.trees;

import com.vinner.codeme.ctci.ds.trees.graphsearch.BreadthFirstSearch;
import com.vinner.codeme.ctci.ds.trees.graphsearch.DepthFirstSearch;
import com.vinner.codeme.ctci.ds.trees.problems.GraphNode;

public class GraphDriverProgram {


    public static  void main(String args[]) {
        GraphNode<Integer> root = GraphNodeUtil.generateIntegerGraph();

        DepthFirstSearch dfs = new DepthFirstSearch();
        System.out.println("DFS : ");
        dfs.executeDFS(root);
        System.out.println();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        System.out.println("BsFS : ");
        bfs.executeBFS(root);


    }

}
