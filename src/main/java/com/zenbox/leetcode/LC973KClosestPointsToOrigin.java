package com.zenbox.leetcode;

import java.util.PriorityQueue;

/**
 * {@code LC973KClosestPointsToOrigin}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin">973. K
 * Closest Points to Origin</a>.
 * </p>
 */
public class LC973KClosestPointsToOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

            for (int i = 0; i < points.length; i++) {
                q.add(new int[] { distanceToOrigin(points[i]), i });
            }

            int[][] res = new int[k][2];

            for (int i = 0; i < k; i++) {
                int[] pNearest = q.poll();
                res[i] = points[pNearest[1]];
            }

            return res;
        }

        private int distanceToOrigin(int[] p) {
            return distance(p, new int[] { 0, 0 });
        }

        private int distance(int[] p1, int[] p2) {
            return (int) Math.pow(p1[0] - p2[0], 2) + (int) Math.pow(p1[1] - p2[1], 2);
        }
    }
}
