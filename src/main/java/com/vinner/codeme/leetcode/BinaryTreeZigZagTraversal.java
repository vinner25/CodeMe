package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.*;

public class BinaryTreeZigZagTraversal implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [3,9,20,null,null,15,7]\n" +
                "Output: [[3],[20,9],[15,7]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [1]\n" +
                "Output: [[1]]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: root = []\n" +
                "Output: []";
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> myStack = new Stack<>();
            for(int i=0 ; i<size;i++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if((level+1) % 2 == 0) //If Next level is R -> L Do Right to Left
                {
                    if(node.left != null)
                        myStack.add(node.left);
                    if(node.right != null)
                        myStack.push(node.right);
                }
                else { // L -> R
                    if(node.right != null)
                        myStack.push(node.right);
                    if(node.left != null)
                        myStack.add(node.left);
                }
            }
            result.add(list);
            while(!myStack.isEmpty())
            {
                queue.add(myStack.pop());
            }
            level++;
        }

        return result;
    }

    @Override
    public String getSolutionNotes() {
        return "We will do a level order tarversal and at each level we will decide whether to go Right to Left or Left to Right";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for Queue + O(H) for List where H is height; Stack being used are auxilary ";
    }
}
