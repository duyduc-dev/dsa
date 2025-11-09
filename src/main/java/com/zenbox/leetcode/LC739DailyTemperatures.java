package com.zenbox.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * {@code LC739DailyTemperatures}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/daily-temperatures">LeetCode Problem 739: Daily Temperatures</a>.
 * </p>
 */
public class LC739DailyTemperatures {

    public int[] dailyTemperaturesWithStackImprove(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperaturesWithStackAndMap(int[] temperatures) {
        int n = temperatures.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        stack.push(temperatures[n - 1]);
        map.put(temperatures[n - 1], n - 1);

        for(int i = n - 2; i >= 0; i--) {
            Integer maxTemp = stack.peek();
            int curr = temperatures[i];
            while(maxTemp != null && curr >= maxTemp) {
                map.remove(maxTemp);
                stack.pop();
                maxTemp = stack.isEmpty() ? null : stack.peek();
            }
            if(maxTemp != null && curr < maxTemp) {
                int indexMaxTemp = map.get(maxTemp);
                result[i] = indexMaxTemp - i;
            }
            stack.push(curr);
            map.put(curr, i);
        }
        return result;
    }

    /**
     * Time: O(n^2)
     * Space: O(n)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            for(int j = i + 1; j < temperatures.length; j++) {
                int tempFuture = temperatures[j];
                if(tempFuture > temp) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }
}
