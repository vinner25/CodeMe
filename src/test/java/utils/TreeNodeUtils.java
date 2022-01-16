package utils;

import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtils {

    public static TreeNode generateTreefromArray(Integer[] arr)
    {
        TreeNode root = new TreeNode(arr[0]);

        List<TreeNode> prevNode = new ArrayList<>();

        prevNode.add(root);
        int jump = 1;
        int index = 1;
        while(index < arr.length)
        {

            List<TreeNode> newPrevNode = new ArrayList<>();
            int k = 0;

            for(int j = 0 ; j<2*jump; j = j+2)
            {
                TreeNode node= prevNode.get(k);
                if(node != null) {
                    TreeNode leftNode = arr[index] == null ? null : new TreeNode(arr[index]);
                    newPrevNode.add(leftNode);
                    node.left = leftNode;
                    if (index + 1 < arr.length) {
                        TreeNode rightNode = arr[index + 1] == null ? null : new TreeNode(arr[++index]);
                        node.right = rightNode;
                        newPrevNode.add(rightNode);
                    }
                }
                else
                {
                    newPrevNode.add(null);
                    newPrevNode.add(null);
                    j = j-2;
                }
                k++;
            }
            prevNode = newPrevNode;
            index = index + 2*jump;
            jump++;

        }
        return root;


    }
}
