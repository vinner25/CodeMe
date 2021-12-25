package com.vinner.codeme.ctci.ds.trees.traversals;

import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;

public class MyTreeTraversals{

    /**
     *  Left Node
     *  Current Node
     *  Right Node
     */
    public static <T> void inOrderTraversal(BinaryTreeNode<T> node)
    {
        if(node != null)
        {
            inOrderTraversal(node.getLeftNode());
            visitNode(node);
            inOrderTraversal(node.getRightNode());
        }

    }

    /**
     * Current Node
     *  Left Node
     *  Right Node
     */
    public static <T> void preOrderTraversal(BinaryTreeNode<T> node)
    {
        if(node != null)
        {
            visitNode(node);
            preOrderTraversal(node.getLeftNode());
            preOrderTraversal(node.getRightNode());
        }
    }

    /**
     *  Left Node
     *  Right Node
     *  Current Node
     */
    public static <T> void postOrderTraversal(BinaryTreeNode<T> node)
    {
        if(node != null)
        {
            postOrderTraversal(node.getLeftNode());
            postOrderTraversal(node.getRightNode());
            visitNode(node);
        }
    }

    public static <T> void visitNode(BinaryTreeNode<T> node)
    {
        System.out.print(node.getValue()+" ");
    }
}
