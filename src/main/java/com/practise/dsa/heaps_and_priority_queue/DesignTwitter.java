package com.practise.dsa.heaps_and_priority_queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {
  
  private class Tweet {
    int tweetId;
    int timestamp;
    Tweet next; // for getNewsFeed optimization - getNewsFeed2 method
    private Tweet(int tweetId, int timestamp) {
      this.tweetId = tweetId;
      this.timestamp = timestamp;
    }
  }
  
  private int time;
  
  private Map<Integer, Set<Integer>> followingMap = new HashMap<Integer, Set<Integer>>();
  private Map<Integer, LinkedList<Tweet>> userTweetMap = new HashMap<Integer, LinkedList<Tweet>>();

  public DesignTwitter() {
    
  }
  
  public void postTweet(int userId, int tweetId) {
    LinkedList<Tweet> userTweetList;
    
    if (this.userTweetMap.containsKey(userId)) {
      userTweetList = this.userTweetMap.get(userId);
    } else {
      userTweetList = new LinkedList<DesignTwitter.Tweet>();
      this.userTweetMap.put(userId, userTweetList);
    }
    
    Tweet newTweet = new Tweet(tweetId, this.time);
    Tweet tweetHead = userTweetList.peekFirst();
    // this part only for getNewsFeed2 optimization
    if (tweetHead != null) {
      newTweet.next = tweetHead;
    }
    
    userTweetList.offerFirst(newTweet);
    this.time += 1;
  }
  
  public List<Integer> getNewsFeed1(int userId) {
    if (!this.followingMap.containsKey(userId)) {
      this.follow(userId, userId);
    }
    
    Set<Integer> followerSet = this.followingMap.get(userId);
    PriorityQueue<Tweet> maxHeap = new PriorityQueue<DesignTwitter.Tweet>((a,b) -> Integer.compare(b.timestamp, a.timestamp));
    
    for (Integer follower : followerSet) {
      LinkedList<Tweet> userTweetList = this.userTweetMap.get(follower);
      if (userTweetList == null) {
        continue;
      }
      
      for (Tweet userTweet : userTweetList) {
        if (userTweet != null) {
          maxHeap.add(userTweet);
        }
      }
    }
    
    List<Integer> userNewsFeed = new ArrayList<Integer>();
    while (!maxHeap.isEmpty() && userNewsFeed.size()<10) {
      Tweet latestTweet = maxHeap.poll();
      userNewsFeed.add(latestTweet.tweetId);
    }
    return userNewsFeed;
  }
  
  public List<Integer> getNewsFeed2(int userId) {
    if (!this.followingMap.containsKey(userId)) {
      this.follow(userId, userId);
    }
    
    Set<Integer> followerSet = this.followingMap.get(userId);
    PriorityQueue<Tweet> maxHeap = new PriorityQueue<DesignTwitter.Tweet>((a,b) -> Integer.compare(b.timestamp, a.timestamp));
    
    for (Integer follower : followerSet) {
      LinkedList<Tweet> userTweetList = this.userTweetMap.get(follower);
      if (userTweetList == null) {
        continue;
      }
      
      Tweet userTweetHead = userTweetList.peekFirst();
      maxHeap.offer(userTweetHead);
    }
    
    List<Integer> userNewsFeed = new ArrayList<Integer>();
    while (!maxHeap.isEmpty() && userNewsFeed.size()<10) {
      Tweet latestTweet = maxHeap.poll();
      userNewsFeed.add(latestTweet.tweetId);
      
      if (latestTweet.next != null) {
        maxHeap.offer(latestTweet.next);
      }
    }
    return userNewsFeed;
  }
  
  public void follow(int followerId, int followeeId) {
    if (!this.followingMap.containsKey(followerId)) { 
      Set<Integer> followerSet = new HashSet<Integer>();
      followerSet.add(followerId); followerSet.add(followeeId);
      this.followingMap.put(followerId, followerSet); 
    
    } else {
      Set<Integer> followerSet = this.followingMap.get(followerId);
      followerSet.add(followeeId);
      // this.followingMap.put(followerId, followerSet); // not required, followerSet points to object memory
    }
  }
  
  public void unfollow(int followerId, int followeeId) {
    if (followerId == followeeId) {
      return;
    }
    
    Set<Integer> followerSet = this.followingMap.get(followerId);
    if (followerSet != null && followerSet.contains(followeeId)) {
      followerSet.remove(followeeId);
      // this.followingMap.put(followerId, followerSet); // not required, followerSet points to object memory
    }
  }
}
