package com.vinner.codeme.blind75.tree;

import com.vinner.codeme.ProblemStatement;

public class BinaryTreeMaxPath implements ProblemStatement {
    @Override
    public String getDescription() {
        return "A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.\n" +
                "\n" +
                "The path sum of a path is the sum of the node's values in the path.\n" +
                "\n" +
                "Given the root of a binary tree, return the maximum path sum of any non-empty path.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3]\n" +
                "Output: 6\n" +
                "Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [-10,9,20,null,null,15,7]\n" +
                "Output: 42\n" +
                "Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.";
    }
    private int maxSum = Integer.MIN_VALUE; //Initialize Maimum Path sum to be least value
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    /*
        We will do a post order traversal  and compute value from bottom to top
    */
    private int maxSum(TreeNode node)
    {

        if(node == null) //Base case
            return 0;

        int left = Math.max(0,maxSum(node.left)); // Bound maximum that you can from left as 0 as there is no
        // benefit in adding 0 to node's value
        int right = Math.max(0,maxSum(node.right));
        maxSum = Math.max(maxSum, left+right+node.val); //We are already setting a value for max sum so in case of a negative binary tree the max sum anyhow will get set to it
        return Math.max(left,right) + node.val; //since for the above node the max can either be from all left or all right node to make path a single line
    }

    @Override
    public String getSolutionNotes() {
        return "We will perform a post oder traversal in order to get the max sum. The Solution will compare left and right max paths and set the max path accordingly" +
                " Each node will return the max path to its parent and then the parent will add them to see if it increases the max path further. " +
                "Great explanation here : https://www.youtube.com/watch?v=6cA_NDtpyz8";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we are traversing each node in the tree only once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(h) - We will make H recursive calls where h is height of the tree";
    }
}
