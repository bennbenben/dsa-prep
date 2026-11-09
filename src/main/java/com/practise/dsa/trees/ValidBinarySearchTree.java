package com.practise.dsa.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ValidBinarySearchTree {
  public boolean isValidBSTDfsRecursive(TreeNode root) {
    if (root == null) {
      return true;
    }
    return this.isValidDfsRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  private boolean isValidDfsRecursive(TreeNode root, long minBound, long maxBound) {
    if (root == null) {
      return true;
    }
    
    TreeNode node = root;
    if (minBound < node.val && node.val < maxBound) {
      return this.isValidDfsRecursive(root.left, minBound, node.val) && 
          this.isValidDfsRecursive(root.right, node.val, maxBound);
    } else {
      return false;
    }
  }
  
  private record Node(TreeNode root, long minBound, long maxBound) {}
  
  public boolean isValidBSTDfsIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Deque<Node> stack = new LinkedList<Node>();
    stack.offerFirst(new Node(root, Long.MIN_VALUE, Long.MAX_VALUE));
    
    while (!stack.isEmpty()) {
      Node node = stack.pollFirst();
      if (node.minBound < node.root.val && node.root.val < node.maxBound) {
        if (node.root.right != null) {
          Node rightChildNode = new Node(node.root.right, node.root.val, node.maxBound);
          stack.offerFirst(rightChildNode);
        }
        
        if (node.root.left != null) {
          Node leftChildNode = new Node(node.root.left, node.minBound, node.root.val);
          stack.offerFirst(leftChildNode);
        }
        
      } else {
        return false;
      }
    }
    
    return true;
  }
  
  public boolean isValidBSTBfsIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(new Node(root, Long.MIN_VALUE, Long.MAX_VALUE));
    
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.minBound < node.root.val && node.root.val < node.maxBound) {
        if (node.root.right != null) {
          Node rightChildNode = new Node(node.root.right, node.root.val, node.maxBound);
          queue.offer(rightChildNode);
        }
        
        if (node.root.left != null) {
          Node leftChildNode = new Node(node.root.left, node.minBound, node.root.val);
          queue.offer(leftChildNode);
        }
        
      } else {
        return false;
      }
    }
    
    return true;
  }
}
