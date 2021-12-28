package com.vinner.codeme.blind75.linkedlist;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.common.ListNode;

public class ReverseLinkedList implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the head of a singly linked list, reverse the list, and return the reversed list.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: head = [1,2,3,4,5]\n" +
                "Output: [5,4,3,2,1]";
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode reverse = head;
        ListNode ptr = head.next;
        reverse.next = null;
        while(ptr != null)
        {
            ListNode currentNode = ptr;
            ptr = ptr.next; //We have to set Pointer before to next Node as in next step we are resetting next of current pointer. If
            // we do not set the ptr before ,we will lose the currentnode;
            currentNode.next = reverse;
            reverse = currentNode;

        }
        return reverse;
    }

    @Override
    public String getSolutionNotes() {
        return "Simply iterate from the head and start adding elements in reverese";
    }

    @Override
    public String getTimeComplexity() {
        return "O(N)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
