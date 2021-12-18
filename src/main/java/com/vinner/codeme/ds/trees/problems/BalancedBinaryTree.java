package com.vinner.codeme.ds.trees.problems;

import com.vinner.codeme.ds.trees.BinaryTreeNode;
import com.vinner.codeme.ds.trees.BinaryTreeUtil;

public class BalancedBinaryTree {
class SubTreeDetails{

    private boolean balanced;
    private int height;
    SubTreeDetails(boolean balanced, int height)
    {
        this.balanced = balanced;
        this.height = height;
    }
    public boolean isBalanced() {
        return balanced;
    }

    public void setBalanced(boolean balanced) {
        this.balanced = balanced;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}


    public boolean isBalanced(BinaryTreeNode<Integer> binaryTreeNode)
    {
        SubTreeDetails subTreeDetails = checkBalanced(binaryTreeNode);
        return subTreeDetails.isBalanced();
    }

    private SubTreeDetails checkBalanced(BinaryTreeNode<Integer> node)
    {
        if(node==null)
        {
            return new SubTreeDetails(true,0);
        }
        else
        {
            SubTreeDetails leftSubTreeDetails = checkBalanced(node.getLeftNode());
            if(!leftSubTreeDetails.isBalanced())
                return new SubTreeDetails(false, 0); //If Left Sub Tree is not balanced itself, no need to iterate right
            SubTreeDetails rightSubTreeDetails = checkBalanced(node.getRightNode());
            int height = 1+ Math.max(leftSubTreeDetails.getHeight(), rightSubTreeDetails.getHeight());
            if(!leftSubTreeDetails.isBalanced() || !rightSubTreeDetails.isBalanced())
                return new SubTreeDetails(false, height);
            else
                return  new SubTreeDetails( Math.abs(leftSubTreeDetails.getHeight() - rightSubTreeDetails.getHeight()) <= 1 ? true: false, height);
        }
    }


    public static  void main(String args[])
    {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();

        BinaryTreeNode<Integer> binaryTreeNode = BinaryTreeUtil.generateIntegerBinaryTree();

        System.out.println(balancedBinaryTree.isBalanced(binaryTreeNode));
        System.out.println(balancedBinaryTree.isBalanced( BinaryTreeUtil.generateUnBalancedIntegerBinaryTree()));


    }

}
