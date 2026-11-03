package com.practise.dsa.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KokoEatingBananasTest {

  private final KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
  
  @Test
  void testKokoEatingBananas1() {
    int[] piles = new int[] {1,4,3,2}; int h = 9;
    Assertions.assertEquals(2, this.kokoEatingBananas.minEatingSpeed(piles, h));
  }
  
  @Test
  void testKokoEatingBananas2() {
    int[] piles = new int[] {25,10,23,4}; int h = 4;
    Assertions.assertEquals(25, this.kokoEatingBananas.minEatingSpeed(piles, h));
  }
}
