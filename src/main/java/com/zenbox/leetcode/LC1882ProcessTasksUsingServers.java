package com.zenbox.leetcode;

import java.util.PriorityQueue;

/**
 * {@code LC1882ProcessTasksUsingServers}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/process-tasks-using-servers">1882.
 * Process Tasks Using Servers</a>.
 * </p>
 */
public class LC1882ProcessTasksUsingServers {
   class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        // [weight, index]
        PriorityQueue<int[]> frees = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // [excution time, index]
        PriorityQueue<int[]> busies = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            frees.add(new int[] { servers[i], i });
        }

        int[] res = new int[m];

        int i = 0;
        int idxRes = 0;
        int t = 0;

        while (idxRes < m) {
            while (!busies.isEmpty() && busies.peek()[0] <= t) {
                int[] busyServer = busies.poll();
                frees.add(new int[] { servers[busyServer[1]], busyServer[1] });
            }

            if (!frees.isEmpty()) {
                int[] freeServer = frees.poll();
                busies.add(new int[] { t + tasks[i], freeServer[1] });
                i++;
                t = Math.max(t, i);
                res[idxRes++] = freeServer[1];
            } else {
                t = busies.peek()[0];
            }
        }

        return res;
    }
}
}
