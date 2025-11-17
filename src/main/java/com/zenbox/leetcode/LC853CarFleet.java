package com.zenbox.leetcode;

import java.util.*;

/**
 * {@code LC853CarFleet}
 * <p>
 * Solution for <a href="https://leetcode.com/problems/car-fleet">LeetCode Problem 853: Car Fleet</a>.
 * </p>
 */
public class LC853CarFleet {


    /**
     * Time: O(nlog(n))
     * Space: O(n)
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for(int i = 0; i < position.length; i++) {
            cars[i] = new double[] { position[i], speed[i] };
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // O(nlog(n))

        Stack<Double> fleets = new Stack<>();

        for(double[] car: cars) {
            double pos = car[0];
            double spd = car[1];

            double timeTaken = (double)((target - pos) / spd);

            if(fleets.isEmpty() || timeTaken > fleets.peek()) {
                fleets.push(timeTaken);
            }
        }

        return fleets.size();
    }
}
