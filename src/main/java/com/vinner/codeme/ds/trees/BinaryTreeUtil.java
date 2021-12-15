package com.vinner.codeme.ds.trees;

public class BinaryTreeUtil {

    /**
     *                       1
     *                    2    3
     *                  4  5  6
     *
     * @return
     */
    public static BinaryTreeNode<Integer> generateIntegerBinaryTree(){

        BinaryTreeNode<Integer> binaryTreeNode = new BinaryTreeNode<>();

        binaryTreeNode.setValue(1);

        BinaryTreeNode<Integer> level1Left = new BinaryTreeNode<>();
        level1Left.setValue(2);

        BinaryTreeNode<Integer> level1right = new BinaryTreeNode<>();
        level1right.setValue(3);

        BinaryTreeNode<Integer> level2Left_left = new BinaryTreeNode<>();
        level2Left_left.setValue(4);

        BinaryTreeNode<Integer> level2Left_right= new BinaryTreeNode<>();
        level2Left_right.setValue(5);

        BinaryTreeNode<Integer> level2right_left = new BinaryTreeNode<>();
        level2right_left.setValue(6);



        level1Left.setLeftNode(level2Left_left);
        level1Left.setRightNode(level2Left_right);

        level1right.setLeftNode(level2right_left);

        binaryTreeNode.setLeftNode(level1Left);
        binaryTreeNode.setRightNode(level1right);
        return binaryTreeNode;

    }
}
