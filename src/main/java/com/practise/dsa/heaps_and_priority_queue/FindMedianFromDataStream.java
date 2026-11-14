package com.practise.dsa.heaps_and_priority_queue;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

  private final PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
  private final PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
  
  public FindMedianFromDataStream() {
    
  }
  
  public void addNum(int num) {
    this.maxHeap.offer(num);
    this.minHeap.offer(this.maxHeap.poll());
    
    if (this.minHeap.size() > this.maxHeap.size()) {
      this.maxHeap.offer(this.minHeap.poll());
    }
  }
  
  public double findMedian() {
    int size = this.maxHeap.size() + this.minHeap.size();
    
    if (size%2 == 0) { // even
      return (this.maxHeap.peek() + this.minHeap.peek())/Double.valueOf(2);
    } else { // odd
      return this.maxHeap.peek();
    }
  }
}
