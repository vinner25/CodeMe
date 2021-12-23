package com.vinner.codeme.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Implement an algorithm to Remove Duplicate items from an unsorted singly linked list." +
                " \n Follow Up" +
                " \n How to remove if there is no extra buffer available?" ;
    }

    @Override
    public String getSolutionNotes() {
        return null;
    }

    /*
        Iterate over on eelement at a time and maintain a Set of visited values
        If Dup found remove the dup node
        Time Complexity : O(n)
        Space Complexity : O(n)
     */
    public LinkedListNode<Integer> removeDups(LinkedListNode<Integer> head)
    {
        if(head == null) //Nothing to remove
            return  null;
        Set<Integer> found = new HashSet<>();
        found.add(head.getValue());
        LinkedListNode<Integer> currentNode = head;
        while(currentNode!= null && currentNode.getNext() != null)
        {
            int currentValNext = currentNode.getNext().getValue();
            if(found.contains(currentValNext))
            {
                currentNode.setNext(currentNode.getNext().getNext());
            }
            else
            {
                found.add(currentValNext);
                currentNode = currentNode.getNext();
            }
        }
        return  head;
    }


    public LinkedListNode<Integer> removeDupsWithoutBuffer(LinkedListNode<Integer> head)
    {
        if(head == null) //Nothing to remove
            return  null;
        LinkedListNode<Integer> currentNode = head;
        while(currentNode!= null )
        {
            LinkedListNode<Integer> nextNode = currentNode.getNext();
            LinkedListNode<Integer> previousNode = currentNode.getNext();
            while(nextNode != null)
            {
                if(nextNode.getValue() == currentNode.getValue())//Means it is a duplicate node
                {
                    previousNode.setNext(nextNode.getNext());

                }
                previousNode = nextNode;
                nextNode = nextNode.getNext();
            }
            currentNode = currentNode.getNext();
        }
        return  head;
    }



}
