package com.vinner.codeme.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*
     Iterative Approach using BFS
     */
    public int maxDepth(TreeNode root) {

        if(root == null )
            return 0;

        Map<TreeNode,Integer> valueToLevelMap = new HashMap<>();
        valueToLevelMap.put(root, 1);
        Queue<TreeNode> myQ = new LinkedList<>();
        myQ.add(root);
        int depth = 1;
        while(!myQ.isEmpty())
        {
            TreeNode element = myQ.poll();
            int currentLevel = valueToLevelMap.get(element);
            boolean hasChild = false;
            if(element.left != null  )
            {
                valueToLevelMap.put(element.left,currentLevel+1 );
                hasChild=true;
                myQ.add(element.left);
            }

            if(element.right != null)
            {
                valueToLevelMap.put(element.right,currentLevel+1 );
                hasChild=true;
                myQ.add(element.right);
            }
            if( hasChild)
                depth = currentLevel+1;
            else
                depth =  currentLevel;
        }
        return depth;
    }

    public int getDepthRecursion(TreeNode node)
    {
        if(node == null)
            return  0;
        else
            return 1 + Math.max(getDepthRecursion(node.left), getDepthRecursion(node.right));
    }
}
