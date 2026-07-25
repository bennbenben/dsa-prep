package com.practise.dsa.arrays_and_hashing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {

  private final GroupAnagrams groupAnagrams = new GroupAnagrams();

  @Test
  void testGroupAnagram() {
    String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };
    List<List<String>> expectedOutput = List.of(
        List.of("hat"),
        List.of("act", "cat"), 
        List.of("pots", "tops", "stop") 
    );
    
    List<List<String>> actualOutput = groupAnagrams.groupAnagramsSorting(strs);
    assertTrue(actualOutput.containsAll(expectedOutput), "groupAnagramsSorting failed");
    
    actualOutput = groupAnagrams.groupAnagramsHashTable(strs);
    assertTrue(actualOutput.containsAll(expectedOutput), "groupAnagramsHashTable failed");
    
  }

  @Test
  void testGroupAnagram2() {
    String[] strs = { "x" };
    List<List<String>> expectedOutput = List.of(
        List.of("x")
    );
    
    List<List<String>> actualOutput = groupAnagrams.groupAnagramsSorting(strs);
    assertTrue(actualOutput.containsAll(expectedOutput), "groupAnagramsSorting failed");
    
    actualOutput = groupAnagrams.groupAnagramsHashTable(strs);
    assertTrue(actualOutput.containsAll(expectedOutput), "groupAnagramsHashTable failed");
  }

}
