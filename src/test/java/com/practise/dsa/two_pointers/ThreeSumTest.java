package com.practise.dsa.two_pointers;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {
  
  private final ThreeSum threeSum = new ThreeSum();

  @Test
  void testThreeSum1() {
    int[] numbers = new int[] {-1,0,1,2,-1,-4};
    List<List<Integer>> output = Arrays.asList(
        Arrays.asList(-1,-1,2),
        Arrays.asList(-1,0,1)
    );
    Assertions.assertEquals(output, threeSum.threeSum(numbers));
  }
  
  @Test
  void testThreeSum2() {
    int[] numbers = new int[] {0,1,1};
    List<List<Integer>> output = Arrays.asList();
    Assertions.assertEquals(output, threeSum.threeSum(numbers));
  }
  
  @Test
  void testThreeSum3() {
    int[] numbers = new int[] {0,0,0};
    List<List<Integer>> output = Arrays.asList(
        Arrays.asList(0,0,0)
    );
    Assertions.assertEquals(output, threeSum.threeSum(numbers));
  }
  
}
