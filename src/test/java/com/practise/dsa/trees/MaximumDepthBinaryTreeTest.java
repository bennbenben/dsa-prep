package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumDepthBinaryTreeTest {

  private final MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
  
  @Test
  void testMaximumDepthBinaryTree1() {
    TreeNode root1 = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,null,4});
    TreeNode root2 = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,null,4});
    TreeNode root3 = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,null,4});
    TreeNode root4 = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,null,4});
    
    int expected = 3;

    int maxDepthRecursiveDfs = this.maximumDepthBinaryTree.maxDepthRecursiveDfs(root1);
    int maxDepthIterativeDfs = this.maximumDepthBinaryTree.maxDepthIterativeDfs(root2);
    int maxDepthIterativeBfs = this.maximumDepthBinaryTree.maxDepthIterativeBfs(root3);
    int maxDepthIterativeBfsOptimized = this.maximumDepthBinaryTree.maxDepthIterativeBfsOptimized(root4);
    
    Assertions.assertEquals(expected, maxDepthRecursiveDfs, "Error in maxDepthIterativeBfsOptimized");
    Assertions.assertEquals(expected, maxDepthIterativeDfs, "Error in maxDepthIterativeDfs");
    Assertions.assertEquals(expected, maxDepthIterativeBfs, "Error in maxDepthIterativeBfs");
    Assertions.assertEquals(expected, maxDepthIterativeBfsOptimized, "Error in maxDepthIterativeBfsOptimized");
  }
  
  @Test
  void testMaximumDepthBinaryTree2() {
    TreeNode root1 = TreeTestUtils.buildTree(new Integer[] {});
    TreeNode root2 = TreeTestUtils.buildTree(new Integer[] {});
    TreeNode root3 = TreeTestUtils.buildTree(new Integer[] {});
    TreeNode root4 = TreeTestUtils.buildTree(new Integer[] {});
    
    int expected = 0;

    int maxDepthRecursiveDfs = this.maximumDepthBinaryTree.maxDepthRecursiveDfs(root1);
    int maxDepthIterativeDfs = this.maximumDepthBinaryTree.maxDepthIterativeDfs(root2);
    int maxDepthIterativeBfs = this.maximumDepthBinaryTree.maxDepthIterativeBfs(root3);
    int maxDepthIterativeBfsOptimized = this.maximumDepthBinaryTree.maxDepthIterativeBfsOptimized(root4);
    
    Assertions.assertEquals(expected, maxDepthRecursiveDfs, "Error in maxDepthIterativeBfsOptimized");
    Assertions.assertEquals(expected, maxDepthIterativeDfs, "Error in maxDepthIterativeDfs");
    Assertions.assertEquals(expected, maxDepthIterativeBfs, "Error in maxDepthIterativeBfs");
    Assertions.assertEquals(expected, maxDepthIterativeBfsOptimized, "Error in maxDepthIterativeBfsOptimized");
  }
}
