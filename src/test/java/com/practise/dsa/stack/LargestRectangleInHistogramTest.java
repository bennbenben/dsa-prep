package com.practise.dsa.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargestRectangleInHistogramTest {

  private final LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
  
  @Test
  void testLargestRectangleInHistogram1() {
    int[] heights = new int[]{7,1,7,2,2,4};
    int output = 8;
    
    Assertions.assertEquals(output, largestRectangleInHistogram.largestRectangleArea(heights));
  }
  
  @Test
  void testLargestRectangleInHistogram2() {
    int[] heights = new int[]{1,3,7};
    int output = 7;
    
    Assertions.assertEquals(output, largestRectangleInHistogram.largestRectangleArea(heights));

  }
}
