package linkedlist.problems;

import com.vinner.codeme.ds.linkedlist.LinkedListNode;
import com.vinner.codeme.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ds.linkedlist.problems.NodePartition;
import org.junit.Assert;
import org.junit.Test;

public class NodePartitionTest {

    NodePartition np = new NodePartition();

    @Test
    public void testNodePartition()
    {
        LinkedListNode<Integer> linkedListNode = LinkedListUtil.generateIntegerLinkedListFromArray(new int[]{3,5,8,5,10,2,1});
        LinkedListNode partitionNode = np.partitionNode(linkedListNode,5);
        Assert.assertEquals(1, partitionNode.getValue());
        Assert.assertEquals(2, partitionNode.getNext().getValue());
        Assert.assertEquals(3, partitionNode. getNext().getNext().getValue());
        Assert.assertEquals(10, partitionNode.getNext().getNext().getNext().getValue());
    }
}
