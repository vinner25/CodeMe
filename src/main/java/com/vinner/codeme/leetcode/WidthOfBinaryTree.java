package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class WidthOfBinaryTree implements ProblemStatement {
    public int widthOfBinaryTree(TreeNode root) {

        int maxWidth = 0;

        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty())
        {
            while(!queue.isEmpty() && queue.getFirst() == null)
                queue.removeFirst();
            while(!queue.isEmpty() && queue.getLast() == null)
                queue.removeLast();
            int n = queue.size();
            maxWidth = Math.max(maxWidth, n);
            for(int i= 0 ; i<n ; i++)
            {
                TreeNode node = queue.poll();
                if(node == null )
                {
                    queue.add(null);
                    queue.add(null);
                }
                else
                {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

        }
        return maxWidth;
    }

    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return the maximum width of the given tree.\n" +
                "\n" +
                "The maximum width of a tree is the maximum width among all levels.\n" +
                "\n" +
                "The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.\n" +
                "\n" +
                "It is guaranteed that the answer will in the range of 32-bit signed integer.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,3,2,5,3,null,9]\n" +
                "Output: 4\n" +
                "Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,3,null,5,3]\n" +
                "Output: 2\n" +
                "Explanation: The maximum width existing in the third level with the length 2 (5,3).\n" +
                "Example 3:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,3,2,5]\n" +
                "Output: 2\n" +
                "Explanation: The maximum width existing in the second level with the length 2 (3,2).";
    }

    @Override
    public String getSolutionNotes() {
        return "We Will use level order Traversal and calculate the width of each level. For Nulls in between we will add null oursleves" +
                " For Trimming boundary Nulls we will use Deque";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
