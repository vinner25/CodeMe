package fang;

import com.vinner.codeme.blind75.tree.TreeNode;
import com.vinner.codeme.fang.MinimumAbsoluteDiffBST;
import org.junit.Test;

public class MinimumAbsoluteDiffBSTtest {

    MinimumAbsoluteDiffBST minimumAbsoluteDiffBST  = new MinimumAbsoluteDiffBST();

    @Test
    public void testMinimumDiffBST()
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);

        int minDiff = minimumAbsoluteDiffBST.getMinimumDifference(root);


    }

}
