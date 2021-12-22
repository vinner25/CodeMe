package com.vinner.codeme.ds.trees.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.trees.BinaryTreeNode;

public class CommonAncestor implements ProblemStatement {

    /*
        The Logic is We first find which side of the tree both the nodes exist
        If Node 1 exist on left and node 2 on right, then common ancestor is root
        Else if node 1 and node 2 are on same side, we recursively iterate the tree unless both the nodes are already reached or they are on differenht side
        Time Complexity : O(n) -> Iterating the tree to check side is 2N times (N for checking on one side each) , and then once we find the
        side, the tree is searched again 2n/2, 2n/4 times which adds to total complexity of O(n) times
     */
    public BinaryTreeNode findCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q)
    {
        if(root == null || p == null || q == null)
        {
            return  root;
        }
        boolean isNodePOnLeft = hasNode(root.getLeftNode(), p );
        boolean isNodeQOnLeft = hasNode(root.getLeftNode(), q );
        if(isNodePOnLeft != isNodeQOnLeft) //On Different Side
            return  root;
        BinaryTreeNode childSide = isNodePOnLeft ? root.getLeftNode() : root.getRightNode();
        return  findCommonAncestor(childSide, p , q);
    }

    private boolean hasNode(BinaryTreeNode root, BinaryTreeNode node)
    {
        if(root == null)
            return  false;
        else if(root == node)
            return  true;
        else
          return  hasNode(root.getLeftNode(), node) || hasNode(root.getRightNode(), node);
    }

    @Override
    public String getDescription() {
        return "Given a Binary Tree, Find the Common Ancestor between two nodes. Please not there is no reference to the parent node from the child nodes";
    }
}
