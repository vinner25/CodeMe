package com.vinner.codeme.blind75.heap;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.\n" +
                "\n" +
                "Merge all the linked-lists into one sorted linked-list and return it.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: lists = [[1,4,5],[1,3,4],[2,6]]\n" +
                "Output: [1,1,2,3,4,4,5,6]\n" +
                "Explanation: The linked-lists are:\n" +
                "[\n" +
                "  1->4->5,\n" +
                "  1->3->4,\n" +
                "  2->6\n" +
                "]\n" +
                "merging them into one sorted list:\n" +
                "1->1->2->3->4->4->5->6\n" +
                "Example 2:\n" +
                "\n" +
                "Input: lists = []\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: lists = [[]]\n" +
                "Output: []";
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    //Using Priority Queue to first add elements of each of the Nodes
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(ListNode node : lists)
        {
            while(node != null)
            {
                queue.add(node.val);
                node = node.next;

            }

        }


        ListNode dummyNode = new ListNode();
        ListNode root = dummyNode;
        while(!queue.isEmpty())
        {
            ListNode newNode = new ListNode(queue.remove());
            dummyNode.next = newNode;
            dummyNode = dummyNode.next;
        }

        return root.next;
    }

    private ListNode sortLinkedList(ListNode ln)
    {
        if(ln == null )
            return new ListNode();

        ListNode root = ln;

        while(ln != null)
        {
            ListNode jn = ln.next;
            while(jn != null)
            {
                if(jn.val < ln.val) //Swap
                {
                    int temp = ln.val;
                    ln.val =  jn.val;
                    jn.val = temp;
                }
                jn = jn.next;
            }
            ln = ln.next;

        }
        return root;
    }

    // Brute Force - Iterating each Linked List and adding elements to Array -> Sorting the array and creating list out of it
    // Time Complexity : O(NLogN) -> O(N) time for iterating N nodes, O(NLogN) for Sorting and then O(N) for iterating over List to create
    // Linked List
    // Space Complexity : O(N) - > Sorting N elements takes O(N) space
    public ListNode mergeKListsBruteForce(ListNode[] lists) {

        List<Integer> elements = new ArrayList<>();

        for(ListNode listNode : lists)
        {
            while(listNode != null)
            {
                elements.add(listNode.val);
                listNode = listNode.next;
            }

        }

        ListNode root = null;
        ListNode prevNode = null;
        Collections.sort(elements);
        for(Integer mergedVal : elements)
        {
            ListNode node = new ListNode(mergedVal);
            if(root == null)
                root = node;
            if(prevNode != null)
                prevNode.next = node;

            prevNode = node;
        }
        return  root;
    }



    @Override
    public String getSolutionNotes() {
        return "We Can use a Priority Queue to store the elements in a Priority Queue. Each List is traversed first and " +
                "elements stored in the Priority queue are then removed one by one to create the linked list." +
                " As Priority Queue behaves as a heap each time we remove the head of Priority Queue , it resets the head with next minimum" +
                " value. Therefore, we always have the minimum value at the head.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogK) where K is the number of linked list. Each Pop and Insertion in heap will cost O(logK) time and we have N nodes in the final list";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N) for creating a Linked List with N nodes. Priority Queue will cost O(K) space but O(K) should be less than O(n)";
    }
}
