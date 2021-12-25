package com.vinner.codeme.blind75.tree;

import com.vinner.codeme.ProblemStatement;

public class InvertTree implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, invert the tree, and return its root.\n" +
                "Example 1:\n" +
                "Input: root = [4,2,7,1,3,6,9]\n" +
                "Output: [4,7,2,9,6,3,1]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [2,1,3]\n" +
                "Output: [2,3,1]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []";
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        swapNodes(root);
        return root;
    }

    private void swapNodes(TreeNode node)
    {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left != null)
            swapNodes(node.left);
        if(right != null)
            swapNodes(node.right);

        TreeNode temp = left;
        left = right;
        right = temp;
        node.left = left;
        node.right = right;

    }


    @Override
    public String getSolutionNotes() {
        return "Recursively Iterate the Tree Node and swap the left node with right node all the way from bottom to top";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Each Node is Visited only once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
