package ctci.ds.linkedlist.problems;

import com.vinner.codeme.common.ListNode;
import com.vinner.codeme.ctci.ds.linkedlist.problems.LinkedListIntersection;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListIntersectionTest {

    LinkedListIntersection listIntersection = new LinkedListIntersection();

    @Test
    public void testListIntersection()
    {
        ListNode headA = new ListNode(4);

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);
        headB.next.next.next = new ListNode(5);
        headB.next.next.next.next = headA;

        ListNode intersection = listIntersection.getIntersectionNode2(headA, headB);
        Assert.assertEquals(4,intersection.val);

    }
}
