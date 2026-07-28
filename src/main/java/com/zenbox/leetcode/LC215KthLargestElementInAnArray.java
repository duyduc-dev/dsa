package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.List;
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

  class SolutionDivideAndConquer {
    public int findKthLargest(int[] nums, int k) {
      List<Integer> l = new ArrayList<>(),
          m = new ArrayList<>(),
          r = new ArrayList<>();
      int n = nums.length;

      int pivot = nums[(int) (Math.random() * n)];

      for (int num : nums) {
        if (num > pivot)
          r.add(num);
        if (num == pivot)
          m.add(num);
        if (num < pivot)
          l.add(num);
      }

      if (k <= r.size())
        return findKthLargest(r.stream().mapToInt(Integer::intValue).toArray(), k);

      k -= r.size();

      if (k <= m.size())
        return pivot;

      k -= m.size();

      return findKthLargest(l.stream().mapToInt(Integer::intValue).toArray(), k);

    }
  }

  /**
   * Using priority queue (min-heap)
   * Solution
   */
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
