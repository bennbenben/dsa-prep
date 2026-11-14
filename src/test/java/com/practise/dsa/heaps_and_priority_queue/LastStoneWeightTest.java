package com.practise.dsa.heaps_and_priority_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LastStoneWeightTest {

  private final LastStoneWeight lastStoneWeight = new LastStoneWeight();
  
  @Test
  void testLastStoneWeight1() {
    int[] stones = new int[] {2,3,6,2,4};
    int lastStone = this.lastStoneWeight.lastStoneWeight(stones); 
    int expected = 1;
    Assertions.assertEquals(expected, lastStone);
  }
  
  @Test
  void testLastStoneWeight2() {
    int[] stones = new int[] {1,2};
    int lastStone = this.lastStoneWeight.lastStoneWeight(stones); 
    int expected = 1;
    Assertions.assertEquals(expected, lastStone);
  }
}
