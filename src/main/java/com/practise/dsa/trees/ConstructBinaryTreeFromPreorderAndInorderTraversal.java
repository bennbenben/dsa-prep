package com.practise.dsa.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  
  int preOrderIdx = 0;
  private Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i=0; i<inorder.length; i++) {
      this.inOrderMap.put(inorder[i], i);
    }
    
    return this.buildTreeHelper(preorder, 0, inorder.length - 1);
  }
  
  private TreeNode buildTreeHelper(int[] preOrder, int inOrderLeft, int inOrderRight) {
    if (inOrderLeft > inOrderRight) {
      return null;
    }
    
    int rootValue = preOrder[this.preOrderIdx]; 
    this.preOrderIdx += 1;
    TreeNode node = new TreeNode(rootValue);
    
    int mid = this.inOrderMap.get(rootValue);
    
    node.left = this.buildTreeHelper(preOrder, inOrderLeft, mid - 1); 
    node.right = this.buildTreeHelper(preOrder, mid + 1, inOrderRight); 
    
    return node;
  }
}
