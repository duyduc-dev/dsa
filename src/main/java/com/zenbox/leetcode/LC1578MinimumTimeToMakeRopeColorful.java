package com.zenbox.leetcode;

/**
 * {@code LC1834SingleThreadedCPU}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/single-threaded-cpu/">1834.
 * Single-Threaded CPU</a>.
 * </p>
 */
public class LC1578MinimumTimeToMakeRopeColorful {
    class Solution {
        public int minCost(String colors, int[] neededTime) {
            int l = 0, r = 0;
            int n = neededTime.length;
            int res = 0;

            while (l <= r && r < n) {
                int maxTime = 0;
                while (l <= r && r < n && colors.charAt(l) == colors.charAt(r)) {
                    res += neededTime[r];
                    maxTime = Math.max(maxTime, neededTime[r]);
                    r++;
                }

                res -= maxTime;
                l = r;
            }

            return res;
        }
    }
}
