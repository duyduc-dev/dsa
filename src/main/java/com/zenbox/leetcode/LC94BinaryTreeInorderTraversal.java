package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code LC94BinaryTreeInorderTraversal}
 * <p>
 * Solution for <a href=
 * "https://leetcode.com/problems/binary-tree-inorder-traversal/">94. Binary
 * Tree Inorder Traversal</a>.
 * </p>
 */
public class LC94BinaryTreeInorderTraversal {

    class Solution {

        /**
         * Left -> Root - Right
         * 
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            traversal(res, root);
            return res;
        }

        public void traversal(List<Integer> res, TreeNode root) {

            if (root != null) {
                if (root.left != null)
                    traversal(res, root.left);
                res.add(root.val);
                if (root.right != null)
                    traversal(res, root.right);
            }

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
