package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class FreedomTrail implements ProblemStatement {

    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length()][ring.length()];
        for(int i=0 ; i < dp.length; i++)
            for(int j= 0 ; j< dp[0].length; j++)
                dp[i][j] = -1;
        return minSteps(0,0,key,ring, dp);
    }



    private int minSteps(int keyIndex, int ringPtr, String key, String ring, int[][] dp)
    {
        if(keyIndex == key.length())
            return 0;

        if(dp[keyIndex][ringPtr] != -1)

        {
            return dp[keyIndex][ringPtr];
        }
        int steps = Integer.MAX_VALUE; //We will keep max value for steps as we iterate over loop and steps can be calculated again and again for diff combinations
        for(int i = 0; i<ring.length(); i++)
        {

            if(ring.charAt(i) == key.charAt(keyIndex))
            {

                steps = Math.min(steps, 1 + Math.min(Math.abs(i-ringPtr), Math.abs(ring.length() - Math.abs(i-ringPtr))) +
                        minSteps(keyIndex+1, i, key , ring, dp));

            }
        }

        dp[keyIndex][ringPtr] = steps;
        return steps;
    }

    @Override
    public String getDescription() {
        return "n the video game Fallout 4, the quest \"Road to Freedom\" requires players to reach a metal dial called the \"Freedom Trail Ring\" and use the dial to spell a specific keyword to open the door.\n" +
                "\n" +
                "Given a string ring that represents the code engraved on the outer ring and another string key that represents the keyword that needs to be spelled, return the minimum number of steps to spell all the characters in the keyword.\n" +
                "\n" +
                "Initially, the first character of the ring is aligned at the \"12:00\" direction. You should spell all the characters in key one by one by rotating ring clockwise or anticlockwise to make each character of the string key aligned at the \"12:00\" direction and then by pressing the center button.\n" +
                "\n" +
                "At the stage of rotating the ring to spell the key character key[i]:\n" +
                "\n" +
                "You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of the rotation is to align one of ring's characters at the \"12:00\" direction, where this character must equal key[i].\n" +
                "If the character key[i] has been aligned at the \"12:00\" direction, press the center button to spell, which also counts as one step. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: ring = \"godding\", key = \"gd\"\n" +
                "Output: 4\n" +
                "Explanation:\n" +
                "For the first key character 'g', since it is already in place, we just need 1 step to spell this character. \n" +
                "For the second key character 'd', we need to rotate the ring \"godding\" anticlockwise by two steps to make it become \"ddinggo\".\n" +
                "Also, we need 1 more step for spelling.\n" +
                "So the final output is 4.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: ring = \"godding\", key = \"godding\"\n" +
                "Output: 13";
    }

    @Override
    public String getSolutionNotes() {
        return "The Problem can be solved by the basic idea here " +
                "1) Find the first word in the dial that matches the Key in the minimum possible characters" +
                "2) Even the first word in the Key is available multiple times in the dial, we give each a try as we we will " +
                "be iterating in a for loop over each character" +
                "3) Then keep on finding the next word in the key and this time the start position in the index of found word in dial" +
                "4) The problem can be optimized using DP like this. We keep a 2 D array of index and ptr positions. For example if the key is " +
                " vinay and dial is vniany . Notice that there are two N so we have to explore both after N our goal is to find a so if we cache the results " +
                " of a from a to Y sp when we call the getSteps for second N we will use cached results of a to Y";
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
