package com.zenbox.leetcode;

/**
 * {@code LC45JumpGame2}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/jump-game-ii/">45. Jump
 * Game II</a>.
 * </p>
 */
public class LC45JumpGame2 {
  class Solution {
    public int jump(int[] nums) {
      int curr = 0;
      int count = 0;
      int n = nums.length;

      while (curr < n - 1) {
        int next = curr + 1;
        int maxReach = Math.min(n - 1, curr + nums[curr]);

        if (maxReach == n - 1)
          return count + 1;

        for (int i = next; i <= maxReach; i++) {
          if (i + nums[i] > next + nums[next]) {
            next = i;
          }
        }

        curr = next;
        count++;
      }

      return count;
    }
  }
}
