package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SameBinaryTreeTest {

  private final SameBinaryTree sameBinaryTree = new SameBinaryTree();
  
  @Test
  void testSameBinaryTree1() {
    TreeNode p = TreeTestUtils.buildTree(new Integer[] {1,2,3});
    TreeNode q = TreeTestUtils.buildTree(new Integer[] {1,2,3});
    Assertions.assertEquals(true, this.sameBinaryTree.isSameTreeDfsRecursive(p, q));
    Assertions.assertEquals(true, this.sameBinaryTree.isSameTreeDfsIterative(p, q));
    Assertions.assertEquals(true, this.sameBinaryTree.isSameTreeBfsIterative(p, q));
  }
  
  @Test
  void testSameBinaryTree2() {
    TreeNode p = TreeTestUtils.buildTree(new Integer[] {4,7});
    TreeNode q = TreeTestUtils.buildTree(new Integer[] {4,null,7});
    Assertions.assertEquals(false, this.sameBinaryTree.isSameTreeDfsRecursive(p, q));
    Assertions.assertEquals(false, this.sameBinaryTree.isSameTreeDfsIterative(p, q));
    Assertions.assertEquals(false, this.sameBinaryTree.isSameTreeBfsIterative(p, q));
  }
  
  @Test
  void testSameBinaryTree3() {
    TreeNode p = TreeTestUtils.buildTree(new Integer[] {1,2,3});
    TreeNode q = TreeTestUtils.buildTree(new Integer[] {1,3,2});
    Assertions.assertEquals(false, this.sameBinaryTree.isSameTreeDfsRecursive(p, q));
    Assertions.assertEquals(false, this.sameBinaryTree.isSameTreeDfsIterative(p, q));
    Assertions.assertEquals(false, this.sameBinaryTree.isSameTreeBfsIterative(p, q));
  }
}
