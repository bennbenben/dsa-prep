package com.practise.dsa.arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

  public int[] topKFrequentSorting(int[] nums, int k) {

    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    for (int num : nums) {
      Integer existingCount = frequencyMap.getOrDefault(num, 0) + 1;
      frequencyMap.put(num, existingCount);
    }

    int[][] frequencyArray = new int[frequencyMap.size()][2];
    int i = 0;
    for (Map.Entry<Integer, Integer> frequencyMapEntry : frequencyMap.entrySet()) {
      frequencyArray[i][0] = frequencyMapEntry.getKey();
      frequencyArray[i][1] = frequencyMapEntry.getValue();
      i += 1;
    }

    Arrays.sort(frequencyArray, Comparator.comparingInt(item -> item[1]));
    i = 0;
    int[] result = new int[k];
    while (i < k) {
      result[i] = frequencyArray[frequencyMap.size() - 1 - i][0];
      i += 1;
    }
    return result;
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
