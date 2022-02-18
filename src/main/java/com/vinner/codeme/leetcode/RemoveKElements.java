package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.Stack;

public class RemoveKElements implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: num = \"1432219\", k = 3\n" +
                "Output: \"1219\"\n" +
                "Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: num = \"10200\", k = 1\n" +
                "Output: \"200\"\n" +
                "Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: num = \"10\", k = 2\n" +
                "Output: \"0\"\n" +
                "Explanation: Remove all the digits from the number and it is left with nothing which is 0.";
    }

    public String removeKdigits(String num, int k) {

        if(num == null || num.length() == 0)
            return "0";

        if(k >= num.length())
            return "0";


        Stack<Character> resStack = new Stack<>();


        for(char c : num.toCharArray())
        {
            if(resStack.isEmpty()) //if Stack is Empty then There os nothing to compare against
            {
                if(c!= '0') //Since Trailing Zeroes are not required so do not add
                    resStack.push(c);

            }
            else{

                while(!resStack.isEmpty() && resStack.peek() > c && k> 0 ) //If There is a dip remove the Maxima element
                {
                    resStack.pop();
                    k--;
                }


                if(resStack.isEmpty())
                {
                    if(c != '0')
                        resStack.push(c);
                }
                else{
                    resStack.push(c);
                }
            }
        }

        if(k > 0) //If No Dip found , Eg : String was 12345 and K = 2. We have to remove last two elements in this case
        {
            while(!resStack.isEmpty() && k>0)
            {
                resStack.pop();
                k--;
            }
        }


        if(resStack.isEmpty())
            return "0";

        StringBuilder sb = new StringBuilder();
        while(!resStack.isEmpty())
            sb.append(resStack.pop());

        return sb.reverse().toString(); //Since we used String Builder and it appended from right to left from stack, we need to reverse for our ans


    }

    @Override
    public String getSolutionNotes() {
        return "The Problem uses a Stack to Push elements from given string as we iterate. Whenever it encounters any DIP, the goal " +
                "is to remove the element which are the maxima before the current element. ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - Since we are iterating String of length N";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) for the Stack of size N";
    }
}
