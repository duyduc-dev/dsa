package com.zenbox.leetcode;

/**
 * {@code LC238ProductOfArrayExceptSelf}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/contains-duplicate">LeetCode Problem 238: Product of array except self</a>.
 * </p>
 */
public class LC238ProductOfArrayExceptSelf {


    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelfWithPrefixAndSuffixOptimize(int[] nums) {
       int[] res = new int[nums.length];

       res[0] = 1;

       for(int i = 1; i < nums.length; i++) {
           res[i] = res[i - 1] * nums[i - 1];
       }

       int postfix = 1;
       for(int i = nums.length - 1; i >= 0; i--) {
           res[i] *= postfix;
           postfix *= nums[i];
       }

       return res;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelfWithPrefixAndSuffix(int[] nums) {
       int n = nums.length;
       int[]
           res = new int[n],
           prefix = new int[n],
           suffix = new int[n];

       prefix[0] = 1;
       suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = suffix[i] * prefix[i];
        }

       return res;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelfWithDivision(int[] nums) {
        int multipleValue = 1;
        int zeroCount = 0;
        for(int num: nums) {
            if(num == 0) zeroCount++;
            else multipleValue *= num;
        }

        if(zeroCount > 1) return new int[nums.length];

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if(nums[i] == 0) result[i] = multipleValue;
            else result[i] = zeroCount > 0 ? 0 : multipleValue / nums[i];
        }

        return result;
    }

    /**
     * Brute force
     * TIme: O(n^2)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int value = 1;
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                value *= nums[j];
            }
            result[i] = value;
        }
        return result;
    }
}
