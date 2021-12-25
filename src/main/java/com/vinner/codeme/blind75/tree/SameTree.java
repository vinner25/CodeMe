package com.vinner.codeme.blind75.tree;

import com.vinner.codeme.ProblemStatement;

public class SameTree implements ProblemStatement {

    @Override
    public String getDescription() {
        return "Given the roots of two binary trees p and q, write a function to check if they are the same or not.\n" +
                "\n" +
                "Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: p = [1,2,3], q = [1,2,3]\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: p = [1,2], q = [1,null,2]\n" +
                "Output: false\n" +
                "Example 3:\n" +
                "\n" +
                "\n" +
                "Input: p = [1,2,1], q = [1,1,2]\n" +
                "Output: false";
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p != null && q != null)
        {
            if(p.val != q.val)
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else if(p == null && q == null)
            return true;
        else
            return false;

    }

    @Override
    public String getSolutionNotes() {
        return "Simply Iterate over each side of node of both tree and compare values. Return False if not same";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - N is Number of Nodes in both the trees.";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
