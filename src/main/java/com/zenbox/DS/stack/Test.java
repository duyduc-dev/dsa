package com.zenbox.DS.stack;

public class Test {

  public static void main(String[] args) {
    LinkedStack<String> stack = new LinkedStack<>();
    stack.push("DUCK");
    stack.push("DUCK 2");
    stack.push("DUCK 3");
    stack.push("DUCK 4");
    stack.push("DUCK 5");

    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack);
  }
}
