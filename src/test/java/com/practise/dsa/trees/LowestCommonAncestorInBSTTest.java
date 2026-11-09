package com.practise.dsa.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LowestCommonAncestorInBSTTest {

  private final LowestCommonAncestorInBST lowestCommonAncestorInBST = new LowestCommonAncestorInBST();
  
  @Test
  void testLowestCommonAncestorInBST1() {
    TreeNode root = TreeTestUtils.buildTree(new Integer[] {5,3,8,1,4,7,9,null,2});
    TreeNode p = new TreeNode(3); TreeNode q = new TreeNode(8);
    TreeNode expectedNode = new TreeNode(5);
    TreeNode outputNode1 = this.lowestCommonAncestorInBST.lowestCommonAncestor1(root, p, q);
    TreeNode outputNode2 = this.lowestCommonAncestorInBST.lowestCommonAncestor2(root, p, q);

    Assertions.assertEquals(expectedNode.val, outputNode1.val, "Error in outputNode1");
    Assertions.assertEquals(expectedNode.val, outputNode2.val, "Error in outputNode2");
  }
  
  @Test
  void testLowestCommonAncestorInBST2() {
    TreeNode root = TreeTestUtils.buildTree(new Integer[] {5,3,8,1,4,7,9,null,2});
    TreeNode p = new TreeNode(3); TreeNode q = new TreeNode(4);
    TreeNode expectedNode = new TreeNode(3);
    TreeNode outputNode1 = this.lowestCommonAncestorInBST.lowestCommonAncestor1(root, p, q);
    TreeNode outputNode2 = this.lowestCommonAncestorInBST.lowestCommonAncestor2(root, p, q);

    Assertions.assertEquals(expectedNode.val, outputNode1.val);
    Assertions.assertEquals(expectedNode.val, outputNode2.val);
  }
}
