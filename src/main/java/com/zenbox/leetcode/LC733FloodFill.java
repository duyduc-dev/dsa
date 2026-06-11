package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * {@code LC733FloodFill}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/daily-temperatures">733.
 * Flood Fill</a>.
 * </p>
 * 
 * [
 * [1,2,1],
 * [2,1,2],
 * [1,2,1]]
 */
public class LC733FloodFill {

    public static void main(String[] args) {
        LC733FloodFill lc733 = new LC733FloodFill();
        Solution solution = lc733.new Solution();

        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;

        int[][] res = solution.floodFill(image, sr, sc, color);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    class Solution {

        final int[] DX = { -1, 0, 1, 0 };
        final int[] DY = { 0, 1, 0, -1 };

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int n = image.length;
            int m = n == 0 ? 0 : image[0].length;

            int[][] res = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    res[i][j] = image[i][j];
                }
            }

            boolean[][] visited = new boolean[n][m];
            Queue<int[]> queue = new ArrayDeque<>();

            queue.add(new int[] { sr, sc });
            res[sr][sc] = color;
            visited[sr][sc] = true;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int x = DX[dir] + curr[0];
                    int y = DY[dir] + curr[1];

                    if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && image[x][y] != color && image[x][y] == image[sr][sc]) {
                        res[x][y] = color;
                        visited[x][y] = true;
                        queue.add(new int[] { x, y });
                    }
                }
            }

            return res;

        }
    }
}
