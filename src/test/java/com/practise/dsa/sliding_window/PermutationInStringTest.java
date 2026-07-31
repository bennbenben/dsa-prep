package com.practise.dsa.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PermutationInStringTest {

  private final PermutationInString permutationInString = new PermutationInString();
  
  @Test
  void testPermutationInString1() {
    Assertions.assertTrue(permutationInString.checkInclusion("abc", "lecabee"));
  }
  
  @Test
  void testPermutationInString2() {
    Assertions.assertFalse(permutationInString.checkInclusion("abc", "lecaabee"));
  }
}
