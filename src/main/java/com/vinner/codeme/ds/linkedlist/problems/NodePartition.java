package com.vinner.codeme.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

public class NodePartition implements ProblemStatement {

	/*
		We Will create two list for start and end based on the condition of start has elements less than partition element
		End has elements greater than equal to partition element.
		Time Complexity : O(n) , N is number of elements in Linked List
	 */
	public LinkedListNode partitionNode(LinkedListNode<Integer> head, int partition)
	{
		if(head == null || head.next == null) //If Node is null or there are no more than two elements to partition
			return head;

		LinkedListNode start = null, end = null;
		LinkedListNode startEnd = null;
		while(head != null){
			LinkedListNode node = new LinkedListNode<>(head.value);
			if(head.value < partition)
			{
				node.next = start;
				start = node;
				if(startEnd == null) //Keep a node pointing to start when it has only one element to add end as the tail
					startEnd = start;

			}
			else { //Insert at head of tail
				node.next = end;
				end = node;
			}
			head = head.next;
		}
		if(startEnd != null) //Adding tail to the start
			 startEnd.next = end;
		else //Means there was no element at start ever found
			start = end;
		return start;
	}

	@Override
	public String getDescription() {
		return "Given Head of a linked list, write a code to partition the linked list at element x such all element less than x are towards left side of " +
				"list and all elements greater than x towards right. There is no order required to keep element x in between left and right elements." +
				"";
	}
}
