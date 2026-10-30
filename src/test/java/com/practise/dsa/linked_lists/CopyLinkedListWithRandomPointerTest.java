package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CopyLinkedListWithRandomPointerTest {

  private final CopyLinkedListWithRandomPointer copyLinkedListWithRandomPointer = new CopyLinkedListWithRandomPointer();
  
  @Test
  void testCopyRandomListHashMap1() {
    Node node0 = new Node(3); 
    Node node1 = new Node(7);
    Node node2 = new Node(4);
    Node node3 = new Node(5);

    node0.next = node1;
    node1.next = node2;
    node2.next = node3;

    node0.random = null;
    node1.random = node3;
    node2.random = node0;
    node3.random = node1;

    Node copiedHead = this.copyLinkedListWithRandomPointer.copyRandomListHashMap(node0);
    Node originalNode = node0;

    while (originalNode != null) {
      assertDeepCopy(originalNode, copiedHead);
      assertDeepCopy(originalNode.random, copiedHead.random);

      originalNode = originalNode.next;
      copiedHead = copiedHead.next;
    }
    
    Assertions.assertNull(copiedHead, "Copied list is too long");
    
  }
  
  @Test
  void testCopyRandomListHashMap2() {
    Node node0 = new Node(1); 
    Node node1 = new Node(2);
    Node node2 = new Node(3);

    node0.next = node1;
    node1.next = node2;

    node0.random = null;
    node1.random = node2;
    node2.random = node2;

    Node copiedHead = this.copyLinkedListWithRandomPointer.copyRandomListHashMap(node0);
    Node originalNode = node0;

    while (originalNode != null) {
      assertDeepCopy(originalNode, copiedHead);
      assertDeepCopy(originalNode.random, copiedHead.random);

      originalNode = originalNode.next;
      copiedHead = copiedHead.next;
    }
    
    Assertions.assertNull(copiedHead, "Copied list is too long");
    
  }
  
  @Test
  void testCopyRandomList2Ptrs1() {
    Node node0 = new Node(3); 
    Node node1 = new Node(7);
    Node node2 = new Node(4);
    Node node3 = new Node(5);

    node0.next = node1;
    node1.next = node2;
    node2.next = node3;

    node0.random = null;
    node1.random = node3;
    node2.random = node0;
    node3.random = node1;

    Node copiedHead = this.copyLinkedListWithRandomPointer.copyRandomList2Pointers(node0);
    Node originalNode = node0;

    while (originalNode != null) {
      assertDeepCopy(originalNode, copiedHead);
      assertDeepCopy(originalNode.random, copiedHead.random);

      originalNode = originalNode.next;
      copiedHead = copiedHead.next;
    }
    
    Assertions.assertNull(copiedHead, "Copied list is too long");
    
  }
  
  @Test
  void testCopyRandomList2Ptrs2() {
    Node node0 = new Node(1); 
    Node node1 = new Node(2);
    Node node2 = new Node(3);

    node0.next = node1;
    node1.next = node2;

    node0.random = null;
    node1.random = node2;
    node2.random = node2;

    Node copiedHead = this.copyLinkedListWithRandomPointer.copyRandomList2Pointers(node0);
    Node originalNode = node0;

    while (originalNode != null) {
      assertDeepCopy(originalNode, copiedHead);
      assertDeepCopy(originalNode.random, copiedHead.random);

      originalNode = originalNode.next;
      copiedHead = copiedHead.next;
    }
    
    Assertions.assertNull(copiedHead, "Copied list is too long");
    
  }
  
  private void assertDeepCopy(Node original, Node copy) {
    if (original == null) {
      Assertions.assertNull(copy, "Expected null but found a node");
      return;
    }
    
    Assertions.assertNotNull(copy, "Expected a node but found null");
    Assertions.assertNotSame(original, copy, "Memory addresses match! Not a deep copy.");
    Assertions.assertEquals(original.val, copy.val, "Node values do not match");
  }
}
