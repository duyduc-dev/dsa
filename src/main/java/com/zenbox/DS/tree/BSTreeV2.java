package com.zenbox.DS.tree;

import com.zenbox.DS.stack.LinkedStack;
import java.util.Iterator;

public class BSTreeV2<E extends Comparable<E>> implements TreeADT<E> {

  private int count = 0;
  private Node<E> root;

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public int height() {
    return height(root);
  }

  private int height(Node<E> node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.getRight()), height(node.getLeft()));
  }

  @Override
  public boolean contains(E element) {
    return contains(root, element);
  }

  private boolean contains(Node<E> node, E element) {
    if (node == null || element == null) return false;
    int value = element.compareTo(node.getValue());
    if (value == 0) return true;
    if (value < 0) return contains(node.getLeft(), element);
    return contains(node.getRight(), element);
  }

  @Override
  public boolean add(E element) {
    if (contains(element)) return false;
    root = add(root, element);
    count++;
    return true;
  }

  private Node<E> add(Node<E> node, E element) {
    if (node == null) return new Node<>(element);
    int value = element.compareTo(node.getValue());
    if (value < 0) node.setLeft(add(node.getLeft(), element));
    else if (value > 0) node.setRight(add(node.getRight(), element));
    return node;
  }

  @Override
  public boolean remove(E element) {
    if (!contains(element)) return false;
    root = remove(root, element);
    count--;
    return true;
  }

  private Node<E> remove(Node<E> node, E element) {
    if (node == null) return null;
    int value = element.compareTo(node.getValue());
    if (value < 0) node.setLeft(remove(node.getLeft(), element));
    else if (value > 0) node.setRight(remove(node.getRight(), element));
    else {
      E minRight = getMinRight(node.getRight());
      remove(node.getRight(), minRight);
      Node<E> newNode = new Node<>(minRight, node.getLeft(), node.getRight());
      node.setRight(null);
      node.setLeft(null);
      node.setValue(null);
      node = null;
      return newNode;
    }
    return node;
  }

  private E getMinRight(Node<E> node) {
    while (node.getLeft() != null) node = node.getLeft();
    return node.getValue();
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

  // NLR
  private Iterator<E> preOrderTraverse() {
    LinkedStack<Node<E>> stack = new LinkedStack<>();
    stack.push(root);
    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        return root != null && !stack.isEmpty();
      }

      @Override
      public E next() {
        Node<E> node = stack.pop();
        if (node.getRight() != null) stack.push(node.getRight());
        if (node.getLeft() != null) stack.push(node.getLeft());
        return node.getValue();
      }
    };
  }

  // LNR
  private Iterator<E> inOrderTraverse() {
    LinkedStack<Node<E>> stack = new LinkedStack<>();
    stack.push(root);
    return new Iterator<E>() {
      private Node<E> cursor = root;

      @Override
      public boolean hasNext() {
        return root != null && !stack.isEmpty();
      }

      @Override
      public E next() {
        while (cursor != null) {
          stack.push(cursor);
          cursor = cursor.getLeft();
        }

        // Visit node
        Node<E> node = stack.pop();

        // Move to the right subtree
        cursor = node.getRight();

        return node.getValue();
      }
    };
  }

  // LRN
  private Iterator<E> postOrderTraverse() {
    LinkedStack<Node<E>> stack = new LinkedStack<>();
    stack.push(root);
    Node<E> cursor = root;

    return new Iterator<E>() {
      @Override
      public boolean hasNext() {
        return root != null && !stack.isEmpty();
      }

      @Override
      public E next() {
        while (true) {
          Node<E> node = stack.peek();
          if (node != null && node.getRight() != null && cursor != node.getRight()) {
            pushLeft(node.getRight());
          } else {
            stack.pop();
            //                        cursor = node;
            return node.getValue();
          }
        }
      }

      private void pushLeft(Node<E> node) {
        while (node != null) {
          stack.push(node);
          node = node.getLeft();
        }
      }
    };
  }

  private Iterator<E> levelOrderTraverse() {
    return null;
  }
}
