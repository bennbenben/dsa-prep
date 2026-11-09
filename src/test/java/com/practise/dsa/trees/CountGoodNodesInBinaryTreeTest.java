package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountGoodNodesInBinaryTreeTest {

  private final CountGoodNodesInBinaryTree countGoodNodesInBinaryTree = new CountGoodNodesInBinaryTree();;
  
  @Test
  void testCountGoodNodesInBinaryTree1() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {2,1,1,3,null,1,5});
    int goodNodesCountDfsRecursive = this.countGoodNodesInBinaryTree.goodNodesDfsRecursive(node);
    int goodNodesCountBfsIterative = this.countGoodNodesInBinaryTree.goodNodesBfsIterative(node);
    int goodNodesCountDfsIterative = this.countGoodNodesInBinaryTree.goodNodesDfsIterative(node);
    Assertions.assertEquals(3, goodNodesCountDfsRecursive, "Error in goodNodesDfsRecursive");
    Assertions.assertEquals(3, goodNodesCountBfsIterative, "Error in goodNodesBfsIterative");
    Assertions.assertEquals(3, goodNodesCountDfsIterative, "Error in goodNodesDfsIterative");
  }
  
  @Test
  void testCountGoodNodesInBinaryTree2() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {1,2,-1,3,4});
    int goodNodesCountDfsRecursive = this.countGoodNodesInBinaryTree.goodNodesDfsRecursive(node);
    int goodNodesCountBfsIterative = this.countGoodNodesInBinaryTree.goodNodesBfsIterative(node);
    int goodNodesCountDfsIterative = this.countGoodNodesInBinaryTree.goodNodesDfsIterative(node);
    Assertions.assertEquals(4, goodNodesCountDfsRecursive, "Error in goodNodesDfsRecursive");
    Assertions.assertEquals(4, goodNodesCountBfsIterative, "Error in goodNodesBfsIterative");
    Assertions.assertEquals(4, goodNodesCountDfsIterative, "Error in goodNodesDfsIterative");
  }
}
