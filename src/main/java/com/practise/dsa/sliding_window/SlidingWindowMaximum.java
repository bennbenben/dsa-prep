package com.practise.dsa.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
  public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[0]-a[0]);
    int slowPointer=0, fastPointer=0;
    List<Integer> maxWindowValueList = new ArrayList<Integer>();
    
    while (fastPointer < nums.length) {
      
      while (maxHeap.size() > 0 && maxHeap.peek()[1] < slowPointer) {
        maxHeap.poll();
      }
      
      if (fastPointer - slowPointer + 1 < k) {
        maxHeap.offer(new int[] {nums[fastPointer], fastPointer});
        fastPointer+=1;
      } else {
        maxHeap.offer(new int[] {nums[fastPointer], fastPointer});
        maxWindowValueList.add(maxHeap.peek()[0]);
        fastPointer+=1; slowPointer+=1;
      }
    }
    
    int[] maxWindowValueArray = new int[maxWindowValueList.size()];
    for (int i=0; i<maxWindowValueList.size(); i++) {
      maxWindowValueArray[i] = maxWindowValueList.get(i);
    }
    return maxWindowValueArray;
  }
  
  /**
   * Sliding window with Deque (LinkedList)
   * Time complexity: O(N) as the input array nums is only iterated once. Every element of input array nums is being added to the deque once, and removed exactly once 
   * Space Complexity: O(N) as the size of the windowDeque will grow to at most size k, however, the result array will take same as number of windows which is O(length(nums)-K+1) => O(N) 
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindowDeque(int[] nums, int k) {
    LinkedList<Integer> windowDeque = new LinkedList<Integer>();
    int slowPointer=0, fastPointer=0;
    List<Integer> maxWindowValuesList = new ArrayList<Integer>();
    
    while (fastPointer<nums.length) {
      while (windowDeque.size()>0 && slowPointer > windowDeque.peekFirst()) {
        windowDeque.pollFirst();
      }
      
      while (windowDeque.size()>0 && nums[fastPointer]>nums[windowDeque.peekLast()]) {
        windowDeque.pollLast();
      }
      
      windowDeque.offer(fastPointer);
      int windowLength = fastPointer - slowPointer + 1;
      if (windowLength < k) {
        fastPointer += 1;
      } else {
        maxWindowValuesList.add(nums[windowDeque.peekFirst()]);
        slowPointer += 1; fastPointer += 1;
      }
    }
    
    int[] maxWindowValuesArray = new int[maxWindowValuesList.size()];
    for (int i=0; i<maxWindowValuesList.size(); i++) {
      maxWindowValuesArray[i]=maxWindowValuesList.get(i);
    }
    return maxWindowValuesArray;
  }
  
  public static void main(String[] args) {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    slidingWindowMaximum.maxSlidingWindowBruteForce(new int[] {10, 1, 2, 3}, 3);
    slidingWindowMaximum.maxSlidingWindowPriorityQueue(new int[] {10, 1, 2, 3}, 3);
    slidingWindowMaximum.maxSlidingWindowDeque(new int[] {10, 1, 2, 3}, 3);
  }
}
