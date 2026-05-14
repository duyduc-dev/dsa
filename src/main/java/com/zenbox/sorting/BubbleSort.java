package com.zenbox.sorting;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = { 2, 7, 4, 1, 5, 3 };
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void bubbleSort(int[] num) {
    int n = num.length;
    int l = 0;
    int r = 1;

    if (n == 1)
      return;

    while (n > 1) {
      l = 0;
      r = 1;
      boolean swapped = false;

      while (r < n) {
        if (num[r] < num[l]) {
          swapElement(num, l, r);
          swapped = true;
        }

        r++;
        l++;
      }

      if (!swapped)
        break;

      n--;

    }
  }

  private static void swapElement(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
