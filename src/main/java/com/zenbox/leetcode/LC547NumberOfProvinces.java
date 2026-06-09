package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * {@code LC547NumberOfProvinces}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/number-of-provinces">547. Number of
 * Provinces</a>.
 * </p>
 */
public class LC547NumberOfProvinces {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            if (n <= 1)
                return n;

            boolean[] visited = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    res++;
                    bfs(isConnected, visited, i);
                }

            }

            return res;
        }

        private void bfs(int[][] isConnected, boolean[] visited, int root) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(root);
            visited[root] = true;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                
                for (int i = 0; i < isConnected[curr].length; i++) {
                    if (isConnected[curr][i] == 1 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
}
