package com.zenbox.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link LC169MajorityElement}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/majority-element">169. Majority Element</a>.
 * </p>
 */
public class LC169MajorityElement {

    public static void main(String[] args) {
        var s = new SolutionDivideAndconQuer();
        int[] nums = { 3, 2, 3 };

        System.out.println(s.majorityElement(nums));
    }

    static class SolutionDivideAndconQuer {
        public int majorityElement(int[] nums) {
            return divide(nums, 0, nums.length - 1);
        }

        int divide(int[] nums, int l, int r) {
            if (l == r)
                return nums[l];

            int m = (l + r) / 2;

            int leftMajority = divide(nums, l, m);
            int rightMajority = divide(nums, m + 1, r);

            if (leftMajority == rightMajority)
                return rightMajority;

            int leftCount = count(nums, leftMajority, l, r);
            int rightCount = count(nums, rightMajority, l, r);

            return leftCount > rightCount ? leftMajority : rightMajority;
        }

        int count(int[] nums, int target, int l, int r) {
            int count = 0;

            for (int i = l; i <= r; i++) {
                if (nums[i] == target) {
                    count++;
                }
            }

            return count;
        }
    }

    class SolutionWithMooreVotingAlgorithm {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }

                if (nums[i] == candidate)
                    count++;
                else
                    count--;
            }

            return candidate;
        }
    }

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    class SolutionWithMap {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : nums)
                map.put(num, map.getOrDefault(num, 0) + 1);

            for (var entry : map.entrySet()) {
                if (entry.getValue() > nums.length / 2)
                    return entry.getKey();
            }

            return 0;
        }
    }
}
