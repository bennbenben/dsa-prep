package com.practise.dsa.arrays_and_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopKFrequentElementsTest {

  private final TopKFrequentElements topKFrequentElements = new TopKFrequentElements();

  @Test
  void testTopKFrequentElements1() {
    int[] nums = { 1, 2, 2, 3, 3, 3 };
    int k = 2;
    int[] expectedOutput = { 3, 2 };
    Assertions.assertArrayEquals(expectedOutput, topKFrequentElements.topKFrequentSorting(nums, k));
    Assertions.assertArrayEquals(expectedOutput, topKFrequentElements.topKFrequentBucketSort(nums, k));
  }

  @Test
  void testTopKFrequentElements2() {
    int[] nums = { 7, 7 };
    int k = 1;
    int[] expectedOutput = { 7 };
    Assertions.assertArrayEquals(expectedOutput, topKFrequentElements.topKFrequentSorting(nums, k));
    Assertions.assertArrayEquals(expectedOutput, topKFrequentElements.topKFrequentBucketSort(nums, k));
  }

}
