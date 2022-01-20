package com.vinner.codeme.ctci.ds.sorting_and_searching;

import com.vinner.codeme.ProblemStatement;

public class BadVersion implements ProblemStatement {
    @Override
    public String getDescription() {
        return "You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.\n" +
                "\n" +
                "Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.\n" +
                "\n" +
                "You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: n = 5, bad = 4\n" +
                "Output: 4\n" +
                "Explanation:\n" +
                "call isBadVersion(3) -> false\n" +
                "call isBadVersion(5) -> true\n" +
                "call isBadVersion(4) -> true\n" +
                "Then 4 is the first bad version.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: n = 1, bad = 1\n" +
                "Output: 1";
    }
    private int realBadVersion = 0;
    private boolean isBadVersion(int n)
    {
        if( n == realBadVersion)
            return  true;
        return false;
    }
    public int firstBadVersion(int n, int badVersionReal) { //badVersionReal is for reference for API methd isBadVersion and wont be given in reality

        this.realBadVersion = badVersionReal;
        if( n <=1)
            return n;

        int start= 1;
        int end = n;

        while(start < end)
        {

            int mid = start + (end - start) / 2;
            if(isBadVersion(mid))
            {
                end = mid;

            }
            else
            {
                start = mid+1;
            }
        }
        return start;
    }

    @Override
    public String getSolutionNotes() {
        return "The Efficient solution is performing a Binary Search. As soon as we see Mid is bad version, we reduce our search to left side. If not " +
                "we only search on right side";
    }

    @Override
    public String getTimeComplexity() {
        return "O(logN)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(1)";
    }
}
