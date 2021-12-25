package com.vinner.codeme.ctci.ds.linkedlist;

public class LinkedListUtil {
    /*
     * Generate Linked List like below:
     *  1-> 4 -> 5-> 16 -> 3 -> 7 -> 6
     */
    public static LinkedListNode<Integer> generateIntegerLinkedList()
    {
        int arr[] = new int[]{1,4,5,16,3,7,6};
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> previousNode = null;
        for(int i: arr)
        {
            if(head == null) {
                head = new LinkedListNode<>(i);
                previousNode = head;
            }
            else
            {
                LinkedListNode<Integer> newNode = new LinkedListNode<>(i);
                previousNode.setNext(newNode);
                previousNode = newNode;
            }
        }
        return head;
    }

    /*
     * Generate Linked List like based on the array provided
     */
    public static LinkedListNode<Integer> generateIntegerLinkedListFromArray(int[] arr)
    {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> previousNode = null;
        for(int i: arr)
        {
            if(head == null) {
                head = new LinkedListNode<>(i);
                previousNode = head;
            }
            else
            {
                LinkedListNode<Integer> newNode = new LinkedListNode<>(i);
                previousNode.setNext(newNode);
                previousNode = newNode;
            }
        }
        return head;
    }

    public  static int getSizeOfLinkedList(LinkedListNode head)
    {
        if(head == null)
            return 0;
        int size = 1;
        LinkedListNode currentNode = head;
        while(currentNode.getNext() != null)
        {
            size++;
            currentNode = currentNode.getNext();
        }
        return  size;
    }
}
