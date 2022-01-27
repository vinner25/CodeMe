package com.vinner.codeme.leetcode;

import com.vinner.codeme.ProblemStatement;

public class WordSearch implements ProblemStatement {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length ; j++)
            {
                if(wordFindDFS(board, i,j,word, "", visited))
                    return true;
            }
        }
        return false;

    }

    private boolean wordFindDFS(char[][] board, int i , int j , String word, String currentWord, boolean[][] visited)
    {
        if( i<0 ||   i == board.length || j == board[0].length || j<0 || visited[i][j]) //out of Bound
            return false;

        currentWord += board[i][j];

        if(!word.startsWith(currentWord))
        {
            return false;
        }

        if(word.equals(currentWord))
            return true;

        visited[i][j] = true;
        if(wordFindDFS(board, i, j+1, word, currentWord,visited) ||
                wordFindDFS(board, i, j-1, word, currentWord,visited) ||
                wordFindDFS(board, i+1, j, word, currentWord,visited) ||
                wordFindDFS(board, i-1, j, word, currentWord,visited))
            return true;
        visited[i][j] = false;
        return false;

    }

    @Override
    public String getDescription() {
        return "Given an m x n grid of characters board and a string word, return true if word exists in the grid.\n" +
                "\n" +
                "The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.\n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "\n" +
                "Input: board = [[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]], word = \"ABCCED\"\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "\n" +
                "Input: board = [[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]], word = \"SEE\"\n" +
                "Output: true\n" +
                "Example 3:\n" +
                "\n" +
                "\n" +
                "Input: board = [[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]], word = \"ABCB\"\n" +
                "Output: false";
    }

    @Override
    public String getSolutionNotes() {
        return "We will maintain a Visited[][] to keep track of workds visited and try searching the word in all the directions. " +
                "Other way is instead of using visited[][] we can just empty the word at the index so that if visited again it will fail the " +
                "word match. Just saves some space";
    }

    @Override
    public String getTimeComplexity() {
        return "O(m*n)";
    }

    @Override
    public String getSpaceComplexity() {
        return "O(m*n) for visited array";
    }
}
