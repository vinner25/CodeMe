package com.vinner.codeme.blind75.tree;

import com.vinner.codeme.ProblemStatement;

import java.util.*;

public class BinaryTreeTraversal implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [3,9,20,null,null,15,7]\n" +
                "Output: [[3],[9,20],[15,7]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [1]\n" +
                "Output: [[1]]";
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            List<Integer> sub = new ArrayList<>();
            int n = q.size();
            for(int i = 0; i<n; i++)
            {
                TreeNode node = q.poll();
                sub.add(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);

            }
            res.add(sub);
        }
        return res;

    }
    public List<List<Integer>> levelOrderRecursion(TreeNode root) {

        Map<Integer,List<Integer>> valueMap = new HashMap<>();
        traverseTree(root, 1, valueMap);
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(valueMap.values());
        return res;

    }

    private void traverseTree(TreeNode node, int level, Map<Integer,List<Integer>> valueMap)
    {
        if(node != null)
        {
            List<Integer> list;
            if(valueMap.containsKey(level))
                list = valueMap.get(level);
            else
                list = new ArrayList<>();
            list.add(node.val);
            valueMap.put(level, list);
            traverseTree(node.left, level+1, valueMap);
            traverseTree(node.right, level+1, valueMap);
        }
    }


    @Override
    public String getSolutionNotes() {
        return "There are two ways to solve this problem. One Way is we use recursion as the tree opens two stacks (left and right), therefore runtime is high O(2^n). " +
                "Other way out is we use BFS, and at each level we empty the complete queue and add it in the list. We add the children to the queue to be " +
                "picked in next iteration ";
    }

    @Override
    public String getTimeComplexity() {
        return "BFS approach takes O(n) as each elements is touched once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
