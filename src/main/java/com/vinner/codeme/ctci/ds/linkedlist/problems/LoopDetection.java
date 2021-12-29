package com.vinner.codeme.ctci.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.common.ListNode;

public class LoopDetection implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.\n" +
                "\n" +
                "There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.\n" +
                "\n" +
                "Do not modify the linked list.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: head = [3,2,0,-4], pos = 1\n" +
                "Output: tail connects to node index 1\n" +
                "Explanation: There is a cycle in the linked list, where tail connects to the second node.\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: head = [1,2], pos = 0\n" +
                "Output: tail connects to node index 0\n" +
                "Explanation: There is a cycle in the linked list, where tail connects to the first node.\n" +
                "Example 3:\n" +
                "\n" +
                "\n" +
                "Input: head = [1], pos = -1\n" +
                "Output: no cycle\n" +
                "Explanation: There is no cycle in the linked list.";
    }
    public ListNode detectCycle(ListNode head) {

        ListNode sp = head;
        ListNode fp = head;

        while(fp != null && fp.next != null)
        {
            fp= fp.next.next;
            sp = sp.next;

            if(fp == sp)
                break;

        }

        if(fp == null || fp.next == null )
            return null;

        sp = head;
        while(sp != fp)
        {
            sp = sp.next;
            fp= fp.next;
        }
        return sp;
    }

    @Override
    public String getSolutionNotes() {
        return "This solution is solved using two pointers and uses Floyd's algorithm. " +
                "For more details : https://www.youtube.com/watch?v=jcZtMh_jov0 (Language : Hindi)";
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
