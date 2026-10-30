package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;

public class ReorderLinkedListTest {

  private final ReorderLinkedList reorderLinkedList = new ReorderLinkedList();
  
  @Test
  void testReorderLinkedList1() {
    ListNode head = LinkedListTestUtils.createList(new int[] {2, 4, 6, 8});
    reorderLinkedList.reorderList(head);
    LinkedListTestUtils.assertListEquals(new int[] {2,8,4,6}, head);
  }
  
  @Test
  void testReorderLinkedList2() {
    ListNode head = LinkedListTestUtils.createList(new int[] {2,4,6,8,10});
    reorderLinkedList.reorderList(head);
    LinkedListTestUtils.assertListEquals(new int[] {2,10,4,8,6}, head);
  }
}
