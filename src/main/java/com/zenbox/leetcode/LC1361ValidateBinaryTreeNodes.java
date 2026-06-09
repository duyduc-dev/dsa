package com.zenbox.leetcode;

import java.util.Arrays;

/**
 * {@code LC1361ValidateBinaryTreeNodes}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/validate-binary-tree-nodes">1361.
 * Validate Binary Tree Nodes</a>.
 * </p>
 */
public class LC1361ValidateBinaryTreeNodes {

  public static void main(String[] args) {

  }

  public static class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
      int[] parentNode = new int[n];

      for (int node = 0; node < n; node++) {
        if (leftChild[node] != -1) {
          if (parentNode[leftChild[node]] != -1)
            return false;
          parentNode[leftChild[node]] = node;
        }
        if (rightChild[node] != -1) {
          if (parentNode[rightChild[node]] != -1)
            return false;
          parentNode[rightChild[node]] = node;
        }
      }

      int root = -1;
      for (int node = 0; node < n; node++) {
        if (parentNode[node] == -1) {
          if (root != -1)
            return false;
          root = node;
        }
      }

      if (root == -1)
        return false;

      boolean[] nodeVisited = new boolean[n];

      return dfsEdges(root, leftChild, rightChild, nodeVisited) == n - 1;

    }

    private int dfsEdges(int node, int[] leftChild, int[] rightChild, boolean[] visited) {
      visited[node] = true;
      int res = 0;

      if (leftChild[node] != -1 && !visited[leftChild[node]]) {
        res += 1 + dfsEdges(leftChild[node], leftChild, rightChild, visited);
      }
      if (rightChild[node] != -1 && !visited[rightChild[node]]) {
        res += 1 + dfsEdges(rightChild[node], leftChild, rightChild, visited);
      }

      return res;
    }
  }
}
