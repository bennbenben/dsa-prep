package com.practise.dsa.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
  
  public int[] topKFrequentSorting(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) { 
      int existingCount = frequencyMap.getOrDefault(num, 0);
      frequencyMap.put(num, existingCount+1);
    }
    
    int[][] frequencyArray = new int [frequencyMap.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      frequencyArray[i][0] = entry.getKey();
      frequencyArray[i][1] = entry.getValue();
      i += 1;
    }
    Arrays.sort(frequencyArray, (a, b) -> b[1] - a[1]);
    
    int[] frequentElements = new int[k];
    for (i = 0; i < k; i++) {
      frequentElements[i] = frequencyArray[i][0];
    }
    
    return frequentElements;
  }
  
  public int[] topKFrequentBucketSort(int[] nums, int k) {

    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      Integer existingCount = frequencyMap.getOrDefault(num, 0) + 1;
      frequencyMap.put(num, existingCount);
    }

    List<List<Integer>> buckets = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      buckets.add(new ArrayList<>());
    }

    for (Map.Entry<Integer, Integer> frequencyMapEntry : frequencyMap.entrySet()) {
      int num = frequencyMapEntry.getKey();
      int freq = frequencyMapEntry.getValue();
      
      buckets.get(freq).add(num);
    }

    int[] result = new int[k];
    int resultIndex = 0;

    for (int i = buckets.size() - 1; i >= 0; i--) {
      for (int num : buckets.get(i)) {
        result[resultIndex] = num;
        resultIndex += 1;

        if (resultIndex == k) {
          return result;
        }
      }

    }

    return result;
  }

}
