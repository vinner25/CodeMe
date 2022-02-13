package com.vinner.codeme.blind75.heap;

import com.vinner.codeme.ProblemStatement;
import jdk.nashorn.internal.runtime.arrays.IntElements;

import java.util.*;

public class TopKFrequentElements implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [1,1,1,2,2,3], k = 2\n" +
                "Output: [1,2]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [1], k = 1\n" +
                "Output: [1]";
    }
    class Element{
        int number;
        int frequency;


    }



    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> valueToCountMap = new HashMap<>();
        for(int i=0; i< nums.length; i++)
        {
            int count = 1;
            if(valueToCountMap.containsKey(nums[i]))
                count += valueToCountMap.get(nums[i]);

            valueToCountMap.put(nums[i], count);

        }

        List<Element> elements = new ArrayList<>();
        for(int key : valueToCountMap.keySet())
        {
            Element element = new Element();
            element.number = key;
            element.frequency = valueToCountMap.get(key);
            elements.add(element);
        }

        // We will create the heap and implement comparator based on count of values in Map
        // so that the minimum value stays at the top of the heap. Alternatively we can also implement a max heap
        // which means we have to store all the elements and then choose top K
        PriorityQueue<Element> queue = new PriorityQueue<Element>(
                new Comparator<Element>() {
                    @Override
                    public int compare(Element o1, Element o2) {
                        return o1.frequency - o2.frequency; //Means if 01.fre - o2.fr > 1 , it will swap. Means the element with less freq stays at top
                    }
                });

        for(Element element : elements)
        {
            queue.add(element);
            if(queue.size() > k) //If the Heap becomes more than asked K chop of the top value which will be minimum
                queue.poll();
        }

        int[] res = new int[k];

        while(k>0)
        {
            res[res.length-k] =  queue.poll().number;
            k--;
        }
        return res;
    }
    @Override
    public String getSolutionNotes() {
        return "We Will first iterate over the nums array to generate a hashmap of Value to Counts" +
                "Then we will add the elements in a heap of size K such that only Top K elements will remain in the heap" +
                " Then we will Poll the heap to return the top K elements";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NlogK) - O(N) is for adding elements into Hashmap and then LogK  for Pushing and Popping elements into Heap" +
                "Even though we add N elements (worst case) in Heap the operations are (n-k)LogK . Combining the haspMap and " +
                " heap Time complexity we get O(NlogK)" +
                " Worst case if K == N then it becomes O(NlogN) ";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(N+K) - N for hashmap and K for heap of size K. The int[] result is of size K too which gets added as k+k => K";
    }
}
