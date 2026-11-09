package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidBinarySearchTreeTest {

  private final ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
  
  @Test
  void testValidBinarySearchTree1() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {2,1,3});
    boolean isValidBSTDfsRecursive = this.validBinarySearchTree.isValidBSTDfsRecursive(treeNode);
    boolean isValidBSTDfsIterative = this.validBinarySearchTree.isValidBSTDfsIterative(treeNode);
    boolean isValidBSTBfsIterative = this.validBinarySearchTree.isValidBSTBfsIterative(treeNode);
    
    Assertions.assertTrue(isValidBSTDfsRecursive, "Error in isValidBSTDfsRecursive");
    Assertions.assertTrue(isValidBSTDfsIterative, "Error in isValidBSTDfsIterative");
    Assertions.assertTrue(isValidBSTBfsIterative, "Error in isValidBSTBfsIterative");
  }
  
  @Test
  void testValidBinarySearchTree2() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {1,2,3});
    boolean isValidBSTDfsRecursive = this.validBinarySearchTree.isValidBSTDfsRecursive(treeNode);
    boolean isValidBSTDfsIterative = this.validBinarySearchTree.isValidBSTDfsIterative(treeNode);
    boolean isValidBSTBfsIterative = this.validBinarySearchTree.isValidBSTBfsIterative(treeNode);
    
    Assertions.assertFalse(isValidBSTDfsRecursive, "Error in isValidBSTDfsRecursive");
    Assertions.assertFalse(isValidBSTDfsIterative, "Error in isValidBSTDfsIterative");
    Assertions.assertFalse(isValidBSTBfsIterative, "Error in isValidBSTBfsIterative");
  }

}
