package com.practise.dsa.linked_lists;

public class ReverseLinkedList {
  public ListNode reverseListIteration(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
      ListNode nextNode = curr.next;
      curr.next = prev;
      prev = curr; curr = nextNode;
    }
    return prev;
  }
  
  public ListNode reverseListRecursive(ListNode head) {
    
    if (head == null || head.next == null) {
      return head;
    }
    
    ListNode newHead = reverseListRecursive(head.next);
    
    ListNode temp = head.next; // grab node 2
    temp.next = head; // node 2's next point to node 1
    head.next = null; // node 1 points to null
    
    return newHead;
  }
}
