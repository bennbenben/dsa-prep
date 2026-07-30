package com.practise.dsa.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestRepeatingCharacterReplacementTest {

  private final LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();
  
  @Test
  void testLongestRepeatingCharacterReplacement1() {
    Assertions.assertEquals(4, solver.characterReplacement("XYYX", 2));
  }
  
  @Test
  void testLongestRepeatingCharacterReplacement2() {
    Assertions.assertEquals(5, solver.characterReplacement("AAABABB", 1));
  }
  
}
