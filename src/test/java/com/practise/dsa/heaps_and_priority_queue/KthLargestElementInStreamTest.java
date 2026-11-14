package com.practise.dsa.heaps_and_priority_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestElementInStreamTest {

  @Test
  void testKthLargestElementInStreamMaxHeap() {
    KthLargestElementInStream.KthLargestMaxHeap maxHeap = new KthLargestElementInStream.KthLargestMaxHeap(3, new int[] { 1, 2, 3, 3 });
    Assertions.assertEquals(3, maxHeap.add(3));
    Assertions.assertEquals(3, maxHeap.add(5));
    Assertions.assertEquals(3, maxHeap.add(6));
    Assertions.assertEquals(5, maxHeap.add(7));
    Assertions.assertEquals(6, maxHeap.add(8));
  }
  
  @Test
  void testKthLargestElementInStreamMinHeapOptimized() {
    KthLargestElementInStream.KthLargestMinHeap minHeap = new KthLargestElementInStream.KthLargestMinHeap(3, new int[] { 1, 2, 3, 3 });
    Assertions.assertEquals(3, minHeap.add(3));
    Assertions.assertEquals(3, minHeap.add(5));
    Assertions.assertEquals(3, minHeap.add(6));
    Assertions.assertEquals(5, minHeap.add(7));
    Assertions.assertEquals(6, minHeap.add(8));
  }
}
