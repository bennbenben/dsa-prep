package com.practise.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  
  List<List<Integer>> subsets = new ArrayList<List<Integer>>();
  
  // DFS - Recursive 
  public List<List<Integer>> subsetsDfsRecursive(int[] nums) {
    this.subsets.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    this.dfsRecursive(0, nums, currentSubset);
    return this.subsets;
  }
  
  private void dfsRecursive(int index, int[] nums, List<Integer> subset) {
    if (index == nums.length) {
      this.subsets.add(new ArrayList<Integer>(subset));
      return;
    } 
    
    // branch left: save current number
    int num = nums[index];
    subset.add(num);
    this.dfsRecursive(index+1, nums, subset);
    
    // branch right: skip current number
    subset.remove(subset.size()-1);
    this.dfsRecursive(index+1, nums, subset);
  }
  
  // DFS - Recursive using For-loop
  public List<List<Integer>> subsetsDfsRecursiveForLoop(int[] nums) {
    this.subsets.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    this.dfsRecursiveForLoop(0, nums, currentSubset);
    return this.subsets;
  }
  
  private void dfsRecursiveForLoop(int index, int[] nums, List<Integer> subset) {
    this.subsets.add(new ArrayList<Integer>(subset));
    
    for (int i=index; i<nums.length; i++) {
      subset.add(nums[i]);
      this.dfsRecursiveForLoop(i+1, nums, subset);
    }
  }
  
  // Iterative subsets method
  public List<List<Integer>> subsetsIterativeCascading(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<Integer>());
    
    for (int num : nums) {
      int currentSize = result.size();
      
      for (int i=0; i<currentSize; i++) {
        List<Integer> newResultFrame = new ArrayList<Integer>(result.get(i));
        newResultFrame.add(num);
        result.add(newResultFrame);
      }
    }
    
    return result;
  }
}
