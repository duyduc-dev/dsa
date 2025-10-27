package com.zenbox.DS.queue;

public interface QueueADT<E> {
  void enqueue(E element); // Add element to the back
  E dequeue(); // Remove and return front element
  E first(); // Peek at front element
  boolean isEmpty(); // Check if empty
  int size();
}
