package com.practise.dsa.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
  
  // DFS - Recursive method
  public TreeNode invertTreeRecursiveDfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    TreeNode tempNode = root.left;
    root.left = root.right;
    root.right = tempNode;
    
    invertTreeRecursiveDfs(root.left);
    invertTreeRecursiveDfs(root.right);
    return root;
  }
  
  // DFS - iterative
  public TreeNode invertTreeIterativeDfs(TreeNode root) {
    if (root == null) {
      return null;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollFirst();
      
      TreeNode tempNode = node.left;
      node.left = node.right;
      node.right = tempNode;
      
      if (node.right != null) { // enqueue the right before left for next iteration
        stack.offerFirst(node.right);
      }
      
      if (node.left != null) {
        stack.offerFirst(node.left);
      }
      
    }
    
    return root;
  }
  
  // BFS - Iterative
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
      if (node.left != null) {
        queue.offer(node.left);
      } 
      
      if (node.right != null) {
        queue.offer(node.right);
      } 
    }
    
    return root;
  }
}
