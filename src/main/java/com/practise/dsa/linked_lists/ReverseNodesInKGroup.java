package com.practise.dsa.linked_lists;

public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode headNode = head; int nodesCount = 0;
    while (headNode != null) {
      nodesCount += 1;
      headNode = headNode.next;
    }
    headNode = head;
    
    int numReverseGroupCount = nodesCount / k; int groupsReversedCount = 0;
    ListNode dummyNode = new ListNode(); dummyNode.next = headNode;
    ListNode groupDummyNode = dummyNode;
    
    while (groupsReversedCount < numReverseGroupCount) {
      ListNode nextGroupHeadNode = headNode;
      for (int i=0; i<k; i++) {
        nextGroupHeadNode = nextGroupHeadNode.next;
      }
      
      ListNode prev = null;
      ListNode curr = headNode;
      for (int i=0; i<k; i++) {
        ListNode nextNode = curr.next;
        curr.next = prev;
        prev = curr; curr = nextNode;
      }
      
      groupDummyNode.next = prev;
      headNode.next = nextGroupHeadNode;
      groupDummyNode = headNode;
      headNode = nextGroupHeadNode;
      
      groupsReversedCount += 1;
    }
    
    return dummyNode.next;
  }
}
