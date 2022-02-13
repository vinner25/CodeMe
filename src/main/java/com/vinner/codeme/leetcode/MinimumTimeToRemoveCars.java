package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class MinimumTimeToRemoveCars implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given a 0-indexed binary string s which represents a sequence of train cars. s[i] = '0' denotes that the ith car does not contain illegal goods and s[i] = '1' denotes that the ith car does contain illegal goods.\n" +
                "\n" +
                "As the train conductor, you would like to get rid of all the cars containing illegal goods. You can do any of the following three operations any number of times:\n" +
                "\n" +
                "Remove a train car from the left end (i.e., remove s[0]) which takes 1 unit of time.\n" +
                "Remove a train car from the right end (i.e., remove s[s.length - 1]) which takes 1 unit of time.\n" +
                "Remove a train car from anywhere in the sequence which takes 2 units of time.\n" +
                "Return the minimum time to remove all the cars containing illegal goods.\n" +
                "\n" +
                "Note that an empty sequence of cars is considered to have no cars containing illegal goods.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: s = \"1100101\"\n" +
                "Output: 5\n" +
                "Explanation: \n" +
                "One way to remove all the cars containing illegal goods from the sequence is to\n" +
                "- remove a car from the left end 2 times. Time taken is 2 * 1 = 2.\n" +
                "- remove a car from the right end. Time taken is 1.\n" +
                "- remove the car containing illegal goods found in the middle. Time taken is 2.\n" +
                "This obtains a total time of 2 + 1 + 2 = 5. \n" +
                "\n" +
                "An alternative way is to\n" +
                "- remove a car from the left end 2 times. Time taken is 2 * 1 = 2.\n" +
                "- remove a car from the right end 3 times. Time taken is 3 * 1 = 3.\n" +
                "This also obtains a total time of 2 + 3 = 5.\n" +
                "\n" +
                "5 is the minimum time taken to remove all the cars containing illegal goods. \n" +
                "There are no other ways to remove them with less time.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: s = \"0010\"\n" +
                "Output: 2\n" +
                "Explanation:\n" +
                "One way to remove all the cars containing illegal goods from the sequence is to\n" +
                "- remove a car from the left end 3 times. Time taken is 3 * 1 = 3.\n" +
                "This obtains a total time of 3.\n" +
                "\n" +
                "Another way to remove all the cars containing illegal goods from the sequence is to\n" +
                "- remove the car containing illegal goods found in the middle. Time taken is 2.\n" +
                "This obtains a total time of 2.\n" +
                "\n" +
                "Another way to remove all the cars containing illegal goods from the sequence is to \n" +
                "- remove a car from the right end 2 times. Time taken is 2 * 1 = 2. \n" +
                "This obtains a total time of 2.\n" +
                "\n" +
                "2 is the minimum time taken to remove all the cars containing illegal goods. \n" +
                "There are no other ways to remove them with less time.";
    }
    public int minimumTime(String s) {

        int n = s.length(); //Calculate Length of the String

        int[] leftWork = new int[n];
        leftWork[0] = Character.getNumericValue(s.charAt(0));

        for(int i= 1 ; i<n ; i++)
        {
            if(s.charAt(i) == '1')
            {

                leftWork[i] = Math.min(i+1, leftWork[i-1]+2); //Minimum work between left spot removal or left removal and middle removal

            }
            else
            {
                leftWork[i] = leftWork[i-1] ; //Nothing to remove so work remains same as upto now
            }


        }

        int[] rightWork = new int[n];
        rightWork[n-1] = Character.getNumericValue(s.charAt(n-1));

        for(int i= n-2; i>=0 ; i--)
        {
            if(s.charAt(i) == '1')
                rightWork[i] = Math.min(n-i, rightWork[i+1]+2);
            else
                rightWork[i] = rightWork[i+1];

        }


        int res = Math.min(leftWork[n-1], rightWork[0]); //Initially set minimum work yielded from any of sides

        for(int i=0; i<n-1;i++)
        {
            res = Math.min(res, leftWork[i] + rightWork[i+1]); //This means upto I we did left work and then for i+1 we did right work, If it minimum we take it
        }
        return res;
    }
    @Override
    public String getSolutionNotes() {
        return "We First Calculate amount of work done on left iteration and then calculate amount of work done on right iteration. " +
                "In the end we will do a merge by comparing current Min with case if upto i work wa done by left and then onwards" +
                "work was done by right. ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(2N) -> O(n)";
    }
}
