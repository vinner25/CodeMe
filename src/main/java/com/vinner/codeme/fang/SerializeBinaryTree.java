package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeBinaryTree implements ProblemStatement {


    public String serialize(TreeNode root) {

        List<String> tokens = new ArrayList<>();
        traverseTree(root, tokens);
        StringBuilder res = new StringBuilder();
        for(String token: tokens)
            res.append(token).append(",");

        if(res.length() > 0)
            res.setLength(res.length()-1);
        return res.toString();
    }

    private void traverseTree(TreeNode node, List<String> result)
    {
        if(node == null)
        {
            result.add("N");
            return;
        }

        result.add(String.valueOf(node.val));
        traverseTree(node.left, result);
        traverseTree(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.length() == 0)
            return null;

        String[] tokens = data.split(",");
        return buildTree(tokens, new int[1]);



    }

    private TreeNode buildTree( String[] tokens, int[] cIndex)
    {
        if(cIndex[0] > tokens.length-1)
            return null;

        if(tokens[cIndex[0]].equals("N"))
        {
            cIndex[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(tokens[cIndex[0]++]));
        root.left = buildTree( tokens,cIndex);
        root.right = buildTree( tokens, cIndex);
        return root;

    }


    @Override
    public String getDescription() {
        return "Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.\n" +
                "\n" +
                "Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.\n" +
                "\n" +
                "Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3,null,null,4,5]\n" +
                "Output: [1,2,3,null,null,4,5]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []";
    }

    @Override
    public String getSolutionNotes() {
        return "We will create a Serialized string by doing a preOrder traversal of the Tree and wherever we encounter Null we will keep on adding" +
                " N to our result. the Deserialization is bit tricky we know that after every node the next node is a left child and the right child only starts " +
                "after a N of the left child has been reached.";
    }

    @Override
    public String getTimeComplexity() {
        return "Serialization : O(n) , Deserialization : O(N)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N) for List to carry N nodes";
    }
}
