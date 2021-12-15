package com.vinner.codeme.ds.trees;



/**
 * Generic Binary Tree Class
 * @param <T>
 */
public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> leftNode;
    private BinaryTreeNode<T> rightNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
