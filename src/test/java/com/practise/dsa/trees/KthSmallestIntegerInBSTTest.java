package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthSmallestIntegerInBSTTest {

  private final KthSmallestIntegerInBST kthSmallestIntegerInBST = new KthSmallestIntegerInBST();
  
  @Test
  void testKthSmallestIntegerInBST1() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {2,1,3});
    int outputKthSmallestPreOrderDfsRecursive = this.kthSmallestIntegerInBST.kthSmallestPreOrderDfsRecursive(treeNode, 1);
    int outputKthSmallestInOrderDfsRecursive = this.kthSmallestIntegerInBST.kthSmallestInOrderDfsRecursive(treeNode, 1);
    int outputKthSmallestInOrderDfsRecursiveOptimized = this.kthSmallestIntegerInBST.kthSmallestInOrderDfsRecursiveOptimized(treeNode, 1);
    
    Assertions.assertEquals(outputKthSmallestPreOrderDfsRecursive, 1);
    Assertions.assertEquals(outputKthSmallestInOrderDfsRecursive, 1);
    Assertions.assertEquals(outputKthSmallestInOrderDfsRecursiveOptimized, 1);
  }
  
  @Test
  void testKthSmallestIntegerInBST2() {
    TreeNode treeNode = TreeTestUtils.buildTree(new Integer[] {4,3,5,2,null});
    int outputKthSmallestPreOrderDfsRecursive = this.kthSmallestIntegerInBST.kthSmallestPreOrderDfsRecursive(treeNode, 4);
    int outputKthSmallestInOrderDfsRecursive = this.kthSmallestIntegerInBST.kthSmallestInOrderDfsRecursive(treeNode, 4);
    int outputKthSmallestInOrderDfsRecursiveOptimized = this.kthSmallestIntegerInBST.kthSmallestInOrderDfsRecursiveOptimized(treeNode, 4);
    
    Assertions.assertEquals(outputKthSmallestPreOrderDfsRecursive, 5);
    Assertions.assertEquals(outputKthSmallestInOrderDfsRecursive, 5);
    Assertions.assertEquals(outputKthSmallestInOrderDfsRecursiveOptimized, 5);
  }
}
