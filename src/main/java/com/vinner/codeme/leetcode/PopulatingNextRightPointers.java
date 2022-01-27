package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers implements ProblemStatement {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    @Override
    public String getDescription() {
        return "You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:\n" +
                "\n" +
                "struct Node {\n" +
                "  int val;\n" +
                "  Node *left;\n" +
                "  Node *right;\n" +
                "  Node *next;\n" +
                "}\n" +
                "Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.\n" +
                "\n" +
                "Initially, all next pointers are set to NULL.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3,4,5,6,7]\n" +
                "Output: [1,#,2,3,#,4,5,6,7,#]\n" +
                "Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []\n" +
                " ";
    }
    public Node connect(Node root) {
        if(root == null)
            return null;
        if(root.left == null)
            return root;


        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty())
        {
            int size = queue.size();

            Node prev = queue.poll();
            if(prev.left != null)
            {
                queue.add(prev.left);
                queue.add(prev.right);
            }
            for(int i=1 ; i< size ; i++)
            {
                Node nextNode = queue.poll();
                prev.next = nextNode;

                if(nextNode.left != null)
                    queue.add(nextNode.left);

                if(nextNode.right != null)
                    queue.add(nextNode.right);
                prev = nextNode;

            }
        }

        return root;

    }
    @Override
    public String getSolutionNotes() {
        return "Easiest solution is to do a level order traversal and iterate each level while making connections";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for queue";
    }
}
