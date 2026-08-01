package com.practise.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
  
  /**
   * Fast and slow pointer while checking highest frequency alphabet
   * Time complexity: O(N), where N is the length of input string S
   * Although there is 2 while loops, the outer loop will only traverse once. The inner while loop will also only ever traverse once
   * Space complexity: O(1), where there will only ever be 26 alphabets in the HashMap
   * @param s
   * @param k
   * @return
   */
  public int characterReplacement(String s, int k) {
    int slowPointer=0, fastPointer=1;
    
    Map<Character,Integer> frequencyMap = new HashMap<Character,Integer>();
    frequencyMap.put(s.charAt(slowPointer), 1);
    
    int highestFrequency = 1, totalFrequencies = 1, numsOfReplacementsRequired = 0;
    
    while (fastPointer < s.length()) {
      System.out.printf("Existing slowPointer=%d, value=%s%n", slowPointer, s.charAt(slowPointer));
      System.out.printf("Existing fastPointer=%d, value=%s%n", fastPointer, s.charAt(fastPointer));
      
      int fastPointerFrequency = frequencyMap.getOrDefault(s.charAt(fastPointer),0)+1;
      frequencyMap.put(s.charAt(fastPointer), fastPointerFrequency);
      System.out.printf("frequencyMap=%s%n", frequencyMap.toString());
      
      totalFrequencies = 0;
      for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
        totalFrequencies += entry.getValue();
        if (entry.getValue() > highestFrequency) {
          highestFrequency = entry.getValue();
        }
      }
      
      numsOfReplacementsRequired = totalFrequencies - highestFrequency;
      System.out.printf("numOfReplacements=%s%n", numsOfReplacementsRequired);
      
      while (numsOfReplacementsRequired>k) {
        System.out.printf("(numsOfReplacementsRequired=%d) > (k=%d)%n", numsOfReplacementsRequired, k);
        int slowPointerFrequency = frequencyMap.get(s.charAt(slowPointer))-1;
        frequencyMap.put(s.charAt(slowPointer), slowPointerFrequency);
        slowPointer +=1;
        
        totalFrequencies = 0;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
          totalFrequencies += entry.getValue();
          if (entry.getValue() > highestFrequency) {
            highestFrequency = entry.getValue();
          }
        }
        
        numsOfReplacementsRequired = totalFrequencies - highestFrequency;
        System.out.printf("numOfReplacements=%s%n", numsOfReplacementsRequired);
      }
      
      fastPointer+=1;
    }
    
    System.out.printf("totalFrequencies=%d%n", totalFrequencies);
    return totalFrequencies;
  }
}
