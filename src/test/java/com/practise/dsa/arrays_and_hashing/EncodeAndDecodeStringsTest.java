package com.practise.dsa.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EncodeAndDecodeStringsTest {

  private final EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();

  @Test
  void testEncodeStrings1() {
    List<String> strs = new ArrayList<String>(Arrays.asList("Hello", "World"));
    Assertions.assertEquals("5#Hello5#World", encodeAndDecodeStrings.encode(strs));
  }
  
  @Test
  void testDecodeStrings1() {
    List<String> strs = new ArrayList<String>(Arrays.asList("Hello", "World"));
    Assertions.assertEquals(strs, encodeAndDecodeStrings.decode("5#Hello5#World"));
  }
  
  @Test
  void testEncodeStrings2() {
    List<String> strs = new ArrayList<String>(Arrays.asList(""));
    Assertions.assertEquals("0#", encodeAndDecodeStrings.encode(strs));
  }
  
  @Test
  void testDecodeStrings2() {
    List<String> strs = new ArrayList<String>(Arrays.asList(""));
    Assertions.assertEquals(strs, encodeAndDecodeStrings.decode("0#"));
  }

}
