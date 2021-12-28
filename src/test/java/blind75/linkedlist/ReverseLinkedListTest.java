package blind75.linkedlist;

import com.vinner.codeme.blind75.linkedlist.ReverseLinkedList;
import com.vinner.codeme.common.ListNode;
import common.CommonDSUtils;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListTest {

    ReverseLinkedList rv = new ReverseLinkedList();

    @Test
    public void reverseAlist()
    {
        ListNode listNode = CommonDSUtils.generateListNodeFromArray(new int[] {1,2,3,4,5});
        ListNode reverese = rv.reverseList(listNode);
        Assert.assertNotNull(reverese);


    }

}
