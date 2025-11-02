package com.zenbox.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * {@code LC128LongestConsecutiveSequence}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/longest-consecutive-sequence">LeetCode Problem 128: Longest Consecutive Sequence</a>.
 * </p>
 */
public class LC128LongestConsecutiveSequence {

    /**
     * Time: O(n)
     * Space:  O(n)
     * @param nums
     * @return
     */
    public int longestConsecutiveWithSetAndNonRemove(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int longest = 0;
        for(int num: set) {
            if(set.contains(num - 1)) continue;
            int size = 1;
            int curr = num;
            while (set.contains(curr + 1)) {
                size++;
                curr++;
            }
            longest = Math.max(longest, size);
        }

        return longest;
    }

    /**
     * Time: O(n)
     * Space:  O(n)
     * @param nums
     * @return
     */
    public int longestConsecutiveWithSetAndRemove(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int longest = 0;
        for(int num: nums) {
            if(set.contains(num - 1)) continue;
            int size = 1;
            while (set.contains(num + size)) {
                set.remove(num + size);
                size++;
            }
            longest = Math.max(longest, size);
        }

        return longest;
    }

    /**
     * Time: O(n^2)
     * Space:  O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums); // nlog(n)
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int num: nums) { // O(n^2)
            boolean isAdded = false;
            if(map.containsKey(num - 1)) {
                map.get(num - 1).add(num);
            }
            for(var item: map.entrySet()) {
                if(item.getValue().contains(num - 1)) {
                    item.getValue().add(num);
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded) {
                map.putIfAbsent(num, new HashSet<>());
                map.get(num).add(num);
            }
        }

        int maxSize = 0;
        for(int key: map.keySet()) { // O(n)
            if(map.get(key).size() > maxSize) {
                maxSize = map.get(key).size();
            }
        }

        return maxSize;
    }
}
