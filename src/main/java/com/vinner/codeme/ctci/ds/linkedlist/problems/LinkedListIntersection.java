package com.vinner.codeme.ctci.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.common.ListNode;

public class LinkedListIntersection implements ProblemStatement {

    @Override
    public String getDescription() {
        return "Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.";
    }

    @Override
    public String getSolutionNotes() {
        return "Two Intersecting Linked lists will have same tail. Once we see tails are same , compute differences between there lengths and start comparison once the extra nodes in longer node is skipped." +
                "Once we see same node in both lists we know this is where the intersection began";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m+n) -> m is length of list node A and N is length of node B";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }

    class Result{
        ListNode tail;
        int size;

        Result(ListNode _tail, int _size)
        {
            this.tail = _tail;
            this.size = _size;
        }


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        Result nodeATail = getTailAndSize(headA);
        Result nodeBTail = getTailAndSize(headB);

        if(nodeATail.tail != nodeBTail.tail) // If nodes are intersecting there Tail has to be same
            return null;

        ListNode longer = nodeATail.size > nodeBTail.size ? headA : headB;
        ListNode smaller = nodeATail.size < nodeBTail.size ? headA : headB;

        int diff =  Math.abs(nodeATail.size - nodeBTail.size); //We will start the comparison once the longer node has skipped the elements that are extra. After that once the node become same we know the intersecting node.
        int currentIndex = 0;

        while(longer != null)
        {
            if(currentIndex >= diff)
            {
                //Do the comparison
                if(smaller == longer)
                    return smaller;
                smaller = smaller.next;
            }
            currentIndex++;
            longer = longer.next;
        }
        return null;
    }

 // This method is an optimized method
    /*
        Lets say we have two lists A of length 3 and b of length 5
        If we combine A &  B like AB and BA , both have length 8 at 9th position both will have null anyhow
        So we create two pointers ptrA and ptrB and then iterate. once any of the pointer is null we assign it to head of another pointer .
        If there is any intersection they will cross path in between else they will meet at null
        Time Complexity : O(n+m)
        Space Complexity : O(1)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        ListNode ptrA = headA;


        ListNode ptrB = headB;


        while(ptrA != ptrB)
        {

            if(ptrA == null)
                ptrA = headB;
            else
                ptrA = ptrA.next;


            if(ptrB == null)
                ptrB = headA;
            else
                ptrB = ptrB.next;

        }
        return ptrA;


    }


    private Result getTailAndSize(ListNode node) //Find Tail of both Nodes
    {
        ListNode tail = node;
        int size = 1;
        while(tail.next != null)
        {
            size++;
            tail = tail.next;
        }

        return new Result(tail, size);

    }


}
