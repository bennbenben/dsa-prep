package com.practise.dsa.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

  private final LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();
  
  @Test
  void testLongestSubstringWithoutRepeatingCharacters1() {
    String s = "zxyzxyz";
    Assertions.assertEquals(3, solver.lengthOfLongestSubstring(s));
  }
  
  @Test
  void testLongestSubstringWithoutRepeatingCharacters2() {
    String s = "xxxx";
    Assertions.assertEquals(1, solver.lengthOfLongestSubstring(s));
  }
}
