package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.Stack;

public class KthSmallestInBST implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [3,1,4,null,2], k = 1\n" +
                "Output: 1\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: root = [5,3,6,2,4,null,null,1], k = 3\n" +
                "Output: 3\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree is n.\n" +
                "1 <= k <= n <= 104\n" +
                "0 <= Node.val <= 104\n" +
                " \n" +
                "\n";
    }
    public int kthSmallest(TreeNode root, int k) {

        int index = 0;
        Stack<TreeNode> myStack = new Stack<>();
        while(true)
        {
            while(root != null)
            {
                myStack.push(root);
                root = root.left;
            }
            root = myStack.pop();
            if(++index == k)
                return root.val;
            root = root.right;
        }
    }
    @Override
    public String getSolutionNotes() {
        return "The brute force algorithm is to do a inorder traversal of the BST which gives " +
                "a sorted array. Then find the Kth element in the sorted array." +
                "Other way is to smartely traverse the tree using an iterative approach";
    }

    @Override
    public String getTimeComplexity() {
        return "Brute Force : O(n)," +
                "Iterative approach : O(H+k) where H is the height of the tree and you have to look " +
                "for atleast K elemenets in order to find the Kth smallest";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(H) for stack containing elements as height of the tree";
    }
}
