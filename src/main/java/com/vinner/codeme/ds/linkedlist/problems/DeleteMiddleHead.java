package com.vinner.codeme.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

public class DeleteMiddleHead implements ProblemStatement {

	/*
	 We Will implement a Two Pointer Approach for this , the slow Pointer iterates 1 step and fast pointer iterates 2 steps
	 When Fast is at the end , the slow pointer is at the middle (Note for Odd it is exact middle, for even number
	 of elements we are taking upper limit element eg , 1,2,3,4 -> Middle element is 2)

	 */
	public void removeMiddle(LinkedListNode head)
	{
		LinkedListNode slow = head;
		if(head.getNext() == null || head.getNext().getNext() == null) // there are not 3 elements
			return;

		LinkedListNode fast = head.getNext();
		LinkedListNode prev = head;
		while(fast != null && fast.getNext() !=null)
		{
			prev = slow;
			slow = slow.getNext();
			fast = fast.getNext().getNext();

		}

		//At This time slow is add the middle, so we need to remove this node
		prev.setNext( slow.getNext());

	}


	@Override
	public String getDescription() {
		return "Given head of a Singly Linked List , Remove the Middle element.";
	}
}
