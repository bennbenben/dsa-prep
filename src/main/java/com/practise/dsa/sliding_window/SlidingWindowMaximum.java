package com.practise.dsa.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

  /**
   * Sliding window, brute force
   * Time complexity: O(N * K), where N is the length of input array nums, and k is the size of window. This is because the iteration is from left to right O(N), and within each window, each element is iterate once O(K)
   * Space complexity: O(N-K+1), which is the number of windows
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
    // nums = 1,2,1,0,4,2,6, k = 3
    System.out.printf("input nums=%s, k=%d%n", Arrays.toString(nums), k);
    
    List<Integer> maxWindows = new ArrayList<Integer>();
    
    int slowPointer=0, fastPointer=k-1;
    while (fastPointer < nums.length) {
      int maxWindowValue = Integer.MIN_VALUE;
      for (int i=slowPointer; i<=fastPointer; i++) {
        maxWindowValue = Math.max(maxWindowValue, nums[i]);
      }
      maxWindows.add(maxWindowValue);
      slowPointer+=1; fastPointer+=1;
    }
    
    System.out.printf("maxWindows=%s%n", Arrays.toString(maxWindows.toArray()));
    
    int[] maxWindowArray = new int[maxWindows.size()];
    for (int i=0; i<maxWindows.size(); i++) {
      maxWindowArray[i] = maxWindows.get(i);
    }
    
    return maxWindowArray;
  }
  
  /**
   * Sliding window with Max Heap (Priority Queue)
   * Time complexity: O(N log N), where N is the length of input int[] array nums. O(logN) due to the time taken for insertion and deletion
   * Space complexity: O(N) where N is the length of input int[] array nums, due to the variable length of the Priority Queue (heap)
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindowMaxHeap(int[] nums, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[0]-a[0]);
    for (int i=0; i<k; i++) {
      maxHeap.offer(new int[] {nums[i], i});
    }
    
//    int[] maxWindowArray = new int[nums.length-k+1]; // nums.length-k+1 will return the number of windows
    List<Integer> maxWindows = new ArrayList<Integer>();
    
    int slowPointer=0, fastPointer=k-1;
    while (fastPointer<nums.length) {
      
      // If index < slowPointer, entry is already out of the window
      while (maxHeap.peek()[1] < slowPointer) {
        maxHeap.poll();
      }
      maxWindows.add(maxHeap.peek()[0]);
      
      slowPointer +=1; fastPointer +=1;
      if (fastPointer < nums.length)
        maxHeap.offer(new int[] {nums[fastPointer], fastPointer});
    }
    
    int[] maxWindowArray = new int[maxWindows.size()];
    for (int i=0; i<maxWindows.size(); i++) {
      maxWindowArray[i] = maxWindows.get(i);
    }
    
    return maxWindowArray;
  }
  
  public static void main(String[] args) {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    slidingWindowMaximum.maxSlidingWindowBruteForce(new int[] {10, 1, 2, 3}, 3);
    slidingWindowMaximum.maxSlidingWindowMaxHeap(new int[] {10, 1, 2, 3}, 3);
  }
}
