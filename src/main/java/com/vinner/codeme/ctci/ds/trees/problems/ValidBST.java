package com.vinner.codeme.ctci.ds.trees.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;

public class ValidBST implements ProblemStatement {



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

    @Override
    public String getDescription() {
        return "Given a Binary Tree, verify if it is Valid BST or not";
    }

    @Override
    public String getSolutionNotes() {
        return " We create a range of min and max\n" +
                "        For the Left Node the MAX value is node's parent value and\n" +
                "        fpr Right Node, Min is Node Parent Value. This is what is called a Binary Search Tree.\n" +
                "        Other way is in a BST inOrder Traversal, the array is always a Sorted array\n" ;
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
