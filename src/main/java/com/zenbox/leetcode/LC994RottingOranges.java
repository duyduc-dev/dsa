package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * {@code LC994RottingOranges}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/rotting-oranges">994.
 * Rotting Oranges</a>.
 * </p>
 */
public class LC994RottingOranges {

    class Solution {

        int[] DX = { -1, 0, 1, 0 };
        int[] DY = { 0, 1, 0, -1 };

        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = n == 0 ? 0 : grid[0].length;
            if (m == 0 || n == 0)
                return 0;

            Queue<int[]> queue = new ArrayDeque<>();
            int[][] rottenMinute = new int[n][m];
            int freshCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        freshCount++;
                    }
                    if (grid[i][j] == 2) {
                        queue.add(new int[] { i, j });
                        rottenMinute[i][j] = 1;
                    }
                }
            }

            int res = 1, rottenCount = 0;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                res = rottenMinute[curr[0]][curr[1]];
                for (int dir = 0; dir < 4; dir++) {
                    int x = curr[0] + DX[dir];
                    int y = curr[1] + DY[dir];
                    if (x < n && y < m && x >= 0 && y >= 0 && grid[x][y] == 1 && rottenMinute[x][y] == 0) {
                        rottenMinute[x][y] = rottenMinute[curr[0]][curr[1]] + 1;
                        queue.add(new int[] { x, y });
                        rottenCount++;
                    }
                }
            }

            return rottenCount == freshCount ? res - 1 : -1;
        }
    }
}
