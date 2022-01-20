package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.*;

public class TreeForest implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, each node in the tree has a distinct value.\n" +
                "\n" +
                "After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).\n" +
                "\n" +
                "Return the roots of the trees in the remaining forest. You may return the result in any order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]\n" +
                "Output: [[1,2,null,4],[6],[7]]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [1,2,4,null,3], to_delete = [3]\n" +
                "Output: [[1,2,4]]";
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        if(root == null)
            return new ArrayList<>();

        if(to_delete == null || to_delete.length == 0)
            return new ArrayList<>(Arrays.asList(root));

        Set<Integer> nodesToDelete = new HashSet<>();

        for(int del : to_delete)
            nodesToDelete.add(del);
        List<TreeNode> res = new ArrayList<>();

        addToList(root, res,nodesToDelete);
        return res;

    }

    //BFS Approach
    private void addToList(TreeNode root, List<TreeNode> res, Set<Integer> nodesToDelete )
    {
        if(root == null)
            return;

        TreeNode subTree = root;

        Queue<TreeNode[]> q = new LinkedList<>();
        q.add(new TreeNode[]{root, null}); //TreeNode[] is for Node and its Parent
        while(!q.isEmpty())
        {
            TreeNode[] nodes = q.poll();

            TreeNode node = nodes[0];

            if(nodesToDelete.contains(node.val))
            {
                TreeNode left = node.left;
                TreeNode right = node.right;
                TreeNode parentNode = nodes[1];
                if(parentNode != null)
                {
                    if(parentNode.left == node)
                        parentNode.left = null;
                    else
                        parentNode.right = null;
                }
                else
                {
                    subTree = null; //Means No parent , root is being removed
                }
                addToList(left, res, nodesToDelete); //Left is separate Tree
                addToList(right, res , nodesToDelete); //Right is Separate Tree
            }
            else
            {
                if(node.left != null)  q.add(new TreeNode[]{node.left , node});
                if(node.right != null)  q.add(new TreeNode[]{node.right , node});
            }
        }
        if(null != subTree)
            res.add(subTree);
    }

    /** DFS Approach
     *  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
     *
     *         if(root == null)
     *             return new ArrayList<>();
     *
     *         if(to_delete == null || to_delete.length == 0)
     *             return new ArrayList<>(Arrays.asList(root));
     *
     *         Set<Integer> nodesToDelete = new HashSet<>();
     *
     *         for(int del : to_delete)
     *             nodesToDelete.add(del);
     *         List<TreeNode> res = new ArrayList<>();
     *
     *         removeNode(root, res,nodesToDelete);
     *        if(!nodesToDelete.contains(root.val))
     *        {
     *            res.add(root);
     *
     *        }
     *         return res;
     *     }
     *
     *     private TreeNode removeNode(TreeNode node, List<TreeNode> res, Set<Integer> nodesToDelete )
     *     {
     *         if(node == null)
     *             return null;
     *
     *         node.left = removeNode(node.left, res , nodesToDelete);
     *         node.right = removeNode(node.right, res, nodesToDelete);
     *
     *         if(nodesToDelete.contains(node.val))
     *         {
     *             if(node.left != null)
     *                 res.add(node.left);
     *
     *             if(node.right != null)
     *                 res.add(node.right);
     *             return null;
     *         }
     *         return node;
     *
     *
     *     }
     * @return
     */
    @Override
    public String getSolutionNotes() {
        return "We can either solve this problem using DFS approach or BFS approach. DFS approach is little better as it takes " +
                " less lines of code and easy to implement. In DFS approach we are iterating towards the very end of the tree and while coming up if we see any of the " +
                " node is to be removed. We add its left and right to result set and return null to parent call which removes it inclusively. " +
                " BFS approach is little complex as we are removing manually";
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
