package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class BinaryTreeInorderTraversalIterative implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return the inorder traversal of its nodes' values iteratively.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,null,2,3]\n" +
                "Output: [1,3,2]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: root = [1]\n" +
                "Output: [1]\n" +
                " ";
    }

    @Override
    public String getSolutionNotes() {
        return "The Obvious solution while replacing recursion with iteration is use of stacks. We will recurse using stack by following algo: " +
                "1) Add root to stack" +
                "2) Add left of CurrentNode till it is null"+
                "3) Print first element from stack (POP)" +
                "4) Check if current element has a right then add it to stack " +
                "5) Add all the left of right element while it is null" +
                "6) Repeat step 3";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we are touching each element only once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for stack of N elements";
    }
}
