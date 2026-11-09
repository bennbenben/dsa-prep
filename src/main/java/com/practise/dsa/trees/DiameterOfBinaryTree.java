package com.practise.dsa.trees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DiameterOfBinaryTree {
  private int maxDiameter = 0;
  
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
  
  public int diameterOfBinaryTreeDfsIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    Map<TreeNode, Integer> nodeMap = new HashMap<TreeNode, Integer>();
    
    while (!stack.isEmpty()) {
      TreeNode node = stack.peek();
      TreeNode childNodeLeft = node.left;
      TreeNode childNodeRight = node.right;
      
      if (nodeMap.containsKey(childNodeLeft) && nodeMap.containsKey(childNodeRight)) {
        node = stack.pollFirst();
        int nodeDiameter = 1 + nodeMap.get(childNodeLeft) + nodeMap.get(childNodeRight);
        nodeMap.put(node, nodeDiameter);
        this.maxDiameter = Math.max(this.maxDiameter, nodeMap.get(childNodeLeft) + nodeMap.get(childNodeRight));
      
      } else {
        if (!nodeMap.containsKey(childNodeRight)) {
          stack.offerFirst(childNodeRight);
        }
        if (!nodeMap.containsKey(childNodeLeft)) {
          stack.offerFirst(childNodeLeft);
        }
      }
    }
    
    return this.maxDiameter;
  }
}
