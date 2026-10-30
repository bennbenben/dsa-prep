package com.practise.dsa.linked_lists;

public class RemoveNthNodeFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    
    ListNode slowNode = dummy; ListNode fastNode = dummy;
    for (int i=0; i<=n; i++) {
      fastNode = fastNode.next;
    }
    
    while (fastNode != null) {
      slowNode = slowNode.next; fastNode = fastNode.next;
    }
    
    slowNode.next = slowNode.next.next;
    return dummy.next;
  }
}
