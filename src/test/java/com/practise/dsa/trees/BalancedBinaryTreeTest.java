package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalancedBinaryTreeTest {

  private final BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
  
  @Test
  void testBalancedBinaryTree1() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,null,4});
    Assertions.assertEquals(true, this.balancedBinaryTree.isBalancedDfsRecursive(treeNode));
    Assertions.assertEquals(true, this.balancedBinaryTree.isBalancedDfsRecursiveOptimized(treeNode));
    Assertions.assertEquals(true, this.balancedBinaryTree.isBalancedDfsIterative(treeNode));
  }
  
  @Test
  void testBalancedBinaryTree2() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,null,4,null,5});
    Assertions.assertEquals(false, this.balancedBinaryTree.isBalancedDfsRecursive(treeNode));
    Assertions.assertEquals(false, this.balancedBinaryTree.isBalancedDfsRecursiveOptimized(treeNode));
    Assertions.assertEquals(false, this.balancedBinaryTree.isBalancedDfsIterative(treeNode));
  }
  
  @Test
  void testBalancedBinaryTree3() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {});
    Assertions.assertEquals(true, this.balancedBinaryTree.isBalancedDfsRecursive(treeNode));
    Assertions.assertEquals(true, this.balancedBinaryTree.isBalancedDfsRecursiveOptimized(treeNode));
    Assertions.assertEquals(true, this.balancedBinaryTree.isBalancedDfsIterative(treeNode));
  }
}
