package com.vinner.codeme.ctci.ds.trees;

import com.vinner.codeme.ctci.ds.trees.traversals.MyTreeTraversals;

public class TreeDriverProgram {

    public static void main(String args[])
    {
        BinaryTreeNode<Integer> node = BinaryTreeUtil.generateIntegerBinaryTree();

        System.out.println("In Order : ");
        MyTreeTraversals.inOrderTraversal(node);
        System.out.println();
        System.out.println( " Pre Order : ");
        MyTreeTraversals.preOrderTraversal(node);
        System.out.println();
        System.out.println( " Post Order : ");
        MyTreeTraversals.postOrderTraversal(node);
    }
}
