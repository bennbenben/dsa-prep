package com.practise.dsa.trees;

public class SubtreeOfAnotherTree {
  private boolean isSameTree(TreeNode p, TreeNode q) { // solution from another question - SameBinaryTree
    if (p == null && q == null) { // end of traversal
      return true;
    }
    
    if (p == null || q == null) { // check for null values. earlier just checked if both are nulls
      return false;
    }
    
    if (p.val != q.val) { // check value
      return false;
    }
    
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
  }
  
  public boolean isSubtreeDfsRecursive(TreeNode root, TreeNode subroot) {
    if (root == null) {
      return false;
    }
    
    if (this.isSameTree(root,subroot)) {
      return true;
    }
    
    return this.isSubtreeDfsRecursive(root.left, subroot) || this.isSubtreeDfsRecursive(root.right, subroot);
  }
  
  public boolean isSubTreeDfsSerializationStringConcatenation(TreeNode root, TreeNode subroot) {
    String mainTree = this.treeSerializationStringConcatenation(root);
    String subTree = this.treeSerializationStringConcatenation(subroot);
    return mainTree.contains(subTree);
  }
  
  public String treeSerializationStringConcatenation(TreeNode root) {
    if (root == null) {
      return "#N";
    }
    return "#" + root.val + treeSerializationStringConcatenation(root.left) + treeSerializationStringConcatenation(root.right);
  }
  
  public boolean isSubTreeDfsStringBuilder(TreeNode root, TreeNode subroot) {
    StringBuilder mainTreeSb = new StringBuilder();
    this.treeSerializationSb(root, mainTreeSb);
    String mainTree = mainTreeSb.toString();
    
    StringBuilder subTreeSb = new StringBuilder();
    this.treeSerializationSb(subroot, subTreeSb);
    String subTree = subTreeSb.toString();
    
    return mainTree.contains(subTree);
  }
  
  public void treeSerializationSb(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#N");
      return;
    }
    
    sb.append("#").append(root.val);
    this.treeSerializationSb(root.left, sb);
    this.treeSerializationSb(root.right, sb);
  }
}
