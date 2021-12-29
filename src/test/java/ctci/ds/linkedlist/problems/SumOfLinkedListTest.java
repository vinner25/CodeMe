package ctci.ds.linkedlist.problems;

import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ctci.ds.linkedlist.problems.SumOfLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SumOfLinkedListTest {

    SumOfLinkedList sumOfLinkedList = new SumOfLinkedList();

    @Test
    public void shouldTestLinkedListAddtionInReverese()
    {
        LinkedListNode<Integer> n1 = LinkedListUtil.generateIntegerLinkedListFromArray(new int[]{1,9,9,9,9,9,9,9,9,9});
        LinkedListNode<Integer> n2 = LinkedListUtil.generateIntegerLinkedListFromArray(new int[]{9});
        LinkedListNode sum = sumOfLinkedList.sumLinkedList(n1,n2);
        Assert.assertEquals(2, sum.getValue());
        Assert.assertEquals(1, sum.getNext().getValue());
        Assert.assertEquals(9, sum.getNext().getNext().getValue());
    }
}
