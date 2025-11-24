package com.zenbox.leetcode;

import java.util.*;

/**
 * {@code LC15ThreeSum}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/3sum/">LeetCode Problem 15: 3Sum</a>.
 * </p>
 */
public class LC15ThreeSum {

    /**
     * Time O(n^2)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumWithSpaceOptimize(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) k--;
                else if(sum < 0) j++;
                else {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--; // we can ignore it
                }
            }
        }

        return res;
    }


    /**
     * Time: O(n^2)
     * SpaceL O(n^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Map<String, List<Integer>> res = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while(j < k) {
                if(nums[j] + nums[k] > -nums[i]) k--;
                else if(nums[j] + nums[k] < -nums[i]) j++;
                else {
                    Integer[] key = new Integer[] {nums[i], nums[j], nums[k]};
                    Arrays.sort(key);
                    res.put(Arrays.toString(key), List.of(key));
                    j++;
                };
            }
        }
        return res.values().stream().toList();
    }
}
