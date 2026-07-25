package com.practise.dsa.arrays_and_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestConsecutiveSequenceTest {

  private final LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

  @Test
  void testLongestConsecutiveSequence1() {
    int[] nums = { 2,20,4,10,3,4,5 };
    int output = 4;
    Assertions.assertEquals(output, longestConsecutiveSequence.longestConsecutive(nums), "longestConsecutiveSequence.longestConsecutive failed");
  }

  @Test
  void testLongestConsecutiveSequence2() {
    int[] nums = { 0,3,2,5,4,6,1,1 };
    int output = 7;
    Assertions.assertEquals(output, longestConsecutiveSequence.longestConsecutive(nums), "longestConsecutiveSequence.longestConsecutive failed");
  }

}
