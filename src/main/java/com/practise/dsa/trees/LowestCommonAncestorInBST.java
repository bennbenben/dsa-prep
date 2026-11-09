package com.practise.dsa.trees;

public class LowestCommonAncestorInBST {
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode node = root;
    
    while (node != null) {
      if ((node.val < p.val) && (node.val < q.val)) { // if node is larger than both, go right
        node = node.right;

      } else if ((node.val > q.val) && (node.val > q.val)) { // if node is smaller than both, go left
        node = node.left;
      
      } else { // by elimination - one of it would be split / exact match
        return node;
      }
    }

    return null;
  }

  
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode node = root;
    
    while (node != null) {
      if ((node.val < p.val) && (node.val < q.val)) { // if node is larger than both, go right
        node = node.right;
        continue;
      } 
      
      if ((node.val > q.val) && (node.val > q.val)) { // if node is smaller than both, go left
        node = node.left;
        continue;
      } 
      
      if (node.val >= p.val && node.val <= q.val ||
          node.val >= q.val && node.val <= p.val) { // by elimination - one of it would be split / exact match
        return node;
      }
      
    }
    return null;
  }
}
