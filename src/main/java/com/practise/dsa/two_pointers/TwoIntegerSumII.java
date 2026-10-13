package com.practise.dsa.two_pointers;

public class TwoIntegerSumII {
  
  /**
   * 2 Pointers solution Time complexity: O(N) due to iteration across the array
   * Space complexity: O(1) as the number of temporary pointers are constant
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSumTwoPointers(int[] numbers, int target) {
    int left = 0, right = numbers.length-1;    
    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum < target) {
        left += 1;
        continue;
      } else if (sum > target) {
        right -= 1;
        continue;
      } else {
        return new int[] {left+1, right+1};
      }
    }
    return null;
  }
  
  /**
   * Binary Search method to look for the complement digit
   * Time complexity: O(logN) for each element in the array. There are N elements so O(N log N)
   * Space complexity: O(1) as the number of temporary elements to store is constant
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSumBinarySearch(int[] numbers, int target) {
    int left, right, complement;
    
    for (int i=0; i<numbers.length-1; i++) {
      left = i+1; 
      right = numbers.length-1;
      complement = target - numbers[i];
      
      while (left <= right) {
        int mid = (left + right) / 2;
        if (numbers[mid] < complement) {
          left = mid + 1;
          continue;
        } else if (numbers[mid] > complement) {
          right = mid - 1;
          continue;
        } else {
          return new int[] {i+1, mid+1};
        }
      }
    }
    return null;
  }
}
