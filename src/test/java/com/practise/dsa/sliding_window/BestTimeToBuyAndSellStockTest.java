package com.practise.dsa.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BestTimeToBuyAndSellStockTest {

  private final BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
  
  @Test
  void testBestTimeToBuyAndSellStock1() {
    int[] prices = {10,1,5,6,7,1};
    Assertions.assertEquals(6, bestTimeToBuyAndSellStock.maxProfitLeftAndRightArray(prices));
    Assertions.assertEquals(6, bestTimeToBuyAndSellStock.maxProfit2Pointers(prices));
  }
}
