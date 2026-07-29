package com.practise.dsa.sliding_window;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
  
  /**
   * 2 Pointers 
   * Time complexity: O(N) as it iterates the array linearly
   * Space complexity: O(1) as there is fixed number of temporary objects
   * @param prices
   * @return
   */
  public int maxProfit2Pointers(int[] prices) {
    int slowPointer=0, fastPointer=1;
    int maxProfit=0, currentProfit=0;
    
    while (fastPointer < prices.length) {
      System.out.printf("Current iteration slowPointer=%d, fastPointer=%d%n", slowPointer, fastPointer);
      System.out.printf("slowPointerValue=%d, fastPointerValue=%d%n", prices[slowPointer], prices[fastPointer]);
      
      currentProfit = prices[fastPointer] - prices[slowPointer];
      System.out.printf("currentProfit=%d%n", currentProfit);
      
      maxProfit = Math.max(maxProfit, currentProfit);
      System.out.printf("maxProfit=%d%n", maxProfit);
      
      if (prices[fastPointer] < prices[slowPointer]) {
        slowPointer = fastPointer;
        fastPointer = slowPointer+1;
        System.out.printf("fastPointer is < slowPointer. Updating slowPointer=%d, fastPointer=%d%n", slowPointer, fastPointer);
      } else {
        fastPointer += 1;
        System.out.printf("fastPointer is >= slowPointer. Updating fastPointer=%d%n", fastPointer);
      }
      
    }
    
    return maxProfit;
  }
  
  /**
   * Left and right array 
   * Time complexity: O(N) as the input array prices is iterated linearly
   * Space complexity: O(N) as intermediate arrays scale linearly with the input array prices
   * @param prices
   * @return
   */
  public int maxProfitLeftAndRightArray(int[] prices) {
    
    int[] buyArray = new int[prices.length];
    int[] sellArray = new int[prices.length];
    
    buyArray[0] = prices[0];
    for (int i=1; i<prices.length;i++) {
      buyArray[i] = Math.min(buyArray[i-1], prices[i]);
    }
    
    System.out.printf("buyArray=%s%n", Arrays.toString(buyArray));
    
    sellArray[prices.length-1] = prices[prices.length-1];
    for (int i=prices.length-1-1; i>-1; i--) {
      sellArray[i] = Math.max(sellArray[i+1], prices[i]);
    }
    
    System.out.printf("sellArray=%s%n", Arrays.toString(sellArray));
    
    int maxProfit=0;
    for (int i=0; i<prices.length; i++) {
      maxProfit = Math.max(maxProfit, sellArray[i] - buyArray[i]);
    }
    
    System.out.printf("maxProfit=%s%n", maxProfit);
    
    return maxProfit;
    
  }
  
}
