package com.practise.dsa.arrays_and_hashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsOfArrayExceptSelfTest {

  private final ProductsOfArrayExceptSelf productsOfArrayExceptSelf = new ProductsOfArrayExceptSelf();

  @Test
  void testProductsOfArrayExceptSelf1() {
    int[] nums = new int[] {1,2,4,6};
    int[] output = new int[] {48,24,12,8};
//    Assertions.assertArrayEquals(output, productsOfArrayExceptSelf.productExceptSelfPrefixAndSuffix(nums));
    Assertions.assertArrayEquals(output, productsOfArrayExceptSelf.productExceptSelfPrefixAndSuffixOptimal(nums));
  }
  
//  @Test
  void testProductsOfArrayExceptSelf2() {
    int[] nums = new int[] {-1,0,1,2,3};
    int[] output = new int[] {0,-6,0,0,0};
    Assertions.assertArrayEquals(output, productsOfArrayExceptSelf.productExceptSelfPrefixAndSuffix(nums));
    Assertions.assertArrayEquals(output, productsOfArrayExceptSelf.productExceptSelfPrefixAndSuffixOptimal(nums));
  }
  
}
