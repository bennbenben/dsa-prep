package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {
  private final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
  
  @Test
  void testReverseLinkedList() {
    ListNode head = LinkedListTestUtils.createList(new int[] {0,1,2,3});
    ListNode reversedHeadIteration = this.reverseLinkedList.reverseListIteration(head);
    LinkedListTestUtils.assertListEquals(new int[] {3,2,1,0}, reversedHeadIteration);
    
    ListNode head2 = LinkedListTestUtils.createList(new int[] {0,1,2,3});
    ListNode reversedHeadRecursive = this.reverseLinkedList.reverseListRecursive(head2);
    LinkedListTestUtils.assertListEquals(new int[] {3,2,1,0}, reversedHeadRecursive);
  }

}
