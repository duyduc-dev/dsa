package com.zenbox.sorting;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    var a = new MergeSort();
    int[] arr = { 2, 7, 4, 1, 5, 3 };
    a.mergeSort(arr);
    System.out.println(Arrays.toString(arr));

  }

  public void mergeSort(int[] arr) {
    mergeSortRange(arr, 0, arr.length - 1);
  }

  private void mergeSortRange(int[] arr, int l, int r) {

    if (l >= r)
      return;

    int mid = l + ((r - l) / 2);

    mergeSortRange(arr, l, mid);
    mergeSortRange(arr, mid + 1, r);

    int n1 = mid - l + 1;
    int n2 = r - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++)
      L[i] = arr[l + i];

    for (int i = 0; i < n2; i++)
      R[i] = arr[mid + 1 + i];

    int i = 0;
    int j = 0;
    int k = l;

    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }

      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      k++;
      i++;
    }
    while (j < n2) {
      arr[k] = R[j];
      k++;
      j++;
    }

  }

}
