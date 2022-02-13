package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;

public class LruCache implements ProblemStatement {

    Map<Integer,ListNode> cachedData = new HashMap<>();
    ListNode tail = new ListNode(); //The Most LRU element stays at end of doubly Linked list
    ListNode head = new ListNode();
    int capacity;

    public LruCache(int capacity) {

        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cachedData.containsKey(key)) //Key already exists
        {
            addLRUElement(key);
            return cachedData.get(key).val;
        }
        else
            return -1;


    }

    public void put(int key, int value) {

        if(cachedData.containsKey(key)) //Key already exists
        {
            addLRUElement(key);
            ListNode node = cachedData.get(key);
            node.val = value; // Update the value
        }
        else
        {
            if(capacity  == cachedData.keySet().size())
            {
                //Evict from Head
                ListNode nodeToEvict = head.next;
                head.next = nodeToEvict.next;
                nodeToEvict.next.prev = head;
                cachedData.remove(nodeToEvict.key);
            }

            ListNode newNode = new ListNode();
            newNode.val = value;
            newNode.key = key;
            cachedData.put(key,newNode);
            setLRUElement(newNode);

        }


    }

    private void addLRUElement(int key)
    {
        ListNode node = cachedData.get(key);
        node.prev.next = node.next;
        node.next.prev  = node.prev;
        setLRUElement(node);
    }

    private void setLRUElement(ListNode node)
    {
        //Most LRU goes at the TAIL of the node
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    @Override
    public String getDescription() {
        return "Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.\n" +
                "\n" +
                "Implement the LRUCache class:\n" +
                "\n" +
                "LRUCache(int capacity) Initialize the LRU cache with positive size capacity.\n" +
                "int get(int key) Return the value of the key if the key exists, otherwise return -1.\n" +
                "void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.\n" +
                "The functions get and put must each run in O(1) average time complexity.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input\n" +
                "[\"LRUCache\", \"put\", \"put\", \"get\", \"put\", \"get\", \"put\", \"get\", \"get\", \"get\"]\n" +
                "[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]\n" +
                "Output\n" +
                "[null, null, null, 1, null, -1, null, -1, 3, 4]\n" +
                "\n" +
                "Explanation\n" +
                "LRUCache lRUCache = new LRUCache(2);\n" +
                "lRUCache.put(1, 1); // cache is {1=1}\n" +
                "lRUCache.put(2, 2); // cache is {1=1, 2=2}\n" +
                "lRUCache.get(1);    // return 1\n" +
                "lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}\n" +
                "lRUCache.get(2);    // returns -1 (not found)\n" +
                "lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}\n" +
                "lRUCache.get(1);    // return -1 (not found)\n" +
                "lRUCache.get(3);    // return 3\n" +
                "lRUCache.get(4);    // return 4\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= capacity <= 3000\n" +
                "0 <= key <= 104\n" +
                "0 <= value <= 105\n" +
                "At most 2 * 105 calls will be made to get and put.";
    }

    @Override
    public String getSolutionNotes() {
        return "We will use a HashTable of ListNode for O(1). The oldest accessed element will be at the head of doubly linked list" +
                "and LRU will be at the tail of linked list";
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        int key;

    }

}
