package com.vinner.codeme.fang;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in a number stream
 *
 * Problem Statement: Design a class to efficiently find the Kth largest element in a stream of numbers. The class should have the following two things:​
 *
 * The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
 *
 * The class should expose a function add(int num) which will store the given number and return the Kth largest number.
 *
 *
 */
public class KLargest {

    private PriorityQueue<Integer> heap;
    private int heapSize;
    /*
     We Will use Priority Queue for this Question since Priority Queue is a Min Heap in Java
     We will initialize the heap to only store the K number of elements and thus the Kth largest element
     is always at the top of the heap
     The Time Complexity of using a Heap O(n log(n))

     For Custom Min Heap using array refer tp MinHeapArray.java
     */
    public KLargest(int []arr, int k)
    {
        heap = new PriorityQueue<>(k);
        this.heapSize = k;
        for(int i : arr) {
            heap.add(i);
            if(heap.size() > k)
                heap.remove();
        }
    }

    public int add(int num)
    {
        heap.add(num);
        if(heap.size() > this.heapSize)
            heap.remove();
        return heap.peek();
    }

}
