package com.practise.dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum2 {
  
  // DFS - Recursive, for-loop method with sorting
  private List<List<Integer>> combinationSum2Result = new ArrayList<List<Integer>>();
  
  public List<List<Integer>> combinationSum2DfsForLoop(int[] candidates, int target) {
    this.combinationSum2Result.clear();
    List<Integer> currentSubset = new ArrayList<Integer>();
    Arrays.sort(candidates);
    this.dfsRecursiveForLoop(0, candidates, target, currentSubset);
    return this.combinationSum2Result;
  }
  
  private void dfsRecursiveForLoop(int index, int[] candidates, int target, List<Integer> subset) {
    if (target == 0) {
      this.combinationSum2Result.add(new ArrayList<Integer>(subset));
      return;
    }
    
    if (target<0 || index >= candidates.length) {
      return;
    }
    
    for (int i=index; i<candidates.length; i++) {
      if (i>index && candidates[i] == candidates[i-1]) {
        continue;
      }
      
      int candidate = candidates[i];
      subset.add(candidate);
      this.dfsRecursiveForLoop(i+1, candidates, target-candidate, subset); // i+1 because no duplicates
      subset.remove(subset.size()-1);
    }
  }
  
  // DFS - Recursive, for-loop method with hashmap 
  public List<List<Integer>> combinationSum2DfsHashMap(int[] candidates, int target) {
    this.combinationSum2Result.clear();
    Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    for (int candidate : candidates) {
      int candidateFreq = freqMap.getOrDefault(candidate, 0)+1;
      freqMap.put(candidate, candidateFreq);
    }
    List<Integer> currentSubset = new ArrayList<Integer>();
    List<Integer> uniqCandidates = new ArrayList<Integer>(freqMap.keySet());
    this.dfsRecursiveHashMap(0, uniqCandidates, target, currentSubset, freqMap);
    return this.combinationSum2Result;
  }
  
  private void dfsRecursiveHashMap(int index, List<Integer> candidates, int target, List<Integer> subset, Map<Integer, Integer> freqMap) {
    if (target == 0) {
      this.combinationSum2Result.add(new ArrayList<Integer>(subset));
      return;
    }
    
    if (target<0 || index >= candidates.size()) {
      return;
    }
    
    for (int i=index; i<candidates.size(); i++) {
      int candidate = candidates.get(i);
      int candidateCount = freqMap.get(candidate);  
      
      if (candidateCount > 0) {  
        subset.add(candidate);
        candidateCount -= 1;
        freqMap.put(candidate, candidateCount);
        this.dfsRecursiveHashMap(i, candidates, target-candidate, subset, freqMap);
        
        subset.remove(subset.size()-1);
        candidateCount += 1;
        freqMap.put(candidate, candidateCount);
      }
    }
  }
}
