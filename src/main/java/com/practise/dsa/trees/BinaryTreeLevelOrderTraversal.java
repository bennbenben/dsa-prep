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
    
    TreeNode node = root;
    Queue<TreeNode> treeQueue = new LinkedList<TreeNode>();
    treeQueue.offer(node);
    List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
    
    while (!treeQueue.isEmpty()) {
      List<Integer> levelList = new ArrayList<Integer>();
      int numberOfElements = treeQueue.size();
      for (int i=0; i<numberOfElements; i++) {
        node = treeQueue.poll();
        levelList.add(node.val);
        
        if (node.left != null) {
          treeQueue.offer(node.left);
        }
        
        if (node.right != null) {
          treeQueue.offer(node.right);
        }
        
      }
      
      levelOrderList.add(levelList);
    }
    
    return levelOrderList;
  }
}
