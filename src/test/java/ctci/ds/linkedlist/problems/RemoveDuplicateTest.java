package ctci.ds.linkedlist.problems;

import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ctci.ds.linkedlist.problems.RemoveDuplicate;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateTest {

    private RemoveDuplicate removeDuplicate = new RemoveDuplicate();

    @Test
    public void testRemoveDuplicatesWithBuffer()
    {
        LinkedListNode<Integer> linkedListNode = LinkedListUtil.generateIntegerLinkedListFromArray(new int[]{1,4,5,1,4,2,5});
        LinkedListNode<Integer> duplicatesRemoved = removeDuplicate.removeDups(linkedListNode);
        Assert.assertEquals(4, LinkedListUtil.getSizeOfLinkedList(duplicatesRemoved));
    }


    @Test
    public void testRemoveDuplicatesWithoutBuffer()
    {
        LinkedListNode<Integer> linkedListNode = LinkedListUtil.generateIntegerLinkedListFromArray(new int[]{1,4,5,1,4,2,5});
        LinkedListNode<Integer> duplicatesRemoved = removeDuplicate.removeDupsWithoutBuffer(linkedListNode);
        Assert.assertEquals(4, LinkedListUtil.getSizeOfLinkedList(duplicatesRemoved));
    }
}
