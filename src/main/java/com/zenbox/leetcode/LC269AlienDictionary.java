package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@code LC269AlienDictionary}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/alien-dictionary/">
 * 269 Alien Dictionary
 * </a>.
 * </p>
 */
public class LC269AlienDictionary {
  class Solution {
    public String foreignDictionary(String[] words) {
      Map<Integer, List<Integer>> cons = new HashMap<>();

      for (String word : words) {
        for (char ch : word.toCharArray()) {
          cons.putIfAbsent(ch - 'a', new ArrayList<>());
        }
      }

      for (int i = 0; i < words.length - 1; i++) {
        char[] w1 = words[i].toCharArray();
        char[] w2 = words[i + 1].toCharArray();

        for (int j = 0; j < w1.length; j++) {
          if (j >= w2.length)
            return "";

          if (w1[j] == w2[j])
            continue;

          cons.get(w1[j] - 'a').add(w2[j] - 'a');
          break;
        }
      }

      boolean[] visited = new boolean[26];
      boolean[] path = new boolean[26];

      StringBuilder sb = new StringBuilder();

      for (int key : cons.keySet()) {
        if (!visited[key] && !dfs(key, visited, path, cons, sb)) {
          return "";
        }
      }

      return sb.toString();
    }

    private boolean dfs(int curr, boolean[] visited, boolean[] path, Map<Integer, List<Integer>> cons,
        StringBuilder sb) {

      visited[curr] = true;
      path[curr] = true;

      for (Integer key : cons.get(curr)) {
        if (!visited[key]) {
          if (!dfs(key, visited, path, cons, sb))
            return false;
        } else if (path[key])
          return false;
      }

      path[curr] = false;
      sb.insert(0, (char) (curr + 'a'));
      return true;
    }
  }
}
