package com.vinner.codeme.ds.linkedlist.problems;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.ds.linkedlist.LinkedListNode;

public class DeleteNode implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given Node of a Singly Linked List Node, Remove the Node itself. Note You cannot remove the head or last of the Linked List";
    }

    public boolean removeNode(LinkedListNode nodeToDelete)
    {
        if(nodeToDelete == null || nodeToDelete.getNext() == null)
            return false; //Failure:  Node to delete cannot be the last node

        //Simply Copy Data Value of Next Node
        // and assign Next node's next to this node's next . Basically nExt Node is copied over to this node and next node is removed
        nodeToDelete.setValue(nodeToDelete.getNext().getValue());
        nodeToDelete.setNext(nodeToDelete.getNext().getNext());
        return true; //Success
    }
}
