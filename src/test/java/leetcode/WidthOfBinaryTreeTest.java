package leetcode;

import com.vinner.codeme.blind75.tree.TreeNode;
import com.vinner.codeme.leetcode.WidthOfBinaryTree;
import org.junit.Test;
import utils.TreeNodeUtils;

public class WidthOfBinaryTreeTest {

    WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();

    @Test
    public void testWidthOfBinaryTree()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
      //  TreeNode treeNode = TreeNodeUtils.generateTreefromArray(new Integer[]{1,3,2,5,null,null,9,6,null,null,7});
        int width = widthOfBinaryTree.widthOfBinaryTree(root);
    }
}
