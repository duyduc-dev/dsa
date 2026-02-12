package com.zenbox.leetcode;

/**
 * {@code LC42TrappingRainWater}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/3sum/">LeetCode Problem
 * 42: Trapping rain water</a>.
 * </p>
 */
public class LC42TrappingRainWater {

    public static void main(String[] args) {
        LC42TrappingRainWater trap = new LC42TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap.trapTwoPoint(height));
    }

    /**
     * Two point
     * Time: O(n)
     * Space: O(1)
     * @param height
     * @return
     */
    public int trapTwoPoint(int[] height) {
        int waterTrapped = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxLeft = height[l];
        int maxRight = height[r];

        while (l <= r) {
            if (height[l] <= height[r]) {
                maxLeft = Math.max(maxLeft, height[l]);
                waterTrapped += maxLeft - height[l];
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r]);
                waterTrapped += maxRight - height[r];
                r--;
            }
        }

        return waterTrapped;
    }

    /**
     * Brute force
     * Time: O(n^2)
     * Space: O(1)
     * @param height
     * @return
     */
    public int trapBruteforce(int[] height) {

        int waterTrapped = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            int maxLeft = 0;
            for (int l = 0; l <= i; l++) {
                if (height[l] > maxLeft)
                    maxLeft = height[l];
            }

            int maxRight = 0;
            for (int r = i; r < n; r++) {
                if (height[r] > maxRight)
                    maxRight = height[r];
            }

            int level = Math.min(maxLeft, maxRight);

            waterTrapped += level - height[i];
        }

        return waterTrapped;
    }
}
