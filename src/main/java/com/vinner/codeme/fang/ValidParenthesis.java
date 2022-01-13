package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.\n" +
                "\n" +
                "An input string is valid if:\n" +
                "\n" +
                "Open brackets must be closed by the same type of brackets.\n" +
                "Open brackets must be closed in the correct order.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"()\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"()[]{}\"\n" +
                "Output: true\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"(]\"\n" +
                "Output: false";
    }
    public boolean isValid(String s) {

        if(s == null || s.length() %2 != 0)
            return false;

        Stack<Character> startStack = new Stack<>();
        Map<Character,Character> parenthesisPair = new HashMap(){{
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }};


        for( int i = 0 ; i< s.length() ; i++)
        {

            char c = s.charAt(i);
            if(parenthesisPair.containsKey(c))
            {
                startStack.push(c);
            }
            else if(!startStack.isEmpty() && c == parenthesisPair.get(startStack.pop()))
            {
                continue;
            }
            else
            {
                return false;
            }

        }

        return startStack.isEmpty();

    }


    @Override
    public String getSolutionNotes() {
        return "The basic agorithm of this problem is whenever we see a start bracket we put in a stack. The ide of using stack is the last " +
                "open bracket will always be at the top of the stack and now whenever we find a closing bracket the open bracket at the top of the stack should match it";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n) - We are iterating over the list only once";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) - Worst case if the String contains only open brackets the stack will contain N elements";
    }
}
