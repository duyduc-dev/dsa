package com.zenbox.leetcode;

/**
 * {@link LC108ConvertSortedArrayToBinarySearchTree}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree">108.
 * Convert Sorted Array to Binary Search Tree</a>.
 * </p>
 */
public class LC108ConvertSortedArrayToBinarySearchTree {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildBST(nums, 0, nums.length - 1);
        }

        TreeNode buildBST(int[] nums, int l, int r) {
            if (l > r)
                return null;

            int m = (l + r) / 2;

            var node = new TreeNode(nums[m]);

            node.left = buildBST(nums, l, m - 1);
            node.right = buildBST(nums, m + 1, r);

            return node;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
