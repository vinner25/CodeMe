package com.vinner.codeme.ctci.ds.trees.problems;

import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;
import com.vinner.codeme.ctci.ds.trees.BinaryTreeUtil;

/**
 * Implement a Function to check if Binary Tree is Balanced. A Balanced Binary Tree is such that
 * the height of sub tree of a node and the node itself never differs by 1
 */
public class CheckBalanced {
    public static class Heights{
        int leftHeight;
        int rightHeight;
    }


    public boolean isBalanced(BinaryTreeNode<Integer> root)
    {
        if(root == null)
            return false;
        Heights heights = new Heights();
        heights.leftHeight=1;
        heights.rightHeight=1;
        return  calculateHeight(root, heights, 1);
    }

    private boolean calculateHeight(BinaryTreeNode<Integer> node, Heights heights, int currentHeight)
    {
        if(node != null)
        {
            if(node.getLeftNode() != null && currentHeight == heights.leftHeight)
                heights.leftHeight++;
            if(node.getRightNode()!= null &&  currentHeight == heights.rightHeight)
                heights.rightHeight++;
            return calculateHeight(node.getLeftNode(), heights,currentHeight+1 ) &&
            calculateHeight(node.getRightNode(), heights,currentHeight+1);
        }

        if(Math.abs(heights.rightHeight-currentHeight) > 1 || Math.abs(heights.leftHeight-currentHeight) > 1)
            return false;
        return true;
    }

    public static  void main(String[] args)
    {
       // BinaryTreeNode<Integer> root = BinaryTreeUtil.generateIntegerBinaryTree();

        CheckBalanced checkBalanced = new CheckBalanced();
       // System.out.println(checkBalanced.isBalanced(root));

        BinaryTreeNode<Integer> root2 = BinaryTreeUtil.generateUnBalancedIntegerBinaryTree();

        System.out.println(checkBalanced.isBalanced(root2));
    }
}




