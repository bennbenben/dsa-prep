package com.practise.dsa.linked_lists;

public class AddTwoNumbers {
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    ListNode firstHead = l1; ListNode secondHead = l2;
    ListNode dummy = new ListNode(); ListNode additionHead = dummy;
    
    int carry = 0;
    int remainder = 0;
    while ((firstHead != null) && (secondHead != null)) {
      remainder = (firstHead.val + secondHead.val + carry)%10;
      carry = (firstHead.val + secondHead.val + carry)/10;
      additionHead.next = new ListNode(remainder);
      
      firstHead = firstHead.next;
      secondHead = secondHead.next;
      additionHead = additionHead.next;
    }
    
    while (firstHead != null) {
      remainder = (firstHead.val + carry)%10;
      carry = (firstHead.val + carry)/10;
      additionHead.next = new ListNode(remainder);

      firstHead = firstHead.next;
      additionHead = additionHead.next;
    }
    
    while (secondHead != null) {
      remainder = (secondHead.val + carry)%10;
      carry = (secondHead.val + carry)/10;
      additionHead.next = new ListNode(remainder);

      secondHead = secondHead.next;
      additionHead = additionHead.next;
    }
    
    if (carry != 0) {
      additionHead.next = new ListNode(carry);
    }
    
    return dummy.next;
  }
  
  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode firstHead = l1; ListNode secondHead = l2;
    ListNode dummy = new ListNode(); ListNode additionHead = dummy;
    
    int carry = 0; int remainder = 0;
    int firstHeadVal; int secondHeadVal;
    while ((firstHead != null) || (secondHead != null) || (carry != 0)) {
      
      if (firstHead == null) {
        firstHeadVal = 0;
      } else {
        firstHeadVal = firstHead.val;
        firstHead = firstHead.next;
      }
      
      if (secondHead == null) {
        secondHeadVal = 0;
      } else {
        secondHeadVal = secondHead.val;
        secondHead = secondHead.next;
      }
      
      
      remainder = (firstHeadVal + secondHeadVal + carry)%10;
      carry = (firstHeadVal + secondHeadVal + carry)/10;
      additionHead.next = new ListNode(remainder);
      additionHead = additionHead.next;
    }
    
    return dummy.next;
  }
}
