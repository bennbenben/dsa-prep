package com.practise.dsa.arrays_and_hashing;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TwoSumTest {

  private final TwoSum twoSum = new TwoSum();

  @Test
  void testTwoSumCase1() {
    int[] nums = new int[] { 3, 4, 5, 6 };
    int target = 7;
    assertArrayEquals(new int[] { 0, 1 }, twoSum.twoSum2Pointers(nums, target), "twoSum2Pointers failed");
    assertArrayEquals(new int[] { 0, 1 }, twoSum.twoSumHashMapTwoPass(nums, target), "twoSumHashMapTwoPass failed");
    assertArrayEquals(new int[] { 0, 1 }, twoSum.twoSumHashMapOnePass(nums, target), "twoSumHashMapOnePass failed");
  }
  
  @Test
  void testTwoSumCase2() {
    int[] nums = new int[] { 4, 5, 6 };
    int target = 10;
    assertArrayEquals(new int[] { 0, 2 }, twoSum.twoSum2Pointers(nums, target), "twoSum2Pointers failed");
    assertArrayEquals(new int[] { 0, 2 }, twoSum.twoSumHashMapTwoPass(nums, target), "twoSumHashMapTwoPass failed");
    assertArrayEquals(new int[] { 0, 2 }, twoSum.twoSumHashMapOnePass(nums, target), "twoSumHashMapOnePass failed");
  }

}
