package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class AllScoreDividingBinaryArray implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are given a 0-indexed binary array nums of length n. nums can be divided at index i (where 0 <= i <= n) into two arrays (possibly empty) numsleft and numsright:\n" +
                "\n" +
                "numsleft has all the elements of nums between index 0 and i - 1 (inclusive), while numsright has all the elements of nums between index i and n - 1 (inclusive).\n" +
                "If i == 0, numsleft is empty, while numsright has all the elements of nums.\n" +
                "If i == n, numsleft has all the elements of nums, while numsright is empty.\n" +
                "The division score of an index i is the sum of the number of 0's in numsleft and the number of 1's in numsright.\n" +
                "\n" +
                "Return all distinct indices that have the highest possible division score. You may return the answer in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [0,0,1,0]\n" +
                "Output: [2,4]\n" +
                "Explanation: Division at index\n" +
                "- 0: numsleft is []. numsright is [0,0,1,0]. The score is 0 + 1 = 1.\n" +
                "- 1: numsleft is [0]. numsright is [0,1,0]. The score is 1 + 1 = 2.\n" +
                "- 2: numsleft is [0,0]. numsright is [1,0]. The score is 2 + 1 = 3.\n" +
                "- 3: numsleft is [0,0,1]. numsright is [0]. The score is 2 + 0 = 2.\n" +
                "- 4: numsleft is [0,0,1,0]. numsright is []. The score is 3 + 0 = 3.\n" +
                "Indices 2 and 4 both have the highest possible division score 3.\n" +
                "Note the answer [4,2] would also be accepted.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [0,0,0]\n" +
                "Output: [3]\n" +
                "Explanation: Division at index\n" +
                "- 0: numsleft is []. numsright is [0,0,0]. The score is 0 + 0 = 0.\n" +
                "- 1: numsleft is [0]. numsright is [0,0]. The score is 1 + 0 = 1.\n" +
                "- 2: numsleft is [0,0]. numsright is [0]. The score is 2 + 0 = 2.\n" +
                "- 3: numsleft is [0,0,0]. numsright is []. The score is 3 + 0 = 3.\n" +
                "Only index 3 has the highest possible division score 3.\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [1,1]\n" +
                "Output: [0]\n" +
                "Explanation: Division at index\n" +
                "- 0: numsleft is []. numsright is [1,1]. The score is 0 + 2 = 2.\n" +
                "- 1: numsleft is [1]. numsright is [1]. The score is 0 + 1 = 1.\n" +
                "- 2: numsleft is [1,1]. numsright is []. The score is 0 + 0 = 0.\n" +
                "Only index 0 has the highest possible division score 2.";
    }

    public List<Integer> maxScoreIndices(int[] nums) {

        int maxScore= 0 ;
        int[] scores = new int[nums.length+1];
        int prevLeftScore = 0;
        int prevRightScore = 0;
        for(int i=0; i<= nums.length; i++)
        {

            if(i == 0)
            {
                scores[i] =  calculateScoreRight(0, nums);
                prevRightScore = scores[i];
            }
            else if( i == nums.length)
            {
                if(nums[i-1] == 0)
                prevLeftScore += 1;
                scores[i] =  prevLeftScore;

            }
            else
            {
                if(nums[i-1] == 0)
                {
                    prevLeftScore = prevLeftScore + 1;

                }
                if(nums[i-1] == 1)
                    prevRightScore = prevRightScore - 1;
                scores[i] =  prevLeftScore + prevRightScore;
            }

            maxScore = Math.max(maxScore, scores[i]);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i< scores.length; i++)
        {
            if(scores[i] == maxScore)
                res.add(i);
        }
        return res;
    }



    private int calculateScoreRight(int j,  int[] nums)
    {

        int score =0;
        while(  j < nums.length)
        {
            if(nums[j] == 1)
                score++;
            j++;
        }
        return score;

    }

    @Override
    public String getSolutionNotes() {
        return ProblemStatement.super.getSolutionNotes();
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
