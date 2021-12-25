package com.vinner.codeme.ctci.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ctci.ds.linkedlist.LinkedListNode;

public class SumOfLinkedList implements ProblemStatement {

	/*
		We first Transform both Linked list into numbers in reverse order such as first element is at 1th place, then second is 10 place and so on
		Then we calculate sum and transform sum back to linked list by taking out the last number
		Time Complexity : O(m+n) , where m and n is size of list m and list n
	 */
	public LinkedListNode<Integer> sumLinkedList(LinkedListNode<Integer> n1, LinkedListNode<Integer> n2)
	{
		if(n1 == null || n2 == null)
			return null; //Failure

		long s1 =  transformLinkedListToNumber(n1);
		long s2 =  transformLinkedListToNumber(n2);
		long sum = s1+s2;

		return transformNumberToLinkedList(sum);

	}

	private long transformLinkedListToNumber(LinkedListNode<Integer> n)
	{
		long decimalPlace = 1;
		long number = 0;
		while(n != null)
		{
			number += n.value * decimalPlace;
			decimalPlace *= 10;
			n= n.next;
		}
		return number;
	}

	private LinkedListNode transformNumberToLinkedList(long num)
	{
		LinkedListNode head = null;
		LinkedListNode headEnd = null;
		while( num > 0)
		{
			long rem =  num%10;
			LinkedListNode<Integer> node = new LinkedListNode<>((int)rem);
			if(head == null) {
				headEnd = node;
				head = headEnd;
			}
			else {
				headEnd.next = node;
				headEnd = headEnd.next;
			}
			num = num/10;
		}
		return head;
	}

	@Override
	public String getDescription() {
		return "Given two Linked List where each List represent a number in the reverse Order. Eg  7->1-6 represents 617 and 5->9->2 " +
				"represents 295. write a code to add two numbers and return a linked list in reverse order" +
				"617 + 295 -> 912 , output should be 2->1->9";
	}
}
