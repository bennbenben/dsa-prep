package com.practise.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<List<Integer>>();
    }
    
    List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
    
    TreeNode node = root;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(node);
    
    int numInLevel = 0;
    
    while (!queue.isEmpty()) {
      numInLevel = queue.size();
      List<Integer> levelList = new ArrayList<Integer>();
      for (int i=0; i<numInLevel; i++) {
        node = queue.poll();
        levelList.add(node.val);
        
        if (node.left != null) {
          queue.offer(node.left);
        }
        
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      
      levelOrderList.add(levelList);
    }
    return levelOrderList;
  }
}
