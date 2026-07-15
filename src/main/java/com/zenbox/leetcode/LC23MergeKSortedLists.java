package com.zenbox.leetcode;

/**
 * {@code LC23MergeKSortedLists}
 * <p>
 * Solution for
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists">23. Merge k
 * Sorted Lists</a>.
 * </p>
 */
public class LC23MergeKSortedLists {

  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      return null;
    }
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
