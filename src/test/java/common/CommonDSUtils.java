package common;

import com.vinner.codeme.common.ListNode;

public class CommonDSUtils {

    public static ListNode generateListNodeFromArray(int[] arr)
    {
        ListNode root= null, prevNode = null;

        for(int i : arr)
        {
            ListNode node = new ListNode(i);
            if(root==null)
                root = node;

            if(prevNode != null)
                prevNode.next = node;

            prevNode = node;
        }

        return root;

    }
}
