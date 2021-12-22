package com.vinner.codeme.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

public class KElementToLast implements ProblemStatement {


    @Override
    public String getDescription() {
        return "Implement an algorithm to Find Kth element to last in a singly linked list";

    }

    /*
     We will use two pointers p1 and p2
     P1 will be initialized at the Kth position from start in the list
     Then P2 will start moving till p1 reaches end of list. When P1 reaches End, p2 will be at Kth position from last
     Time Complexity : O(n)
     space Complexity : O(1)
     */
    public int findKElement(LinkedListNode<Integer> head, int k)
    {
        if(head == null || k < 0)
            throw new IllegalArgumentException("Illegal Arguments provided");

        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head;
        for(int i = 1; i<= k; i++)
        {
            if(p1 == null) //Over flow - means K is greater than size of linked list
                throw new IllegalArgumentException("K is greater than Linked List Size");
            p1= p1.getNext();
        }

        while(p1 != null)
        {
            p2 = p2.getNext();
            p1= p1.getNext();
        }

        return p2.getValue();

    }





    
}
