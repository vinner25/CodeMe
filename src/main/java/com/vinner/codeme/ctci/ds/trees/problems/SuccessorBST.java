package com.vinner.codeme.ctci.ds.trees.problems;

/**
 *  Given node of Binary Search Tree, find the next Successor in InOrder Traversal. For this Question that the node knows its parent.
 *
 */
public class SuccessorBST{

    static class Tree{
        int value;
        Tree left;
        Tree right;
        Tree parent;

    }

    /**
     * We know that in a BST the InOrder Traversal returns a sorted Array. So we can use that but for that we have to traverse
     * the complete tree of N Nodes which will yield Time Complexity of O(n). then in the array find the next element after node we value we are inetersetd in
     *
     * Other way round is , we know in a BST, the next element can either be the Left most element of the right subtree or
     * the parent of the current node . This will have Time Complexity of O(H) depending on the node we are looking in which will definitely
     * be less than O(n).
     * @param node
     * @return
     */
    public Tree getSuccessor(Tree node)
    {

        // Next Successor can either be on right side or be the parent since Left is already traversed in InOrder Traversal
        if(node.right != null) // if Right child is there first check for next node in right because the next greatest element will be on left child
        {
            return getSuccessforFromRight(node.right);
        }
        else if(node.parent != null) //If Parent is not null look for value greater than this value in parent since it will be the successor
        {
            return getSuccessforFromParent(node.parent, node.value);
        }
        else
            return null;

    }

    private Tree getSuccessforFromParent(Tree b , int value)
    {
        if(b==null)
            return null;

        else if(b.value > value)
            return b;

        else
            return getSuccessforFromParent(b.parent, value);



    }

    private Tree getSuccessforFromRight(Tree b )
    {

        if(b == null)
            return null;
        else //Check for Min only on left child since RIGHT be greater than this node as it is BST
        {
            Tree successorLeftMostRight = getSuccessforFromRight(b.left);
            if(successorLeftMostRight == null)
                return b;
            else
                return b.value > successorLeftMostRight.value ? successorLeftMostRight : b;

        }

    }

    public static  void main(String args[])
    {
        Tree root = new Tree();
        root.value = 18;


        Tree secondLeft = new Tree();
        secondLeft.value = 10;


        Tree secondRight = new Tree();
        secondRight.value = 25;

        Tree secondLeft_left = new Tree();
        secondLeft_left.value = 6;


        Tree secondLeft_right= new Tree();
        secondLeft_right.value = 11;



        Tree secondLeft_left_right = new Tree();
        secondLeft_left_right.value = 7;

        Tree secondLeft_right_right= new Tree();
        secondLeft_right_right.value = 12;



        Tree secondRight_left = new Tree();
        secondRight_left.value = 20;

        Tree secondRight_right= new Tree();
        secondRight_right.value = 29;


        Tree secondRight_left_right = new Tree();
        secondRight_left_right.value = 21;


        Tree secondRight_right_left = new Tree();
        secondRight_right_left.value = 28;

        root.left = secondLeft;
        root.right = secondRight;

        secondLeft.left = secondLeft_left;
        secondLeft.parent = root;
        secondLeft.right = secondLeft_right;


        secondLeft_left.right = secondLeft_left_right;
        secondLeft_left.parent = secondLeft;

        secondLeft_left_right.parent = secondLeft_left;


        secondLeft_right.right = secondLeft_right_right;

        secondLeft_right.parent = secondLeft;

        secondLeft_right_right.parent  = secondLeft_right;


        secondRight.left = secondRight_left;
        secondRight.parent =  root;

        secondRight_left.right = secondRight_left_right;
        secondRight_left_right.parent  = secondRight_left;

        secondRight.right = secondRight_right;
        secondRight_right.left = secondRight_right_left;
        secondRight_right.parent =  secondRight;
        secondRight_right_left.parent = secondRight_right;

        SuccessorBST successorBST = new SuccessorBST();
         System.out.println(successorBST.getSuccessor(secondLeft_left_right).value); //  10;

          System.out.println(successorBST.getSuccessor(secondRight).value); //  28;

        System.out.println(successorBST.getSuccessor(secondRight_right)); // Null
    }





}
