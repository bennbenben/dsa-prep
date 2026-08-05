package com.practise.dsa.stack;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    
    LinkedList<String> rpnStack = new LinkedList<String>();
    
    for (String token : tokens) {
      switch (token) {
        case "+" -> {
          Integer a = Integer.valueOf(rpnStack.pollFirst());
          Integer b = Integer.valueOf(rpnStack.pollFirst());
          rpnStack.offerFirst(String.valueOf(a+b));
        }
        case "-" -> {
          Integer a = Integer.valueOf(rpnStack.pollFirst());
          Integer b = Integer.valueOf(rpnStack.pollFirst());
          rpnStack.offerFirst(String.valueOf(b-a));      
        }
        case "*" -> {
          Integer a = Integer.valueOf(rpnStack.pollFirst());
          Integer b = Integer.valueOf(rpnStack.pollFirst());
          rpnStack.offerFirst(String.valueOf(a*b));
        }
        case "/" -> {
          Integer a = Integer.valueOf(rpnStack.pollFirst());
          Integer b = Integer.valueOf(rpnStack.pollFirst());
          rpnStack.offerFirst(String.valueOf(b/a));
        }
        default -> {
          rpnStack.offerFirst(token);
        }
      }
    }
    
    return Integer.valueOf(rpnStack.pollFirst());
  }
  
  public static void main(String[] args) {
    EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
    evaluateReversePolishNotation.evalRPN(new String[] {"1","2","+","3","*","4","-"});
  }
}
