package com.vinner.codeme.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 A valid BST is defined as follows:
 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 Example 1:
 Input: root = [2,1,3]
 Output: true
 Example 2:
 Input: root = [5,1,4,null,null,3,6]
 Output: false
 Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Iterative Approach
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        //InOrder Traversal - The Array should be already Sorted
        List<Integer> arr = new ArrayList<>();
        inOrderTraversal(root,arr);
        int previousValue = arr.get(0);
        for(int i=1; i< arr.size() ; i++ )
        {
            if(previousValue >= arr.get(i))
                return false;
            previousValue =  arr.get(i);

        }
        return true;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> arr)
    {
        if(node != null)
        {
            inOrderTraversal(node.left, arr);
            arr.add(node.val);
            inOrderTraversal(node.right, arr);
        }
    }

    //Recursive Approach
    // Since whe have to carry on the comparisons at the root level, therefore we have to maintain a range
    public boolean isValidBSTRecursive(TreeNode root)
    {
        if(root == null )
            return false;
        return  isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max)
    {
        if(node == null)
            return  true;

        if(node.val <= min || node.val >= max)
            return false;

        return  isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }



}
