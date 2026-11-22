package com.practise.dsa.backtracking;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombinationSum2Test {
  private final CombinationSum2 combinationSum2 = new CombinationSum2();
  
  @Test
  void testCombinationSum1() {
    int[] nums = new int[] {9,2,2,4,6,1,5};
    int target = 8;
    List<List<Integer>> expected = List.of(
        List.of(1,2,5),
        List.of(2,2,4),
        List.of(2,6)
        );
    List<List<Integer>> combinationSum2DfsForLoop = this.combinationSum2.combinationSum2DfsForLoop(nums, target);
    List<List<Integer>> combinationSum2DfsHashMap = this.combinationSum2.combinationSum2DfsHashMap(nums, target);
    
    Assertions.assertEquals(expected, combinationSum2DfsForLoop, "Error in testCombinationSum1.combinationSumDfsRecursive");
    Assertions.assertEquals(expected, combinationSum2DfsHashMap, "Error in testCombinationSum1.combinationSum2DfsHashMap");
  }
  
  @Test
  void testCombinationSum2() {
    int[] nums = new int[] {1,2,3,4,5};
    int target = 7;
    
    List<List<Integer>> expected = List.of(
        List.of(1,2,4),
        List.of(2,5),
        List.of(3,4)
        );
    List<List<Integer>> combinationSum2DfsForLoop = this.combinationSum2.combinationSum2DfsForLoop(nums, target);
    List<List<Integer>> combinationSum2DfsHashMap = this.combinationSum2.combinationSum2DfsHashMap(nums, target);
    
    Assertions.assertEquals(expected, combinationSum2DfsForLoop, "Error in testCombinationSum2.combinationSumResultDfsRecursive");
    Assertions.assertEquals(expected, combinationSum2DfsHashMap, "Error in testCombinationSum1.combinationSum2DfsHashMap");
  }
  
}
