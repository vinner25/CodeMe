package com.vinner.codeme.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {

        return validateRowsAndColumn(board) && validateGrid(board);


    }
    private boolean validateGrid(char[][] board)
    {
        int step =0;
        while(step < 9)
        {
            int[] counts = new int[9];

            for( int i=step; i< step+3; i++)
            {
                for( int j = step ; j<step+3; j++)
                {
                    char val = board[i][j];
                    if(val == '\0'  || val == '.')
                        continue;
                    int value = Character.getNumericValue(val);
                    if(counts[value-1] > 0)
                        return false;
                    counts[value-1]++;

                }

            }
            step = step + 3;
        }
        return true;

    }

    private boolean validateRowsAndColumn(char[][] board)
    {
        Map<Integer, int[]> columnCountsMap = new HashMap<>();

        for( int i=0;i<9;i++)
        {
            int[] rowCounts = new int[9];
            for( int j =0  ; j<9; j++)
            {
                char val = board[i][j];
                if(val == '\0'  || val == '.')
                    continue;

                int[] columnCounts;
                if(columnCountsMap.get(j) == null)
                    columnCounts = new int[9];
                else
                    columnCounts = columnCountsMap.get(j);

                int value = Character.getNumericValue(val);

                if(value < 1 || value > 9 || rowCounts[value-1] > 0 ||columnCounts[value-1] > 0 )
                    return false;
                rowCounts[value-1]++;
                columnCounts[value-1]++;

                columnCountsMap.put(j,columnCounts );
            }
        }
        return true;
    }
}
