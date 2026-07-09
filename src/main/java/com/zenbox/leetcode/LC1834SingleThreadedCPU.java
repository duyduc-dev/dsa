package com.zenbox.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * {@code LC1834SingleThreadedCPU}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/single-threaded-cpu/">1834.
 * Single-Threaded CPU</a>.
 * </p>
 */
public class LC1834SingleThreadedCPU {
  class Solution {
    public int[] getOrder(int[][] tasks) {
      int n = tasks.length;
      int[][] sortedTasks = new int[n][3];

      for (int i = 0; i < n; i++) {
        sortedTasks[i] = new int[] { tasks[i][0], tasks[i][1], i };
      }

      Arrays.sort(sortedTasks, (a, b) -> a[0] != b[0]
          ? Integer.compare(a[0], b[0])
          : Integer.compare(a[2], b[2]));

      PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] != b[0]
          ? Integer.compare(a[0], b[0])
          : Integer.compare(a[1], b[1]));

      int[] res = new int[n];

      int idxRes = 0;
      int i = 0;
      int t = 0;

      while (idxRes < n) {
        while (i < n) {
          int[] task = sortedTasks[i];
          if (task[0] <= t) {
            q.add(new int[] { task[1], task[2] });
            i++;
          } else
            break;
        }

        if (!q.isEmpty()) {
          int[] task = q.poll();
          res[idxRes++] = task[1];
          t += task[0];
        } else {
          t = sortedTasks[i][0];
        }
      }

      return res;
    }
  }
}
