package com.practise.dsa.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidPalindromeTest {
  
  private final ValidPalindrome validPalindrome = new ValidPalindrome();

  @Test
  void testIsPalindrome1() {
    String s = "Was it a car or a cat I saw?";
    Assertions.assertTrue(validPalindrome.isPalindrome(s));
  }
  
  @Test
  void testIsPalindrome2() {
    String s = "tab a cat";
    Assertions.assertFalse(validPalindrome.isPalindrome(s));
  }
}
