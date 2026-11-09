package com.practise.dsa.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
  public int maxDepthRecursiveDfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepthRecursiveDfs(root.left), maxDepthRecursiveDfs(root.right));
  }
  
  public class TreePair {
    private TreeNode node;
    private Integer depth;
    public TreePair(TreeNode node, Integer depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  public int maxDepthIterativeDfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Deque<MaximumDepthBinaryTree.TreePair> stack = new LinkedList<MaximumDepthBinaryTree.TreePair>();
    stack.offerFirst(new TreePair(root, 1));
    Integer depth = 0;
    
    while (!stack.isEmpty()) {
      TreePair topPair = stack.pollFirst();
      TreeNode topNode = topPair.node;
      Integer topDepth = topPair.depth;
      depth = Math.max(depth, topDepth);
      
      if (topNode.right != null) {
        stack.offerFirst(new TreePair(topNode.right, topDepth+1));
      }
      
      if (topNode.left != null) {
        stack.offerFirst(new TreePair(topNode.left, topDepth+1));
      }
    }
    return depth;
  }
  
  public int maxDepthIterativeBfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Queue<MaximumDepthBinaryTree.TreePair> queue = new LinkedList<MaximumDepthBinaryTree.TreePair>();
    queue.offer(new TreePair(root, 1));
    Integer depth = 0;
    
    while (!queue.isEmpty()) {
      TreePair topPair = queue.poll();
      TreeNode topNode = topPair.node;
      Integer topDepth = topPair.depth;
      depth = Math.max(depth, topDepth);
      
      if (topNode.right != null) {
        queue.offer(new TreePair(topNode.right, topDepth+1));
      }
      
      if (topNode.left != null) {
        queue.offer(new TreePair(topNode.left, topDepth+1));
      }
    }
    return depth;
  }
  
  public int maxDepthIterativeBfsOptimized(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int depth = 0;
    
    while (!queue.isEmpty()) {
      int numberOfNodesOnLevel = queue.size();
      for (int i=0; i<numberOfNodesOnLevel; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      depth += 1;
    }
    return depth;
  }
}
