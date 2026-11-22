package com.practise.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  
  // DFS - Recursive with for-loop
  List<List<Integer>> combinations = new ArrayList<List<Integer>>();
  
  public List<List<Integer>> combinationSumDfsForLoop(int[] nums, int target) {
    this.combinations.clear();
    List<Integer> currentCombination = new ArrayList<Integer>();
    this.dfsForLoop(0, nums, target, currentCombination);
    return this.combinations;
  }
  
  private void dfsForLoop(int index, int[] nums, int target, List<Integer> combination) {
    if (target == 0) { // found the answer
      this.combinations.add(new ArrayList<Integer>(combination));
      return;
    }
    
    if (target < 0) { // exceeded the limit of target - cancel it now
      return;
    }
    
    for (int i=index; i<nums.length; i++) {
      combination.add(nums[i]); // choose the given num
      this.dfsForLoop(i, nums, target-nums[i], combination);
      combination.remove(combination.size()-1); // the backtrack
    }
  }
  
  // DFS - Recursive
  public List<List<Integer>> combinationSumDfsRecursive(int[] nums, int target) {
    this.combinations.clear();
    List<Integer> currentCombination = new ArrayList<Integer>();
    this.dfsRecursive(0, nums, target, currentCombination);
    return this.combinations;
  }
  
  private void dfsRecursive(int index, int[] nums, int target, List<Integer> combination) {
    // accumulate if success
    if (target == 0) {
      this.combinations.add(new ArrayList<Integer>(combination));
      return;
    }
    
    // if target reached negative, or end of the index traversing
    if (index >= nums.length || target < 0) {
      return;
    }
    
    // choose the current index
    combination.add(nums[index]);
    this.dfsRecursive(index, nums, target-nums[index], combination); // choose the current one x number of times
    // skip current index
    combination.remove(combination.size()-1);
    this.dfsRecursive(index+1, nums, target, combination); 
  }
}
