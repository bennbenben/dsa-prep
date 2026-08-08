package com.practise.dsa.stack;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {
  public int evalRPN1(String[] tokens) {
    
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
  
  public int evalRPN2(String[] tokens) {
    LinkedList<Integer> integerStack = new LinkedList<Integer>();
    
    for (String token : tokens) {
      switch (token) {
        case "+" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second + first);
        }
        case "-" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second - first);
        }
        case "*" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second * first);
        }
        case "/" -> {
          int first = integerStack.pollFirst();
          int second = integerStack.pollFirst();
          integerStack.offerFirst(second / first);
        }
        default -> {
          integerStack.offerFirst(Integer.parseInt(token));
        }
      }
    }
    return integerStack.pollFirst();
  }
  
  public static void main(String[] args) {
    EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
    evaluateReversePolishNotation.evalRPN1(new String[] {"1","2","+","3","*","4","-"});
    evaluateReversePolishNotation.evalRPN2(new String[] {"1","2","+","3","*","4","-"});
  }
}
