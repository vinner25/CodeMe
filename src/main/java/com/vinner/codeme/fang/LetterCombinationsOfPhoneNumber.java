package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.\n" +
                "\n" +
                "A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: digits = \"23\"\n" +
                "Output: [\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]\n" +
                "Example 2:\n" +
                "\n" +
                "Input: digits = \"\"\n" +
                "Output: []\n" +
                "Example 3:\n" +
                "\n" +
                "Input: digits = \"2\"\n" +
                "Output: [\"a\",\"b\",\"c\"]";
    }
    /*
    public final Map<Integer, char[]> dataDictionary = new HashMap(){{
        put(2, new char[]{'a', 'b', 'c'});
        put(3, new char[]{'d','e','f'});
        put(4, new char[]{'g','h','i'});
        put(5, new char[]{'j','k','l'});
        put(6, new char[]{'m','n','o'});
        put(7, new char[]{'p', 'q', 'r','s'});
        put(8, new char[]{'t', 'u', 'v'});
        put(9, new char[]{'w','x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        List<StringBuilder> sbList = null;

        for( int i = 0 ; i< digits.length() ; i++)
        {
            char[] chars = dataDictionary.get(Character.getNumericValue(digits.charAt(i)));
            sbList = addTosbList(sbList,chars );
        }

        List<String> result = new ArrayList<>();
        for(StringBuilder sb : sbList)
        {
            result.add(sb.toString());
        }
        return result;


    }

    private List<StringBuilder> addTosbList(List<StringBuilder> sbList, char[] chars)
    {
        boolean firstTime = sbList == null || sbList.isEmpty();
        List<StringBuilder> res= new ArrayList<>();
        for(char c : chars){

            if(firstTime) //First Time
            {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                res.add(sb);
            }
            else
            {
                for(StringBuilder sb : sbList)
                {
                    StringBuilder newSb = new StringBuilder();
                    newSb.append(sb).append(c);
                    res.add(newSb);
                }
            }
        }

        return res;

    } */
    public final String[] dictionary = new String[]{
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();

        addToList(result, 0 , "", digits);
        return result;
    }

    private void addToList(List<String> result, int currentIndex, String currentString, String digits)
    {
        if(currentIndex == digits.length())
        {
            result.add(currentString);
            return;
        }
        char[] chars = dictionary[digits.charAt(currentIndex) - '0'].toCharArray();

        for(char c : chars)
        {
            addToList(result,currentIndex+1, currentString+c, digits);
        }
    }
    @Override
    public String getSolutionNotes() {
        return "We Can recursively Iterate over the possible combination ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n*4^n) - N is the number of digits. For Each digit we can have 3 or 4 characters. If we take the worst case ( digits 9), it can have 4 characters and the " +
                "recursive tree will be expanding 4 times and we have to do it N times";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(4^n) + O(n) - Space complexity for storing possible strings worst case and the Recursive stack till N digits";
    }
}
