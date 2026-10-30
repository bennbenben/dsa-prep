package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindDuplicateNumberTest {
  
  private final FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();

  @Test
  void testFindDuplicateLinkedList1() {
    int[] nums = new int[] {1,2,3,2,2};
    Assertions.assertEquals(2, this.findDuplicateNumber.findDuplicateLinkedList(nums));
  }
  
  @Test
  void testFindDuplicateLinkedList2() {
    int[] nums = new int[] {1,2,3,4,4};
    Assertions.assertEquals(4, this.findDuplicateNumber.findDuplicateLinkedList(nums));
  }
  
  @Test
  void testFindDuplicateBinarySearch1() {
    int[] nums = new int[] {1,2,3,2,2};
    Assertions.assertEquals(2, this.findDuplicateNumber.findDuplicateBinarySearch(nums));
  }
  
  @Test
  void testFindDuplicateBinarySearch2() {
    int[] nums = new int[] {1,2,3,4,4};
    Assertions.assertEquals(4, this.findDuplicateNumber.findDuplicateBinarySearch(nums));
  }
}
