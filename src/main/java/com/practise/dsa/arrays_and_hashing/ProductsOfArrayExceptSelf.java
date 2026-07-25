package com.practise.dsa.arrays_and_hashing;

import java.util.Arrays;

public class ProductsOfArrayExceptSelf {
  
  public int[] productExceptSelfPrefixAndSuffix(int[] nums) {
    int[] leftArray = new int[nums.length];
    leftArray[0] = 1;
    for (int i=1; i<nums.length; i++) {
      leftArray[i] = nums[i-1] * leftArray[i-1];
    }
    
    System.out.println(Arrays.toString(leftArray));
    
    int[] rightArray = new int[nums.length];
    rightArray[nums.length-1] = 1;
    for (int i=nums.length-2; i>-1; i--) {
      rightArray[i] = nums[i+1] * rightArray[i+1];
    }
    
    System.out.println(Arrays.toString(rightArray));
    
    int[] resultArray = new int[nums.length];
    for (int i=0; i<resultArray.length;i++) {
      resultArray[i]=leftArray[i]*rightArray[i];
    }
    
    System.out.println(Arrays.toString(resultArray));

    return resultArray;
  }
  
  public int[] productExceptSelfPrefixAndSuffixOptimal(int[] nums) {
    int[] leftArray = new int[nums.length];
    leftArray[0] = 1;
    for (int i=1; i<nums.length; i++) {
      leftArray[i] = nums[i-1] * leftArray[i-1];
    }
    System.out.println(Arrays.toString(leftArray));
    
    int rightInt = 1;
    int j;
    for (int i=0; i<nums.length; i++) {
      j = nums.length-1-i; // 4-1-1=2
      leftArray[j] = leftArray[j] * rightInt; // leftArray[2] = 2*6 
      rightInt = rightInt*nums[j]; // rightInt = 6
    }
    
    System.out.println(Arrays.toString(leftArray));
    
    return leftArray;
  }
  
}
