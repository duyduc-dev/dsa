package com.zenbox.DS.queue;

public class Test {

  public static void main(String[] args) {
    LinkedQueue<String> stack = new LinkedQueue<>();
    stack.enqueue("DUCK");
    stack.enqueue("DUCK 2");
    stack.enqueue("DUCK 3");
    stack.enqueue("DUCK 4");
    stack.enqueue("DUCK 5");

    System.out.println(stack);
    System.out.println(stack.dequeue());
    System.out.println(stack.dequeue());
    System.out.println(stack);
  }
}
