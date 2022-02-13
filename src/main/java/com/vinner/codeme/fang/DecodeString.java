package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.Stack;

public class DecodeString implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given an encoded string, return its decoded string.\n" +
                "\n" +
                "The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.\n" +
                "\n" +
                "You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.\n" +
                "\n" +
                "Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"3[a]2[bc]\"\n" +
                "Output: \"aaabcbc\"\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"3[a2[c]]\"\n" +
                "Output: \"accaccacc\"\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"2[abc]3[cd]ef\"\n" +
                "Output: \"abcabccdcdcdef\"\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= s.length <= 30\n" +
                "s consists of lowercase English letters, digits, and square brackets '[]'.\n" +
                "s is guaranteed to be a valid input.\n" +
                "All the integers in s are in the range [1, 300].";
    }
    public String decodeString(String s) {
        Stack<Character>  myStack= new Stack<>();

        for(char c : s.toCharArray())
        {

            if(c != ']')
            {
                myStack.push(c);
            }
            else
            {
                solveSubProblem(myStack);
            }

        }

        String  res = "";
        while(!myStack.isEmpty())
            res = myStack.pop() + res;
        return res;

    }


    private void solveSubProblem(Stack<Character> myStack)
    {
        String val = "";

        while(!myStack.isEmpty())
        {
            char c = myStack.pop();
            if(c == '[')
                break;
            else
                val = c+val;


        }
        String timesS = "";
        while(!myStack.isEmpty() )
        {
            char c = myStack.pop();


            if(Character.isDigit(c))
            {
                timesS = c+timesS;
            }
            else
            {
                myStack.push(c); //Add it back to Stack
                break;
            }
        }
        int times = Integer.parseInt(timesS);
        for(int i=0 ;i<times; i++)
        {
            for(char c : val.toCharArray())
            {
                myStack.push(c);
            }
        }
    }

    @Override
    public String getSolutionNotes() {
        return "We Will use Stack to solve this kind of problem. We solve subproblem first before jumping to outer problem. " +
                "So whenever we encounter ] in stack ,it means closing of subproblem. Then we pop from stack till we reach [." +
                "After that we count times it has to be multiplied , and we push the decoded version back to stack";
    }

    @Override
    public String getTimeComplexity() {
        return ProblemStatement.super.getTimeComplexity();
    }

    @Override
    public String getSpaceComplexity() {
        return ProblemStatement.super.getSpaceComplexity();
    }
}
