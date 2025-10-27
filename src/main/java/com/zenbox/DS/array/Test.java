package com.zenbox.DS.array;

public class Test {

  public static void main(String[] args) {
    DynamicArray<Integer> list1 = new DynamicArray<>();
    DynamicArray<Integer> list2 = new DynamicArray<>();

    list1.add(10);
    list1.add(20);
    list2.add(10);
    list2.add(20);

    System.out.println(list1.hashCode()); // e.g., 9821
    System.out.println(list2.hashCode()); // should match list1

    System.out.println(list1.equals(list2)); // true
    System.out.println(list1.hashCode() == list2.hashCode()); // true ✅
  }
}
