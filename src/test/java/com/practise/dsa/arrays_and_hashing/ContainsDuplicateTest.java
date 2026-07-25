package com.practise.dsa.arrays_and_hashing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ContainsDuplicateTest {

  private final ContainsDuplicate containsDuplicate = new ContainsDuplicate();

  @Test
  void testHasDuplicate() {
    int[] nums = { 1, 2, 3, 1 };
    assertTrue(containsDuplicate.hasDuplicateSorting(nums), "hasDuplicateSorting failed");
    assertTrue(containsDuplicate.hasDuplicateHashSet(nums), "hasDuplicateHashSet failed");
  }

  @Test
  void testNoDuplicate() {
    int[] nums = { 1, 2, 3, 4 };
    assertFalse(containsDuplicate.hasDuplicateSorting(nums), "hasDuplicateSorting failed");
    assertFalse(containsDuplicate.hasDuplicateHashSet(nums), "hasDuplicateSorting failed");
  }

}
