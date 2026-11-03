package com.practise.dsa.binary_search;

public class BinarySearch {
  
  public int search(int[] nums, int target) {
    int left=0, right = nums.length-1;
    
    while (left <= right) {
      int mid = left+(right-left)/2;
      if (nums[mid]==target) {
        return mid;
      }
      if (nums[mid] < target) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) {
    BinarySearch binarySearch = new BinarySearch();
    binarySearch.search(new int[] {-1,0,2,4,6,8}, 4);
  }
}
