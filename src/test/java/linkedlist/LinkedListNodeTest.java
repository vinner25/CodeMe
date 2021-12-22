package linkedlist;

import com.vinner.codeme.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ds.linkedlist.LinkedListUtil;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListNodeTest {

    @Test
    public void testLinkedListAddToHead()
    {
        LinkedListNode<Integer> head = LinkedListUtil.generateIntegerLinkedList();
        Assert.assertEquals(1, (int)head.getValue());
        head = head.addNodeToHead(255);
        Assert.assertEquals(255, (int)head.getValue());

    }

    @Test
    public void testLinkedListAddToTail()
    {
        LinkedListNode<Integer> head = LinkedListUtil.generateIntegerLinkedList();
        Assert.assertEquals(1, (int)head.getValue());
        head= head.addNodeToTail(255);
        Assert.assertEquals(1, (int)head.getValue());

    }


    @Test
    public void testLinkedListRemoveHead()
    {
        LinkedListNode<Integer> head = LinkedListUtil.generateIntegerLinkedList();
        Assert.assertEquals(1, (int)head.getValue());
        head= head.removeElementFromHead();
        Assert.assertEquals(4, (int)head.getValue());

    }

    @Test
    public void testLinkedListRemovalByValue()
    {
        LinkedListNode<Integer> head = LinkedListUtil.generateIntegerLinkedList();
        Assert.assertEquals(4, (int)head.getNext().getValue());
        head= head.removeElementByValue(4); //Remove Second Element which is 4
        Assert.assertEquals(5, (int)head.getNext().getValue());
    }
}
