package com.zenbox.DS.tree;

import com.zenbox.DS.stack.LinkedStack;
import java.util.Iterator;

class TreePostOrderTraverse<E extends Comparable<E>> implements Iterator<E> {

  private final LinkedStack<Node<E>> stack;
  private Node<E> cursor;

  public TreePostOrderTraverse(Node<E> root, int nodeCount) {
    stack = new LinkedStack<>();
    pushLeft(root);
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  @Override
  public E next() {
    while (true) {
      Node<E> node = stack.peek();
      if (node != null && node.getRight() != null && cursor != node.getRight()) {
        pushLeft(node.getRight());
      } else {
        stack.pop();
        cursor = node;
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
}
