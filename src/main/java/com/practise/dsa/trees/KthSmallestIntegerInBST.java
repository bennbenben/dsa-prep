package com.practise.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestIntegerInBST {
  
  private List<Integer> bstValuesList = new ArrayList<Integer>();
  
  public int kthSmallestPreOrderDfsRecursive(TreeNode root, int k) {
    this.bstValuesList.clear();
    this.preOrderDfsRecursive(root);
    this.bstValuesList.sort((a,b) -> Integer.compare(a, b));
    return this.bstValuesList.get(k-1);
  }
  
  private void preOrderDfsRecursive(TreeNode root) {
    if (root == null) {
      return;
    }
    
    this.bstValuesList.add(root.val);
    if (root.left != null) {
      this.preOrderDfsRecursive(root.left);
    }
    if (root.right != null) {
      this.preOrderDfsRecursive(root.right);
    }
  }
  
  public int kthSmallestInOrderDfsRecursive(TreeNode root, int k) {
    this.bstValuesList.clear();
    this.inOrderDfsRecursive(root);
    return this.bstValuesList.get(k-1);
  }
  
  private void inOrderDfsRecursive(TreeNode root) {
    if (root == null) {
      return;
    }
    this.inOrderDfsRecursive(root.left);
    this.bstValuesList.add(root.val);
    this.inOrderDfsRecursive(root.right);
  }
  
  private int count;
  private int result;
  public int kthSmallestInOrderDfsRecursiveOptimized(TreeNode root, int k) {
    this.count = 0;
    this.result = -1;
    this.inOrderDfsRecursiveOptimized(root, k);
    return this.result;
  }
  
  private void inOrderDfsRecursiveOptimized(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    this.inOrderDfsRecursiveOptimized(root.left, k);
    
    this.bstValuesList.add(root.val);
    this.count += 1;
    if (this.count == k) {
      this.result = root.val;
      return;
    }
    
    if (this.count < k) {
      this.inOrderDfsRecursiveOptimized(root.right, k);
    }
  }

}
