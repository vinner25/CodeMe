package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class MaximumGoodPersonsPerStatements implements ProblemStatement {
    @Override
    public String getDescription() {
        return "There are two types of persons:\n" +
                "\n" +
                "The good person: The person who always tells the truth.\n" +
                "The bad person: The person who might tell the truth and might lie.\n" +
                "You are given a 0-indexed 2D integer array statements of size n x n that represents the statements made by n people about each other. More specifically, statements[i][j] could be one of the following:\n" +
                "\n" +
                "0 which represents a statement made by person i that person j is a bad person.\n" +
                "1 which represents a statement made by person i that person j is a good person.\n" +
                "2 represents that no statement is made by person i about person j.\n" +
                "Additionally, no person ever makes a statement about themselves. Formally, we have that statements[i][i] = 2 for all 0 <= i < n.\n" +
                "\n" +
                "Return the maximum number of people who can be good based on the statements made by the n people." +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: statements = [[2,1,2],[1,2,2],[2,0,2]]\n" +
                "Output: 2\n" +
                "Explanation: Each person makes a single statement.\n" +
                "- Person 0 states that person 1 is good.\n" +
                "- Person 1 states that person 0 is good.\n" +
                "- Person 2 states that person 1 is bad.\n" +
                "Let's take person 2 as the key.\n" +
                "- Assuming that person 2 is a good person:\n" +
                "    - Based on the statement made by person 2, person 1 is a bad person.\n" +
                "    - Now we know for sure that person 1 is bad and person 2 is good.\n" +
                "    - Based on the statement made by person 1, and since person 1 is bad, they could be:\n" +
                "        - telling the truth. There will be a contradiction in this case and this assumption is invalid.\n" +
                "        - lying. In this case, person 0 is also a bad person and lied in their statement.\n" +
                "    - Following that person 2 is a good person, there will be only one good person in the group.\n" +
                "- Assuming that person 2 is a bad person:\n" +
                "    - Based on the statement made by person 2, and since person 2 is bad, they could be:\n" +
                "        - telling the truth. Following this scenario, person 0 and 1 are both bad as explained before.\n" +
                "            - Following that person 2 is bad but told the truth, there will be no good persons in the group.\n" +
                "        - lying. In this case person 1 is a good person.\n" +
                "            - Since person 1 is a good person, person 0 is also a good person.\n" +
                "            - Following that person 2 is bad and lied, there will be two good persons in the group.\n" +
                "We can see that at most 2 persons are good in the best case, so we return 2.\n" +
                "Note that there is more than one way to arrive at this conclusion.\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: statements = [[2,0],[0,2]]\n" +
                "Output: 1\n" +
                "Explanation: Each person makes a single statement.\n" +
                "- Person 0 states that person 1 is bad.\n" +
                "- Person 1 states that person 0 is bad.\n" +
                "Let's take person 0 as the key.\n" +
                "- Assuming that person 0 is a good person:\n" +
                "    - Based on the statement made by person 0, person 1 is a bad person and was lying.\n" +
                "    - Following that person 0 is a good person, there will be only one good person in the group.\n" +
                "- Assuming that person 0 is a bad person:\n" +
                "    - Based on the statement made by person 0, and since person 0 is bad, they could be:\n" +
                "        - telling the truth. Following this scenario, person 0 and 1 are both bad.\n" +
                "            - Following that person 0 is bad but told the truth, there will be no good persons in the group.\n" +
                "        - lying. In this case person 1 is a good person.\n" +
                "            - Following that person 0 is bad and lied, there will be only one good person in the group.\n" +
                "We can see that at most, one person is good in the best case, so we return 1.\n" +
                "Note that there is more than one way to arrive at this conclusion.\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "n == statements.length == statements[i].length\n" +
                "2 <= n <= 15\n" +
                "statements[i][j] is either 0, 1, or 2.\n" +
                "statements[i][i] == 2";
    }

    public int maximumGood(int[][] statements) {

        return getMaxGood(statements, "");

    }

    private int getMaxGood(int[][] statements,String comb)
    {
        int maxGood = 0;
        if(comb.length() == statements.length)
        {
            //Validate if the combination formed is contradicting
            int goodPersons = 0;
            boolean isValidComb = true;
            for(int i=0;i<comb.length(); i++)
            {
                if(comb.charAt(i) == '1') //A Good person , verify his statements
                {
                    int[] personIthStatements = statements[i];
                    for(int j=0; j< personIthStatements.length; j++)
                    {
                        if(personIthStatements[j] != 2 && personIthStatements[j] != Character.getNumericValue(comb.charAt(j)) )
                        {
                            isValidComb = false;
                            break;
                        }
                    }
                    goodPersons++;
                }
            }
            if(isValidComb)
                maxGood  =  goodPersons;
        }
        else{
            maxGood = Math.max(getMaxGood(statements, comb+"1"), getMaxGood(statements,  comb+"0"));
        }
        return maxGood;

    }

    @Override
    public String getSolutionNotes() {
        return "The Solution is too create all the possible combinations and then validate the statements. And if statement is invalid as per " +
                "combination, disregard it. Keep the combination as per Good person. We need to only care about good persons based on our assumption " +
                "as there statements can help us decide  ";
    }

    @Override
    public String getTimeComplexity() {
        return "O(2^n  + n^3)  - 2^n for combinations for N persons and each comb of length N  is traversed Over n*n statements ";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(2N) Recursion tree";
    }
}
