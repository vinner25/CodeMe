package leetcode;

import com.vinner.codeme.blind75.tree.TreeNode;
import com.vinner.codeme.leetcode.TreeForest;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TreeForestTest {

    TreeForest treeForest = new TreeForest();

    @Test
    public void checkTreeForest()
    {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;

        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        List<TreeNode> list = treeForest.delNodes(treeNode, new int[] {3,5});
        Assert.assertEquals(2, list.size());
    }
}
