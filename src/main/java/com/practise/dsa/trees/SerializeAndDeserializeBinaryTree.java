package com.practise.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
  
  // DFS - Recursive, encodes tree to a single string  
  public String serializeDfsRecursive(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    this.serializeDfsRecursiveMethod(root, sb);
    return sb.toString();
  }
  
  private void serializeDfsRecursiveMethod(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("null");
      sb.append(",");
      return;
    }
    
    sb.append(root.val).append(",");
    this.serializeDfsRecursiveMethod(root.left, sb);
    this.serializeDfsRecursiveMethod(root.right, sb);
  }
  
  // DFS - Recursive, decode string to Tree  
  private int deserializeDfsRecursiveIndex = 0;
  
  public TreeNode deserializeDfsRecursive(String data) {
    if (data.equals("null") || data.isEmpty()) {
      return null;
    }
    this.deserializeDfsRecursiveIndex = 0;
    String[] deserializeString = data.split(",");
    TreeNode node = this.deserializeDfsRecursiveMethod(deserializeString);
    return node;
  }
  
  private TreeNode deserializeDfsRecursiveMethod(String[] data) {
    String currentValue = data[deserializeDfsRecursiveIndex]; 
    this.deserializeDfsRecursiveIndex += 1;
    
    if (!currentValue.equals("null")) {
      TreeNode node = new TreeNode(Integer.valueOf(currentValue)); 
      node.left = this.deserializeDfsRecursiveMethod(data);
      node.right = this.deserializeDfsRecursiveMethod(data);
      return node;  
    
    } else {
      return null;
    }
  }

  // BFS - Recursive, encodes tree to a single string
  public String serialize(TreeNode root) {
    Queue<TreeNode> serializeQueue = new LinkedList<TreeNode>();
    serializeQueue.offer(root);
    StringBuilder sbTree = new StringBuilder();
    
    while (!serializeQueue.isEmpty()) {
      TreeNode node = serializeQueue.poll();
      
      if (node != null) {
        sbTree.append(node.val).append(",");
        serializeQueue.offer(node.left); 
        serializeQueue.offer(node.right);
      } else {
        sbTree.append("null").append(",");
      }
    }
    
    return sbTree.toString();
  }

  // BFS - Iterative, decodes your data to tree
  public TreeNode deserialize(String data) {
    if (data.equals("null,") || data.isEmpty()) {
      return null;
    }
    
    String[] dataValues = data.split(",");
    
    Queue<TreeNode> deserializeQueue = new LinkedList<TreeNode>();
    TreeNode rootNode = new TreeNode(Integer.valueOf(dataValues[0]));
    deserializeQueue.offer(rootNode);
    int i=1;
    
    while (!deserializeQueue.isEmpty()) {
      TreeNode node = deserializeQueue.poll();
      
      if (dataValues[i].equals("null")) {
        i += 1;
      } else {
        TreeNode leftChildNode = new TreeNode(Integer.valueOf(dataValues[i]));
        node.left = leftChildNode;
        deserializeQueue.offer(leftChildNode);
        i += 1;
      }
      
      if (dataValues[i].equals("null")) {
        i += 1;
      } else {
        TreeNode rightChildNode = new TreeNode(Integer.valueOf(dataValues[i]));
        node.right = rightChildNode;
        deserializeQueue.offer(rightChildNode);
        i += 1;
      }
      
      
    }
    
    return rootNode;
  }
}
