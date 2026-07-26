package com.practise.dsa.two_pointers;

import java.util.Arrays;

public class TwoIntegerSumII {

  /**
   * 2 Pointers solution
   * Time complexity: O(N) due to iteration across the array
   * Space complexity: O(1) as the temp pointers are constant
   * @param numbers
   * @param target
   * @return
   */
  public int[] twoSum2Pointers1(int[] numbers, int target) {
    int i = 0, j = numbers.length-1;
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
    int i = 0, j = numbers.length-1,sum;
    System.out.println("input numbers[]=" + Arrays.toString(numbers) + ", target=" + target);
    
    while (i<j) {
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
  
  public static void main(String[] args) {
    TwoIntegerSumII twoIntegerSumII = new TwoIntegerSumII();
    twoIntegerSumII.twoSum2Pointers1(new int[]{1,2,3,4}, 3);
    twoIntegerSumII.twoSum2Pointers2(new int[]{1,2,3,4}, 3);
  }
  
}
