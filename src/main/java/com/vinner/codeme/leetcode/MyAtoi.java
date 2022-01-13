package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class MyAtoi implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).\n" +
                "\n" +
                "The algorithm for myAtoi(string s) is as follows:\n" +
                "\n" +
                "Read in and ignore any leading whitespace.\n" +
                "Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.\n" +
                "Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.\n" +
                "Convert these digits into an integer (i.e. \"123\" -> 123, \"0032\" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).\n" +
                "If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.\n" +
                "Return the integer as the final result.\n" +
                "Note:\n" +
                "\n" +
                "Only the space character ' ' is considered a whitespace character.\n" +
                "Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"42\"\n" +
                "Output: 42\n" +
                "Explanation: The underlined characters are what is read in, the caret is the current reader position.\n" +
                "Step 1: \"42\" (no characters read because there is no leading whitespace)\n" +
                "         ^\n" +
                "Step 2: \"42\" (no characters read because there is neither a '-' nor '+')\n" +
                "         ^\n" +
                "Step 3: \"42\" (\"42\" is read in)\n" +
                "           ^\n" +
                "The parsed integer is 42.\n" +
                "Since 42 is in the range [-231, 231 - 1], the final result is 42.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"   -42\"\n" +
                "Output: -42\n" +
                "Explanation:\n" +
                "Step 1: \"   -42\" (leading whitespace is read and ignored)\n" +
                "            ^\n" +
                "Step 2: \"   -42\" ('-' is read, so the result should be negative)\n" +
                "             ^\n" +
                "Step 3: \"   -42\" (\"42\" is read in)\n" +
                "               ^\n" +
                "The parsed integer is -42.\n" +
                "Since -42 is in the range [-231, 231 - 1], the final result is -42.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: s = \"4193 with words\"\n" +
                "Output: 4193\n" +
                "Explanation:\n" +
                "Step 1: \"4193 with words\" (no characters read because there is no leading whitespace)\n" +
                "         ^\n" +
                "Step 2: \"4193 with words\" (no characters read because there is neither a '-' nor '+')\n" +
                "         ^\n" +
                "Step 3: \"4193 with words\" (\"4193\" is read in; reading stops because the next character is a non-digit)\n" +
                "             ^\n" +
                "The parsed integer is 4193.\n" +
                "Since 4193 is in the range [-231, 231 - 1], the final result is 4193.";
    }


    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        // Discard all spaces from the beginning of the input string.
        while (index < n && input.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result.
            result = 10 * result + digit;
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }


    @Override
    public String getSolutionNotes() {
        return "Carefully Follow and implement the rules";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
