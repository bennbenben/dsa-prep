package com.practise.dsa.arrays_and_hashing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidAnagramTest {
  
  private final ValidAnagram validAnagram = new ValidAnagram();
  
  @Test
  void testIsAnagram() {
    String s = "racecar";
    String t = "carrace";
    assertTrue(validAnagram.isAnagramSorted(s, t), "validAnagram.isAnagramSorted failed");
    assertTrue(validAnagram.isAnagramHashMap(s, t), "validAnagram.isAnagramHashMap failed");
    assertTrue(validAnagram.isAnagramPrimitiveArray(s, t), "validAnagram.isAnagramPrimitiveArray failed");
  }
  
  @Test
  void testIsNotAnagram() {
    String s = "jar";
    String t = "jam";
    assertFalse(validAnagram.isAnagramSorted(s, t), "validAnagram.isAnagramSorted failed");
    assertFalse(validAnagram.isAnagramHashMap(s, t), "validAnagram.isAnagramHashMap failed");
    assertFalse(validAnagram.isAnagramPrimitiveArray(s, t), "validAnagram.isAnagramPrimitiveArray failed");
  }

}
