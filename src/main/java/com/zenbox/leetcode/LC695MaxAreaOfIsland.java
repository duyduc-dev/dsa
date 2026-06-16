package com.zenbox.leetcode;

/**
 * {@code LC695MaxAreaOfIsland}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/max-area-of-island/">695.
 * Max Area of Island</a>.
 * </p>
 */
public class LC695MaxAreaOfIsland {
  class Solution {

    private final int[] DX = { -1, 0, 1, 0 };
    private final int[] DY = { 0, 1, 0, -1 };

    public int maxAreaOfIsland(int[][] grid) {
      int n = grid.length;
      int m = n == 0 ? 0 : grid[0].length;

      boolean[][] visited = new boolean[n][m];
      int res = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (!visited[i][j] && grid[i][j] == 1) {
            res = Math.max(res, dfs(new int[] { i, j }, grid, visited, n, m));
          }
        }
      }

      return res;
    }

    private int dfs(int[] curr, int[][] grid, boolean[][] visited, int n, int m) {
      visited[curr[0]][curr[1]] = true;

      int res = 1;

      for (int dir = 0; dir < 4; dir++) {
        int x = curr[0] + DX[dir];
        int y = curr[1] + DY[dir];
        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1 && !visited[x][y]) {
          res += dfs(new int[] { x, y }, grid, visited, n, m);
        }
      }
      
      return res;
    }
  }
}
