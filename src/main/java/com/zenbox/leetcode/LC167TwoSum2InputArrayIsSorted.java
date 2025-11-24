package com.zenbox.leetcode;

/**
 * {@code LC167TwoSum2InputArrayIsSorted}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted">LeetCode Problem 167: Two Sum II - Input Array Is Sorted</a>.
 * </p>
 */
public class LC167TwoSum2InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(numbers[i] + numbers[j] != target) {
            if(numbers[i] + numbers[j] > target) j--;
            else i++;
        }

        return new int[] { i + 1, j + 1 };
    }
}
