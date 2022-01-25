package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

public class ConstructBinaryTreeWithPreOrderAndInOrder implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]\n" +
                "Output: [3,9,20,null,null,15,7]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: preorder = [-1], inorder = [-1]\n" +
                "Output: [-1]";
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        return buildTree(preorder, inorder, 0, inorder.length-1, 0);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart)
    {
        if(preStart >= preorder.length || inStart > inEnd)//Boundaries
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        // We will find the index of current root element in the inorder array. All the elements to left
        // of this index will be left sub tree

        for(int i=inStart; i<=inEnd; i++)
        {
            if(inorder[i] == root.val)
            {
                inIndex = i;
                break;
            }
        }
        // We pass the elements in order which will be forming the left subtree. The preStart +1 will be the left node beginning
        root.left = buildTree(preorder, inorder, inStart, inIndex-1, preStart+1);
// Now since inIndex tells where this element is in the right array, it means we have to skip elements length
        // which are definitely going to form left subtree to get hold of the next element on the right side
        // That length is inIndex - inStart + 1. So we add that left in preOrder because in preOrder traversal
        // these elements will be part of left subtree so we skip them
        root.right = buildTree(preorder, inorder, inIndex+1, inEnd, preStart + inIndex - inStart + 1);
        return root;

    }


    @Override
    public String getSolutionNotes() {
        return "The Basic foundation is on 2 principles : 1) First element of preOrder Traversal is root" +
                " The elements on left side of this element in the preOrder traversal form the left subtree" +
                "";
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
