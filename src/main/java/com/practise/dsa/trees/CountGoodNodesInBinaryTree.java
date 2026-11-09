package com.practise.dsa.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CountGoodNodesInBinaryTree {

  private int countGoodNodes = 0;
  
  public int goodNodesDfsRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    this.countGoodNodes = 0;
    this.dfsRecursive(root, root.val);
    return this.countGoodNodes;
  }
  
  private void dfsRecursive(TreeNode node, int maxSoFar) {
    if (node == null) {
      return;
    }
    
    if (node.val >= maxSoFar) {
      this.countGoodNodes += 1;
    }
    
    int newMaxSoFar = Math.max(maxSoFar, node.val);
    
    this.dfsRecursive(node.left, newMaxSoFar);
    this.dfsRecursive(node.right, newMaxSoFar);
  }
  
  private record Node (TreeNode root, int maxSoFar) {}
  
  public int goodNodesBfsIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Node node = new Node(root, root.val);
    int countGoodNodes = 0;
    
    Queue<Node> bfsQueue = new LinkedList<Node>();
    bfsQueue.offer(node);
    
    while (!bfsQueue.isEmpty()) {
      node = bfsQueue.poll(); 
      if (node.root.val >= node.maxSoFar) {
        countGoodNodes += 1;
      }
      int nextMaxSoFar = Math.max(node.root.val, node.maxSoFar);
      if (node.root.left != null) {
        bfsQueue.offer(new Node(node.root.left, nextMaxSoFar));
      }
      if (node.root.right != null) {
        bfsQueue.offer(new Node(node.root.right, nextMaxSoFar));
      }
    }
    
    return countGoodNodes;
  }
  
  public int goodNodesDfsIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Node node = new Node(root, root.val);
    int countGoodNodes = 0;
    
    Deque<Node> dfsStack = new LinkedList<Node>();
    dfsStack.offer(node);
    
    while (!dfsStack.isEmpty()) {
      node = dfsStack.pollFirst(); 
      if (node.root.val >= node.maxSoFar) {
        countGoodNodes += 1;
      }
      int nextMaxSoFar = Math.max(node.root.val, node.maxSoFar);
      if (node.root.right != null) {
        dfsStack.offerFirst(new Node(node.root.right, nextMaxSoFar));
      }
      if (node.root.left != null) {
        dfsStack.offerFirst(new Node(node.root.left, nextMaxSoFar));
      }
    }
    
    return countGoodNodes;
  }
}
