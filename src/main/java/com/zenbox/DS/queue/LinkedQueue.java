package com.zenbox.DS.queue;

import com.zenbox.DS.linkedlist.LinkedList;

public class LinkedQueue<E> implements QueueADT<E> {

  private LinkedList<E> list = new LinkedList<>();

  @Override
  public void enqueue(E element) {
    list.add(element);
  }

  @Override
  public E dequeue() {
    return list.remove(0);
  }

  @Override
  public E first() {
    return list.getFirst();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public String toString() {
    return list.toString();
  }
}
