package com.practise.dsa.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrappingRainWaterTest {
  
  private final TrappingRainWater trappingRainWater = new TrappingRainWater();
  
  @Test
  void testTrappingRainWater() {
    int[] height = new int[] {0,2,0,3,1,0,1,3,2,1};
    Assertions.assertEquals(9, trappingRainWater.trapLeftAndRightArrays(height));
    Assertions.assertEquals(9, trappingRainWater.trap2Pointers(height));
  }
}
