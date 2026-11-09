package com.practise.dsa.trees;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeLevelOrderTraversalTest {

  private final BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();

  @Test
  void testBinaryTreeLevelOrderTraversal1() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
    List<List<Integer>> outputList = this.binaryTreeLevelOrderTraversal.levelOrder(node);
    List<List<Integer>> expectedList = List.of(
        List.of(1), 
        List.of(2, 3), 
        List.of(4, 5, 6, 7)
      );
    Assertions.assertEquals(expectedList, outputList);
  }

  @Test
  void testBinaryTreeLevelOrderTraversal2() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {1});
    List<List<Integer>> outputList = this.binaryTreeLevelOrderTraversal.levelOrder(node);
    List<List<Integer>> expectedList = List.of(List.of(1));
    Assertions.assertEquals(expectedList, outputList);
  }

  @Test
  void testBinaryTreeLevelOrderTraversal3() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {});
    List<List<Integer>> outputList = this.binaryTreeLevelOrderTraversal.levelOrder(node);
    List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
    Assertions.assertEquals(expectedList, outputList);
  }
}
