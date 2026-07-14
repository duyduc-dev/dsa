package com.zenbox.leetcode;

import java.util.PriorityQueue;

/**
 * {@code LC1962RemoveStonesToMinimizeTheTotal}
 * <p>
 * Solution for
 * <a href=
 * "https://leetcode.com/problems/remove-stones-to-minimize-the-tota">1962.
 * Remove Stones to Minimize the Total</a>.
 * </p>
 */
public class LC1962RemoveStonesToMinimizeTheTotal {
    class SolutionFaster {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>();

            int sum = 0;
            for (int pile : piles) {
                q.add(-pile);
                sum += pile;
            }

            while (k-- > 0) {
                int pile = -q.poll();
                int removed = pile / 2;
                sum -= removed;
                q.add(-(pile - removed));
            }

            return sum;
        }
    }

    class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int pile : piles) {
                q.add(-pile);
            }

            int res = 0;

            while (k-- > 0) {
                int stone = -q.poll();
                stone = (int) Math.ceil(stone / 2.0);
                q.add(-stone);
            }

            while (!q.isEmpty()) {
                res -= q.poll();
            }

            return res;
        }
    }
}
