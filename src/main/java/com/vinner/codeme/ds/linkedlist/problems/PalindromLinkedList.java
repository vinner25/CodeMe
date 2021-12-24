package com.vinner.codeme.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.heap.ListNode;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

public class PalindromLinkedList implements ProblemStatement  {
    @Override
    public String getDescription() {
        return "Implement a function to check if a list is palindrome.";
    }

    public boolean isPalindrome(LinkedListNode<Integer> ln) {
        if(ln == null )
            return  false;
        LinkedListNode forwardHead = ln;
        LinkedListNode reverseHead = null;
        int size = 0;
        while(ln != null)
        {
            LinkedListNode newNode =  new LinkedListNode(ln.getValue());
            newNode.next = reverseHead;
            reverseHead = newNode;
            ln = ln.next;
            size++;
        }
        int comparisonCounter = 0;
        while(forwardHead != null && comparisonCounter <= size/2)
        {

            if(forwardHead.getValue() != reverseHead.getValue())
                return  false;

            reverseHead = reverseHead.next;
            forwardHead = forwardHead.next;
            comparisonCounter++;
        }
        return true;
    }

    @Override
    public String getSolutionNotes() {
        return "The Simplest solution is to reverse the original list and then compare each element of the reverser list with the original list" +
                "We can just compare the reversed list till half if half matches the original list , then it is palindrom ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we have to Iterate over N nodes of the linked list to compute the reverse list. Then O(n/2) for comparison of rverese list " +
                "with original list till half. So in nutshell the Time complexity is O(n).";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) since we are creating a reverse list of N nodes. We can reduce the space complexity to O(1) if we modify the original list by reversing the elements after middle in original list" +
                "and then comparising the original list before middle and after middle. In the end we can restore the original list too.";
    }
}
