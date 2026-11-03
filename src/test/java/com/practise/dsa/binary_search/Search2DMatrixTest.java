package com.practise.dsa.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Search2DMatrixTest {

  private final Search2DMatrix search2dMatrix = new Search2DMatrix();
  
  @Test
  void testSearch2DMatrix1() {
    int[][] inputMatrix = new int[][] {
        new int[] {1,2,4,8},
        new int[] {10,11,12,13},
        new int[] {14,20,30,40}
    };
    Assertions.assertTrue(this.search2dMatrix.searchMatrix(inputMatrix, 10));
  }
  
  @Test
  void testSearch2DMatrix2() {
    int[][] inputMatrix = new int[][] {
        new int[] {1,2,4,8},
        new int[] {10,11,12,13},
        new int[] {14,20,30,40}
    };
    Assertions.assertFalse(this.search2dMatrix.searchMatrix(inputMatrix, 15));
  }

}
