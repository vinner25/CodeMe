package fang;

import com.vinner.codeme.blind75.tree.TreeNode;
import com.vinner.codeme.fang.SerializeBinaryTree;
import org.junit.Assert;
import org.junit.Test;

public class SerializeBinaryTreeTest {

    SerializeBinaryTree sb = new SerializeBinaryTree();

    @Test
    public void testSerializeBinaryTree()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String s = sb.serialize(root);
        TreeNode treeNode = sb.deserialize(s);
        Assert.assertNotNull(treeNode);


    }
}
