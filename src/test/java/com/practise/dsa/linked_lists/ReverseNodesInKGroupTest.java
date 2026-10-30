package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;

public class ReverseNodesInKGroupTest {

  private final ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
  
  @Test
  void reverseKGroupTest1() {
    ListNode head = LinkedListTestUtils.createList(new int[] {1,2,3,4,5,6});
    ListNode result = this.reverseNodesInKGroup.reverseKGroup(head, 3);
    LinkedListTestUtils.assertListEquals(new int[]{3, 2, 1, 6, 5, 4}, result);
  }
  
  @Test
  void reverseKGroupTest2() {
    ListNode head = LinkedListTestUtils.createList(new int[] {1,2,3,4,5});
    ListNode result = this.reverseNodesInKGroup.reverseKGroup(head, 3);
    LinkedListTestUtils.assertListEquals(new int[]{3,2,1,4,5}, result);
  }
  
}
