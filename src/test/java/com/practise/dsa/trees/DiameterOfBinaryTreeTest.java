package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiameterOfBinaryTreeTest {

  private final DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
  
  @Test
  void testDiameterOfBinaryTree1() {
    TreeNode tree = TreeTestUtils.buildTree(new Integer[] {1,null,2,3,4,5});
    int diameter = this.diameterOfBinaryTree.diameterOfBinaryTreeDfsRecursive(tree);
    Assertions.assertEquals(3, diameter);
  }
  
  @Test
  void testDiameterOfBinaryTree2() {
    TreeNode tree = TreeTestUtils.buildTree(new Integer[] {1,2,3});
    int diameter = this.diameterOfBinaryTree.diameterOfBinaryTreeDfsRecursive(tree);
    Assertions.assertEquals(2, diameter);
  }
}
