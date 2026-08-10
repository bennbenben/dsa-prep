package com.practise.dsa.binary_search;

public class BinarySearch {

  public int search(int[] nums, int target) {
    int leftIndex=0, rightIndex = nums.length-1;
    
    while (leftIndex <= rightIndex) {
      int midIndex = (rightIndex - leftIndex) / 2 + leftIndex;
      
      if (nums[midIndex] == target) {
        return midIndex;
      }
      
      if (nums[midIndex] < target) {
        leftIndex = midIndex + 1;
      } else {
        rightIndex = midIndex - 1;
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();
    binarySearch.search(new int[] {-1,0,2,4,6,8}, 4);
  }
}
