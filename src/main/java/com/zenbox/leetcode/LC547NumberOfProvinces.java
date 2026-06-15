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

            int res = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    res++;
                    dfs(i, isConnected, visited);
                }
            }

            return res;
        }

        private void dfs(int root, int[][] isConnected, boolean[] visited) {
            visited[root] = true;

            for (int node = 0; node < isConnected.length; node++) {
                if (!visited[node] && isConnected[root][node] == 1) {
                    dfs(node, isConnected, visited);
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
