package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.common.ListNode;

public class RemoveNElementFromLastLinkedList implements ProblemStatement {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head;
        ListNode p2 = head;

        for(int i=0 ; i<n; i++)
        {
            if(p1== null) //Means We Overflow and K is greater than size of List
                return null;
            p1 = p1.next;
        }

        //Now P1 is at K items from start . Now if we start P2 then when P1 reaches end P2 will at the Kth element from last and we will remove that shit
        if(p1 == null) //If Elemt to remove is the first element of the linked list
        {
            head = head.next;
        }
        else
        {
            while(p1.next != null)
            {
                p1= p1.next;
                p2=p2.next;


            }
            p2.next = p2.next.next;
        }
        return head;
    }

    @Override
    public String getDescription() {
        return "Given the head of a linked list, remove the nth node from the end of the list and return its head.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: head = [1,2,3,4,5], n = 2\n" +
                "Output: [1,2,3,5]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: head = [1], n = 1\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: head = [1,2], n = 1\n" +
                "Output: [1]";
    }

    @Override
    public String getSolutionNotes() {
        return "We Traverse the list using two pointers. One pointer first traverse upto N elements and then the next pointers starts." +
                " If first pointer reaches end of list , it means first element of linked list has to be removed" +
                " Else we iterate till next pointer has no next and when it reaches last , second pointer is one step before the N element" +
                " At this time we remove the next element" +
                "";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - we might have to traverse the complete list if element to remove is in between or last element of list";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
