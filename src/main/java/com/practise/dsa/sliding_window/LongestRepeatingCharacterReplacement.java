package com.practise.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
  
  public int characterReplacement(String s, int k) {
    
    int slowPointer=0, fastPointer=1;
    char[] sCharArray = s.toCharArray();
    Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();
    
    charFrequency.put(sCharArray[slowPointer], 1);
    int maxWindowSize = 1;
    
    while (fastPointer < sCharArray.length) {
      int fastPointerFrequency = charFrequency.getOrDefault(sCharArray[fastPointer], 0)+1;
      charFrequency.put(sCharArray[fastPointer], fastPointerFrequency);
      
      Character mostFrequentCharacter = null;
      Integer mostFrequentCharacterFrequency = 0;
      for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
        if (entry.getValue() > mostFrequentCharacterFrequency) {
          mostFrequentCharacter = entry.getKey();
          mostFrequentCharacterFrequency = entry.getValue();
        }
      }
      
      int windowSize = fastPointer - slowPointer + 1;
      int numberOfImposters = windowSize - mostFrequentCharacterFrequency;
      
      while (numberOfImposters > k) {
        charFrequency.put(sCharArray[slowPointer], charFrequency.get(sCharArray[slowPointer])-1);
        slowPointer += 1;
        
        mostFrequentCharacter = null;
        mostFrequentCharacterFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
          if (entry.getValue() > mostFrequentCharacterFrequency) {
            mostFrequentCharacter = entry.getKey();
            mostFrequentCharacterFrequency = entry.getValue();
          }
        }
        
        windowSize = fastPointer - slowPointer + 1;
        numberOfImposters = windowSize - mostFrequentCharacterFrequency;
      }
      
      maxWindowSize = Math.max(maxWindowSize, windowSize);
      fastPointer +=1;
    }
    
    return maxWindowSize;
    
  }
}
