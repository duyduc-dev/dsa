package com.zenbox.leetcode;

/**
 * {@code LC1905CountSubIslands}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/count-sub-islands">1905.
 * Count Sub Islands</a>.
 * </p>
 */
public class LC1905CountSubIslands {
  class Solution {

    private final int[][] D = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
      int n = grid1.length;
      int m = n == 0 ? 0 : grid1[0].length;

      boolean[][] visited = new boolean[n][m];
      int res = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (!visited[i][j] && grid2[i][j] == 1 && dfs(i, j, n, m, grid1, grid2, visited)) {
            res++;
          }
        }
      }
      return res;
    }

    private boolean dfs(int x, int y, int n, int m, int[][] grid1, int[][] grid2, boolean[][] visited) {
      visited[x][y] = true;
      boolean isOk = grid1[x][y] == 1;
      for (int dir = 0; dir < 4; dir++) {
        int a = x + D[dir][0];
        int b = y + D[dir][1];
        if (a >= 0 && b >= 0 && a < n && b < m && !visited[a][b] && grid2[a][b] == 1) {
          isOk &= dfs(a, b, n, m, grid1, grid2, visited);
        }
      }
      return isOk;
    }
  }
}
