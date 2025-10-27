package com.zenbox.DS.tree;

import com.zenbox.DS.queue.LinkedQueue;
import com.zenbox.DS.stack.LinkedStack;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BSTree<E extends Comparable<E>> implements TreeADT<E> {

  private Node<E> root = null;
  private int nodeCount = 0;

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return nodeCount;
  }

  @Override
  public int height() {
    return height(root);
  }

  @Override
  public boolean contains(E element) {
    return contains(root, element);
  }

  @Override
  public boolean add(E element) {
    if (contains(element)) return false;
    root = add(root, element);
    nodeCount++;
    return true;
  }

  @Override
  public boolean remove(E element) {
    if (!contains(element)) return false;
    root = remove(root, element);
    nodeCount--;
    return true;
  }

  @Override
  public Iterator<E> traverse(TreeTraverseType type) {
    return switch (type) {
      case PRE_ORDER -> preOrderTraverse();
      case IN_ORDER -> inOrderTraverse();
      case POST_ORDER -> postOrderTraverse();
      case LEVEL_ORDER -> levelOrderTraverse();
    };
  }

  // level by level
  private Iterator<E> levelOrderTraverse() {
    LinkedQueue<Node<E>> queue = new LinkedQueue<>();
    queue.enqueue(root);
    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        return root != null && !queue.isEmpty();
      }

      @Override
      public E next() {
        Node<E> node = queue.dequeue();
        if (node.getLeft() != null) queue.enqueue(node.getLeft());
        if (node.getRight() != null) queue.enqueue(node.getRight());
        return node.getValue();
      }
    };
  }

  // LRN
  private Iterator<E> postOrderTraverse() {
    return new TreePostOrderTraverse<>(root, nodeCount);
  }

  // LNR
  private Iterator<E> inOrderTraverse() {
    final int expectedCount = nodeCount;
    LinkedStack<Node<E>> stack = new LinkedStack<>();
    stack.push(root);
    return new Iterator<E>() {
      private Node<E> curr = root;

      @Override
      public boolean hasNext() {
        if (expectedCount != nodeCount) throw new ConcurrentModificationException();
        return curr != null && !stack.isEmpty();
      }

      @Override
      public E next() {
        if (expectedCount != nodeCount) throw new ConcurrentModificationException();
        while (curr != null && curr.getLeft() != null) {
          stack.push(curr.getLeft());
          curr = curr.getLeft();
        }
        Node<E> node = stack.pop();
        if (node.getRight() != null) {
          stack.push(node.getRight());
          curr = node.getRight();
        }
        return node.getValue();
      }
    };
  }

  // NLR
  private Iterator<E> preOrderTraverse() {
    final int expectedCount = nodeCount;
    LinkedStack<Node<E>> stack = new LinkedStack<>();
    stack.push(root);

    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        if (expectedCount != nodeCount) throw new ConcurrentModificationException();
        return !stack.isEmpty() && root != null;
      }

      @Override
      public E next() {
        if (expectedCount != nodeCount) throw new ConcurrentModificationException();
        if (!hasNext()) throw new NoSuchElementException();
        Node<E> node = stack.pop();
        if (node.getRight() != null) stack.push(node.getRight());
        if (node.getLeft() != null) stack.push(node.getLeft());
        return node.getValue();
      }
    };
  }

  private Node<E> remove(Node<E> node, E item) {
    if (node == null) return null;
    int value = item.compareTo(node.getValue());
    if (value == 0) {
      if (node.getRight() == null) {
        return null;
      }
      E minRightValue = getMinRight(node.getRight());
      Node<E> newNode = new Node<>(minRightValue, node.getLeft(), node.getRight());
      newNode.setRight(remove(node.getRight(), minRightValue));
      node.setValue(null);
      node.setLeft(null);
      node.setRight(null);
      node = null;
      return newNode;
    }
    if (value < 0) node.setLeft(remove(node.getLeft(), item));
    else node.setRight(remove(node.getRight(), item));
    return node;
  }

  private E getMinRight(Node<E> node) {
    while (node.getLeft() != null) node = node.getLeft();
    return node.getValue();
  }

  private Node<E> add(Node<E> node, E item) {
    if (item == null) return null;
    if (node == null) {
      return new Node<>(item);
    }
    int cpValue = item.compareTo(node.getValue());
    if (cpValue == 0) return node;
    if (cpValue < 0) {
      node.setLeft(add(node.getLeft(), item));
    } else {
      node.setRight(add(node.getRight(), item));
    }
    return node;
  }

  private boolean contains(Node<E> node, E item) {
    if (node == null || item == null) return false;
    int value = item.compareTo(node.getValue());
    if (value == 0) return true;
    return value < 0 ? contains(node.getLeft(), item) : contains(node.getRight(), item);
  }

  private int height(Node<E> node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
  }
}
