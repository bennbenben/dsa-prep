package com.practise.dsa.trees;

public class BinaryTreeMaximumPathSum {
  
  private int maxSum = 0;
  
  public int maxPathSum(TreeNode root) {
    this.maxSum = Integer.MIN_VALUE; // handling for negative numbers
    this.dfsRecursive(root);
    return this.maxSum;
  }
  
  private int dfsRecursive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftSum = Math.max(0, this.dfsRecursive(root.left)); // if a branch is negative, ignore it
    int rightSum = Math.max(0, this.dfsRecursive(root.right));
    
    int Vmax = root.val + leftSum + rightSum;
    this.maxSum = Math.max(this.maxSum, Vmax);
    
    return Math.max(root.val + leftSum, root.val + rightSum);
  }
}
