package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.Stack;

public class FlattenTreeNode implements ProblemStatement {


    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right==null))
            return;
        Stack<TreeNode> rightTrees = new Stack<>();
        flattenTree(root, rightTrees);
    }

    private void flattenTree(TreeNode node, Stack<TreeNode> treeStack)
    {
        if(node == null)
        {
            return;
        }

        if(node.right != null)
        {
            treeStack.push(node.right);
        }

        if(node.left != null)
        {
            node.right = node.left;
            node.left = null;
            node = node.right;
            flattenTree(node, treeStack);
        }

        while(!treeStack.isEmpty())
        {
            TreeNode stackNode = treeStack.pop();
            node.right = stackNode;
            flattenTree(stackNode, treeStack);

        }




    }

    @Override
    public String getDescription() {
        return "Given the root of a binary tree, flatten the tree into a \"linked list\":\n" +
                "\n" +
                "The \"linked list\" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.\n" +
                "The \"linked list\" should be in the same order as a pre-order traversal of the binary tree.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,5,3,4,null,6]\n" +
                "Output: [1,null,2,null,3,null,4,null,5,null,6]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: root = [0]\n" +
                "Output: [0]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree is in the range [0, 2000].\n" +
                "-100 <= Node.val <= 100";
    }

    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
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
