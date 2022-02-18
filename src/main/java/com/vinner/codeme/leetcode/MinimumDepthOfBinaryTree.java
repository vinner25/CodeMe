package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

public class MinimumDepthOfBinaryTree implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a binary tree, find its minimum depth.\n" +
                "\n" +
                "The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.\n" +
                "\n" +
                "Note: A leaf is a node with no children.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [3,9,20,null,null,15,7]\n" +
                "Output: 2\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [2,null,3,null,4,null,5,null,6]\n" +
                "Output: 5";
    }
    int minimumDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {

        if(root == null)
            return 0;

        dfs(root, 1);
        return minimumDepth;

    }

    private void dfs(TreeNode root, int currentDepth)
    {


        if(root.left == null && root.right == null)
        {
            minimumDepth = Math.min(minimumDepth, currentDepth);
        }

        if(currentDepth < minimumDepth) //Only Traverse Tree till you have not find the Minimum Depth
        {
            if(root.left != null)
                dfs(root.left, currentDepth+1);
            if(root.right != null)
                dfs(root.right,currentDepth+1);
        }

    }
    @Override
    public String getSolutionNotes() {
        return "This solution requires a simple DFS but the optimization catch is we only continue till we have found minimumDepth";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(h) - The Recursion stack can be equal to the height of the tree";
    }
}
