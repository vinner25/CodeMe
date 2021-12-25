package com.vinner.codeme.ctci.ds.trees.problems;

/**
 * We Will Create a Binary Min Heap using an Array
 * A Min Heap is a Full  Binary Tree in which the root element is the smallest element. The Run time for
 * getting the minimalist element is O(1) since it is always at the root. A Max heap is opposite of min heap but works
 * similarly.
 * Min Heap Representation :   2    (Note : A Perfect Binary tree does not mean all node has equal child but always has child from left tp right)
 *                          3      5
 *                         7  4  15
 * Note this can be represented as an array like : 2,3,5,7,4,15
 *  The Child is always : 2*i+1 (left child), 2*i + 2 (right child)
 *  We will use Array to implement a Min Heap
 *  The Constructor of this problem will take a sorted array firt and a size of heap. Initializes Heap size by K
 *  The on any insert it first check if Heap Size is there , if yes then insert at end and then heapify UP
 *  Else if size is exhausted, remove first element and heapify Down
 *
 *  Heaps are very useful in solving problems like finding Minimum in the stream and maximum in the stream.
 *
 *  Java has PriorityQueue which acts as a Min Heap  //Refer to Problem : KLargest.java
 *
 */
public class MinHeapArray{

    private int[] arr;
    private int heapSize;
    private int currentSize = 0;

    public MinHeapArray(int[] newArr, int heapSize)
    {
        this.arr =  new int[heapSize];
        int startCounter = newArr.length > heapSize ? newArr.length-heapSize : 0;
        for(int i=startCounter; i< newArr.length; i++)
        {
            this.arr[currentSize] = newArr[i];
            currentSize++;
        }
        this.heapSize = heapSize;
    }

    public int add(int num)
    {
// If Current Size of Heap is less than designated length, just insert and heapifyUp
        if(currentSize < this.arr.length)
        {
            this.arr[currentSize] = num;
            currentSize++;
            heapifyUp(currentSize-1);
        }
        else  //If Size is already Exhausted, Remove Top Element and insert there and then heapifyDown
        {
            this.arr[0] = num;
            heapifyDown(0);
        }

        return this.arr[0];
    }

    public void heapifyUp(int currentIndex)
    {
        if(currentIndex < 1)
            return;
        // Parent for Right Node : n -2/2 , for left node is n-1/2
        int parentIndex =  currentIndex % 2 == 0 ? (currentIndex - 2) / 2 : (currentIndex - 1)/2;
        if(this.arr[parentIndex] > this.arr[currentIndex]) //Swap
        {
            int temp = this.arr[parentIndex];
            this.arr[parentIndex] = this.arr[currentIndex];
            this.arr[currentIndex] = temp;
            heapifyUp(parentIndex);
        }

    }

    public void heapifyDown(int currentIndex)
    {
        int leftChildIndex = (2*currentIndex)+1;
        int rightChildIndex = (2*currentIndex)+2;
        int minIndexToReplace;
        if(leftChildIndex  <  this.currentSize) //At least has one child, since heaps are perfect binary tree so will have left node before right node
        {
            minIndexToReplace = leftChildIndex ;
            if(rightChildIndex  <   this.currentSize && this.arr[rightChildIndex] < this.arr[leftChildIndex])
                minIndexToReplace  = rightChildIndex;

            int temp = this.arr[currentIndex];
            this.arr[currentIndex] = this.arr[minIndexToReplace];
            this.arr[minIndexToReplace] = temp;

            heapifyDown(minIndexToReplace);
        }
    }




}
