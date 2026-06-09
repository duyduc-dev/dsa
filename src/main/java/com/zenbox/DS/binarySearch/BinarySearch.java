package com.zenbox.DS.binarySearch;

public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = { 1, 3, 4, 5, 6, 9, 12 };
    BinarySearch run = new BinarySearch();
    System.out.println("search > " + run.search(nums, 3));
    System.out.println("binarySearchWithRecusion > " + run.binarySearchWithRecusion(nums, 3));
    System.out.println("binarySearchFindSmallestWhichLargerThanX > " + run.binarySearchFindSmallestWhichLargerThanX(nums, 12));
  }

  public Integer search(int[] nums, int x) {
    return binarySearch(nums, x);
  }

  /**
   * Time: O(logn)
   * Spave: O(1)
   * 
   * @param nums
   * @param x
   * @return
   */
  private int binarySearch(int[] nums, int x) {
    int l = 0, r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == x)
        return mid;

      if (nums[mid] < x) {
        l++;
      } else {
        r--;
      }
    }

    return -1;
  }

  private int binarySearchWithRecusion(int[] nums, int x) {
    return binarySearchWithRecusion(nums, 0, nums.length - 1, x);
  };

  private int binarySearchWithRecusion(int[] nums, int l, int r, int x) {
    if (l > r)
      return -1;

    int mid = l + (r - l) / 2;
    if (nums[mid] == x)
      return mid;

    if (nums[mid] > x)
      return binarySearchWithRecusion(nums, 0, mid, x);

    return binarySearchWithRecusion(nums, mid + 1, nums.length - 1, x);
  };

  private int binarySearchFindSmallestWhichLargerThanX(int[] nums, int x) {
    int l = 0, r = nums.length - 1;

    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] <= x) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }

    return r + 1;
  }
}
