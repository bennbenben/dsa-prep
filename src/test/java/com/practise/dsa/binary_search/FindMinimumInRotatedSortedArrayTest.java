package com.practise.dsa.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMinimumInRotatedSortedArrayTest {

  private final FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
  
  @Test
  void testFindMinimumInRotatedSortedArray1() {
    Assertions.assertEquals(1, this.findMinimumInRotatedSortedArray.findMin(new int[] {3,4,5,6,1,2}));
  }
  
  @Test
  void testFindMinimumInRotatedSortedArray2() {
    Assertions.assertEquals(0, this.findMinimumInRotatedSortedArray.findMin(new int[] {4,5,0,1,2,3}));
  }
  
  @Test
  void testFindMinimumInRotatedSortedArray3() {
    Assertions.assertEquals(4, this.findMinimumInRotatedSortedArray.findMin(new int[] {4,5,6,7}));
  }
}
