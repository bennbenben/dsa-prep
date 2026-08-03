package com.practise.dsa.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlidingWindowMaximumTest {

  private final SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
  
  @Test
  void testSlidingWindowMaximum() {
    int[] nums = {1,2,1,0,4,2,6};
    int k = 3;
    int[] output = {2,2,4,4,6};
    Assertions.assertArrayEquals(output, slidingWindowMaximum.maxSlidingWindowBruteForce(nums, k));
    Assertions.assertArrayEquals(output, slidingWindowMaximum.maxSlidingWindowPriorityQueue(nums, k));
    Assertions.assertArrayEquals(output, slidingWindowMaximum.maxSlidingWindowDeque(nums, k));
  }
}
