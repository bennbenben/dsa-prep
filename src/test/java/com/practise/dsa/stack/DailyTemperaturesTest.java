package com.practise.dsa.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DailyTemperaturesTest {

  private final DailyTemperatures dailyTemperatures = new DailyTemperatures();
  
  @Test
  void testDailyTemperatures1() {
    int[] temperatures = {30,38,30,36,35,40,28};
    int[] output = {1,4,1,2,1,0,0};
    Assertions.assertArrayEquals(output, dailyTemperatures.dailyTemperatures(temperatures));
  }
  
  @Test
  void testDailyTemperatures2() {
    int[] temperatures = {22,21,20};
    int[] output = {0,0,0};
    Assertions.assertArrayEquals(output, dailyTemperatures.dailyTemperatures(temperatures));
  }
}
