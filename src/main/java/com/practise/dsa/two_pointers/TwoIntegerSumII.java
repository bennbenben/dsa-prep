package com.practise.dsa.two_pointers;

import java.util.Arrays;

public class TwoIntegerSumII {
  
  /**
   * Binary Search method to look for the complement digit
   * Time complexity: O(logN) for each element in the array. There are N elements so O(N log N)
   * Space complexity: O(1) as the number of temporary elements to store is constant
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSumBinarySearch(int[] numbers, int target) {
    int complement, left, right;
    
    for (int i=0; i<numbers.length; i++) {
      complement = target - numbers[i];
      left = i+1;
      right = numbers.length-1;
      
      while (left <= right) {
        int mid = (right - left)/2 + left;
        
        if (numbers[mid] == complement) {
          return new int[] {i+1, mid+1};
        
        } else if (numbers[mid] < complement) {
          left = mid + 1;
        
        } else {
          right = mid - 1;
        }
      }
      
    }
    
    return null;
  }

  /**
   * 2 Pointers solution Time complexity: O(N) due to iteration across the array
   * Space complexity: O(1) as the number of temporary pointers are constant
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum2Pointers1(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    int sum = numbers[i] + numbers[j];

    System.out.println("input numbers[]=" + Arrays.toString(numbers) + ", target=" + target);

    while (sum != target) {
      System.out.println("i=" + i + ", j=" + j + ", sum=" + sum);
      if (sum < target) {
        i += 1;
      } else if (sum > target) {
        j -= 1;
      }
      sum = numbers[i] + numbers[j];
    }

    System.out.println("Found a match. i=" + numbers[i] + ", while j=" + numbers[j]);
    System.out.println("Output 1-indexed array=" + Arrays.toString(new int[] { i + 1, j + 1 }));
    return new int[] { i + 1, j + 1 };
  }

  public int[] twoSum2Pointers2(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1, sum;
    System.out.println("input numbers[]=" + Arrays.toString(numbers) + ", target=" + target);

    while (i < j) {
      sum = numbers[i] + numbers[j];
      System.out.println("i=" + i + ", j=" + j + ", sum=" + sum);

      if (sum == target) {
        return new int[] { i + 1, j + 1 };
      }

      if (sum < target) {
        i += 1;
      } else if (sum > target) {
        j -= 1;
      }
    }

    return null;
  }

}
