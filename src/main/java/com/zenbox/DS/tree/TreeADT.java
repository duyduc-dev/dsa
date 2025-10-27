package com.zenbox.DS.tree;

import java.util.Iterator;

public interface TreeADT<E extends Comparable<E>> {
  boolean isEmpty();
  int size();
  int height();
  boolean contains(E element);
  boolean add(E element);
  boolean remove(E element);
  Iterator<E> traverse(TreeTraverseType type);
}
