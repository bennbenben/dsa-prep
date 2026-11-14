package com.practise.dsa.heaps_and_priority_queue;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  private class Point {
    int[] coordinates;
    double distance;

    public Point(int[] coordinates, double distance) {
      this.coordinates = coordinates;
      this.distance = distance;
    }
  }

  public int[][] kClosestMaxHeap(int[][] points, int k) {
    PriorityQueue<Point> distanceMaxHeap = new PriorityQueue<KClosestPointsToOrigin.Point>(
        (a, b) -> Double.compare(b.distance, a.distance));
    
    for (int i=0; i<points.length; i++) {
      Point point = new Point(points[i], Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
      distanceMaxHeap.offer(point);
      if (distanceMaxHeap.size() > k) {
        distanceMaxHeap.poll();
      }
    }
    
    int[][] closestPointsArray = new int[k][2];
    for (int i=0; i<k; i++) {
      Point point = distanceMaxHeap.poll();
      closestPointsArray[i][0] = point.coordinates[0];
      closestPointsArray[i][1] = point.coordinates[1];
    }
    
    return closestPointsArray;
  }
  
  public int[][] kClosestQuickSelect(int[][] points, int k) {
    int left=0; int right = points.length-1;
    int pivotIdx = points.length;
    
    while (pivotIdx != k) {
      pivotIdx = this.partition(points, left, right);
      if (pivotIdx < k) { // if k=4, but pivotIdx=2, there is only 3 elements trapped (inclusive of pivotIdx)
        left = pivotIdx + 1;
      } else {
        right = pivotIdx - 1;
      }
    }
    
    int[][] quickSelectArray = new int[k][2];
    for (int i=0; i<k; i++) {
      quickSelectArray[i][0] = points[i][0];
      quickSelectArray[i][1] = points[i][1];
    }
    
    return quickSelectArray;
  }
  
  private int partition(int[][] points, int left, int right) {
    int pivotIdx = right;
    double pivotIdxDistance = this.calculateDistance(points[pivotIdx]);
    
    int i=left;
    for (int j=left; j<right; j++) {
      double pointDistance = this.calculateDistance(points[j]);
      if (pointDistance <= pivotIdxDistance) {
        int[] temp = points[j];
        points[j] = points[i];
        points[i] = temp;
        i += 1;
      }
    }
    
    int[] temp = points[right];
    points[right] = points[i];
    points[i] = temp;    
    
    return i;
  }
  
  private double calculateDistance(int[] point) {
    return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
  }
}
