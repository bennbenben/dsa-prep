package com.practise.dsa.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
  public TreeNode invertTreeRecursiveDfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    
    invertTreeRecursiveDfs(root.left);
    invertTreeRecursiveDfs(root.right);
    return root;
  }
  
  public TreeNode invertTreeIterativeDfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst(); // get the most recently added node
      
      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
      
      if (node.right!=null) {
        stack.addFirst(node.right);
      }
      
      if (node.left!=null) {
        stack.addFirst(node.left);
      }
    }
    
    return root;
  }
  
  public TreeNode invertTreeIterativeBfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll(); // head of queue
      
      // swap the left and right of most recently added node
      TreeNode temp = node.left; 
      node.left = node.right;
      node.right = temp;
      
      // add the children into queue for next iteration
      if (node.right != null) {
        queue.offer(node.right);
      } 
      
      if (node.left != null) {
        queue.offer(node.left);
      } 
    }
    
    return root;
  }
}
