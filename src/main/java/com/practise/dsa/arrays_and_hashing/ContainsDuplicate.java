package com.practise.dsa.arrays_and_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  /** 
   * Sorting approach
   * Time complexity: O(n log n)
   * Space complexity: O(1) or O(n) depending on the sorting algorithm 
   * Arrays.sort(primitives) uses Dual-Pivot Quicksort, operates in place; not stable (does not preserve original order of elements)
   * Arrays.sort(Object[]) uses TimSort, which requires up to O(n) extra space to perform its merges
   * Arrays.sort(primitives) space complexity is O(log N)
   * @param nums
   * @return
   */
  public boolean hasDuplicateSorting(int[] nums) {
    Arrays.sort(nums);
    for ( int i=0; i < nums.length-1; i++ ) {
      if (nums[i] == nums[i+1]) {
        return true;
      }
    }
    return false;
  }
  
  /** 
   * HashSet approach
   * Time complexity: O(n)
   * Space complexity: O(n) 
   * @param nums
   * @return
   */
  public boolean hasDuplicateHashSet(int[] nums) {
    Set<Integer> seen = new HashSet();
    for (int num : nums) {
      if (seen.contains(num)) {
        return true;
      }
      seen.add(num);
    }
    return false;
  }
  
}
