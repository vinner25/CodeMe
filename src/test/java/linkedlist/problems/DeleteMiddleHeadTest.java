package linkedlist.problems;

import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ctci.ds.linkedlist.problems.DeleteMiddleHead;
import org.junit.Assert;
import org.junit.Test;

public class DeleteMiddleHeadTest {

    DeleteMiddleHead deleteMiddle = new DeleteMiddleHead();

    @Test
    public void deleletMiddleNodeEvenNodes()
    {
        // Should Remove 4
        LinkedListNode<Integer> linkedListNode = LinkedListUtil.generateIntegerLinkedListFromArray(new int[] {1,3,4,5});
        deleteMiddle.removeMiddle(linkedListNode);
        int size = LinkedListUtil.getSizeOfLinkedList(linkedListNode);
        Assert.assertEquals(3, size);

    }


    @Test
    public void deleletMiddleNodeOddNodes()
    {
        //Should remove 4
        LinkedListNode<Integer> linkedListNode = LinkedListUtil.generateIntegerLinkedListFromArray(new int[] {1,3,4,5, 6});
        deleteMiddle.removeMiddle(linkedListNode);
        int size = LinkedListUtil.getSizeOfLinkedList(linkedListNode);
        Assert.assertEquals(4, size);

    }
}
