package com.practise.dsa.stack;

import java.util.LinkedList;

public class DailyTemperatures {
  
  public int[] dailyTemperatures(int[] temperatures) {
    LinkedList<Integer> decreasingTempStack = new LinkedList<Integer>();
    int[] waitingDays = new int[temperatures.length];
    
    for (int i=0; i<temperatures.length; i++) {
      while (decreasingTempStack.size()>0 && 
          temperatures[i] > temperatures[decreasingTempStack.peekLast()]) {
        int prevHotDay = decreasingTempStack.pollLast();
        waitingDays[prevHotDay] = i - prevHotDay;
      }
      decreasingTempStack.offerLast(i);
    }
    return waitingDays;
  }
  
  public static void main(String[] args) {
    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    dailyTemperatures.dailyTemperatures(new int[] {30,38,30,36,35,40,28});
  }
}
