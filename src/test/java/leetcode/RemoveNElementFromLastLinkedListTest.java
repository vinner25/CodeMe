package leetcode;

import com.vinner.codeme.common.ListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.leetcode.RemoveNElementFromLastLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RemoveNElementFromLastLinkedListTest {

    RemoveNElementFromLastLinkedList removeNElementFromLastLinkedList = new RemoveNElementFromLastLinkedList();

    @Test
    public void removeNElement()
    {

        ListNode head = generateIntegerLinkedListFromArray(new int[]{1,2,3,4,5});
        ListNode listNode = removeNElementFromLastLinkedList.removeNthFromEnd(head,2);

        Assert.assertNull(listNode);
    }
    @Test
    public void removeNElement2()
    {

        ListNode head = generateIntegerLinkedListFromArray(new int[]{1});
        ListNode listNode = removeNElementFromLastLinkedList.removeNthFromEnd(head,1);

        Assert.assertNull(listNode);
    }

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
