package com.zenbox.DS.linkedlist;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ILinkedList<E> {

  private Node<E> head;
  private Node<E> tail;
  private int size = 0;

  @Override
  public void add(E element) {
    add(size, element);
  }

  @Override
  public void add(int index, E element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    if (index == 0) {
      Node<E> newNode = new Node<>(element, null, head);
      if (head != null) head.setPrev(newNode);
      head = newNode;
      if (tail == null) tail = newNode;
    } else if (index == size) {
      Node<E> newNode = new Node<>(element, tail, null);
      if (tail != null) tail.setNext(newNode);
      tail = newNode;
      if (head == null) head = newNode;
    } else {
      Node<E> current;
      if (index < size / 2) {
        current = head;
        for (int i = 0; i < index - 1; i++) {
          current = current.getNext();
        }
      } else {
        current = tail;
        for (int i = size - 1; i > index - 1; i--) {
          current = current.getPrev();
        }
      }
      Node<E> newNode = new Node<>(element, current, current.getNext());
      current.getNext().setPrev(newNode);
      current.setNext(newNode);
    }
    size++;
  }

  @Override
  public void addFirst(E element) {
    add(0, element);
  }

  @Override
  public E get(int index) {
    return getNode(index).getValue();
  }

  private Node<E> getNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    if (index == 0) {
      if (head == null) {
        throw new NoSuchElementException();
      }
      return head;
    } else if (index == size - 1) {
      if (tail == null) {
        throw new NoSuchElementException();
      }
      return tail;
    }
    Node<E> current;
    if (index < size / 2) {
      current = head;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
    } else {
      current = tail;
      for (int i = size - 1; i > index; i--) {
        current = current.getPrev();
      }
    }
    if (current == null) {
      throw new NoSuchElementException();
    }
    return current;
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    if (index == 0) {
      if (head == null) {
        throw new IllegalArgumentException();
      }
      E value = head.getValue();
      if (head == tail) {
        head = tail = null;
      } else {
        head = head.getNext();
        head.setPrev(null);
      }
      size--;
      return value;
    }
    if (index == size - 1) {
      if (tail == null) {
        throw new IllegalArgumentException();
      }
      E value = tail.getValue();
      if (head == tail) {
        head = tail = null;
      } else {
        tail = tail.getPrev();
        tail.setNext(null);
      }
      size--;
      return value;
    }
    Node<E> current;
    if (index < size / 2) {
      current = head;
      for (int i = 0; i < index; i++) {
        current = current.getNext();
      }
    } else {
      current = tail;
      for (int i = size - 1; i > index; i--) {
        current = current.getPrev();
      }
    }
    if (current == null) {
      throw new IllegalArgumentException();
    }
    E value = current.getValue();
    current.getPrev().setNext(current.getNext());
    current.getNext().setPrev(current.getPrev());
    current.setValue(null);
    size--;
    return value;
  }

  @Override
  public E removeLast() {
    return remove(size - 1);
  }

  @Override
  public boolean remove(E element) {
    int index = indexOf(element);
    if (index == -1) return false;
    remove(index);
    return true;
  }

  @Override
  public int indexOf(E element) {
    if (head != null && element.equals(head.getValue())) {
      return 0;
    }
    if (tail != null && element.equals(tail.getValue())) {
      return size - 1;
    }
    Node<E> current = head;
    int index = 0;
    while (current != null) {
      if (current.getValue().equals(element)) {
        return index;
      }
      current = current.getNext();
      index++;
    }
    return -1;
  }

  @Override
  public boolean contains(E element) {
    return indexOf(element) > -1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void clear() {
    Node<E> curr = head;
    while (curr != null) {
      Node<E> next = curr.getNext();
      curr.setValue(null);
      curr.setPrev(null);
      curr.setNext(null);
      curr = next;
    }
    head = tail = null;
    size = 0;
  }

  @Override
  public E getFirst() {
    if (head == null) throw new NoSuchElementException();
    return head.getValue();
  }

  @Override
  public E getLast() {
    if (tail == null) throw new NoSuchElementException();

    return tail.getValue();
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      Node<E> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public E next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        E value = current.getValue();
        current = current.getNext();
        return value;
      }
    };
  }

  @Override
  public ListIterator<E> listIterator() {
    return listIterator(0);
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index: " + index);
    }

    return new ListIterator<E>() {
      Node<E> nextNode = getNode(index); // node to be returned by next()
      Node<E> lastReturned = null; // last node returned by next() or previous()
      int nextIndex = index;

      @Override
      public boolean hasNext() {
        return nextIndex < size;
      }

      @Override
      public E next() {
        if (!hasNext()) throw new NoSuchElementException();
        lastReturned = nextNode;
        nextNode = nextNode.getNext();
        nextIndex++;
        return lastReturned.getValue();
      }

      @Override
      public boolean hasPrevious() {
        return nextIndex > 0;
      }

      @Override
      public E previous() {
        if (!hasPrevious()) throw new NoSuchElementException();
        nextNode = (nextNode == null) ? tail : nextNode.getPrev();
        lastReturned = nextNode;
        nextIndex--;
        return lastReturned.getValue();
      }

      @Override
      public int nextIndex() {
        return nextIndex;
      }

      @Override
      public int previousIndex() {
        return nextIndex - 1;
      }

      @Override
      public void remove() {
        if (lastReturned == null) throw new IllegalStateException();
        Node<E> prev = lastReturned.getPrev();
        Node<E> next = lastReturned.getNext();

        if (prev != null) prev.setNext(next);
        else head = next;

        if (next != null) next.setPrev(prev);
        else tail = prev;

        if (nextNode == lastReturned) nextNode = next;
        else nextIndex--;

        size--;
        lastReturned = null;
      }

      @Override
      public void set(E e) {
        if (lastReturned == null) throw new IllegalStateException();
        lastReturned.setValue(e);
      }

      @Override
      public void add(E e) {
        Node<E> newNode = new Node<>(e, (nextNode != null ? nextNode.getPrev() : tail), nextNode);

        if (newNode.getPrev() != null) newNode.getPrev().setNext(newNode);
        else head = newNode;

        if (newNode.getNext() != null) newNode.getNext().setPrev(newNode);
        else tail = newNode;

        size++;
        nextIndex++;
        lastReturned = null;
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (Iterator<E> it = iterator(); it.hasNext(); ) {
      E item = it.next();
      str.append(item);
      if (it.hasNext()) {
        str.append(", ");
      }
    }
    str.append("]");
    return str.toString();
  }
}
