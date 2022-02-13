package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the root of a binary tree, return all root-to-leaf paths in any order.\n" +
                "\n" +
                "A leaf is a node with no children.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: root = [1,2,3,null,5]\n" +
                "Output: [\"1->2->5\",\"1->3\"]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: root = [1]\n" +
                "Output: [\"1\"]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree is in the range [1, 100].\n" +
                "-100 <= Node.val <= 100";
    }
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if(root == null)
            return result;

        dfs(root, root.val+"", result);
        return result;


    }

    private void dfs(TreeNode node, String str , List<String> result)
    {
        if(node == null)
        {
            return;
        }


        if(node.left == null && node.right == null)
        {
            result.add(str);
            return;
        }

        if(node.left != null)
        {
            String newS =  str+ "->"+node.left.val;
            dfs(node.left, newS,result);
        }
        if(node.right != null)
        {
            String newS =  str+ "->"+node.right.val;
            dfs(node.right, newS,result);
        }
    }
    @Override
    public String getSolutionNotes() {
        return "Simple DFS";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(H)";
    }
}
