package com.vinner.codeme.ctci.ds.trees.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;
import com.vinner.codeme.ctci.ds.trees.BinaryTreeUtil;

public class BalancedBinaryTree implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Write an algorithm to verify if a Binary Tree is Balanced or Not?";
    }

    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }

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



}
