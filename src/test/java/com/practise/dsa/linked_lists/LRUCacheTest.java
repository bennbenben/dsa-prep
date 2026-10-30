package com.practise.dsa.linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {

  @Test
  void testLRUCache1() {
    LRUCache lRUCache = new LRUCache(2); // ["LRUCache", [2]]

    lRUCache.put(1, 10);  // ["put", [1, 10]], cache: {1=10}
    Assertions.assertEquals(10, lRUCache.get(1)); // ["get", [1]] 
    
    lRUCache.put(2, 20);  // ["put", [2, 20]], cache: {1=10, 2=20}
    lRUCache.put(3, 30); // ["put", [3, 30]],   
    Assertions.assertEquals(20, lRUCache.get(2)); // ["get", [2]], cache: {3=30, 2=20}
    Assertions.assertEquals(-1, lRUCache.get(1)); // ["get", [1]], not found
  }
}
