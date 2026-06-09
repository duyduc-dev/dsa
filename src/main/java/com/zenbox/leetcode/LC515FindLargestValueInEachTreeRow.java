package com.zenbox.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@code LC515FindLargestValueInEachTreeRow}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">
 * 515. Find Largest Value in Each Tree Row
 * </a>.
 * </p>
 */
public class LC515FindLargestValueInEachTreeRow {
  class Solution {
    public List<Integer> largestValues(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      if (root == null)
        return res;
      List<TreeNode> currLevel = new ArrayList<>();
      currLevel.add(root);

      while (!currLevel.isEmpty()) {
        res.add(Collections.max(currLevel.stream().filter(item -> item != null).map(item -> item.val).toList()));

        List<TreeNode> nextLevel = new ArrayList<>();

        for (TreeNode curr : currLevel) {
          if (curr.left != null)
            nextLevel.add(curr.left);
          if (curr.right != null)
            nextLevel.add(curr.right);
        }

        currLevel = nextLevel;
      }

      return res;
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
