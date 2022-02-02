package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

public class DiameterOfBinaryTree implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return the length of the diameter of the tree.\n" +
                "\n" +
                "The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.\n" +
                "\n" +
                "The length of a path between two nodes is represented by the number of edges between them.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3,4,5]\n" +
                "Output: 3\n" +
                "Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [1,2]\n" +
                "Output: 1\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree is in the range [1, 104].\n" +
                "-100 <= Node.val <= 100";
    }
    int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node)
    {
        if(node == null)
            return 0;

        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        maxLength = Math.max(leftLength+rightLength, maxLength);
        return 1+Math.max(leftLength, rightLength);
    }
    @Override
    public String getSolutionNotes() {
        return "Doing a DFS and keeping max Length at each subTree";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
