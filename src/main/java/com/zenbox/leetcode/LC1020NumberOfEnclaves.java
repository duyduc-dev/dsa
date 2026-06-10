package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * {@code LC1020NumberOfEnclaves}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/number-of-enclaves">1020.
 * Number of Enclaves</a>.
 * </p>
 */
public class LC1020NumberOfEnclaves {

  public static void main(String[] args) {
    LC1020NumberOfEnclaves.SolutionTimeLimited sol = new LC1020NumberOfEnclaves.SolutionTimeLimited();
    int[][] grid = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
    int[][] grid3 = { { 0 }, { 1 }, { 1 }, { 0 }, { 0 } };
    int[][] grid7 = {
        { 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
        { 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0 },
        { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0 },
        { 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        { 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0 },
        { 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
        { 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0 },
        { 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0 },
        { 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
        { 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1 }
    };

    System.out.println(">> " + sol.numEnclaves(grid7));
  }

  static class Solution {

    final int[] DX = { -1, 0, 1, 0 };
    final int[] DY = { 0, 1, 0, -1 };

    public int numEnclaves(int[][] grid) {
      int n = grid.length;
      int m = n == 0 ? 0 : grid[0].length;

      boolean[][] visited = new boolean[n][m];
      Queue<int[]> queue = new ArrayDeque<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) &&
              grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            queue.add(new int[] { i, j });
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        for (int dir = 0; dir < 4; ++dir) {
          int x = curr[0] + DX[dir];
          int y = curr[1] + DY[dir];

          if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            queue.add(new int[] { x, y });
          }
        }
      }

      int res = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1 && !visited[i][j]) {
            res++;
          }
        }
      }

      return res;
    }

  }

  static class SolutionTimeLimited {

    final int[] DX = { -1, 0, 1, 0 };
    final int[] DY = { 0, 1, 0, -1 };

    public int numEnclaves(int[][] grid) {
      int n = grid.length;
      int m = n == 0 ? 0 : grid[0].length;

      int res = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) {
            if (!bfs(new int[] { i, j }, grid)) {
              res++;
            }
            ;
          }
        }
      }

      return res;
    }

    private boolean bfs(int[] root, int[][] grid) {
      int n = grid.length;
      int m = n == 0 ? 0 : grid[0].length;

      Queue<int[]> queue = new ArrayDeque<>();
      boolean[][] visited = new boolean[n][m];

      queue.add(root);
      visited[root[0]][root[1]] = true;

      while (!queue.isEmpty()) {
        int[] curr = queue.poll();

        for (int dir = 0; dir < 4; dir++) {
          int x = curr[0] + DX[dir];
          int y = curr[1] + DY[dir];

          if (x < 0 || y < 0 || x >= n || y >= m) {
            return true;
          }

          if (grid[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            queue.add(new int[] { x, y });
          }
        }

      }

      return false;
    }
  }
}
