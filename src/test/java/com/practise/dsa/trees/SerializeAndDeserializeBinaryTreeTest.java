package com.practise.dsa.trees;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerializeAndDeserializeBinaryTreeTest {

  private final SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();

  @Test
  void testSerializeAndDeserializeBinaryTree1() {
    Integer[] inputArr = { 1, 2, 3, null, null, 4, 5 };
    TreeNode originalTree = TreeTestUtils.buildTree(inputArr);

    String serializedStr = this.serializeAndDeserializeBinaryTree.serialize(originalTree);
    TreeNode deserializedTree = this.serializeAndDeserializeBinaryTree.deserialize(serializedStr);

    List<Integer> actualOutput = TreeTestUtils.toLevelOrderList(deserializedTree);
    List<Integer> expectedOutput = Arrays.asList(1, 2, 3, null, null, 4, 5);

    Assertions.assertEquals(expectedOutput, actualOutput);
  }

  @Test
  void testSerializeAndDeserializeBinaryTree2() {
    Integer[] inputArr = {};
    TreeNode originalTree = TreeTestUtils.buildTree(inputArr);

    String serializedStr = this.serializeAndDeserializeBinaryTree.serialize(originalTree);
    TreeNode deserializedTree = this.serializeAndDeserializeBinaryTree.deserialize(serializedStr);

    List<Integer> actualOutput = TreeTestUtils.toLevelOrderList(deserializedTree);
    List<Integer> expectedOutput = Arrays.asList();

    Assertions.assertEquals(expectedOutput, actualOutput);
  }

}
