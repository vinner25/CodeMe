package com.vinner.codeme.ds.linkedlist;

import java.util.LinkedList;

public class LinkedListNode<T> {

    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T value)
    {
        this.value= value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    /*
     Note: This insertion operation at the head of the node takes O(1) time as we do not have to iterate through the list
     but insertion anywhere between the list of tail will take O(n) time
     */
    public LinkedListNode<T> addNodeToHead(T value)
    {
        LinkedListNode<T> newHead = new LinkedListNode<>(value);
        newHead.setNext(this);
        return  newHead;
    }

    /*
    This insertion takes O(n) total time as we have to iterate through N elements to insert the element in the end
    THE INSERT itself after iteration is taking O(1) but iterating through the list takes O(n), hence total time complexity is
    O(n).
     */
    public LinkedListNode<T> addNodeToTail(T value)
    {
        LinkedListNode<T> newNode = new LinkedListNode<>(value);
        LinkedListNode<T> head = this;
        while(head.next != null)
        {
            head = head.next;
        }
        head.next = newNode;
        return this;
    }

    /*
    This Operation takes only O(1) since we are removing from the head and we assume we are given the head of singly linked list
     */
    public LinkedListNode<T> removeElementFromHead()
    {
        LinkedListNode<T> newHead = this.next;
        this.next = null;
        return newHead;
    }

    /*
    This operation takes total time of O(n) since we have to iterate all the way till N nodes fron head and then
    do the removal which itself is just O(1).
     */
    public LinkedListNode<T> removeElementByValue(T value)
    {
        LinkedListNode<T> head = this;
        if(head.value == value) {
            LinkedListNode<T> newHead = head.next;
            head.next = null;
            return newHead;
        }
        LinkedListNode<T> currentNode = head;
        while(currentNode != null && currentNode.next != null)
        {
            if(currentNode.next.value == value)
            {
                currentNode.next =     currentNode.next.next;
                break;
            }
            currentNode = currentNode.next;
        }
        return head;
    }

}
