package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * {@code LC347TopKFrequentElements}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/top-k-frequent-elements">LeetCode
 * Problem 347: Top K Frequent Elements</a>.
 * </p>
 */
public class LC347TopKFrequentElements {

    public static void main(String[] args) {
        SolutionPriorityQueue run = new SolutionPriorityQueue();

        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        int[] res = run.topKFrequent(nums, k);

        System.out.println(Arrays.toString(res));
    }

    static class SolutionPriorityQueue {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> m = new HashMap();

            for (int n : nums) {
                m.put(n, m.getOrDefault(n, 0) + 1);
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for (int n : m.keySet()) {
                q.add(new int[] { -m.get(n), n });
            }

            int[] res = new int[k];

            for (int i = 0; i < k; i++) {
                res[i] = q.poll()[1];
            }

            return res;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * 
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        List<Integer>[] value = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> data : map.entrySet()) {
            if (value[data.getValue()] == null) {
                value[data.getValue()] = new ArrayList<>();
            }
            value[data.getValue()].add(data.getKey());
        }

        int[] res = new int[k];
        for (int i = value.length - 1, j = 0; i >= 0 && j < k; i--) {
            if (value[i] != null && !value[i].isEmpty()) {
                for (int num : value[i]) {
                    res[j++] = num;
                }
            }
        }

        return res;
    }
}
