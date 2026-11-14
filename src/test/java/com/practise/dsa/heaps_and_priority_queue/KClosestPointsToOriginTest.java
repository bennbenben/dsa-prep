package com.practise.dsa.heaps_and_priority_queue;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KClosestPointsToOriginTest {

  private final KClosestPointsToOrigin kClosestPoints = new KClosestPointsToOrigin();
  
  @Test
  void testKClosestPointsToOriginMaxHeap1() {
    int[][] points = new int[][] { {0, 2}, {2, 2} };
    int[][] expected = new int[][] { {0, 2} };
    
    int[][] actual = this.kClosestPoints.kClosestMaxHeap(points, 1);
    
    Assertions.assertTrue(Arrays.deepEquals(expected, actual), "Failed in testKClosestPointsToOriginMaxHeap1");
  }
  
  @Test
  void testKClosestPointsToOriginMaxHeap2() {
    int[][] points = new int[][] { {0, 2}, {2, 0}, {2, 2} };
    int[][] expected = new int[][] { {0, 2}, {2, 0} };
    
    int[][] actual = this.kClosestPoints.kClosestMaxHeap(points, 2);
    
    Arrays.sort(expected, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(actual, (a, b) -> Integer.compare(a[0], b[0]));
    
    Assertions.assertTrue(Arrays.deepEquals(expected, actual), "Failed in testKClosestPointsToOriginMaxHeap2");
  }
  
  @Test
  void testKClosestPointsToOriginQuickSelect1() {
    int[][] points = new int[][] { {0, 2}, {2, 2} };
    int[][] expected = new int[][] { {0, 2} };
    
    int[][] actual = this.kClosestPoints.kClosestQuickSelect(points, 1);
    
    Assertions.assertTrue(Arrays.deepEquals(expected, actual), "Failed in testKClosestPointsToOriginQuickSelect1");
  }
  
  @Test
  void testKClosestPointsToOriginQuickSelect2() {
    int[][] points = new int[][] { {0, 2}, {2, 0}, {2, 2} };
    int[][] expected = new int[][] { {0, 2}, {2, 0} };
    
    int[][] actual = this.kClosestPoints.kClosestQuickSelect(points, 2);
    
    Arrays.sort(expected, (a, b) -> Integer.compare(a[0], b[0]));
    Arrays.sort(actual, (a, b) -> Integer.compare(a[0], b[0]));
    
    Assertions.assertTrue(Arrays.deepEquals(expected, actual), "Failed in testKClosestPointsToOriginQuickSelect2");
  }

}
