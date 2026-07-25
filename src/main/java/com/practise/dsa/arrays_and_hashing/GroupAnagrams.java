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

    Map<String, List<String>> anagramGroup = new HashMap<String, List<String>>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);

      List<String> existingValues = anagramGroup.get(key);
      if (existingValues == null) {
        existingValues = new ArrayList<String>();
        anagramGroup.put(key, existingValues);
      }

      existingValues.add(str);
    }

    return new ArrayList<List<String>>(anagramGroup.values());

  }

  public List<List<String>> groupAnagramsHashTable(String[] strs) {

    Map<String, List<String>> anagramGroup = new HashMap<String, List<String>>();

    for (String str : strs) {
      int[] alphabetsFrequency = new int[26];
      char[] chars = str.toCharArray();

      for (char c : chars) {
        int alphabet = c - 'a';
        alphabetsFrequency[alphabet] += 1;
      }

      String key = Arrays.toString(alphabetsFrequency);
      List<String> existingValue = anagramGroup.get(key);
      if (existingValue == null) {
        existingValue = new ArrayList<String>();
        anagramGroup.put(key, existingValue);
      }
      existingValue.add(str);

    }
    
    return new ArrayList<List<String>>(anagramGroup.values());
  }

}
