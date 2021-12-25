package linkedlist.problems;

import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ctci.ds.linkedlist.problems.DeleteNode;
import org.junit.Assert;
import org.junit.Test;

public class DeleteNodeTest {


    DeleteNode deleteNode = new DeleteNode();

    @Test
    public void testDeleteNode()
    {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        LinkedListNode<Integer> node1 = new LinkedListNode<>(2);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(3);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(4);
        LinkedListNode<Integer> tail = new LinkedListNode<>(5);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(tail);
        deleteNode.removeNode(node3);
        Assert.assertEquals(4, LinkedListUtil.getSizeOfLinkedList(head));
    }
}
