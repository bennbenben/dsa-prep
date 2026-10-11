package com.practise.dsa.arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {
    Set<Integer> numsSet = new HashSet<Integer>();
    for (int num : nums) {
      numsSet.add(num);
    }
    
    int ongoingStreak=0;
    for (int num : numsSet) {
      if (numsSet.contains(num-1)) {
        continue;
      }
      
      int currentStreak=1;
      int nextNum = num + 1;
      while (numsSet.contains(nextNum)) {
        currentStreak += 1;
        nextNum += 1;
      }
      ongoingStreak = Math.max(currentStreak, ongoingStreak);
    }
    return ongoingStreak;
  }
  
  public static void main(String[] args) {
    LongestConsecutiveSequence s = new LongestConsecutiveSequence();
    s.longestConsecutive(new int[] {2,20,4,10,3,4,5});
  }

}
