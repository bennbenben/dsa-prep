package com.practise.dsa.two_pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerWithMostWaterTest {

  private final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
  
  @Test
  void testContainerWithMostWater1() {
    int[] heights = {1,7,2,5,4,7,3,6};
    int output = 36;
    Assertions.assertEquals(output, containerWithMostWater.maxArea(heights));
  }
  
  @Test
  void testContainerWithMostWater2() {
    int[] heights = {2,2,2};
    int output = 4;
    Assertions.assertEquals(output, containerWithMostWater.maxArea(heights));
  }
}
