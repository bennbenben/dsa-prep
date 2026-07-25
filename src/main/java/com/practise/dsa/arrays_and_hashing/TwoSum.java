package com.practise.dsa.arrays_and_hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  
  /**
   * 2 Pointers method
   * Time complexity: O(N log N) due to the sorting algorithm
   * Space complexity: O(N) as we are creating a copy of the original array
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum2Pointers(int[] nums, int target) {
    int[][] numsCopy = new int[nums.length][2];
    for (int i=0; i<nums.length; i++) {
      numsCopy[i][0]= nums[i];
      numsCopy[i][1]= i;
    }
    
    Arrays.sort(numsCopy, Comparator.comparingInt(valueIndex -> valueIndex[0]));
    
    int i=0, j=nums.length-1;
    while (i<j) {
      int sum = numsCopy[i][0] + numsCopy[j][0];
      
      if (sum == target) {
        return new int[] {numsCopy[i][1], numsCopy[j][1]};
      }
      
      if (sum < target) {
        i += 1;
      } else {
        j -= 1;
      }
    }
    return null;
  }
  
  public int[] twoSumHashMapTwoPass(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    
    for (int i=0; i<nums.length; i++) {
      numsMap.put(nums[i], i);
    }
    
    int diff;
    for (int i=0; i<nums.length; i++) {
      diff = target - nums[i];
      if (numsMap.containsKey(diff) && numsMap.get(diff) != i) {
        return new int[] {i, numsMap.get(diff)};
      }
    }
    
    return null;
  }
  
  /**
   * HashMap, single pass method
   * Time complexity: O(N) as need to iterate across the array to create the hashmap
   * Space complexity: O(N) as creating a hashmap is a "copy" of the input array
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSumHashMapOnePass(int[] nums, int target) {
    Map<Integer, Integer> complementMap = new HashMap<Integer, Integer>();
    
    for (int i=0; i<nums.length; i++) {
      Integer complement = target - nums[i];
      if (complementMap.containsKey(complement)) {
        return new int[] {complementMap.get(complement), i};
      } else {
        complementMap.put(nums[i], i);  
      }
    }
    
    return null;
  }
}
