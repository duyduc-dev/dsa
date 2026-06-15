package com.zenbox.leetcode;

/**
 * {@code LC785IsGraphBipartite}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/is-graph-bipartite">785. Is Graph
 * Bipartite?</a>.
 * </p>
 */
public class LC785IsGraphBipartite {
  class Solution {
    public boolean isBipartite(int[][] graph) {
      int n = graph.length;

      int[] colors = new int[n]; // 0: unvisited, 1: set A, 2: set B

      for (int i = 0; i < n; i++) {
        if (colors[i] == 0 && !dfs(i, colors, graph, 1)) {
          return false;
        }
      }

      return true;
    }

    private boolean dfs(int node, int[] colors, int[][] graph, int color) {
      if (colors[node] != 0) {
        return colors[node] == color;
      }

      colors[node] = color;
      int nextColor = color == 1 ? 2 : 1;

      for (int curr : graph[node]) {
        if (!dfs(curr, colors, graph, nextColor)) {
          return false;
        }
      }

      return true;
    }
  }

}
