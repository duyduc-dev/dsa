package com.zenbox.leetcode;

/**
 * {@code LC739DailyTemperatures}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/daily-temperatures">LeetCode Problem 739: Daily Temperatures</a>.
 * </p>
 */
public class LC739DailyTemperatures {

    public int[] dailyTemperaturesWithStack(int[] temperatures) {
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
