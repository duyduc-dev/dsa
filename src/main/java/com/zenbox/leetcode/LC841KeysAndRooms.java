package com.zenbox.leetcode;

import java.util.List;

/**
 * {@code LC841KeysAndRooms}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/keys-and-rooms/">841. Keys and
 * Rooms</a>.
 * </p>
 */
public class LC841KeysAndRooms {
  class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      int n = rooms.size();
      boolean[] visited = new boolean[n];

      dfs(rooms, visited, 0);

      for (boolean v : visited) {
        if (!v) {
          return false;
        }
      }

      return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int root) {
      visited[root] = true;
      for (int node : rooms.get(root)) {
        if (!visited[node]) {
          dfs(rooms, visited, node);
        }
      }
    }
  }
}
