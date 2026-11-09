package com.practise.dsa.trees;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeRightSideViewTest {

  private final BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
  
  @Test
  void testBinaryTreeRightSideView1() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {1,2,3,null,4,null,5});
    List<Integer> output = this.binaryTreeRightSideView.rightSideView(node);
    List<Integer> expected = List.of(1,3,5);
    Assertions.assertEquals(expected, output);
  }
  
  @Test
  void testBinaryTreeRightSideView2() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {1,2,3,4,null,null,null,5});
    List<Integer> output = this.binaryTreeRightSideView.rightSideView(node);
    List<Integer> expected = List.of(1,3,4,5);
    Assertions.assertEquals(expected, output);
  }
  
  @Test
  void testBinaryTreeRightSideView3() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {1,null,2});
    List<Integer> output = this.binaryTreeRightSideView.rightSideView(node);
    List<Integer> expected = List.of(1,2);
    Assertions.assertEquals(expected, output);
  }
  
  @Test
  void testBinaryTreeRightSideView4() {
    TreeNode node = TreeTestUtils.buildTree(new Integer[] {});
    List<Integer> output = this.binaryTreeRightSideView.rightSideView(node);
    List<Integer> expected = new ArrayList<Integer>();
    Assertions.assertEquals(expected, output);
  }
}
