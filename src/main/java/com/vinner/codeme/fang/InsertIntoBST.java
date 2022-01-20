package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.*;

public class InsertIntoBST implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.\n" +
                "\n" +
                "Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [4,2,7,1,3], val = 5\n" +
                "Output: [4,2,7,1,3,5]\n" +
                "Explanation: Another accepted tree is:\n" +
                "\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [40,20,60,10,30,50,70], val = 25\n" +
                "Output: [40,20,60,10,30,50,70,null,null,25]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5\n" +
                "Output: [4,2,7,1,3,5]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree will be in the range [0, 104].\n" +
                "-108 <= Node.val <= 108\n" +
                "All the values Node.val are unique.\n" +
                "-108 <= val <= 108\n" +
                "It's guaranteed that val does not exist in the original BST.";
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null)
            return new TreeNode(val);


        List<Integer> values = new ArrayList<>();
        Map<Integer,TreeNode> map = new HashMap<>();
        traverseBST(root, values, map);
        values.add(val);
        Collections.sort(values); //Since in Binary Search Tree the Inorder Traversal is always sorted

        int leftNodeIndex = -1;
        for(int i=0 ; i< values.size(); i++)
        {
            if(values.get(i) == val)
            {
                leftNodeIndex = i-1;
                break;
            }
        }
        TreeNode newNode = new TreeNode(val);
        if(leftNodeIndex != -1) //Means inserted before , then insert as it is now right of leftNode
        {

            TreeNode leftNode = map.get(values.get(leftNodeIndex));

            newNode.right = leftNode.right;
            leftNode.right = newNode;

        }else //New Val is less than root, add at left mode
        {

            addRootToLeftMost(root, newNode);

        }

        return root;

    }

    private void addRootToLeftMost(TreeNode node, TreeNode newNode)
    {
        if(node.left == null)
        {
            node.left = newNode;
            return;
        }
        addRootToLeftMost(node.left, newNode);
    }


    private void traverseBST(TreeNode node, List<Integer> values, Map<Integer, TreeNode> treeNodeMap)
    {
        if(node == null)
            return;

        traverseBST(node.left, values, treeNodeMap);
        values.add(node.val);
        treeNodeMap.put(node.val, node);
        traverseBST(node.right,values, treeNodeMap);
    }
    @Override
    public String getSolutionNotes() {
        return "We maintain a List of values BST has and a Map of Node corresponding to each value. Then we insert " +
                "the val given in the list. If val is between the list after insert and sort, we insert the newNode " +
                "just at the right of leftNode of position where it is in array. Else if it is less than root, we " +
                "can insert the new node as the left most node of left side of tree . Return root";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)+O(nLogN) - Traversal and Sorting";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) + O(n) -> O(2n) - > O(n) for List and Map";
    }
}
