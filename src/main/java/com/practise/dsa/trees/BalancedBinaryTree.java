package com.practise.dsa.trees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class BalancedBinaryTree {
  
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
  
  public boolean isBalancedDfsIterative(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Deque<TreeNode> treeStack = new LinkedList<TreeNode>();
    treeStack.offerFirst(root);
    HashMap<TreeNode, Integer> treeMap = new HashMap<TreeNode, Integer>();
    treeMap.put(null, 0);
    
    while (!treeStack.isEmpty()) {
      TreeNode node = treeStack.peekFirst();
      
      if (treeMap.containsKey(node.left) && treeMap.containsKey(node.right)) {
        node = treeStack.pollFirst();
        TreeNode leftChildNode = node.left; int leftChildNodeHeight = treeMap.get(leftChildNode);
        TreeNode rightChildNode = node.right; int rightChildNodeHeight = treeMap.get(rightChildNode);
        
        if (Math.abs(rightChildNodeHeight-leftChildNodeHeight) > 1) {
          return false;
        } else {
          treeMap.put(node, 1 + Math.max(leftChildNodeHeight, rightChildNodeHeight));
        }
        
      } else {
        if (!treeMap.containsKey(node.right)) {
          treeStack.offerFirst(node.right);
        }
        
        if (!treeMap.containsKey(node.left)) {
          treeStack.offerFirst(node.left);
        } 
      }
    }
    
    return true;
  }
}
