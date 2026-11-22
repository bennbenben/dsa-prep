package com.practise.dsa.backtracking;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombinationSumTest {

  private final CombinationSum combinationSum = new CombinationSum();
  
  @Test
  void testCombinationSum1() {
    int[] nums = new int[] {2, 5, 6, 9};
    int target = 9;
    List<List<Integer>> expected = List.of(
        List.of(2,2,5),
        List.of(9)
        );
    List<List<Integer>> combinationSumResultDfsRecursive = this.combinationSum.combinationSumDfsRecursive(nums, target);
    List<List<Integer>> combinationSumDfsForLoop = this.combinationSum.combinationSumDfsForLoop(nums, target);
    
    Assertions.assertEquals(expected, combinationSumResultDfsRecursive, "Error in testCombinationSum1.combinationSumDfsRecursive");
    Assertions.assertEquals(expected, combinationSumDfsForLoop, "Error in testCombinationSum1.combinationSumDfsForLoop");
  }
  
  @Test
  void testCombinationSum2() {
    int[] nums = new int[] {3,4,5};
    int target = 16;
    
    List<List<Integer>> expected = List.of(
        List.of(3,3,3,3,4),
        List.of(3,3,5,5),
        List.of(3,4,4,5),
        List.of(4,4,4,4)
        );
    List<List<Integer>> combinationSumResultDfsRecursive = this.combinationSum.combinationSumDfsRecursive(nums, target);
    List<List<Integer>> combinationSumDfsForLoop = this.combinationSum.combinationSumDfsForLoop(nums, target);
    
    Assertions.assertEquals(expected, combinationSumResultDfsRecursive, "Error in testCombinationSum2.combinationSumResultDfsRecursive");
    Assertions.assertEquals(expected, combinationSumDfsForLoop, "Error in testCombinationSum2.combinationSumDfsForLoop");
  }
  
  @Test
  void testCombinationSum3() {
    int[] nums = new int[] {3};
    int target = 5;
    
    List<List<Integer>> expected = List.of(
        );
    List<List<Integer>> combinationSumResultDfsRecursive = this.combinationSum.combinationSumDfsRecursive(nums, target);
    List<List<Integer>> combinationSumDfsForLoop = this.combinationSum.combinationSumDfsForLoop(nums, target);
    
    Assertions.assertEquals(expected, combinationSumResultDfsRecursive, "Error in testCombinationSum2.combinationSumResultDfsRecursive");
    Assertions.assertEquals(expected, combinationSumDfsForLoop, "Error in testCombinationSum2.combinationSumDfsForLoop");
  }
}
