package com.vinner.codeme.blind75.graph;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

public class CloneGraph implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a reference of a node in a connected undirected graph.\n" +
                "\n" +
                "Return a deep copy (clone) of the graph.\n" +
                "\n" +
                "Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.\n" +
                "\n" +
                "class Node {\n" +
                "    public int val;\n" +
                "    public List<Node> neighbors;\n" +
                "}\n" +
                " ";
    }


    public Node cloneGraph(Node node) {

        if(node == null || node.neighbors.size() < 0)
            return node;

        Map<Integer,Node>  cloneMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty())
        {
            Node element = queue.poll();
            if(cloneMap.get(element.val) == null) //Means Not cloned
            {
                Node cloneNode = new Node(element.val);
                cloneMap.put(element.val,cloneNode); //Insert the Node in the Hash Table
            }
            if(element.neighbors.size() > 0) //Means it has Neighbours too
            {
                Node cloneNode = cloneMap.get(element.val);
                for(Node neighbour : element.neighbors)
                {
                    if(cloneMap.get(neighbour.val) != null) //Means Neighbour is already cloned then create relationships
                    {
                        //Since it is undirected graph so need to clone relationship in both directions
                        Node neighbourClonedNode = cloneMap.get(neighbour.val);
                        cloneNode.neighbors.add(neighbourClonedNode);
                        neighbourClonedNode.neighbors.add(cloneNode);
                    }
                    else if(!cloneMap.containsKey(neighbour.val)){
                        cloneMap.put(neighbour.val, null); //Not yet cloned but added so that we do not add duplicate
                        queue.add(neighbour);

                    }//Else just add it in the Queue so that it can be cloned
                }
            }
        }
        return cloneMap.get(node.val);
    }






    @Override
    public String getSolutionNotes() {
        return "We will solve this problem using Depth First Search. We can make use of Hashtables (Hashmap) to keep track of what is cloned:" +
                "\n 1) BFS the Node and check if the node already exists in the HashTable" +
                "\n 2) If Node does not exist , then clone it and add it to map (Key -> OLD node value , Value is new Node(with no children)" +
                "\n 3) Traverse neighbours of node and check if any of the neighbours is already cloned. If not add it to Queue of BFS for cloning" +
                "\n 4) Next Iteration the neighbour node will be cloned and when it will check its neighbours, it will see one of the adjacent node is already cloned" +
                "\n 5) If find any node which is already cloned, then create relationships among them and repeat." +
                "";
    }

    @Override
    public String getTimeComplexity() {
        return "O(V+E) , Where V is vertices and E is edges since the Time depends on iteration of each node and then its corresponding edges";

    }

    @Override
    public String getSpaceComplexity() {
        return "O(V+E) , Since we have to create another Graph with same Vertices and Edges";
    }
}
