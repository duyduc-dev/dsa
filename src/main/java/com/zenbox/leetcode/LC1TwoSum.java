package com.zenbox.leetcode;

import java.util.HashMap;

/**
 * {@code LC1TwoSum}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/two-sum">LeetCode Problem 1: Two Sum</a>.
 * </p>
 * <p>
 * Given an array of integers {@code nums} and an integer {@code target},
 * return the indices of the two numbers such that they add up to {@code target}.
 * </p>
 */
public class LC1TwoSum {

    /**
     * Time complexity: O(n)
     * Space complexity O(n)
     *
     * @param nums array of integers
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)) {
                return new int[] { map.get(num), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
