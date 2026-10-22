package com.practise.dsa.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  
  /**
   * Fast and Slow pointer sliding window while checking minimum length
   * Time complexity: O(M+N), where N is the length of input string S, and M is the length of t
   * O(M): as t is the reference string, and tFreqMap setup
   * O(N): Sliding window is O(N) because slow and fast pointers only traverse the same direction and each element of string S will be traverse only once by the pointers
   * Helper method frequencyMapEqualsOrMore has a fixed capacity of 26 upper and 26 lower chars = 52 which is a constant, hence considered O(1) 
   * Space complexity: O(1) which is a constant, because there is a fixed input of 26 upper and 26 lower chars = 52 which is a constant
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    Map<Character, Integer> tFreqMap = new HashMap<Character, Integer>();
    for (int i=0; i<t.length(); i++) {
      tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0)+1);
    }
    
    Map<Character, Integer> sFreqMap = new HashMap<Character, Integer>();
    int slowPointer=0, fastPointer=0;
    int minWindowLength=Integer.MAX_VALUE, minStart=0, minEnd=0;
    while (fastPointer < s.length()) {
      int fastPointerValue = sFreqMap.getOrDefault(s.charAt(fastPointer), 0)+1;
      sFreqMap.put(s.charAt(fastPointer), fastPointerValue);
      
      // valid or not - if valid, shrink slowpointer. if not valid, add fastpointer
      while (this.freqMapEqualsOrMore(sFreqMap, tFreqMap)) {
        int windowLength = fastPointer - slowPointer +1;
        if (windowLength < minWindowLength) {
          minStart = slowPointer; minEnd = fastPointer;
          minWindowLength = windowLength;
        }
        
        int slowPointerValue = sFreqMap.get(s.charAt(slowPointer))-1;
        if (slowPointerValue == 0) {
          sFreqMap.remove(s.charAt(slowPointer));
        } else {
          sFreqMap.put(s.charAt(slowPointer), slowPointerValue);
        }
        slowPointer+=1;
      }

      fastPointer += 1;
    }
    
    if (minWindowLength==Integer.MAX_VALUE) {
      return "";
    } else {
      return s.substring(minStart, minEnd+1);
    }
  }
  
  public boolean freqMapEqualsOrMore(Map<Character, Integer> sFreqMap, Map<Character, Integer> tFreqMap) {
    for (Map.Entry<Character, Integer> entry : tFreqMap.entrySet()) {
      if (!sFreqMap.containsKey(entry.getKey())) {
        return false;
      }
      int sFreq = sFreqMap.get(entry.getKey());
      int tFreq = entry.getValue();
      if (sFreq < tFreq) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * "Optimized" version using hash table
   * @param s
   * @param t
   * @return
   */
  public String minWindowHashTable(String s, String t) {
    int tValidChars=0;
    int[] tFreqHashTable = new int[128];
    for (int i=0; i<t.length(); i++) {
      char c = t.charAt(i);
      if (tFreqHashTable[c] == 0) {
        tValidChars += 1;
      }
      tFreqHashTable[c] += 1;
    }
    
    int[] sFreqHashTable = new int[128];
    int sValidChars=0;
    
    int slowPointer=0, fastPointer=0;
    int minWindowLength=Integer.MAX_VALUE, minStart=0, minEnd=0;
    while (fastPointer < s.length()) {
      int fastPointerChar = s.charAt(fastPointer);
      sFreqHashTable[fastPointerChar]+=1;
      
      if (tFreqHashTable[fastPointerChar] > 0 && 
          tFreqHashTable[fastPointerChar] == sFreqHashTable[fastPointerChar]) {
        sValidChars+=1;
      }
      
      // valid or not - if valid, shrink slowpointer. if not valid, add fastpointer
      while (tValidChars==sValidChars) {
        int windowLength = fastPointer - slowPointer +1;
        if (windowLength < minWindowLength) {
          minStart = slowPointer; minEnd = fastPointer;
          minWindowLength = windowLength;
        }
        
        char slowPointerChar = s.charAt(slowPointer);
        sFreqHashTable[slowPointerChar] -= 1;
        if (tFreqHashTable[slowPointerChar] > 0 &&
            sFreqHashTable[slowPointerChar] < tFreqHashTable[slowPointerChar]) {
          sValidChars-=1;
        }
        slowPointer+=1;
      }

      fastPointer += 1;
    }
    
    if (minWindowLength==Integer.MAX_VALUE) {
      return "";
    } else {
      return s.substring(minStart, minEnd+1);
    }
  }
}
