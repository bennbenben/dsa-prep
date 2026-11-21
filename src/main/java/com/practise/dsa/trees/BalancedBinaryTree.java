package com.practise.dsa.trees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BalancedBinaryTree {
  
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    Map<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
    depthMap.put(null, 0);
    
    while (!stack.isEmpty()) {
      TreeNode headNode = stack.peekFirst();
      TreeNode leftChild = headNode.left; TreeNode rightChild = headNode.right;
      
      if (depthMap.containsKey(leftChild) && depthMap.containsKey(rightChild)) {
        headNode = stack.pollFirst();
        int leftChildHeight = depthMap.get(leftChild); int rightChildHeight = depthMap.get(rightChild);
        depthMap.put(headNode, 1+Math.max(leftChildHeight, rightChildHeight));
        
        if (Math.abs(leftChildHeight - rightChildHeight) > 1) {
          return false;
        }
        
      } else {
        if (!depthMap.containsKey(rightChild)) {
          stack.offerFirst(rightChild);
        }
        
        if (!depthMap.containsKey(leftChild)) {
          stack.offerFirst(leftChild);
        }
      }
      
    }
    return true;
  }
  
  // DFS - Recursive (ON2) version
  public boolean isBalancedDfsRecursive(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftHeight = this.dfsRecursive(root.left);
    int rightHeight = this.dfsRecursive(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }
    return this.isBalancedDfsRecursive(root.left) && this.isBalancedDfsRecursive(root.right);
  }
  
  private int dfsRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(this.dfsRecursive(root.left), this.dfsRecursive(root.right));
  }
  
  // DFS - Recursive O(N) version
  public boolean isBalancedDfsRecursiveOptimized(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (this.dfsRecursiveOptimized(root) == -1) {
      return false;
    } else {
      return true;
    }
  }

  private int dfsRecursiveOptimized(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftHeight = this.dfsRecursiveOptimized(root.left);
    int rightHeight = this.dfsRecursiveOptimized(root.right);
    
    if (leftHeight == -1 || rightHeight == -1) {
      return -1;
    }
    
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }
  
  // DFS - Iterative
  public boolean isBalancedDfsIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    Map<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
    depthMap.put(null, 0);
    
    while (!stack.isEmpty()) {
      TreeNode headNode = stack.peekFirst();
      TreeNode leftChild = headNode.left; TreeNode rightChild = headNode.right;
      
      if (depthMap.containsKey(leftChild) && depthMap.containsKey(rightChild)) {
        headNode = stack.pollFirst();
        int leftChildHeight = depthMap.get(leftChild); int rightChildHeight = depthMap.get(rightChild);
        depthMap.put(headNode, 1+Math.max(leftChildHeight, rightChildHeight));
        
        if (Math.abs(leftChildHeight - rightChildHeight) > 1) {
          return false;
        }
        
      } else {
        if (!depthMap.containsKey(rightChild)) {
          stack.offerFirst(rightChild);
        }
        
        if (!depthMap.containsKey(leftChild)) {
          stack.offerFirst(leftChild);
        }
      }
    }
    
    return true;
  }
}
