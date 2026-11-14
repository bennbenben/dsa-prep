package com.practise.dsa.heaps_and_priority_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestElementInAnArrayTest {

  private final KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
  
  @Test
  void testKthLargestElementInAnArray1() {
    int[] nums = new int[] {2,3,1,5,4}; int k=2;
    int kthLargestElementMinHeap = this.kthLargestElementInAnArray.findKthLargestMinHeap(nums, k);
    int kthLargestElementQuickSelect = this.kthLargestElementInAnArray.findKthLargestQuickSelect(nums, k);
    int expected = 4;
    Assertions.assertEquals(expected, kthLargestElementMinHeap, "Error in testKthLargestElementInAnArray1.kthLargestElementMinHeap");
    Assertions.assertEquals(expected, kthLargestElementQuickSelect, "Error in testKthLargestElementInAnArray1.kthLargestElementQuickSelect");
  }
  
  @Test
  void testKthLargestElementInAnArray2() {
    int[] nums = new int[] {2,3,1,1,5,5,4}; int k=3;
    int kthLargestElementMinHeap = this.kthLargestElementInAnArray.findKthLargestMinHeap(nums, k);
    int kthLargestElementQuickSelect = this.kthLargestElementInAnArray.findKthLargestQuickSelect(nums, k);
    int expected = 4;
    Assertions.assertEquals(expected, kthLargestElementMinHeap, "Error in testKthLargestElementInAnArray1.kthLargestElementMinHeap");
    Assertions.assertEquals(expected, kthLargestElementQuickSelect, "Error in testKthLargestElementInAnArray1.kthLargestElementQuickSelect");
  }
}
