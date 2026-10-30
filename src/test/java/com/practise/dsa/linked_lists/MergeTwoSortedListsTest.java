package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {

  private final MergeTwoSortedLists mergeTwoLists = new MergeTwoSortedLists();
  
  @Test
  void testMergeTwoLists1() {
    ListNode list1 = LinkedListTestUtils.createList(new int[] {1, 2, 4});
    ListNode list2 = LinkedListTestUtils.createList(new int[] {1, 3, 5});
    ListNode mergedHead = this.mergeTwoLists.mergeTwoLists(list1, list2);
    
    LinkedListTestUtils.assertListEquals(new int[] {1, 1, 2, 3, 4, 5}, mergedHead);
  }
  
  @Test
  void testMergeTwoLists2() {
    ListNode list1 = LinkedListTestUtils.createList(new int[] {});
    ListNode list2 = LinkedListTestUtils.createList(new int[] {1, 2});
    ListNode mergedHead = this.mergeTwoLists.mergeTwoLists(list1, list2);
    
    LinkedListTestUtils.assertListEquals(new int[] {1, 2}, mergedHead);
  }
  
  @Test
  void testMergeTwoLists3() {
    ListNode list1 = LinkedListTestUtils.createList(new int[] {});
    ListNode list2 = LinkedListTestUtils.createList(new int[] {});
    ListNode mergedHead = this.mergeTwoLists.mergeTwoLists(list1, list2);
    
    LinkedListTestUtils.assertListEquals(new int[] {}, mergedHead);
  }
  
}
