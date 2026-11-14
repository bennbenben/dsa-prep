package com.practise.dsa.heaps_and_priority_queue;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DesignTwitterTest {

  private DesignTwitter twitter;

  @BeforeEach
  public void setUp() {
    this.twitter = new DesignTwitter();
  }

  @Test
  void testDesignTwitter1() {
    // twitter.postTweet(1, 10); User 1 posts a new tweet with id = 10.
    twitter.postTweet(1, 10);

    // twitter.postTweet(2, 20); User 2 posts a new tweet with id = 20.
    twitter.postTweet(2, 20);

    // twitter.getNewsFeed(1); User 1's news feed should only contain their own
    // tweets -> [10].
    Assertions.assertEquals(Arrays.asList(10), twitter.getNewsFeed1(1));

    // twitter.getNewsFeed(2); User 2's news feed should only contain their own
    // tweets -> [20].
    Assertions.assertEquals(Arrays.asList(20), twitter.getNewsFeed1(2));

    // twitter.follow(1, 2); User 1 follows user 2.
    twitter.follow(1, 2);

    // twitter.getNewsFeed(1); User 1's news feed should contain both tweets from
    // user 1 and user 2 -> [20, 10].
    Assertions.assertEquals(Arrays.asList(20, 10), twitter.getNewsFeed1(1));

    // twitter.getNewsFeed(2); User 2's news feed should still only contain their
    // own tweets -> [20].
    Assertions.assertEquals(Arrays.asList(20), twitter.getNewsFeed1(2));

    // twitter.unfollow(1, 2); User 1 unfollows user 2.
    twitter.unfollow(1, 2);

    // twitter.getNewsFeed(1); User 1's news feed should only contain user 1's tweet
    // -> [10]
    Assertions.assertEquals(Arrays.asList(10), twitter.getNewsFeed1(1));
  }
  
  @Test
  void testDesignTwitter2() {
    // twitter.postTweet(1, 10); User 1 posts a new tweet with id = 10.
    twitter.postTweet(1, 10);

    // twitter.postTweet(2, 20); User 2 posts a new tweet with id = 20.
    twitter.postTweet(2, 20);

    // twitter.getNewsFeed(1); User 1's news feed should only contain their own
    // tweets -> [10].
    Assertions.assertEquals(Arrays.asList(10), twitter.getNewsFeed2(1));

    // twitter.getNewsFeed(2); User 2's news feed should only contain their own
    // tweets -> [20].
    Assertions.assertEquals(Arrays.asList(20), twitter.getNewsFeed2(2));

    // twitter.follow(1, 2); User 1 follows user 2.
    twitter.follow(1, 2);

    // twitter.getNewsFeed(1); User 1's news feed should contain both tweets from
    // user 1 and user 2 -> [20, 10].
    Assertions.assertEquals(Arrays.asList(20, 10), twitter.getNewsFeed2(1));

    // twitter.getNewsFeed(2); User 2's news feed should still only contain their
    // own tweets -> [20].
    Assertions.assertEquals(Arrays.asList(20), twitter.getNewsFeed2(2));

    // twitter.unfollow(1, 2); User 1 unfollows user 2.
    twitter.unfollow(1, 2);

    // twitter.getNewsFeed(1); User 1's news feed should only contain user 1's tweet
    // -> [10]
    Assertions.assertEquals(Arrays.asList(10), twitter.getNewsFeed2(1));
  }
}
