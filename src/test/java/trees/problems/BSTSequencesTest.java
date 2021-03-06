package trees.problems;

import com.vinner.codeme.ctci.ds.trees.problems.BSTSequences;
import com.vinner.codeme.ctci.ds.trees.problems.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequencesTest {

    BSTSequences bstSequences = new BSTSequences();

    @Test
    public void testBSTSequences()
    {
        ArrayList<LinkedList<Integer>> allNode = bstSequences.allSequences(getBinarySearchTree());
        Assert.assertNotNull(allNode);
    }

    private TreeNode getBinarySearchTree()
    {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 2;

        TreeNode leftNode = new TreeNode();
        treeNode.left = leftNode;


        TreeNode rightNode = new TreeNode();
        treeNode.right = rightNode;

        return treeNode;


    }
}
