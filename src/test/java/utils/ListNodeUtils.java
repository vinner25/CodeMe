package utils;

import com.vinner.codeme.common.ListNode;

public class ListNodeUtils {

    public static ListNode generateIntegerLinkedListFromArray(int[] arr)
    {
        ListNode head = null;
        ListNode previousNode = null;
        for(int i: arr)
        {
            if(head == null) {
                head = new ListNode(i);
                previousNode = head;
            }
            else
            {
                ListNode newNode = new ListNode(i);
                previousNode.next = newNode;
                previousNode = newNode;
            }
        }
        return head;
    }
}
