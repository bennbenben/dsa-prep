package com.practise.dsa.heaps_and_priority_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskSchedulerTest {

  private final TaskScheduler taskScheduler = new TaskScheduler();
  
  @Test
  void testTaskScheduler1() {
    char[] tasks = new char[] {'X','X','Y','Y'}; int n = 2;
    int leastInterval = this.taskScheduler.leastInterval(tasks, n);
    int expected = 5;
    
    Assertions.assertEquals(expected, leastInterval, "Error in testTaskScheduler1.leastInterval");
  }
  
  @Test
  void testTaskScheduler2() {
    char[] tasks = new char[] {'A','A','A','B','C'}; int n = 3;
    int leastInterval = this.taskScheduler.leastInterval(tasks, n);
    int expected = 9;
    
    Assertions.assertEquals(expected, leastInterval, "Error in testTaskScheduler2.leastInterval");
  }

}
