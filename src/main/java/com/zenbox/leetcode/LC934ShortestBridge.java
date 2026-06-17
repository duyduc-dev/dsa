package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * {@code LC934ShortestBridge}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/shortest-bridge">934.
 * Shortest Bridge</a>.
 * </p>
 */
public class LC934ShortestBridge {

  /**
   * [
   * [1,1,1,1,1],
   * [1,0,0,0,1],
   * [1,0,1,0,1],
   * [1,0,0,0,1],
   * [1,1,1,1,1]]
   */

  class Solution {

    private final int[] DX = { -1, 0, 1, 0 };
    private final int[] DY = { 0, 1, 0, -1 };

    public int shortestBridge(int[][] grid) {
      int n = grid.length;

      boolean[][] visited = new boolean[n][n];
      Queue<int[]> queue = new ArrayDeque<>();

      boolean found = false;
      for (int i = 0; i < n && !found; i++) {
        for (int j = 0; j < n && !found; j++) {
          if (grid[i][j] == 1) {
            dfs(i, j, n, grid, visited, queue);
            found = true;
          }
        }
      }

      int res = 0;
      while (!queue.isEmpty()) {
        int sz = queue.size();

        for (int node = 0; node < sz; node++) {
          int[] curr = queue.poll();

          for (int dir = 0; dir < 4; dir++) {
            int x = curr[0] + DX[dir];
            int y = curr[1] + DY[dir];

            if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
              if (grid[x][y] == 1) {
                return res;
              }
              visited[x][y] = true;
              queue.add(new int[] { x, y });
            }
          }
        }
        res++;
      }

      return res;

    }

    private void dfs(int x, int y, int n, int[][] grid, boolean[][] visited, Queue<int[]> queue) {
      visited[x][y] = true;
      queue.add(new int[] { x, y });

      for (int i = 0; i < 4; i++) {
        int u = x + DX[i];
        int v = y + DY[i];

        if (u >= 0 && u < n && v >= 0 && v < n && !visited[u][v] && grid[u][v] == 1) {
          dfs(u, v, n, grid, visited, queue);
        }
      }
    }
  }
}
