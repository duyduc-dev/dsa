package com.zenbox.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * {@code LC378KthSmallestElementInASortedMatrix}
 * <p>
 * Solution for
 * <a href=
 * "https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix">378.
 * Kth Smallest Element in a Sorted Matrix</a>.
 * </p>
 */
public class LC378KthSmallestElementInASortedMatrix {

    class SolutionFlatArray {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;

            int[] flat = new int[n * n];

            int i = 0;
            for (int[] x : matrix) {
                for (int y : x) {
                    flat[i++] = y;
                }
            }

            Arrays.sort(flat);

            return flat[k - 1];
        }
    }

    class SolutionPriorityQueue {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>();

            for (int[] m : matrix) {
                for (int i : m) {
                    q.add(i);
                }
            }

            int res = 0;
            while (k-- > 0) {
                res = q.poll();
            }

            return res;
        }
    }

    class SolutionPriorityQueueFaster {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>();

            for (int[] m : matrix) {
                for (int i : m) {
                    q.add(-i);
                    if (q.size() > k)
                        q.poll();
                }
            }

            return -q.poll();

        }
    }
}
