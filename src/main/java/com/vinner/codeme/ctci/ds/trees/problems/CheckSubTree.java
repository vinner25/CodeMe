package com.vinner.codeme.ctci.ds.trees.problems;

import com.vinner.codeme.ProblemStatement;

public class CheckSubTree implements ProblemStatement {
    @Override
    public String getDescription() {
       return "Given two TreeNode, check if the second Tree is the subTree of the first";
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) //Null is Subtree of all tree
            return true;
        return isEqual(root, subRoot);

    }

    private boolean isEqual(TreeNode t1, TreeNode t2)
    {
        if(t1 == null) // if Tree T1 has reached end
            return false;
        else if(t1.val == t2.val && matchTree(t1,t2)) // Only if Node elemt value match and rest of tree also match
            return true;
        else
            return isEqual(t1.left, t2) || isEqual(t1.right, t2); // if no match we keep digging towards both nodes


    }

    private boolean matchTree(TreeNode t1, TreeNode t2)
    {
        if(t1 == null && t2 == null) //Both Tree reached end
            return true;
        else if(t1 == null || t2 == null) //One of the tree ie ended
            return false;
        else if(t1.val != t2.val) //value does not match
            return false;
        else //Keep comparing left to left and right to right of subtree
            return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);

    }


    @Override
    public String getSolutionNotes() {
        return "We are iterating over the Longer tree and when the node in Longer tree matches with node in smaller tree" +
                " we compare rest of tree. If still no match we dig the left and right of longer and if any of the " +
                " nodes again match , we re run the isMatch";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NM) where N is nodes in N and M is Nodes in M. If we look closely the runtime is O(N+kM) where K is the number of times we found a hit " +
                "of Node M in N Tree.Only K number of times we are iterating over M. But first case can be called as O(NM)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(Log(N) + Log(M))";
    }
}
