package com.practise.dsa.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SameBinaryTree {
  public boolean isSameTreeDfsRecursive(TreeNode p, TreeNode q) {
    if (p == null && q == null) { // end of traversal
      return true;
    }
    
    if (p == null || q == null) { // just now checked if both are null. if any true here means false
      return false;
    }
    
    if (p.val != q.val) { // check values
      return false;
    }
    
    return isSameTreeDfsRecursive(p.left, q.left) && isSameTreeDfsRecursive(p.right, q.right);
  }
  
  public boolean isSameTreeDfsIterative(TreeNode p, TreeNode q) {
    Deque<TreeNode[]> treeStack = new LinkedList<TreeNode[]>();
    treeStack.offerFirst(new TreeNode[] {p,q});
    
    while (!treeStack.isEmpty()) {
      TreeNode[] nodesArray = treeStack.pollFirst();
      TreeNode nodeP = nodesArray[0]; TreeNode nodeQ = nodesArray[1];
      
      if (nodeP == null && nodeQ == null) { // end of traversal
        continue;
      }
      
      if (nodeP == null || nodeQ == null) { // earlier checked both are not null, if any true here means false
        return false;
      }
      
      if (nodeP.val != nodeQ.val) { // check values
        return false;
      }
      
      TreeNode[] childRightNodesArray = new TreeNode[] {nodeP.right, nodeQ.right};
      treeStack.offerFirst(childRightNodesArray);
      
      TreeNode[] childLeftNodesArray = new TreeNode[] {nodeP.left, nodeQ.left};
      treeStack.offerFirst(childLeftNodesArray);
    }
    
    return true;
  }
  
  public boolean isSameTreeBfsIterative(TreeNode p, TreeNode q) {
    Queue<TreeNode[]> treeStack = new LinkedList<TreeNode[]>();
    treeStack.offer(new TreeNode[] {p,q});
    
    while (!treeStack.isEmpty()) {
      TreeNode[] nodesArray = treeStack.poll();
      TreeNode nodeP = nodesArray[0]; TreeNode nodeQ = nodesArray[1];
      
      if (nodeP == null && nodeQ == null) { // end of traversal
        continue;
      }
      
      if (nodeP == null || nodeQ == null) { // earlier checked both are not null, if any true here means false
        return false;
      }
      
      if (nodeP.val != nodeQ.val) { // check values
        return false;
      }
      
      TreeNode[] childRightNodesArray = new TreeNode[] {nodeP.right, nodeQ.right};
      treeStack.offer(childRightNodesArray);
      
      TreeNode[] childLeftNodesArray = new TreeNode[] {nodeP.left, nodeQ.left};
      treeStack.offer(childLeftNodesArray);
    }
    
    return true;
  }
}
