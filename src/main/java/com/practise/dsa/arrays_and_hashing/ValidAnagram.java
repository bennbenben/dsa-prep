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
    char[] sCharArr = s.toCharArray();
    Arrays.sort(sCharArr);
    
    char[] tCharArr = t.toCharArray();
    Arrays.sort(tCharArr);
    
    return Arrays.equals(sCharArr, tCharArr);
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
    
    if (s.length() != t.length()) {
      return false;
  }
    
    Map<Character, Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();
    
    for (int i=0; i < s.length() ;i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
      tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    
    return sMap.equals(tMap);
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
    if (s.length() != t.length()) {
      return false;
    }
    
    int[] charFrequencies = new int[26];
    
    for (int i=0; i<s.length(); i++) {
      charFrequencies[s.charAt(i) - 'a'] += 1;
      charFrequencies[t.charAt(i) - 'a'] -= 1;
    }
    
    for (int charFrequency : charFrequencies) {
      if (charFrequency != 0) {
        return false;
      }
    }
    
    return true;
  }

}
