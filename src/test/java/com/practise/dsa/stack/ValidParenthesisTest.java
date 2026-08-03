package com.practise.dsa.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidParenthesisTest {

  private final ValidParenthesis validParenthesis = new ValidParenthesis();
  
  @Test
  void testvalidParenthesis1() {
    String s = "[]";
    Assertions.assertTrue(validParenthesis.isValid(s));
  }
  
  @Test
  void testvalidParenthesis2() {
    String s = "([{}])";
    Assertions.assertTrue(validParenthesis.isValid(s));
  }
  
  @Test
  void testvalidParenthesis3() {
    String s = "[(])";
    Assertions.assertFalse(validParenthesis.isValid(s));
  }
}
