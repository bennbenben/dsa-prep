package com.practise.dsa.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFleetTest {

  private final CarFleet carFleet = new CarFleet();
  
  @Test
  void testCarFleet1() {
    Assertions.assertEquals(1, carFleet.carFleet(10, new int[] {1,4}, new int[] {3,2}));
  }
  
  @Test
  void testCarFleet2() {
    Assertions.assertEquals(3, carFleet.carFleet(10, new int[] {4,1,0,7}, new int[] {2,2,1,1}));
  }
}
