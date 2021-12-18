package com.vinner.codeme.ds.trees.problems;

import com.vinner.codeme.ds.trees.BinaryTreeNode;

public class ValidBST {

    /*
        We create a range of min and max
        For the Left Node the MAX value is node's parent value and
        fpr Right Node, Min is Node Parent Value. This is what is called a Binary Search Tree.
        Other way is in a BST inOrder Traversal, the array is always a Sorted array
        Time Complexity : O(log n)
        Space Complexity : O(n)

     */
    public boolean isValidBST(BinaryTreeNode<Integer> root )
    {

        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean isValidBST(BinaryTreeNode<Integer> node, long min, long max)
    {
        if(node == null)
            return  true;

        if(node.getValue() <= min || node.getValue() >= max )
            return  false;

        else
            return  isValidBST(node.getLeftNode(),min , node.getValue()) && isValidBST(node.getRightNode(), node.getValue(), max);
    }

}
