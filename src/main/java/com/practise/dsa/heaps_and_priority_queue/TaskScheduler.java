package com.practise.dsa.heaps_and_priority_queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    int[] tasksFreq = new int[26];
    for (char task : tasks) {
      int taskIdx = task - 'A';
      tasksFreq[taskIdx] += 1;
    }
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
    for (Integer taskFreq : tasksFreq) {
      if (taskFreq > 0) {
        maxHeap.offer(taskFreq);
      }
    }
    
    Queue<int[]> taskQueue = new LinkedList<int[]>();
    int time=0;
    
    while (!maxHeap.isEmpty() || !taskQueue.isEmpty()) {
      time += 1;
      
      if (!maxHeap.isEmpty()) {
        int taskFreq = maxHeap.poll();
        int remainingTaskFreq = taskFreq-1;
        if (remainingTaskFreq>0)
          taskQueue.offer(new int[] {remainingTaskFreq, time + n});  
      } 
      
      if (!taskQueue.isEmpty() && time >= taskQueue.peek()[1]) {
        int[] task = taskQueue.poll();
        maxHeap.offer(task[0]);
      }
    }
    
    return time;
  }
}
