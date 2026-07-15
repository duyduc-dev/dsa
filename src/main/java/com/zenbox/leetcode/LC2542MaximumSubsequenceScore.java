package com.zenbox.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * {@code LC2542MaximumSubsequenceScore}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/">2542.
 * Maximum Subsequence Score</a>.
 * </p>
 */
public class LC2542MaximumSubsequenceScore {
  class Solution {

    /**
     * int arr = [{14,13},{2,11},{1,7},{12,6}]
     * k = 3
     * 
     * i = 0 -> sum = 14, q = [14]
     * i = 1 -> sum = 16, q = [14,2]
     * i = 2 -> sum = 17, q = [14,2,1], res = 0
     * -> i >= k - 1 -> res = max(res, 17 * 7) = 119
     * i = 3 -> sum = 29, q = [14,2,1,6], res = 119
     * -> i >= k -> sum -= q.poll() = 29 - 1 = 28
     * -> res = max(119, 28 * 6) = 168
     * 
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
      int n = nums1.length;
      int[][] arr = new int[n][2];

      for (int i = 0; i < n; i++) {
        arr[i] = new int[] { nums1[i], nums2[i] };
      }

      Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

      PriorityQueue<Integer> q = new PriorityQueue<>();

      long sum = 0;
      long res = 0;

      for (int i = 0; i < n; i++) {
        q.offer(arr[i][0]);
        sum += arr[i][0];

        if (i >= k) {
          sum -= q.poll();
        }

        if (i >= k - 1) {
          res = Math.max(res, sum * arr[i][1]);
        }
      }

      return res;
    }
  }
}
