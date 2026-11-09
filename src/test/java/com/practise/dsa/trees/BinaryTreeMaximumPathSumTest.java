package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeMaximumPathSumTest {

  private final BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
  
  @Test
  void testBinaryTreeMaximumPathSum1() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {1,2,3});
    int maxSum = this.binaryTreeMaximumPathSum.maxPathSum(node);
    Assertions.assertEquals(6, maxSum);
  }
  
  @Test
  void testBinaryTreeMaximumPathSum2() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {-15,10,20,null,null,15,5,-5});
    int maxSum = this.binaryTreeMaximumPathSum.maxPathSum(node);
    Assertions.assertEquals(40, maxSum);
  }
}
