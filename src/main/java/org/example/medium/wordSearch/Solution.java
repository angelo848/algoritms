package org.example.medium.wordSearch;

import java.util.List;
import java.util.Map;

// LeetCode problem: https://leetcode.com/problems/word-search/description/

public class Solution {

  public static boolean exist(char[][] board, String word) {
    int nRows = board.length;
    int nCols = board[0].length;

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (backtrack(board, nRows, nCols, row, col, word)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean backtrack(char[][] board, int nRows, int nCols, int row, int col, String suffix) {
    if (suffix.isEmpty()) {
      return true;
    }

    if (row < 0 || row == nRows ||
        col < 0 || col == nCols ||
        board[row][col] != suffix.toCharArray()[0]) {
      return false;
    }


    board[row][col] = '#';

    List<Map<Integer, Integer>> directions = List.of(
      Map.of(0, 1),
      Map.of(1, 0),
      Map.of(0, -1),
      Map.of(-1, 0)
    );

    for (Map<Integer, Integer> listDirections : directions) {
      for (Map.Entry<Integer, Integer> offset : listDirections.entrySet()) {
        boolean res = backtrack(
          board,
          nRows,
          nCols,
          row + offset.getKey(),
          col + offset.getValue(),
          suffix.substring(1));

        if (res) {
          return true;
        }
      }
    }

    board[row][col] = suffix.toCharArray()[0];

    return false;
  }

  public static void main(String[] args) {
    char[][] board = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'},
    };
    String word = "ABCCED";
    boolean result = exist(board, word);
    System.out.println("Word found: " + result);
  }
}

