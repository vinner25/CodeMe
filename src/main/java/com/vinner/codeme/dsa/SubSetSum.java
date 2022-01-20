package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a list arr of N integers, print sums of all subsets in it.\n" +
                "\n" +
                "Note: Return all the element is increasing order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 2\n" +
                "arr[] = {2, 3}\n" +
                "Output:\n" +
                "0 2 3 5\n" +
                "Explanation:\n" +
                "When no elements is taken then Sum = 0.\n" +
                "When only 2 is taken then Sum = 2.\n" +
                "When only 3 is taken then Sum = 3.\n" +
                "When element 2 and 3 are taken then \n" +
                "Sum = 2+3 = 5.\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "N = 3\n" +
                "arr = {5, 2, 1}\n" +
                "Output:\n" +
                "0 1 2 3 5 6 7 8";
    }
    public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){

        ArrayList<Integer> sumSet = new ArrayList<>();
        sumSet.add(0);

        for(int i=0; i< N; i++)
        {
            int num = arr.get(i);
            addSum(sumSet, num, sumSet.size());
        }

        return sumSet;

    }


    private void addSum(List<Integer> sumSet, int num, int size)
    {
        for(int i=0; i< size; i++)
        {
            int sum = sumSet.get(i) + num;
            sumSet.add(sum);
        }
    }

    @Override
    public String getSolutionNotes() {
        return "Basic Iterative call to keep on summing the current element to elements in Hashset";
    }

    @Override
    public String getTimeComplexity() {
        return "O(2^n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(2^n)";
    }
}
