package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubtreeOfAnotherTreeTest {
  private final SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();

  @Test
  void testIsSubTree1() {
    TreeNode root = TreeTestUtils.buildTree(new Integer[]{1, 2, 3, 4, 5});
    TreeNode subRoot = TreeTestUtils.buildTree(new Integer[]{2, 4, 5});
    
    boolean resultDfsRecursive = this.subtreeOfAnotherTree.isSubtreeDfsRecursive(root, subRoot);
    boolean resultSerializationStringConcatenation = this.subtreeOfAnotherTree.isSubTreeDfsSerializationStringConcatenation(root, subRoot);
    boolean resultDfsStringBuilder= this.subtreeOfAnotherTree.isSubTreeDfsStringBuilder(root, subRoot);
    
    Assertions.assertTrue(resultDfsRecursive, "Error in resultDfsRecursive: subRoot [2,4,5] should be a valid subtree of root [1,2,3,4,5]");
    Assertions.assertTrue(resultSerializationStringConcatenation, "Error in resultSerializationStringConcatenation: subRoot [2,4,5] should be a valid subtree of root [1,2,3,4,5]");
    Assertions.assertTrue(resultDfsStringBuilder, "Error in resultDfsStringBuilder: subRoot [2,4,5] should be a valid subtree of root [1,2,3,4,5]");
  }
  
  @Test
  void testIsSubTree2() {
    TreeNode root = TreeTestUtils.buildTree(new Integer[]{1,2,3,4,5,null,null,6});
    TreeNode subRoot = TreeTestUtils.buildTree(new Integer[]{2, 4, 5});
    
    boolean resultDfsRecursive = this.subtreeOfAnotherTree.isSubtreeDfsRecursive(root, subRoot);
    boolean resultSerializationStringConcatenation = this.subtreeOfAnotherTree.isSubTreeDfsSerializationStringConcatenation(root, subRoot);
    boolean resultDfsStringBuilder= this.subtreeOfAnotherTree.isSubTreeDfsStringBuilder(root, subRoot);
    
    Assertions.assertFalse(resultDfsRecursive, "Error in resultDfsRecursive: subRoot [2,4,5] should be a valid subtree of root [1,2,3,4,5]");
    Assertions.assertFalse(resultSerializationStringConcatenation, "Error in resultSerializationStringConcatenation: subRoot [2,4,5] should be a valid subtree of root [1,2,3,4,5]");
    Assertions.assertFalse(resultDfsStringBuilder, "Error in resultDfsStringBuilder: subRoot [2,4,5] should be a valid subtree of root [1,2,3,4,5]");
  }
}
