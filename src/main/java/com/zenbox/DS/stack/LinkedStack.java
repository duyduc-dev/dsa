package com.zenbox.DS.stack;

import com.zenbox.DS.linkedlist.LinkedList;

public class LinkedStack<E> implements IStack<E> {

  private final LinkedList<E> list = new LinkedList<>();

  @Override
  public E pop() {
    return list.removeLast();
  }

  @Override
  public E peek() {
    return list.getLast();
  }

  @Override
  public void push(E element) {
    list.add(element);
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public String toString() {
    return list.toString();
  }
}
