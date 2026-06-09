package com.zenbox.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * {@code LC104MaximumDepthOfBinaryTree}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum
 * Depth of Binary Tree</a>.
 * </p>
 */
public class LC104MaximumDepthOfBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;

            Queue<TreeNode> queue = new ArrayDeque<>();
            Map<TreeNode, Integer> node2Depth = new HashMap<>();

            queue.add(root);
            node2Depth.put(root, 1);

            int depth = 1;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                    node2Depth.put(node.left, node2Depth.get(node) + 1);
                    depth = Math.max(depth, node2Depth.get(node) + 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    node2Depth.put(node.right, node2Depth.get(node) + 1);
                    depth = Math.max(depth, node2Depth.get(node) + 1);
                }
            }

            return depth;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
