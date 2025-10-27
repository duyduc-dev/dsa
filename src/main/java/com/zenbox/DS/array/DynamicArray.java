package com.zenbox.DS.array;

import java.util.*;

public class DynamicArray<T> implements List<T> {

  public static final int DEFAULT_CAPACITY = 10;
  private T[] elements;
  private int size = 0;
  private int capacity;

  public DynamicArray() {
    capacity = DEFAULT_CAPACITY;
    elements = (T[]) new Object[capacity];
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
  public boolean contains(Object o) {
    return indexOf(o) != -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        return elements[index++];
      }
    };
  }

  @Override
  public T[] toArray() {
    T[] res = (T[]) new Object[size];
    for (int i = 0; i < size; i++) {
      res[i] = elements[i];
    }
    return res;
  }

  @Override
  public boolean add(T t) {
    add(size, t);
    return true;
  }

  @Override
  public boolean remove(Object o) {
    int index = indexOf(o);
    return remove(index) != null;
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    int newSize = a.length < size ? size : a.length;
    T1[] newArr = (T1[]) new Object[newSize];

    for (int i = 0; i < size; i++) {
      newArr[i] = (T1) elements[i];
    }

    return newArr;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    for (T t : c) {
      add(t);
    }
    return true;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    validateIndexForAdd(index);
    int indexOffset = 0;
    for (T t : c) {
      add(index + indexOffset++, t);
    }
    return true;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    boolean modified = false;

    for (Object t : c) {
      if (remove(t)) {
        modified = true;
      }
    }
    return modified;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    for (Object t : c) {
      if (!contains(t)) {
        remove(t);
        modified = true;
      }
    }
    return modified;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DynamicArray)) return false;
    DynamicArray<?> other = (DynamicArray<?>) o;
    if (this.size != other.size) return false;
    for (int i = 0; i < this.size; i++) {
      T ele = elements[i];
      T otherEle = (T) other.get(i);
      if (ele == null && otherEle == null) continue;
      if (ele == null || otherEle == null) return false;
      if (!elements[i].equals(other.get(i))) return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 1;
    for (int i = 0; i < size; i++) {
      Object e = elements[i];
      hash = 31 * hash + (e == null ? 0 : e.hashCode());
    }
    return hash;
  }

  @Override
  public void clear() {
    size = 0;
    for (int i = 0; i < elements.length; i++) {
      elements[i] = null;
    }
    capacity = DEFAULT_CAPACITY;
  }

  @Override
  public T get(int index) {
    validateIndex(index);
    return elements[index];
  }

  @Override
  public T set(int index, T element) {
    validateIndex(index);
    elements[index] = element;
    return element;
  }

  @Override
  public void add(int index, T element) {
    validateIndexForAdd(index);
    resizeArray();
    elements[index] = element;
    size++;
  }

  @Override
  public T remove(int indexRemoved) {
    validateIndex(indexRemoved);
    T element = elements[indexRemoved];
    int newCapacity = elements.length - 1;
    T[] newArr = (T[]) new Object[newCapacity];
    for (int i = 0; i < elements.length; i++) {
      if (i < indexRemoved) {
        newArr[i] = elements[i];
      } else if (i > indexRemoved) {
        newArr[i - 1] = elements[i];
      }
    }
    elements = newArr;
    capacity = newCapacity;
    size--;
    return element;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (o.equals(elements[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = size - 1; i >= 0; i--) {
      if (o.equals(elements[i])) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public ListIterator<T> listIterator() {
    return listIterator(0);
  }

  @Override
  public ListIterator<T> listIterator(int idx) {
    return new ListIterator<T>() {
      int index = idx;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public T next() {
        return elements[index++];
      }

      @Override
      public boolean hasPrevious() {
        return index > 0;
      }

      @Override
      public T previous() {
        return elements[index--];
      }

      @Override
      public int nextIndex() {
        return index + 1;
      }

      @Override
      public int previousIndex() {
        return index - 1;
      }

      @Override
      public void remove() {
        DynamicArray.this.remove(index);
      }

      @Override
      public void set(T t) {
        DynamicArray.this.set(index, t);
      }

      @Override
      public void add(T t) {
        DynamicArray.this.add(index, t);
      }
    };
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    DynamicArray<T> newList = new DynamicArray<>();
    ListIterator<T> iterator = listIterator(fromIndex);
    while (iterator.nextIndex() <= toIndex) {
      newList.add(iterator.next());
    }
    return newList;
  }

  private void resizeArray() {
    if (size() == capacity) {
      int newCapacity = elements.length * 2;
      T[] newArr = (T[]) new Object[newCapacity];
      for (int i = 0; i < elements.length; i++) {
        newArr[i] = elements[i];
      }
      elements = newArr;
      capacity = newCapacity;
    }
  }

  private void validateIndex(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }
  }

  private void validateIndexForAdd(int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }
  }

  @Override
  public String toString() {
    if (isEmpty()) return "[]";
    else {
      StringBuilder sb = new StringBuilder(size);
      sb.append("[");
      for (int i = 0; i < size - 1; i++) {
        sb.append(elements[i]).append(",");
      }
      sb.append(elements[size - 1]).append("]");
      return sb.toString();
    }
  }
}
