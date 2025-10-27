package com.zenbox.DS.stack;

public interface IStack<E> {
  E pop();
  E peek();
  void push(E element);
  int size();
  boolean isEmpty();
}
