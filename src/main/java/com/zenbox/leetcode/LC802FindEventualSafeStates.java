package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code LC802FindEventualSafeStates}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/find-eventual-safe-states">802. Find Eventual
 * Safe States</a>.
 * </p>
 */
public class LC802FindEventualSafeStates {

  public static void main(String[] args) {

    LC802FindEventualSafeStates.Solution sol = new LC802FindEventualSafeStates().new Solution();
    int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
    System.out.println("> " + sol.eventualSafeNodes(graph));
  }

  class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      boolean[] visited = new boolean[n];
      boolean[] path = new boolean[n];

      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          dfs(i, graph, visited, path);
        }
      }

      List<Integer> res = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        if (!path[i])
          res.add(i);
      }

      return res;
    }

    private boolean dfs(int root, int[][] graph, boolean[] visited, boolean[] path) {
      visited[root] = true;
      path[root] = true;

      for (int node : graph[root]) {
        if (!visited[node]) {
          if (!dfs(node, graph, visited, path)) {
            // This is a cycle
            return false;
          }
        } else if (path[node]) {
          // This is a cycle
          return false;
        }
      }

      path[root] = false;
      return true;
    }

  }
}
