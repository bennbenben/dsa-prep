package com.practise.dsa.heaps_and_priority_queue;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
  public int findKthLargestMinHeap(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    
    for (int num : nums) {
      minHeap.offer(num);
      
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    
    return minHeap.poll();
  }
  
  public int findKthLargestQuickSelect(int[] nums, int k) {
    int left=0; int right = nums.length-1;
    int kthLargestElementIndex = nums.length - k;
    int partitionIndex = nums.length;
    
    while (partitionIndex != kthLargestElementIndex) {
      partitionIndex = this.partitionQuickSelect(nums, left, right);
      
      if (partitionIndex < kthLargestElementIndex) {
        left = partitionIndex + 1;
      } else {
        right = partitionIndex - 1;
      }
    }
    
    return nums[partitionIndex];
  }
  
  private int partitionQuickSelect(int[] nums, int left, int right) {
    int slowPointer=left; int fastPointer=left;
    int partitionValue = nums[right];
    while (fastPointer < right) {
      if (nums[fastPointer] <= partitionValue) {
        int temp = nums[fastPointer];
        nums[fastPointer] = nums[slowPointer];
        nums[slowPointer] = temp;
        slowPointer += 1;
      }
      fastPointer += 1;
    }
    int temp = nums[fastPointer]; // fastPointer = right here since exited the while loop: fastPointer < right
    nums[fastPointer] = nums[slowPointer];
    nums[slowPointer] = temp;
    return slowPointer;
  }
}
