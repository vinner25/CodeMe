package com.vinner.codeme.ctci.ds.trees.graphsearch;

import com.vinner.codeme.ctci.ds.trees.problems.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * A Breadth First Search first visits all the immediate neighbors of root node and then neighbors of its
 * neighbors and so on. It basically looks like a radial search where a region is first scanned before widening
 * to outer region. Hence it is called Breadth first search because it searches widely.
 * This kind of search is very efficient in problems like Calculating shortest distance, nearest node etc..
 * Time Complexity = O(v+e) , v is vertices and e is edges
 * Space Complexity = O(v)
 * We should use Queues for implementing BFS
 * */
public class BreadthFirstSearch<T> {

    public void executeBFS(GraphNode<T> rootNode)
    {
        if(rootNode == null)
            return;

        Queue<GraphNode<T>> queue = new LinkedList<>();
        queue.add(rootNode);

        Set<T> seen = new HashSet<>();

        while(!queue.isEmpty())
        {
            GraphNode<T> element = queue.poll(); //Get the element at head of queue
            if(!seen.contains(element.getValue()))
            {
                System.out.print(element.getValue() + " ");
                seen.add(element.getValue());
            }

            if(null != element.getAdjacentVertices())
            {
                for(GraphNode<T> neighbors : element.getAdjacentVertices())
                {
                    if(!seen.contains(neighbors.getValue()))
                    {
                        queue.add(neighbors);

                    }
                }
            }
        }
    }
}

