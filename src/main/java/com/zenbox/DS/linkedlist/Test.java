package com.zenbox.DS.linkedlist;

public class Test {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("Hello");
    list.add("Duck");
    list.addFirst("*");

    list.add(1, "CHAO");
    System.out.println(list);
    System.out.println(list.get(2));
    System.out.println(list.remove(2));
    System.out.println(list);
  }
}
