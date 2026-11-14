package com.practise.dsa.heaps_and_priority_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInStream {
  
  public static class KthLargestMaxHeap {
    private int k = 0;
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> {return b-a;});
    
    public KthLargestMaxHeap(int k, int[] nums) {
      this.k = k;
      for (int num : nums) {
        this.maxHeap.offer(num);
      }
    }
    
    public int add(int val) {
      this.maxHeap.offer(val);
      List<Integer> heapElements = new ArrayList<>();
      for (int i=0; i<(k-1); i++) {
        heapElements.add(this.maxHeap.poll());
      }
      int kthLargest = this.maxHeap.peek();
      heapElements.forEach(element -> this.maxHeap.add(element));
      return kthLargest;
    }
  }
  
  public static class KthLargestMinHeap {
    
    int k = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    
    public KthLargestMinHeap(int k, int[] nums) {
      this.k = k;
      for (int num : nums) {
        this.minHeap.offer(num);
        if (minHeap.size() > k) {
          this.minHeap.poll();
        }
      }
    }
    
    public int add(int val) {
      this.minHeap.offer(val);
      if (minHeap.size() > k) {
        this.minHeap.poll();
      }
      return this.minHeap.peek();
    }
  }
}
