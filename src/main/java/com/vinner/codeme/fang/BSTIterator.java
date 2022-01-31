package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;
import com.vinner.codeme.blind75.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):\n" +
                "\n" +
                "BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.\n" +
                "boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.\n" +
                "int next() Moves the pointer to the right, then returns the number at the pointer.\n" +
                "Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.\n" +
                "\n" +
                "You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input\n" +
                "[\"BSTIterator\", \"next\", \"next\", \"hasNext\", \"next\", \"hasNext\", \"next\", \"hasNext\", \"next\", \"hasNext\"]\n" +
                "[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]\n" +
                "Output\n" +
                "[null, 3, 7, true, 9, true, 15, true, 20, false]\n" +
                "\n" +
                "Explanation\n" +
                "BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);\n" +
                "bSTIterator.next();    // return 3\n" +
                "bSTIterator.next();    // return 7\n" +
                "bSTIterator.hasNext(); // return True\n" +
                "bSTIterator.next();    // return 9\n" +
                "bSTIterator.hasNext(); // return True\n" +
                "bSTIterator.next();    // return 15\n" +
                "bSTIterator.hasNext(); // return True\n" +
                "bSTIterator.next();    // return 20\n" +
                "bSTIterator.hasNext(); // return False\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "The number of nodes in the tree is in the range [1, 105].\n" +
                "0 <= Node.val <= 106\n" +
                "At most 105 calls will be made to hasNext, and next.\n" +
                " \n" +
                "\n" +
                "Follow up:\n" +
                "\n" +
                "Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?";
    }
    Queue<Integer> queue = new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {
        addTraversalToStack(root);

    }

    private void addTraversalToStack(TreeNode node)
    {
        if(node == null)
            return;

        addTraversalToStack(node.left);
        queue.add(node.val);
        addTraversalToStack(node.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
    @Override
    public String getSolutionNotes() {
        return "Initialize The Queue with Inorder traversal , so that the left most part is at the begininng of queue";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) for initializing then next and hasNext is O(1)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for queue ";
    }
}
