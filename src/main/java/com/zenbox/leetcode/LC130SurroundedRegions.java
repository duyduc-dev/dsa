package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * {@code LC130SurroundedRegions}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/surrounded-regions">130.
 * Surrounded Regions</a>.
 * </p>
 */
public class LC130SurroundedRegions {
  class Solution {
    final int[] DX = { -1, 0, 1, 0 };
    final int[] DY = { 0, 1, 0, -1 };

    public void solve(char[][] board) {
      int n = board.length;
      int m = n == 0 ? 0 : board[0].length;

      boolean[][] visited = new boolean[n][m];
      Queue<int[]> queue = new ArrayDeque<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) &&
              board[i][j] == 'O' && !visited[i][j]) {
            visited[i][j] = true;
            queue.add(new int[] { i, j });
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] curr = queue.poll();

        for (int dir = 0; dir < 4; dir++) {
          int x = curr[0] + DX[dir];
          int y = curr[1] + DY[dir];

          if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == 'O' && !visited[x][y]) {
            queue.add(new int[] { x, y });
            visited[x][y] = true;
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O' && !visited[i][j]) {
            board[i][j] = 'X';
          }
        }
      }

    }
  }
}
