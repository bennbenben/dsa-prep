package com.practise.dsa.heaps_and_priority_queue;

import java.util.PriorityQueue;

public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> {return b-a;});
    for (int stone : stones) {
      maxHeap.offer(stone);
    }
    
    while (maxHeap.size()>1) {
      int y = maxHeap.poll(); int x = maxHeap.poll();
      if (y == x) {
        continue;
      } else {
        maxHeap.offer(y - x);
      }
    }
    
    if (maxHeap.size() == 1) {
      return maxHeap.poll();
    } else {
      return 0;
    }
  }
}
