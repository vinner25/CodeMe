package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

public class TrappingRainWater implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]\n" +
                "Output: 6\n" +
                "Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: height = [4,2,0,3,2,5]\n" +
                "Output: 9\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "n == height.length\n" +
                "1 <= n <= 2 * 104\n" +
                "0 <= height[i] <= 105";
    }

    public int trap(int[] height) {

        if(height.length < 3 )
            return 0;

        int[] leftHeights = new int[height.length]; //Auxillary Array to store Maximum Height of Left most building from current position
        int[] rightHeights = new int[height.length];//Auxillary Array to store Maximum Height of Right most building from current position

        leftHeights[0] = height[0];
        for(int i=1 ; i< height.length; i++)
        {
            leftHeights[i] = Math.max(height[i], leftHeights[i-1]);

        }
        rightHeights[height.length-1]= height[height.length -1 ];
        for(int j=height.length-2; j>=0 ; j--)
        {
            rightHeights[j] = Math.max(height[j],rightHeights[j+1] );
        }

        int waterTrapped = 0;
        //Since we know water can be only trapped at a DIP. At a given posiiton we chose the minimum height between left most and right most from that position and subtract the current building height from it.
        for(int i=0; i<height.length;i++)
        {
            int current = Math.min(leftHeights[i], rightHeights[i]) - height[i];
            waterTrapped += current;
        }

        return waterTrapped;

    }

    @Override
    public String getSolutionNotes() {
        return "We Will follow the approach of having two Auxillary Arrays to store left tallest buildinmg from current posoiton and right biggest building from " +
                "current position. Since wayer can only store in a DIP, we calculate this by subtracting the current building height.";
    }

    @Override
    public String getTimeComplexity() {
        return "O(n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(n) + O(n) -> for Auxillary Arrays which comes to O(n)";
    }
}
