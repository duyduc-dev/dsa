package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * {@code LC417PacificAtlanticWaterFlow}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">417.
 * Pacific Atlantic Water Flow</a>.
 * </p>
 * 
 */
public class LC417PacificAtlanticWaterFlow {

  public static void main(String[] args) {
    int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } };

    LC417PacificAtlanticWaterFlow a = new LC417PacificAtlanticWaterFlow();
    LC417PacificAtlanticWaterFlow.Solution b = a.new Solution();

    var res = b.pacificAtlantic(heights);
    System.out.println(res);
  }

  class Solution {

    final int[] DX = { -1, 0, 1, 0 };
    final int[] DY = { 0, 1, 0, -1 };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
      int n = heights.length;
      int m = n == 0 ? 0 : heights[0].length;
      List<List<Integer>> res = new ArrayList<>();

      boolean[][] pacificVisited = new boolean[n][m];
      boolean[][] atlanticVisited = new boolean[n][m];

      Queue<int[]> queue = new ArrayDeque<>();

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if ((i == 0 || j == 0) && !pacificVisited[i][j]) {
            queue.add(new int[] { i, j });
            pacificVisited[i][j] = true;
          }
          if ((i == n - 1 || j == m - 1) && !atlanticVisited[i][j]) {
            queue.add(new int[] { i, j });
            atlanticVisited[i][j] = true;
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        for (int dir = 0; dir < 4; dir++) {
          int x = curr[0] + DX[dir];
          int y = curr[1] + DY[dir];

          if (x >= 0 && y >= 0 && x < n && y < m && heights[x][y] >= heights[curr[0]][curr[1]]) {
            if (pacificVisited[curr[0]][curr[1]] && !pacificVisited[x][y]) {
              pacificVisited[x][y] = true;
              queue.add(new int[] { x, y });
            }
            if (atlanticVisited[curr[0]][curr[1]] && !atlanticVisited[x][y]) {
              atlanticVisited[x][y] = true;
              queue.add(new int[] { x, y });
            }
          }
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (pacificVisited[i][j] && atlanticVisited[i][j]) {
            res.add(List.of(i, j));
          }
        }
      }

      return res;
    }
  }
}
