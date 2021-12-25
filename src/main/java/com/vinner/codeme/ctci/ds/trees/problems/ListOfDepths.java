package com.vinner.codeme.ctci.ds.trees.problems;

import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;
import com.vinner.codeme.ctci.ds.trees.BinaryTreeUtil;

import java.util.ArrayList;
import java.util.List;

/*
Given a Binary Tree, Design an algorithm, to generate Linked List at each depth
Means for Binary Tree of Depth D, you will have D Linked Lists
 */
public class ListOfDepths {

    public List<List<Integer>> generateListOfDepths(BinaryTreeNode root)
    {
        List<List<Integer>> listOfDepths = new ArrayList<>();

        preOrderTraversal(root,listOfDepths,1);


        return  listOfDepths;


    }

    /**
     * We can do a Pre Order Traversal here . All we need to know is what level we are at.
     * This is more of a DFS search
     *
     * Time Complexity : O(N) -> Number of Nodes
     * Space Complexity : O(N) : Returns O(N) of Data
     * @param node
     * @param listOfDepths
     * @param currentDepth
     */
    private void preOrderTraversal(BinaryTreeNode<Integer> node, List<List<Integer>> listOfDepths, int currentDepth)
    {
        if(node != null)
        {
            List<Integer> depthList;
            if(listOfDepths.size() >= (currentDepth)) {
                depthList = listOfDepths.get(currentDepth-1);
            }
            else {
                depthList = new ArrayList<>();
                listOfDepths.add(depthList);
            }
            depthList.add(node.getValue());
            preOrderTraversal(node.getLeftNode(),listOfDepths, currentDepth+1 );
            preOrderTraversal(node.getRightNode(),listOfDepths,currentDepth+1);

        }
    }


    public static  void main(String args[])
    {
        ListOfDepths listOfDepths = new ListOfDepths();
        BinaryTreeNode<Integer> root = BinaryTreeUtil.generateIntegerBinaryTree();
        System.out.println(listOfDepths.generateListOfDepths(root));
    }

}

