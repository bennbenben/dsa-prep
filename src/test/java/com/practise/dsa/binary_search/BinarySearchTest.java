package com.practise.dsa.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

  private final BinarySearch binarySearch = new BinarySearch();
  
  @Test
  void testBinarySearch1() {
    int[] nums = new int[] {-1,0,2,4,6,8};
    int target = 4;
    int output = 3;
    
    Assertions.assertEquals(output, binarySearch.search(nums, target));
  }
  
  @Test
  void testBinarySearch2() {
    int[] nums = new int[] {-1,0,2,4,6,8};
    int target = 3;
    int output = -1;
    
    Assertions.assertEquals(output, binarySearch.search(nums, target));
  }
}
