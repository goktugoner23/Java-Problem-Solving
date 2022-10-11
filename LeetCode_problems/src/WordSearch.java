//https://leetcode.com/problems/word-search/
//Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//Example 1:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//Output: true
//Example 2:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
//Output: true
//Example 3:
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
//Output: false
//Constraints:
//m == board.length
//n = board[i].length
//1 <= m, n <= 6
//1 <= word.length <= 15
//board and word consists of only lowercase and uppercase English letters.

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i =0; i<board.length; i++){
            for (int j =0; j< board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if (findWord(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) return true;
        if (j<0 || i<0 || i== board.length ||j == board[0].length) return false;
        if (board[i][j] == word.charAt(index)){
            board[i][j] = '0'; //visited
            Boolean left = findWord(board, word, i, j-1, index+1);
            Boolean right = findWord(board, word, i, j+1, index+1);
            Boolean up = findWord(board, word, i-1, j, index+1);
            Boolean down = findWord(board, word, i+1, j, index+1);
            if (left || right || up || down) return true;
            board[i][j] = word.charAt(index);
        }
        return false;
    }
}
