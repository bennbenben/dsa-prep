package com.practise.dsa.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinimumWindowSubstringTest {

  private final MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
  
  @Test
  void testMinimumWindowSubstring1() {
    Assertions.assertEquals("YXAZ", minimumWindowSubstring.minWindow("OUZODYXAZV", "XYZ"));
  }
  
  @Test
  void testMinimumWindowSubstring2() {
    Assertions.assertEquals("xyz", minimumWindowSubstring.minWindow("xyz", "xyz"));
  }
  
  @Test
  void testMinimumWindowSubstring3() {
    Assertions.assertEquals("", minimumWindowSubstring.minWindow("x", "xy"));
  }
}
