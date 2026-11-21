package com.practise.dsa.trees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DiameterOfBinaryTree {
  
  private int maxDiameter = 0;
  
  // DFS - Recursive
  public int diameterOfBinaryTreeDfsRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    this.dfsRecursive(root);
    return this.maxDiameter;
  }
  
  private int dfsRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftDepth = this.dfsRecursive(root.left);
    int rightDepth = this.dfsRecursive(root.right);
    
    this.maxDiameter = Math.max(this.maxDiameter, leftDepth + rightDepth);
    return 1 + Math.max(leftDepth, rightDepth);
  }
  
  // DFS - Iterative
  public int diameterOfBinaryTreeDfsIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int maxDiameter = 0;
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    Map<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
    depthMap.put(null, 0);
    
    while (!stack.isEmpty()) {
      TreeNode headNode = stack.peekFirst();
      
      // if both child nodes is already process before
      if (depthMap.containsKey(headNode.left) && depthMap.containsKey(headNode.right)) {
        headNode = stack.pollFirst();
        
        int vShapedDiameter = depthMap.get(headNode.left) + depthMap.get(headNode.right);
        maxDiameter = Math.max(maxDiameter, vShapedDiameter);
        
        depthMap.put(headNode, 1 + Math.max(depthMap.get(headNode.left), depthMap.get(headNode.right)));
        
      } else { // one or more of child nodes not processed before
        if (!depthMap.containsKey(headNode.right)) {
          stack.offerFirst(headNode.right);
        }
        
        if (!depthMap.containsKey(headNode.left)) {
          stack.offerFirst(headNode.left);
        }
      }
    }

    return maxDiameter;
  }
}
