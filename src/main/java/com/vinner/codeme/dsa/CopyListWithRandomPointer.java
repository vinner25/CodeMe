package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer implements ProblemStatement {
    @Override
    public String getDescription() {
        return "A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.\n" +
                "\n" +
                "Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.\n" +
                "\n" +
                "For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.\n" +
                "\n" +
                "Return the head of the copied linked list.\n" +
                "\n" +
                "The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:\n" +
                "\n" +
                "val: an integer representing Node.val\n" +
                "random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.\n" +
                "Your code will only be given the head of the original linked list.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]\n" +
                "Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: head = [[1,1],[2,1]]\n" +
                "Output: [[1,1],[2,1]]\n" +
                "Example 3:\n" +
                "\n" +
                "\n" +
                "\n" +
                "Input: head = [[3,null],[3,0],[3,null]]\n" +
                "Output: [[3,null],[3,0],[3,null]]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "0 <= n <= 1000\n" +
                "-104 <= Node.val <= 104\n" +
                "Node.random is null or is pointing to some node in the linked list.";
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        Node ptr = head;
        Map<Node,Node> oldAndNewNodesMap = new HashMap<>();
        Node prevNode = null;
        while(ptr != null)
        {
            Node newNode = new Node(ptr.val);
            if(prevNode != null)
            {
                prevNode.next = newNode;
            }
            prevNode = newNode;
            oldAndNewNodesMap.put(ptr,newNode);
            ptr = ptr.next;
        }
        ptr = head;
        while(ptr != null)
        {
            Node currentNewNode = oldAndNewNodesMap.get(ptr);

            if(ptr.random != null)
            {
                currentNewNode.random = oldAndNewNodesMap.get(ptr.random);
            }
            ptr = ptr.next;
        }

        return oldAndNewNodesMap.get(head);


    }
    @Override
    public String getSolutionNotes() {
        return "We create a hashmap maintaining a relation with the new nodes and old nodes";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
