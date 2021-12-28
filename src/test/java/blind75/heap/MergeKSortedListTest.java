package blind75.heap;

import com.vinner.codeme.common.ListNode;
import com.vinner.codeme.blind75.heap.MergeKSortedList;
import org.junit.Assert;
import org.junit.Test;

public class MergeKSortedListTest {

    MergeKSortedList mergeKSortedList = new MergeKSortedList();

    @Test
    public void testMergeSortedList()
    {

        ListNode n1 = generateListNodeFromArray(new int[] {1,4,5});
        ListNode n2 = generateListNodeFromArray(new int[] {1,3,4});
        ListNode n3 = generateListNodeFromArray(new int[] {2,6});
        ListNode[] lists = new ListNode[]{n1,n2,n3};
        ListNode mergedNode = mergeKSortedList.mergeKLists(lists);
        Assert.assertNotNull(mergedNode);
    }


    private ListNode generateListNodeFromArray(int[] arr)
    {
        ListNode root= null, prevNode = null;

        for(int i : arr)
        {
            ListNode node = new ListNode(i);
            if(root==null)
                root = node;

            if(prevNode != null)
                prevNode.next = node;

            prevNode = node;
        }

        return root;

    }
}

