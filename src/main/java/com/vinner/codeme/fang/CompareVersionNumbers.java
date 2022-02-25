package com.vinner.codeme.fang;

import com.vinner.codeme.ProblemStatement;

import java.util.LinkedList;
import java.util.Queue;

public class CompareVersionNumbers implements ProblemStatement {
    @Override
    public String getDescription() {
        return "Given two version numbers, version1 and version2, compare them.\n" +
                "\n" +
                "Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.\n" +
                "\n" +
                "To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.\n" +
                "\n" +
                "Return the following:\n" +
                "\n" +
                "If version1 < version2, return -1.\n" +
                "If version1 > version2, return 1.\n" +
                "Otherwise, return 0.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: version1 = \"1.01\", version2 = \"1.001\"\n" +
                "Output: 0\n" +
                "Explanation: Ignoring leading zeroes, both \"01\" and \"001\" represent the same integer \"1\".\n" +
                "Example 2:\n" +
                "\n" +
                "Input: version1 = \"1.0\", version2 = \"1.0.0\"\n" +
                "Output: 0\n" +
                "Explanation: version1 does not specify revision 2, which means it is treated as \"0\".";
    }

    public int compareVersion(String version1, String version2) {
        Queue<Integer> version1Q = queueVersion(version1);

        for(String v2Str : version2.split("\\."))
        {
            int v1 = version1Q.isEmpty() ? 0 : version1Q.poll();

            int v2 = Integer.parseInt(v2Str);

            if(v1 > v2)
                return 1;
            else if(v1 < v2)
                return -1;
        }
        //If Version1 is still remaining we have to check if remaining parts are 0 ot nor
        if(!version1Q.isEmpty()){
            while(!version1Q.isEmpty())
            {
                if(version1Q.poll() > 0)
                    return 1;
            }
        }
        return 0;
    }


    private Queue<Integer> queueVersion(String version)
    {
        Queue<Integer> versionQueue = new LinkedList<>();
        for(String v : version.split("\\."))
        {
            versionQueue.add(Integer.parseInt(v));
        }

        return versionQueue;
    }

    @Override
    public String getSolutionNotes() {
        return "We will simply just create a Queue of one the version and then iterate the other " +
                "while polling from previous version Queue. If the comparison yields any difference " +
                "we return result accordingly";
    }

    @Override
    public String getTimeComplexity() {
        return "O(N) where N is the length of the largest version string length";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(s) where S is the length of the Version 1 QUEUE.";
    }
}
