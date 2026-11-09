package com.practise.dsa.trees;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvertBinaryTreeTest {

  private final InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

  @Test
  void testInvertBinaryTree1() {
    TreeNode root1 = TreeTestUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
    TreeNode root2 = TreeTestUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
    TreeNode root3 = TreeTestUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
    
    TreeNode invertedRecursiveDfs = this.invertBinaryTree.invertTreeRecursiveDfs(root1);
    TreeNode invertedIterativeDfs = this.invertBinaryTree.invertTreeIterativeDfs(root2);
    TreeNode invertedIterativeBfs = this.invertBinaryTree.invertTreeIterativeBfs(root3);
    
    List<Integer> expected = Arrays.asList(1,3,2,7,6,5,4);
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedRecursiveDfs), "Error in invertedRecursiveDfs");
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedIterativeDfs), "Error in invertedIterativeDfs");
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedIterativeBfs), "Error in invertedIterativeBfs");
  }
  
  @Test
  void testInvertBinaryTree2() {
    TreeNode root1 = TreeTestUtils.buildTree(new Integer[] { 3,2,1 });
    TreeNode root2 = TreeTestUtils.buildTree(new Integer[] { 3,2,1 });
    TreeNode root3 = TreeTestUtils.buildTree(new Integer[] { 3,2,1 });
    
    TreeNode invertedRecursiveDfs = this.invertBinaryTree.invertTreeRecursiveDfs(root1);
    TreeNode invertedIterativeDfs = this.invertBinaryTree.invertTreeIterativeDfs(root2);
    TreeNode invertedIterativeBfs = this.invertBinaryTree.invertTreeIterativeBfs(root3);
    
    List<Integer> expected = Arrays.asList(3,1,2);
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedRecursiveDfs), "Error in invertedRecursiveDfs");
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedIterativeDfs), "Error in invertedIterativeDfs");
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedIterativeBfs), "Error in invertedIterativeBfs");
  }
  
  @Test
  void testInvertBinaryTree3() {
    TreeNode root1 = TreeTestUtils.buildTree(new Integer[] {});
    TreeNode root2 = TreeTestUtils.buildTree(new Integer[] {});
    TreeNode root3 = TreeTestUtils.buildTree(new Integer[] {});
    
    TreeNode invertedRecursiveDfs = this.invertBinaryTree.invertTreeRecursiveDfs(root1);
    TreeNode invertedIterativeDfs = this.invertBinaryTree.invertTreeIterativeDfs(root2);
    TreeNode invertedIterativeBfs = this.invertBinaryTree.invertTreeIterativeBfs(root3);
    
    List<Integer> expected = Arrays.asList();
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedRecursiveDfs), "Error in invertedRecursiveDfs");
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedIterativeDfs), "Error in invertedIterativeDfs");
    Assertions.assertEquals(expected, TreeTestUtils.toLevelOrderList(invertedIterativeBfs), "Error in invertedIterativeBfs");
  }
}
