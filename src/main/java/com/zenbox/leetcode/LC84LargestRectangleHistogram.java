package com.zenbox.leetcode;

import java.util.Stack;

/**
 * {@code LC84LargestRectangleHistogram}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/largest-rectangle-in-histogram">LeetCode Problem 84: Largest Rectangle in Histogram</a>.
 * </p>
 */
public class LC84LargestRectangleHistogram {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param heights
     * @return
     */
    public int largestRectangleAreaWithStack(int[] heights) {
        Stack<Integer[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if(stack.isEmpty() || height > stack.peek()[1]) {
                stack.push(new Integer[] { i, height });
            } else if(height < stack.peek()[1]) {
                Integer[] last = stack.pop();
                while (last != null && last[1] > height) {
                    int area = last[1] * (i - last[0]);
                    if(maxArea < area) maxArea = area;
                    if(stack.isEmpty() || stack.peek()[1] < height) break;
                    last = stack.pop();
                }
                int index = last == null ? 0 : last[0];
                stack.push(new Integer[] { index, height });
            }
        }

        if(!stack.isEmpty()) {
            Integer[] curr = stack.pop();
            int lastIndex = heights.length - 1;
            while(curr != null) {
                int area = (lastIndex - curr[0] + 1) * curr[1];
                if(maxArea < area) maxArea = area;
                curr = stack.isEmpty() ? null : stack.pop();
            }
        }

        return maxArea;
    }

    /**
     * Time: O(n^2)
     * Space: O(1)
     * @param heights
     * @return
     */
    public int largestRectangleAreaBruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                if(minHeight > heights[j]) {
                    minHeight = heights[j];
                }
                int max = minHeight * (j - i + 1);
                if(maxArea < max) {
                    maxArea = max;
                }
            }
        }
        return maxArea;
    }

    /**
     * O(n^2)
     * Space O(1)
     * @param heights
     * @return
     */
    public int largestRectangleAreaBruteForceV2(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int right = i + 1;
            while(right < n && heights[right] >= height) {
                right++;
            }

            int left = i - 1;
            while(left >= 0 && heights[left] >= height) {
                left--;
            }

            right--;
            left++;

            maxArea = Math.max(maxArea, height * (right - left + 1));
        }
        return maxArea;
    }
}
