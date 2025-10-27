package com.zenbox.DS.tree;

import java.util.Iterator;

public class Test {

  public static void main(String[] args) {
    TreeADT<Integer> bst = new BSTree<>();
    bst.add(5);
    bst.add(3);
    bst.add(8);
    bst.add(2);
    bst.add(6);
    bst.add(1);
    bst.add(1);
    bst.add(12);
    bst.add(2);
    bst.add(4);
    bst.add(7);
    bst.add(9);
    bst.add(10);

    System.out.println(bst.contains(12));
    System.out.println("size > " + bst.size());
    System.out.println("height > " + bst.height());

    Iterator<Integer> it = bst.traverse(TreeTraverseType.POST_ORDER);

    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
  }
}
