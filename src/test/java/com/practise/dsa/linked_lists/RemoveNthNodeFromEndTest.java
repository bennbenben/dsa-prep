package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;

public class RemoveNthNodeFromEndTest {

  private final RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
  
  @Test
  void testRemoveNthFromEnd1() {
    ListNode inputHead = LinkedListTestUtils.createList(new int[] {1,2,3,4});
    ListNode outputHead = removeNthNodeFromEnd.removeNthFromEnd(inputHead, 2);
    LinkedListTestUtils.assertListEquals(new int[] {1,2,4}, outputHead);
  }
  
  @Test
  void testRemoveNthFromEnd2() {
    ListNode inputHead = LinkedListTestUtils.createList(new int[] {5});
    ListNode outputHead = removeNthNodeFromEnd.removeNthFromEnd(inputHead, 1);
    LinkedListTestUtils.assertListEquals(new int[] {}, outputHead);
  }
  
  @Test
  void testRemoveNthFromEnd3() {
    ListNode inputHead = LinkedListTestUtils.createList(new int[] {1,2});
    ListNode outputHead = removeNthNodeFromEnd.removeNthFromEnd(inputHead, 2);
    LinkedListTestUtils.assertListEquals(new int[] {2}, outputHead);
  }
}
