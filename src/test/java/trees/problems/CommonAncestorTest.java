package trees.problems;

import com.vinner.codeme.ctci.ds.trees.BinaryTreeNode;
import com.vinner.codeme.ctci.ds.trees.problems.CommonAncestor;
import org.junit.Assert;
import org.junit.Test;

public class CommonAncestorTest {

    /**
     *                        15
     *                    10    18
     *                  4  11  16
     *
     * @return
     */
    CommonAncestor commonAncestor = new CommonAncestor();
    @Test
    public void findCommonAncestor()
    {

        BinaryTreeNode<Integer> binaryTreeNode = new BinaryTreeNode<>();
        binaryTreeNode.setValue(15);

        BinaryTreeNode<Integer> level1Left = new BinaryTreeNode<>();
        level1Left.setValue(10);

        BinaryTreeNode<Integer> level1right = new BinaryTreeNode<>();
        level1right.setValue(18);

        BinaryTreeNode<Integer> level2Left_left = new BinaryTreeNode<>();
        level2Left_left.setValue(4);

        BinaryTreeNode<Integer> level2Left_right= new BinaryTreeNode<>();
        level2Left_right.setValue(11);

        BinaryTreeNode<Integer> level2right_left = new BinaryTreeNode<>();
        level2right_left.setValue(16);
        level1Left.setLeftNode(level2Left_left);
        level1Left.setRightNode(level2Left_right);
        level1right.setLeftNode(level2right_left);

        binaryTreeNode.setLeftNode(level1Left);
        binaryTreeNode.setRightNode(level1right);


        BinaryTreeNode commonNode1 = commonAncestor.findCommonAncestor(binaryTreeNode, level2Left_left,level2Left_right);
        Assert.assertEquals(10, commonNode1.getValue());


        BinaryTreeNode commonNode2 = commonAncestor.findCommonAncestor(binaryTreeNode, level2Left_left,level1right);
        Assert.assertEquals(15, commonNode2.getValue());
    }
}
