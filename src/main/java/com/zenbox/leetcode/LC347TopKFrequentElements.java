package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@code LC347TopKFrequentElements}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/top-k-frequent-elements">LeetCode Problem 347: Top K Frequent Elements</a>.
 * </p>
 */
public class LC347TopKFrequentElements {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] value = new ArrayList[nums.length + 1];
        for(Map.Entry<Integer, Integer> data: map.entrySet()) {
            if(value[data.getValue()] == null) {
                value[data.getValue()] = new ArrayList<>();
            }
            value[data.getValue()].add(data.getKey());
        }

        int[] res = new int[k];
        for(int i = value.length - 1, j = 0; i >= 0 && j < k; i--) {
            if(value[i] != null && !value[i].isEmpty()) {
                for(int num: value[i]) {
                    res[j++] = num;
                }
            }
        }

        return res;
    }
}
