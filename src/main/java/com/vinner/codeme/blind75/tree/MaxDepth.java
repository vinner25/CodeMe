package com.vinner.codeme.blind75.tree;

import com.vinner.codeme.ProblemStatement;

public class MaxDepth implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return its maximum depth.\n" +
                "\n" +
                "A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [3,9,20,null,null,15,7]\n" +
                "Output: 3";
    }

    public int getDepth(TreeNode node)
    {
        if(node == null)
            return  0;
        return 1+ Math.max(getDepth(node.left) , getDepth(node.right)); //DFS approach
    }

    @Override
    public String getSolutionNotes() {
        return "The easiest solution is a DFS and recursively incrementing the depth by a as long as we reach the leaf node." +
                "\n We can DFS left and right and return  MAX depth";

    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - N is number of nodes";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)" ;
    }
}
