package trees;

import com.vinner.codeme.ds.trees.problems.ValidBST;
import org.junit.Assert;
import org.junit.Test;
import trees.util.BinaryTreeUtil;

public class ValidBSTTest {

    private ValidBST validBST = new ValidBST();

    @Test
    public void testValidBST()
    {
        Assert.assertFalse(validBST.isValidBST(BinaryTreeUtil.generateIntegerBinaryTree()));
        Assert.assertFalse(validBST.isValidBST(BinaryTreeUtil.generateUnBalancedIntegerBinaryTree()));
        Assert.assertTrue(validBST.isValidBST(BinaryTreeUtil.generateBinarySearchTree()));
    }
}
