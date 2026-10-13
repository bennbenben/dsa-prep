package com.practise.dsa.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoIntegerSumIITest {
  
  private final TwoIntegerSumII twoIntegerSumII = new TwoIntegerSumII();

  @Test
  void testTwoIntegerSumII() {
    int[] numbers = new int[] {1,2,3,4}, output = new int[] {1,2};
    int target = 3;
    Assertions.assertArrayEquals(output, twoIntegerSumII.twoSumTwoPointers(numbers, target));
    Assertions.assertArrayEquals(output, twoIntegerSumII.twoSumBinarySearch(numbers, target));
  }
  
}
