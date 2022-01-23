package com.vinner.codeme.dsa;

import com.vinner.codeme.ProblemStatement;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.\n" +
                "Note: Unlike 0/1 knapsack, you are allowed to break the item. \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "N = 3, W = 50\n" +
                "values[] = {60,100,120}\n" +
                "weight[] = {10,20,30}\n" +
                "Output:\n" +
                "240.00\n" +
                "Explanation:Total maximum value of item\n" +
                "we can have is 240.00 from the given\n" +
                "capacity of sack. \n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "N = 2, W = 50\n" +
                "values[] = {60,100}\n" +
                "weight[] = {10,20}\n" +
                "Output:\n" +
                "160.00\n" +
                "Explanation:\n" +
                "Total maximum value of item\n" +
                "we can have is 160.00 from the given\n" +
                "capacity of sack.\n" +
                " \n" +
                "\n" +
                "Your Task :\n" +
                "Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum value in knapsack.\n" +
                "Note: The details of structure/class is defined in the comments above the given function.\n" +
                "\n" +
                "\n" +
                "Expected Time Complexity : O(NlogN)\n" +
                "Expected Auxilliary Space: O(1)";
    }
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    class Comp implements Comparator<Item> {

        @Override
        public int compare(Item i1, Item i2)
        {
            double value1PerUnit = (double)i1.value/i1.weight;
            double value2PerUnit =  (double)i2.value/i2.weight;
            if(value1PerUnit < value2PerUnit)
                return 1;
            else if(value1PerUnit > value2PerUnit)
                return -1;
            else
                return 0;
        }


    }


    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Comp comp = new Comp();
        Arrays.sort(arr,comp); //Sorted on the basis of Value per Unit
        double maxValue = 0;
        int index= 0;
        while( W > 0 && index < n)
        {
            Item currentItem = arr[index];
            if(currentItem.weight <= W) //If Max available weight of this item is less than What we can carry /add all of it
            {
                maxValue+= currentItem.value;
                W -= currentItem.weight;
            }
            else
            {
                maxValue+= ( (double)currentItem.value/currentItem.weight) * W; //Add Max of this item
                W = 0;

            }
            index++;
        }

        return maxValue;
    }

    @Override
    public String getSolutionNotes() {
        return "The simple solution is to sort by Value/Unit and keep the maximum first. Now when we are iterating over the array we keep the " +
                "Weight available in considertion. if All of the Item can be added to Sack we add it else we add the maximum fraction we can.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(NLogN) sorting ";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
