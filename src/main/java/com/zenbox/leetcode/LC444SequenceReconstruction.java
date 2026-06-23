package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * {@code LC444SequenceReconstruction}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/sequence-reconstruction">
 * 444 Sequence Reconstruction
 * </a>.
 * </p>
 */
public class LC444SequenceReconstruction {
    class Solution {
        public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
            List<List<Integer>> cons = new ArrayList<>();
            int n = nums.length;

            int[] inDegree = new int[n + 1];

            for (int i = 0; i < n + 1; i++) {
                cons.add(new ArrayList<>());
            }

            for (List<Integer> e : sequences) {
                for (int i = 0; i < e.size() - 1; i++) {
                    int u = e.get(i);
                    int v = e.get(i + 1);
                    cons.get(u).add(v);
                    inDegree[v]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i <= n; i++) {
                if (inDegree[i] == 0)
                    q.add(i);
            }

            while (!q.isEmpty()) {
                if (q.size() > 1)
                    return false;
                Integer curr = q.poll();

                for (Integer integer : cons.get(curr)) {
                    inDegree[integer]--;
                    if (inDegree[integer] == 0)
                        q.add(integer);
                }
            }

            return true;
        }
    }
}
