package com.zenbox.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * {@code LC36ValidSudoku}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/valid-sudoku">LeetCode Problem 36: Valid Sudoku</a>.
 * </p>
 */
public class LC36ValidSudoku {

    /**
     * Time: O(n^2)
     * Space: O(n^2)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char curr = board[i][j];
                if(curr == '.') continue;
                if(!set.add("R" + i + curr) || !set.add("C" + j + curr) || !set.add("G" + (i / 3) + (j / 3) + curr)) {
                    return false;
                }
            }
        }
        return true;
    }
}
