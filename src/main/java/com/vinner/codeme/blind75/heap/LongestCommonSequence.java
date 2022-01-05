package com.vinner.codeme.blind75.heap;

import com.vinner.codeme.ProblemStatement;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestCommonSequence implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.\n" +
                "\n" +
                "You must write an algorithm that runs in O(n) time.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [100,4,200,1,3,2]\n" +
                "Output: 4\n" +
                "Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [0,3,7,2,5,8,4,6,0,1]\n" +
                "Output: 9";
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int num: nums)
            numbers.add(num);
        int maxSize = 0;
        for(int num : nums)
        {
            if(!numbers.contains(num-1)) //Start of  a Sequence (We search for start elements)
            {
                int size = 1;
                int currentNum = num+1;
                while(numbers.contains(currentNum)) //Search for next
                {
                    currentNum++;
                    size++;
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }




    /* Using Heap */
    public int longestConsecutiveUsingHeap(int[] nums) {

        if(nums.length == 0)
            return 0;

        if(nums.length == 1)
            return 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums)
        {
            queue.add(num);
        }
        int max= 0;
        int current = 1;
        int last = queue.poll();
        while(!queue.isEmpty())
        {
            int currentNum = queue.poll();
            if(currentNum - last == 1)
                current++;
            else if(currentNum - last == 0)
                current = current;
            else
                current = 1;
            max= Math.max(current,max);
            last = currentNum;
        }
        return max;
    }


    @Override
    public String getSolutionNotes() {
        return "We will show two solutions here one using a Java Min Heap and the other one is using an iterative approach using a Set";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - in the heap version the Heap add and Poll takes O(logN) which is less than O(n) so iterating over N elements and heapify takes max O(n)" +
                " In the iterative approach even though we have a while loop nested inside a for loop, the overall is still O(n). If you look at it the conditions to check if num-1 means the start of sequence even exists in" +
                " the hashset bounds the traversal to very minimum number of elements and then the right elements are searched only till the sequence is there. If everythinh " +
                " is in a sequence like 5,6,7,2,3,1 - The condition of checking (num-1) does not exists in set will be true when it is iterating over 1 and then will check for " +
                " elements from n+1 in set which is a O(1) operation done O(n) times, so overall complexity is O(n) " +
                "This means that despite looking like O(n*n) complexity, the nested loops actually run in O(n + n) = O(n)O(n+n)=O(n) time. " ;

    }

    @Override
    public String getSpaceComplexity() {
        return "O(n)";
    }
}
