package com.zenbox.leetcode;

/**
 * {@code LC1834SingleThreadedCPU}
 * <p>
 * Solution for
 * <a href=
 * "https://leetcode.com/problems/minimum-time-to-make-rope-colorful">1578.
 * Minimum Time to Make Rope Colorful</a>.
 * </p>
 */
public class LC1578MinimumTimeToMakeRopeColorful {
    class Solution {
        public int minCost(String colors, int[] neededTime) {
            int l = 0, r = 0, n = colors.length(), res = 0, max = 0;

            while (l <= r && r < n) {
                max = 0;

                while (r < n && colors.charAt(l) == colors.charAt(r)) {
                    res += neededTime[r];
                    max = Math.max(max, neededTime[r]);
                    r++;
                }

                res -= max;
                l = r;
            }

            return res;
        }
    }
}
