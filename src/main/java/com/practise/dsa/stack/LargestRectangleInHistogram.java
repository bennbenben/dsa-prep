package com.practise.dsa.stack;

import java.util.Arrays;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

  public int largestRectangleArea(int[] heights) {
    LinkedList<int[]> stack = new LinkedList<int[]>();
    int maxArea = 0;

    for (int i = 0; i < heights.length; i++) {
      System.out.printf("current index i=%d%n", i);
      int popIndex=i;
      while (!stack.isEmpty() && heights[i] < stack.peekFirst()[0]) {
        
        System.out.printf("Existing stack=%s, comparing against incoming value=%s%n", Arrays.deepToString(stack.toArray()), heights[i]);
        int[] popStackHead = stack.pollFirst();
        int currentArea = popStackHead[0] * (i - popStackHead[1]);
        maxArea = Math.max(maxArea, currentArea);
        
        System.out.printf("Area updated to %s%n", maxArea);
        popIndex = popStackHead[1];
      }

      stack.offerFirst(new int[] { heights[i], popIndex });
    }
    
    System.out.printf("Existing stack=%s%n", Arrays.deepToString(stack.toArray()));
    
    while (!stack.isEmpty()) {
      int[] popStackHead = stack.pollFirst();
      int currentArea = popStackHead[0] * (heights.length - popStackHead[1]);
      maxArea = Math.max(maxArea, currentArea);
    }
    
    System.out.printf("maxArea=%d%n", maxArea);

    return maxArea;
  }

  public static void main(String[] args) {
    LargestRectangleInHistogram solver = new LargestRectangleInHistogram();
    solver.largestRectangleArea(new int[] { 1,3,7 });
  }
}
