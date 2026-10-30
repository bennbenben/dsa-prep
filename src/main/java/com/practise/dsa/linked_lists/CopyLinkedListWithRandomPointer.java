package com.practise.dsa.linked_lists;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
  public Node copyRandomListHashMap(Node head) {
    Node originalNode = head; 
    Map<Node, Node> nodesMap = new HashMap<Node, Node>();
    
    while (originalNode != null) {
      Node copyNode = new Node(originalNode.val);
      nodesMap.put(originalNode, copyNode);
      originalNode = originalNode.next;
    }
    
    originalNode = head; 
    while (originalNode != null) {
      Node copyNode = nodesMap.get(originalNode);
      
      // assign next node
      copyNode.next = nodesMap.get(originalNode.next);
      copyNode.random = nodesMap.get(originalNode.random);
      originalNode = originalNode.next;
    }
    
    return nodesMap.get(head);
  }
  
  public Node copyRandomList2Pointers(Node head) {
    if (head == null) return null;
    Node originalNode = head;
    
    // transform A -> B -> C into A -> A' -> B -> B' -> C -> C'
    while (originalNode!=null) {
      Node copyNode = new Node(originalNode.val);
      Node nextNode = originalNode.next;
      originalNode.next = copyNode; copyNode.next = nextNode;
      originalNode = nextNode;
    }
    
    // transform copied nodes' .random pointers A -> A' -> B -> B' -> C -> C'
    originalNode = head;
    while (originalNode!=null) {
      Node copyNode = originalNode.next;
      if (originalNode.random == null) {
        copyNode.random = null;
      } else {
        copyNode.random = originalNode.random.next;
      }
      originalNode = copyNode.next;
    }
    
    // unzip A -> A' -> B -> B' -> C -> C' into A -> B -> C and A' -> B' -> C'
    originalNode = head; Node copyHead = originalNode.next;
    while (originalNode!=null) {
      Node copyNode = originalNode.next;
      
      if (copyNode.next != null) {
         originalNode.next = copyNode.next;
         copyNode.next = copyNode.next.next; // or originalNode.next.next
      } else {
        originalNode.next = null;
        copyNode.next = null;
      }
      
      originalNode = originalNode.next;
    }
    return copyHead;
  }
}
