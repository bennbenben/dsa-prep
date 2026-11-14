package com.practise.dsa.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.practise.dsa.heaps_and_priority_queue.FindMedianFromDataStream;

public class FindMedianFromDataStreamTest {

  private FindMedianFromDataStream medianFinder;

  @BeforeEach
  public void setUp() {
    medianFinder = new FindMedianFromDataStream();
  }

  @Test
  public void testNeetCodeExample() {
    // medianFinder.addNum(1); // arr = [1]
    medianFinder.addNum(1);
    // medianFinder.findMedian(); // return 1.0
    Assertions.assertEquals(1.0, medianFinder.findMedian(), "Median should be 1.0 after adding 1");
    // medianFinder.addNum(3); // arr = [1, 3]
    medianFinder.addNum(3);
    // medianFinder.findMedian(); // return 2.0
    Assertions.assertEquals(2.0, medianFinder.findMedian(), "Median should be 2.0 after adding 3");
    // medianFinder.addNum(2); // arr[1, 2, 3]
    medianFinder.addNum(2);
    // medianFinder.findMedian(); // return 2.0
    Assertions.assertEquals(2.0, medianFinder.findMedian(), "Median should be 2.0 after adding 2");
  }
}
