package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

public class MinimumAbsoluteDiffBST implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [4,2,6,1,3]\n" +
                "Output: 1\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,0,48,null,null,12,49]\n" +
                "Output: 1\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree is in the range [2, 104].\n" +
                "0 <= Node.val <= 105";
    }
    int minDiff = Integer.MAX_VALUE;
    TreeNode prevNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;


    }

    private void inOrderTraversal(TreeNode root){
        if(root == null)
            return;

        inOrderTraversal(root.left);
        if(prevNode != null)
            minDiff = Math.min(minDiff,root.val - prevNode.val);
        prevNode = root;
        inOrderTraversal(root.right);

    }
    @Override
    public String getSolutionNotes() {
        return "The Concept is that for BST the inOrderTraversal is a sorted Array. The minimum abs. diff in a sorted array is diff between consective " +
                "elements. To minimise memory consumption we are calculating diff while traversal.";
    }

    @Override
    public String getTimeComplexity() {
        return  "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
