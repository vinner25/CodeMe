package com.vinner.codeme.ds.trees.problems;

import com.vinner.codeme.ds.trees.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *  Given a Directed graph, Design Algo to tell if Path exists between two nodes
 *
 */
public class RouteBetweenNodes {

    /*
     We will use BFS to see neighbors of one of the node and its neigbors and so on
     and If somehow node 2 is found in any of the connection then path exists

     */
    public boolean pathExists (GraphNode<Character> node1, GraphNode<Character> node2 )
    {

        if(node1 == null || node2 == null )
            throw new IllegalArgumentException("Node cannot be null");



        Queue<GraphNode<Character>> queue = new LinkedList<>();
        Set<Character> seen = new HashSet<>();

        queue.add(node1);

        while(!queue.isEmpty())
        {
            GraphNode<Character> element = queue.poll();
            if(!seen.contains(element.getValue()))
            {
                if(element.getValue() == node2.getValue())
                    return true;
               seen.add(element.getValue());

            }
            if(null != element.getAdjacentVertices())
            {
                for(GraphNode<Character> neighbors : element.getAdjacentVertices())
                {
                    if(!seen.contains(neighbors.getValue()))
                    {
                        queue.add(neighbors);
                    }
                }
            }

        }
        return  false;
    }
    /**
     *  Directed Graph like :
     *                  A ------->D  ---> G
     *                 |           \
     *                 v            v
     *                 B  ---------> F
     *                 |
     *                 v
     *                 C ---> E
     *
     */
    public  static  void main(String args[])
    {
        GraphNode<Character> root = new GraphNode<>();
        root.setValue('A');


        GraphNode<Character> twoValueV = new GraphNode<>();
        twoValueV.setValue('B');

        GraphNode<Character> threeValueV = new GraphNode<>();
            threeValueV.setValue('C');

            GraphNode<Character> fourValueV = new GraphNode<>();
            fourValueV.setValue('D');

            GraphNode<Character> fiveValueV = new GraphNode<>();
        fiveValueV.setValue('E');
        GraphNode<Character> sixValueV = new GraphNode<>();
        sixValueV.setValue('F');

        GraphNode<Character> sevenValueV = new GraphNode<>();
        sevenValueV.setValue('G');

        root.addVertix(twoValueV);
        root.addVertix(fourValueV);


        twoValueV.addVertix(threeValueV);
        twoValueV.addVertix(sixValueV);

        threeValueV.addVertix(fiveValueV);

        fourValueV.addVertix(sixValueV);
        fourValueV.addVertix(sevenValueV);
        RouteBetweenNodes gp1 = new RouteBetweenNodes();

        System.out.println(gp1.pathExists(threeValueV,fourValueV)); // C & D // false
        System.out.println(gp1.pathExists(twoValueV,fiveValueV)); // B && E // true
        System.out.println(gp1.pathExists(root,sevenValueV)); // A && G // true
    }


}
