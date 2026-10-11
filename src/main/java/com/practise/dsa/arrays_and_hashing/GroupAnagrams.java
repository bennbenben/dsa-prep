package com.practise.dsa.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  
  /**
   * Hash Map with sorted keys Time complexity: O(N log N * M), where M is the
   * number of strings and N is the length of the longest string Space complexity:
   * O(M * N)
   * 
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagramsSorting(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
    
    for (String str : strs) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedStr = String.valueOf(charArray);
      
      if (anagramMap.containsKey(sortedStr)) {
        anagramMap.get(sortedStr).add(str);
      } else {
        anagramMap.put(sortedStr, new ArrayList<String>());
        anagramMap.get(sortedStr).add(str);
      }
    }
    
    List<List<String>> groupAnagram = new ArrayList<List<String>>();
    groupAnagram.addAll(anagramMap.values());
    return groupAnagram;
  }

  
  public List<List<String>> groupAnagramsHashTable(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<String, List<String>>();
    for (String str : strs) {
      int[] alphabetsFrequency = new int[26];
      char[] chars = str.toCharArray();
      
      for (char c : chars) {
        int alphabet = c - 'a';
        alphabetsFrequency[alphabet] += 1;
      }
      
      String key = Arrays.toString(alphabetsFrequency);
      if (anagramMap.containsKey(key)) {
        anagramMap.get(key).add(str);
      } else {
        anagramMap.put(key, new ArrayList<String>());
        anagramMap.get(key).add(str);
      }
    }
    
    List<List<String>> groupAnagram = new ArrayList<List<String>>();
    groupAnagram.addAll(anagramMap.values());
    return groupAnagram;
  }

}
