package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Assertions;

public class LinkedListTestUtils {
  public static ListNode createList(int[] vals) {
    if (vals.length == 0) {
      return null;
    } else {
      ListNode dummyHead = new ListNode(0);
      ListNode curr = dummyHead;

      for (int val : vals) {
        curr.next = new ListNode(val);
        curr = curr.next;
      }

      return dummyHead.next;
    }
  }

  public static void assertListEquals(int[] expected, ListNode head) {
    ListNode curr = head;
    for (int i = 0; i < expected.length; i++) {
      Assertions.assertNotNull(curr, "List ended earlier than expected at index " + i);
      Assertions.assertEquals(expected[i], curr.val, "Mismatch at index " + i);
      curr = curr.next;
    }
    Assertions.assertNull(curr, "List is longer than expected");
  }
}
