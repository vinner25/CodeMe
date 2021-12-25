package com.vinner.codeme.ctci.ds.trees.problems;

import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;
import com.vinner.codeme.ctci.ds.trees.traversals.MyTreeTraversals;

/**
 *  Given a sorted array of Integers, design amn algo to create
 *  a binary search tree of minimum height
 */
public class MinimalTree {


    public BinaryTreeNode<Integer> generateBinarySearchTree(int[] arr)
    {

    return  createBinaryTreeNode(0,arr.length-1,arr);


    }

    private BinaryTreeNode<Integer> createBinaryTreeNode(int startIndex, int endIndex , int[] arr)
    {

        if(startIndex > endIndex)
            return  null;
        if(startIndex<0 || endIndex >= arr.length)
            return null;

        if(startIndex == endIndex) {
            return new BinaryTreeNode<>(arr[startIndex]);
        }

        else
        {
            int half = ((startIndex+endIndex)/2);
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(arr[half]);
            node.setLeftNode(createBinaryTreeNode(startIndex, half-1, arr));
            node.setRightNode(createBinaryTreeNode(half+1, endIndex, arr));
            return  node;
        }

    }


    public  static  void main(String args[])
    {
        int[] arr = new int[] {1,2,3,4,5};
        BinaryTreeNode<Integer> binarySearchTree = new MinimalTree().generateBinarySearchTree(arr);
        MyTreeTraversals.inOrderTraversal(binarySearchTree);

    }

}
