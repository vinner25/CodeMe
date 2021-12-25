package linkedlist.problems;

import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ctci.ds.linkedlist.problems.KElementToLast;
import org.junit.Assert;
import org.junit.Test;

public class KthElementFromLast {

    KElementToLast kElementToLast = new KElementToLast();
    @Test
    public void shouldFindKElementToLast()
    {
        LinkedListNode<Integer> head = LinkedListUtil.generateIntegerLinkedListFromArray(new int[] {1,4,5,2,7,3,19});
        Assert.assertEquals(7, kElementToLast.findKElement(head, 3));
        Assert.assertEquals(1, kElementToLast.findKElement(head, 7));
        Assert.assertEquals(19, kElementToLast.findKElement(head, 1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionInCaseOfOverflow()
    {
        LinkedListNode<Integer> head = LinkedListUtil.generateIntegerLinkedListFromArray(new int[] {1,4,5,2,7,3,19});
        kElementToLast.findKElement(head, 20);
    }

}
