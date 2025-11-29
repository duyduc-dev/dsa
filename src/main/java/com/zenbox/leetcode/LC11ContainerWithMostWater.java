package com.zenbox.leetcode;

/**
 * {@code LC11ContainerWithMostWater}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/3sum/">LeetCode Problem 11: Container with most water</a>.
 * </p>
 */
public class LC11ContainerWithMostWater {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param height
     * @return
     */
    public int maxAreaTwoPoint(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int hLeft = height[left];
            int hRight = height[right];

            int area = (right - left) * Math.min(hLeft, hRight);
            if (area > maxArea) {
                maxArea = area;
            }

            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Brute force
     * Time: O(n^2)
     * Space: O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;

        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return maxArea;
    }
}
