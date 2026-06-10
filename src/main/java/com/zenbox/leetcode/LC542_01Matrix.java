package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * {@code LC542_01Matrix}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/01-matrix">542. 01
 * Matrix</a>.
 * </p>
 */
public class LC542_01Matrix {

    class Solution {

        final int[] DX = { -1, 0, 1, 0 };
        final int[] DY = { 0, 1, 0, -1 };

        public int[][] updateMatrix(int[][] mat) {
            int n = mat.length;
            int m = n == 0 ? 0 : mat[0].length;

            Queue<int[]> queue = new ArrayDeque<>();
            int[][] res = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new int[] { i, j });
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                for (int dir = 0; dir < 4; ++dir) {
                    int x = DX[dir] + curr[0];
                    int y = DY[dir] + curr[1];

                    if (x >= 0 && y >= 0 && x < n && y < m && mat[x][y] == 1 && res[x][y] == 0) {
                        res[x][y] = 1 + res[curr[0]][curr[1]];
                        queue.add(new int[] { x, y });
                    }

                }
            }

            return res;
        }
    }
}
