package ctci.ds.linkedlist.problems;

import com.vinner.codeme.ctci.ds.linkedlist.LinkedListUtil;
import com.vinner.codeme.ctci.ds.linkedlist.problems.PalindromLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class PalindromLinkedListTest{

    PalindromLinkedList palindromLinkedList = new PalindromLinkedList();

    @Test
    public void shouldTestPalindromLinkedList()
    {
        Assert.assertTrue( palindromLinkedList.isPalindrome(LinkedListUtil.generateIntegerLinkedListFromArray(new int[] {1,2,2,1})));

        Assert.assertFalse( palindromLinkedList.isPalindrome(LinkedListUtil.generateIntegerLinkedListFromArray(new int[] {1,5,2,1})));
    }

}
