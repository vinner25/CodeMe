package com.vinner.codeme.ctci.ds.trees.graphsearch;

import com.vinner.codeme.ctci.ds.trees.problems.GraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * In a Depth First Search the Graphj is Searched from root to its neighbours and then its neighbours and
 * so on. Then it comes back and again searches all the way from root's next neighbour.
 * Hence it searches deeply and searches all the way. It is not very efficient though but useful in cases
 * where we are computing all the exhaustive paths.
 * Time Complexity = O(v+e) , V is vertices and e is edges
 * Space Complexity = O(v)
 * Uses Stacks as the data structure for DFS
 **/
public class DepthFirstSearch<T> {

    public void executeDFS(GraphNode<T> root)
    {
        if(root == null)
            return;

        Stack<GraphNode<T>> stack = new Stack<>();
        stack.add(root);

        Set<T> seen = new HashSet<>();

        while(!stack.isEmpty())
        {
            GraphNode<T> element = stack.pop();

            if(!seen.contains(element.getValue()))
            {
                //The Only Process we are doing here is Print but can be anything
                System.out.print(element.getValue() + " ");
                seen.add(element.getValue());
            }

            if(element.getAdjacentVertices() != null)
            {
                for(GraphNode<T> neighbours : element.getAdjacentVertices())
                {
                    if(!seen.contains(neighbours.getValue()))
                    {
                        stack.add(neighbours);
                    }
                }
            }
        }
    }
}
