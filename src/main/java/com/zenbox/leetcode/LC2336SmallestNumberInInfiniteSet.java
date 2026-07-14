package com.zenbox.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * {@code LC2336SmallestNumberInInfiniteSet}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/smallest-number-in-infinite-set">2336.
 * Smallest Number in Infinite Set</a>.
 * </p>
 */
public class LC2336SmallestNumberInInfiniteSet {
    class SmallestInfiniteSet {

        private final PriorityQueue<Integer> q = new PriorityQueue<>();
        private int p = 1;
        private final Set<Integer> set = new HashSet<>();

        public int popSmallest() {
            if (!q.isEmpty()) {
                int smallest = q.poll();
                set.remove(smallest);
                return smallest;
            }
            return p++;
        }

        public void addBack(int num) {
            if (num < p && set.add(num))
                q.add(num);
        }
    }
}
