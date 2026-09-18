package com.practise.dsa.arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

  /** 
   * Sorting method
   * Time complexity: O(n log n + m log m), based on the sorting algorithm
   * Space complexity: O(1) + O(n+m), depending on the sorting algorithm 
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagramSorted(String s, String t) {
    if (s.length()!=t.length()) {
      return false;
    }
    
    char[] sCharArray = s.toCharArray();
    Arrays.sort(sCharArray);
    
    char[] tCharArray = t.toCharArray();
    Arrays.sort(tCharArray);
    
    for (int i=0; i<s.length(); i++) {
      if (sCharArray[i] != tCharArray[i]) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * HashMap approach
   * Time complexity: O(n+m) since need to iterate to build the hash maps
   * Space complexity: O(1) since there is a fixed number of 26 alphabets
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagramHashMap(String s, String t) {
    if (s.length()!=t.length()) {
      return false;
    }
    
    Map<Character, Integer> sFreqMap = new HashMap<Character, Integer>();
    Map<Character, Integer> tFreqMap = new HashMap<Character, Integer>();
    
    for (int i=0; i<s.length(); i++) {
      sFreqMap.put(s.charAt(i), sFreqMap.getOrDefault(s.charAt(i), 0) + 1);
      tFreqMap.put(t.charAt(i), tFreqMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    
    return sFreqMap.equals(tFreqMap);
  }
  
  /**
   * Primitive Array approach
   * Time complexity: O(N) where N is the length of the string
   * Space complexity: O(1) because the array size is always exactly 26 (all alphabets)
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagramPrimitiveArray(String s, String t) {
    if (s.length()!=t.length()) {
      return false;
    }
    int[] freqHashTable = new int[26];
    for (int i=0; i<s.length(); i++) {
      freqHashTable[s.charAt(i) - 'a'] += 1;
      freqHashTable[t.charAt(i) - 'a'] -= 1;
    }
    for (int i=0; i<freqHashTable.length; i++) {
      if (freqHashTable[i] != 0) {
        return false;
      }
    }
    return true;
  }

}
