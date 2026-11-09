package com.practise.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTestUtils {
  // builds a tree BFS style using Queue
  public static TreeNode buildTree(Integer[] vals) {
    if (vals.length == 0) return null;
    
    TreeNode root = new TreeNode(vals[0]);
    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root); int i=1;
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      
      if (i < vals.length && vals[i] != null) {
        node.left = new TreeNode(vals[i]);
        nodeQueue.offer(node.left);
      } 
      i+=1;
      
      if (i < vals.length && vals[i] != null) {
        node.right = new TreeNode(vals[i]);
        nodeQueue.offer(node.right);
      } 
      i+=1;   
    }
    return root;
  }
  
  public static List<Integer> toLevelOrderList(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    
    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);
    
    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.poll();
      
      if (node == null) {
        result.add(null);
      } else {
        result.add(node.val);
        nodeQueue.offer(node.left);
        nodeQueue.offer(node.right);
      }
    }
    
    // trim trailing nulls
    while (!result.isEmpty() && result.get(result.size() - 1) == null) {
        result.remove(result.size() - 1);
    }
    
    return result;
  }

}
