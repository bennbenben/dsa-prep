package com.practise.dsa.two_pointers;

import java.util.Arrays;

public class TrappingRainWater {
  
  /**
   * 2 Pointers solution
   * Time complexity: O(N) as there is a single traversal linearly
   * Space complexity: O(1) as it only store pointers
   * @param height
   * @return
   */
  public int trap2Pointers(int[] height) {
    int left=0, right = height.length-1;
    int maxLeft=0, maxRight=0;
    int trappedWater = 0;
    
    while (left<right) {
      System.out.printf("left index=%d, left height=%d. right index=%d, right height=%d%n", left, height[left], right, height[right]);
      System.out.printf("maxLeft=%d, maxRight=%d%n", maxLeft, maxRight);      
      System.out.printf("trappedWater=%d%n", trappedWater);      
      
      maxLeft = Math.max(maxLeft, height[left]);
      if (maxLeft > height[left]) {
        System.out.printf("maxLeft updated to=%d. Adding %d units of water%n", maxLeft, maxLeft-height[left]);
        trappedWater = trappedWater + (maxLeft - height[left]);
        System.out.printf("trappedWater=%d%n", trappedWater);
      }
      
      
      maxRight = Math.max(maxRight, height[right]);
      if (maxRight > height[right]) {
        System.out.printf("maxRight updated to=%d. Adding %d to units of water", maxRight, maxRight-height[right]);
        trappedWater = trappedWater + (maxRight - height[right]);
        System.out.println("trappedWater=" + trappedWater);
      }
      
      if (height[left] <= height[right]) {
        left += 1;
      } else if (height[left] > height[right]) {
        right -= 1;
      }
    }
    
    return trappedWater;
  }

  /**
   * Left and right arrays
   * Time complexity: O(N) as there is only linear traversal, including to build up the left and right arrays
   * Space complexity: O(N) as the left and right array scales linearly with length of the input array height
   * @param height
   * @return
   */
  public int trapLeftAndRightArrays(int[] height) {
    int heightLength = height.length; // 10
    int[] leftPeaks = new int[height.length];
    int[] rightPeaks = new int[height.length];
    
    for (int i=1; i<=heightLength-1;i++) { // iteration - index 9 needs to be included
      leftPeaks[i] = Math.max(leftPeaks[i-1], height[i-1]); // index 1
      rightPeaks[heightLength-1-i] = Math.max(rightPeaks[heightLength-i], height[heightLength-i]); // index 8
      
    }
    
    System.out.println("height=" + Arrays.toString(height));
    System.out.println("leftPeaks=" + Arrays.toString(leftPeaks));
    System.out.println("rightPeaks=" + Arrays.toString(rightPeaks));
    
    int shortestPeak, unitsOfWater = 0;
    for (int i=0; i<heightLength; i++) {
      shortestPeak = Math.min(leftPeaks[i], rightPeaks[i]);
      System.out.println("inside index=" + i + ", shortestPeak=" + shortestPeak + ", height=" + height[i]);
      if (shortestPeak > height[i]) {
        unitsOfWater += (shortestPeak - height[i]);
        System.out.println("unitsOfWater=" + unitsOfWater);
      }
    }
    
    return unitsOfWater;
  }
  
}
