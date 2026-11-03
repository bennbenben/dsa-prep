package com.practise.dsa.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchInRotatedSortedArrayTest {

  private final SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
  
  @Test
  void testSearchInRotatedSortedArray1() {
    int[] nums = new int[] {3,4,5,6,1,2};
    int target = 1;
    Assertions.assertEquals(4, this.searchInRotatedSortedArray.search(nums, target));
  }
  
  @Test
  void testSearchInRotatedSortedArray2() {
    int[] nums = new int[] {3,5,6,0,1,2};
    int target = 4;
    Assertions.assertEquals(-1, this.searchInRotatedSortedArray.search(nums, target));
  }
}
