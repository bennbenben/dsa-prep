package com.practise.dsa.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluateReversePolishNotationTest {

  private final EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
  
  @Test
  void testEvaluateReversePolishNotation() {
    Assertions.assertEquals(5, evaluateReversePolishNotation.evalRPN(new String[] {"1","2","+","3","*","4","-"}));
  }
}
