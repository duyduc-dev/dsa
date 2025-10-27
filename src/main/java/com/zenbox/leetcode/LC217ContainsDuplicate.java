package com.zenbox.leetcode;

import java.util.*;

/**
 * {@code LC217ContainsDuplicate}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/contains-duplicate">LeetCode Problem 217: Contains Duplicate</a>.
 * </p>
 */
public class LC217ContainsDuplicate {

    /**
     * Algorithms: Brute force
     * Time: O(n^2)
     * Space: O(1)
     * @param nums
     * @return true if array contains the duplicate
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    /**
     * Time: O(nlog(n))
     * Space: O(1)
     * @param nums
     * @return
     */
    public boolean containsDuplicateWithSorted(int[] nums) {
        Arrays.sort(nums); // O(nlog(n))

        // O(n)
        for (int i = 0, j = i + 1; j < nums.length && i < j; i++, j++) {
           if(nums[i] == nums[j]) return true;
        }
        return false;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicateWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicateWithMap(int[] nums) {
        Map<Integer, Integer> store = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(store.containsKey(nums[i])) {
                return true;
            }
            store.put(nums[i], 1);
        }
        return false;
    }
}
