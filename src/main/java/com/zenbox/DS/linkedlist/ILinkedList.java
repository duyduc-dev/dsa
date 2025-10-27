package com.zenbox.DS.linkedlist;

import java.util.Iterator;
import java.util.ListIterator;

public interface ILinkedList<E> {
  /**
   * Adds an element to the end of the linked list.
   * @param element the element to add
   */
  void add(E element);

  /**
   * Inserts an element at a specific index in the list.
   * @param index the position to insert at (0-based)
   * @param element the element to insert
   * @throws IndexOutOfBoundsException if index is invalid
   */
  void add(int index, E element);

  void addFirst(E element);

  /**
   * Retrieves an element at the given index.
   * @param index the position to retrieve
   * @return the element at that index
   * @throws IndexOutOfBoundsException if index is invalid
   */
  E get(int index);

  /**
   * Removes the element at the given index.
   * @param index the position to remove
   * @return the removed element
   * @throws IndexOutOfBoundsException if index is invalid
   */
  E remove(int index);
  E removeLast();

  /**
   * Removes the first occurrence of a specific element.
   * @param element the element to remove
   * @return true if the element was found and removed, false otherwise
   */
  boolean remove(E element);

  /**
   * Returns the index of the first occurrence of an element.
   * @param element the element to find
   * @return index of element, or -1 if not found
   */
  int indexOf(E element);

  /**
   * Checks if the list contains a specific element.
   * @param element the element to check
   * @return true if found, false otherwise
   */
  boolean contains(E element);

  /**
   * Returns the number of elements in the list.
   * @return the size of the list
   */
  int size();

  /**
   * Checks if the list is empty.
   * @return true if empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Clears all elements from the list.
   */
  void clear();

  /**
   * Returns the first element of the list.
   * @return first element
   * @throws IllegalStateException if the list is empty
   */
  E getFirst();

  /**
   * Returns the last element of the list.
   * @return last element
   * @throws IllegalStateException if the list is empty
   */
  E getLast();

  /**
   * Returns an iterator over the elements in the list.
   * @return an Iterator
   */
  Iterator<E> iterator();

  ListIterator<E> listIterator();
  ListIterator<E> listIterator(int index);

  String toString();
}
