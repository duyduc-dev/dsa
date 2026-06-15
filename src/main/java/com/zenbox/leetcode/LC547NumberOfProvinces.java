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

    class SolutionDFS {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];

            int numberOfProvinces = 0;
            for (int node = 0; node < n; node++) {
                if (!visited[node]) {
                    numberOfProvinces++;
                    dfs(isConnected, visited, node);
                }
            }

            return numberOfProvinces;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int root) {
            visited[root] = true;
            for (int i = 0; i < isConnected.length; i++) {
                if (!visited[i] && isConnected[root][i] == 1) {
                    visited[i] = true;
                    dfs(isConnected, visited, i);
                }
            }
        }
    }

    class SolutionBFS {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];

            int numberOfProvinces = 0;
            for (int node = 0; node < n; node++) {
                if (!visited[node]) {
                    visited[node] = true;
                    numberOfProvinces++;
                    bfs(isConnected, visited, node);
                }
            }

            return numberOfProvinces;
        }

        private void bfs(int[][] isConnected, boolean[] visited, int root) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int currNode = queue.poll();
                int[] edges = isConnected[currNode];
                for (int node = 0; node < edges.length; node++) {
                    if (edges[node] == 1 && !visited[node]) {
                        visited[node] = true;
                        queue.add(node);
                    }
                }
            }
        }
    }
}
