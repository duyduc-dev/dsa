package com.zenbox.leetcode;

import java.util.PriorityQueue;

/**
 * {@code LC215KthLargestElementInAnArray}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215.
 * Kth Largest Element in an Array</a>.
 * </p>
 */
public class LC215KthLargestElementInAnArray {
  class Solution {
    public int findKthLargest(int[] nums, int k) {
      PriorityQueue<Integer> q = new PriorityQueue<>();

      for (int num : nums) {
        q.add(num);

        if (q.size() > k)
          q.poll();
      }

      return q.peek();
    }
  }
}
