package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;

public class MergeKSortedListsTest {

  private final MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
  
  @Test
  void testMergeKSortedListsMinHeap1() {
    ListNode[] lists = new ListNode[] {
        LinkedListTestUtils.createList(new int[]{1, 2, 4}),
        LinkedListTestUtils.createList(new int[]{1, 3, 5}),
        LinkedListTestUtils.createList(new int[]{3, 6})
    };
    
    ListNode merged = this.mergeKSortedLists.mergeKListsMinHeap(lists);
    LinkedListTestUtils.assertListEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 6}, merged);
  }
  
  @Test
  void testMergeKSortedListsMinHeap2() {
    ListNode[] lists = new ListNode[0];
    ListNode merged = this.mergeKSortedLists.mergeKListsMinHeap(lists);
    LinkedListTestUtils.assertListEquals(new int[]{}, merged);
  }
  
  @Test
  void testMergeKSortedListsMinHeap3() {
    ListNode[] lists = new ListNode[] {null};
    ListNode merged = this.mergeKSortedLists.mergeKListsMinHeap(lists);
    LinkedListTestUtils.assertListEquals(new int[]{}, merged);
  }
  
  @Test
  void testMergeKSortedListsDivideNConquer1() {
    ListNode[] lists = new ListNode[] {
        LinkedListTestUtils.createList(new int[]{1, 2, 4}),
        LinkedListTestUtils.createList(new int[]{1, 3, 5}),
        LinkedListTestUtils.createList(new int[]{3, 6})
    };
    
    ListNode merged = this.mergeKSortedLists.mergeKListsDivideNConquer(lists);
    LinkedListTestUtils.assertListEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 6}, merged);
  }
  
  @Test
  void testMergeKSortedListsDivideNConquer2() {
    ListNode[] lists = new ListNode[0];
    ListNode merged = this.mergeKSortedLists.mergeKListsDivideNConquer(lists);
    LinkedListTestUtils.assertListEquals(new int[]{}, merged);
  }
  
  @Test
  void testMergeKSortedListsDivideNConquer3() {
    ListNode[] lists = new ListNode[] {null};
    ListNode merged = this.mergeKSortedLists.mergeKListsDivideNConquer(lists);
    LinkedListTestUtils.assertListEquals(new int[]{}, merged);
  }

}
