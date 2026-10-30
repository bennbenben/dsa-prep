package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListCycleDetectionTest {

  private final LinkedListCycleDetection linkedListCycleDetection = new LinkedListCycleDetection();
  
  @Test
  void testHasCycle1() {
    // 1. Create the straight list: 1 -> 2 -> 3 -> 4
    ListNode head = LinkedListTestUtils.createList(new int[] {1, 2, 3, 4});
    
    // 2. Identify the target node '2' (this is head.next)
    ListNode cycleTarget = head.next;
    
    // 3. Traverse down to find the tail node '4'
    ListNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }
    
    // 4. Wire node '4' back to node '2' as shown in the image
    tail.next = cycleTarget;
    
    // 5. Assert the cycle is successfully detected
    Assertions.assertTrue(linkedListCycleDetection.hasCycle(head));
  }
  
  @Test
  void testHasCycle2() {
    // 1. Create the straight list: 1 -> 2 
    ListNode head = LinkedListTestUtils.createList(new int[] {1, 2});
    Assertions.assertFalse(linkedListCycleDetection.hasCycle(head));
  }
}
