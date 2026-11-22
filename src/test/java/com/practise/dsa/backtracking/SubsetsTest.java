package com.practise.dsa.backtracking;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubsetsTest {

  private final Subsets subsets = new Subsets();
  
  @Test
  void subsetsDfsRecursiveTest1() {
    int[] nums = {1, 2, 3};
    List<List<Integer>> subsetPermutations = this.subsets.subsetsDfsRecursive(nums);
    
    Assertions.assertEquals(8, subsetPermutations.size(), "There should be exactly 8 subsets for an array of 3 elements.");
    
    Assertions.assertTrue(subsetPermutations.contains(List.of()), "Result should contain the empty subset []");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1)), "Result should contain [1]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(2)), "Result should contain [2]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(3)), "Result should contain [3]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1, 2)), "Result should contain [1, 2]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1, 3)), "Result should contain [1, 3]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(2, 3)), "Result should contain [2, 3]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1, 2, 3)), "Result should contain [1, 2, 3]");
  }
  
  @Test
  void subsetsTestDfsRecursive2() {
    int[] nums = {7};
    List<List<Integer>> subsetPermutations = this.subsets.subsetsDfsRecursive(nums);
    
    Assertions.assertEquals(2, subsetPermutations.size(), "There should be exactly 8 subsets for an array of 3 elements.");
    
    Assertions.assertTrue(subsetPermutations.contains(List.of()), "Result should contain the empty subset []");
    Assertions.assertTrue(subsetPermutations.contains(List.of(7)), "Result should contain [1]");
  }
  
  @Test
  void subsetsIterativeCascadingTest1() {
    int[] nums = {1, 2, 3};
    List<List<Integer>> subsetPermutations = this.subsets.subsetsIterativeCascading(nums);
    
    Assertions.assertEquals(8, subsetPermutations.size(), "There should be exactly 8 subsets for an array of 3 elements.");
    
    Assertions.assertTrue(subsetPermutations.contains(List.of()), "Result should contain the empty subset []");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1)), "Result should contain [1]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(2)), "Result should contain [2]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(3)), "Result should contain [3]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1, 2)), "Result should contain [1, 2]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1, 3)), "Result should contain [1, 3]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(2, 3)), "Result should contain [2, 3]");
    Assertions.assertTrue(subsetPermutations.contains(List.of(1, 2, 3)), "Result should contain [1, 2, 3]");
  }
  
  @Test
  void subsetsTestIterativeCascading2() {
    int[] nums = {7};
    List<List<Integer>> subsetPermutations = this.subsets.subsetsIterativeCascading(nums);
    
    Assertions.assertEquals(2, subsetPermutations.size(), "There should be exactly 8 subsets for an array of 3 elements.");
    
    Assertions.assertTrue(subsetPermutations.contains(List.of()), "Result should contain the empty subset []");
    Assertions.assertTrue(subsetPermutations.contains(List.of(7)), "Result should contain [1]");
  }

}
