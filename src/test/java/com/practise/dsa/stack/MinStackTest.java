package com.practise.dsa.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinStackTest {

  private MinStack minStack;
  
  @BeforeEach
  void setUp() {
    this.minStack = new MinStack();
  }
  
  @Test
  void testMinStack() {
    this.minStack.push(1);
    this.minStack.push(2);
    this.minStack.push(0);
    Assertions.assertEquals(0, this.minStack.getMin());
    this.minStack.pop();
    Assertions.assertEquals(2, this.minStack.top());
    Assertions.assertEquals(1, this.minStack.getMin());
  }
}
