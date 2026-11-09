package com.practise.dsa.trees;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

  private final ConstructBinaryTreeFromPreorderAndInorderTraversal treeBuilder = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
  
  @Test
  void testConstructBinaryTreeFromPreorderAndInorderTraversal1() {
    int[] preorder = {1,2,3,4};
    int[] inorder = {2,1,3,4};
    TreeNode actualRoot = this.treeBuilder.buildTree(preorder, inorder);
    
    List<Integer> actualLevelOrder = TreeTestUtils.toLevelOrderList(actualRoot);
    List<Integer> expectedLevelOrder = Arrays.asList(1,2,3,null,null,null,4);
    
    Assertions.assertEquals(expectedLevelOrder, actualLevelOrder);
  }
  
  @Test
  void testConstructBinaryTreeFromPreorderAndInorderTraversal2() {
    int[] preorder = {1};
    int[] inorder = {1};
    TreeNode actualRoot = this.treeBuilder.buildTree(preorder, inorder);
    
    List<Integer> actualLevelOrder = TreeTestUtils.toLevelOrderList(actualRoot);
    List<Integer> expectedLevelOrder = Arrays.asList(1);
    
    Assertions.assertEquals(expectedLevelOrder, actualLevelOrder);
  }
}
