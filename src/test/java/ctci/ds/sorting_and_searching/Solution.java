package ctci.ds.sorting_and_searching;

import java.util.*;
class Solution {
    public static String[] solution(String[] playerNames, long[][] playerHands) {
        // Write your solution here

        int maxValidSum = 0;
        int[] totalSums = new int[playerHands.length];
        for(int i = 0 ; i<playerHands.length; i++){
            
            int sum = 0;
            for(long handValue: playerHands[i]){
                sum+= handValue;
            }
            if(sum <= 21)
               maxValidSum = Math.max(maxValidSum,sum);
            totalSums[i] = sum;
        }
        
        List<String> winnersList = new ArrayList<>();
        for(int i=0 ; i<playerNames.length; i++){
            if(totalSums[i] == maxValidSum)
                winnersList.add(playerNames[i]);
        }
        return winnersList.toArray(new String[winnersList.size()]);        
    }



}