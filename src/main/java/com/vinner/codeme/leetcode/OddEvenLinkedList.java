package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.common.ListNode;

public class OddEvenLinkedList implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.\n" +
                "\n" +
                "The first node is considered odd, and the second node is even, and so on.\n" +
                "\n" +
                "Note that the relative order inside both the even and odd groups should remain as it was in the input.\n" +
                "\n" +
                "You must solve the problem in O(1) extra space complexity and O(n) time complexity.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: head = [1,2,3,4,5]\n" +
                "Output: [1,3,5,2,4]\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: head = [2,1,3,5,6,4,7]\n" +
                "Output: [2,3,6,7,1,5,4]\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "n == number of nodes in the linked list\n" +
                "0 <= n <= 104\n" +
                "-106 <= Node.val <= 106";
    }
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while(p2 != null && p2.next != null)
        {
            ListNode temp = p2.next.next;
            ListNode next = p1.next;
            p1.next = p2.next;
            p1.next.next = next;
            p2.next  = temp;
            p1 = p1.next;
            p2= p2.next;

        }
        return head;
    }

    @Override
    public String getSolutionNotes() {
        return "We Will use Two Pointers to make the changes are arrange elements while traversing";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
