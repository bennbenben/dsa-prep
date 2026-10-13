package com.practise.dsa.two_pointers;

public class TrappingRainWater {
  
  /**
   * Left and right arrays
   * Time complexity: O(N) as there is only linear traversal, including to build up the left and right arrays
   * Space complexity: O(N) as the left and right array scales linearly with length of the input array height
   * @param height
   * @return
   */
  public int trapLeftAndRightArrays(int[] height) {
    int[] leftArray = new int[height.length];
    int[] rightArray = new int[height.length];
    
    leftArray[0] = height[0];
    rightArray[height.length-1] = height[height.length-1];
    
    for (int i=1; i<=height.length-1; i++) {
      if (height[i] > leftArray[i-1]) {
        leftArray[i] = height[i];
      } else {
        leftArray[i] = leftArray[i-1];
      }
    }
    
    for (int i=height.length-2; i>=0; i--) {
      if (height[i] > rightArray[i+1]) {
        rightArray[i] = height[i];
      } else {
        rightArray[i] = rightArray[i+1];
      }
    }
    
    int trappedWater = 0;
    for (int i=0; i<=height.length-1; i++) {
      trappedWater += Math.min(leftArray[i], rightArray[i]) - height[i];
    }
    
    return trappedWater;
  }
  
  /**
   * 2 Pointers solution
   * Time complexity: O(N) as there is a single traversal linearly
   * Space complexity: O(1) as it only store pointers
   * @param height
   * @return
   */
  public int trap2Pointers(int[] height) {
    int left=0, right=height.length-1;
    int leftMax=0, rightMax=0;
    int trappedWater=0;
    
    while (left < right) {
      if (height[left] <= height[right]) {
        leftMax = Math.max(leftMax, height[left]);
        trappedWater += leftMax - height[left];
        left += 1;
      } else {
        rightMax = Math.max(rightMax, height[right]);
        trappedWater += rightMax - height[right];
        right -= 1;
      }
    }
    
    return trappedWater;
  }

}
