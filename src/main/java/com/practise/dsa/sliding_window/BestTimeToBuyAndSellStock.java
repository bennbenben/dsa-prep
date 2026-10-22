package com.practise.dsa.sliding_window;

public class BestTimeToBuyAndSellStock {
  
  /**
   * 2 Pointers 
   * Time complexity: O(N) as it iterates the array linearly
   * Space complexity: O(1) as there is fixed number of temporary objects
   * @param prices
   * @return
   */
  public int maxProfit2Pointers(int[] prices) {
    int slowPointer=0, fastPointer=slowPointer+1;
    int maxProfit=0, profit=0;
    
    while (fastPointer<prices.length) {
      profit = prices[fastPointer] - prices[slowPointer];
      maxProfit = Math.max(maxProfit, profit);
      if (prices[fastPointer] < prices[slowPointer]) {
        slowPointer = fastPointer;
        fastPointer += 1;
      } else {
        fastPointer += 1;
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
    int[] buyArray = new int[prices.length], sellArray = new int[prices.length];
    buyArray[0] = prices[0]; 
    sellArray[prices.length-1] = prices[prices.length-1];
    
    for (int i=1; i<prices.length;i++) {
      int lowestBuy = Math.min(buyArray[i-1], prices[i]);
      buyArray[i] = lowestBuy;
    }
    
    for (int i=prices.length-2; i>=0; i--) {
      int highestSell = Math.max(sellArray[i+1], prices[i]);
      sellArray[i] = highestSell;
    }
    
    int maxProfit = 0, profit = 0;
    for (int i=0; i<prices.length; i++) {
      profit = sellArray[i] - buyArray[i];
      maxProfit = Math.max(maxProfit, profit);
    }
    
    return maxProfit;
  }
}
