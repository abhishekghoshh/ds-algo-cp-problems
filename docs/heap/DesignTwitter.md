# DesignTwitter

**Topic:** `heap` | **File:** `com/problems/heap/DesignTwitter.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-twitter/description/)
- [📄 NeetCode](https://neetcode.io/problems/design-twitter-feed)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/design-twitter_8380711)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=pNichitDD2E)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Most optimized approach merge k list technique this code is modularized we have covered almost all the optimization, but in getFeeds method still we are doing brute force approach we can use the technique of merge k sorted list using a maxHeap

```java
private static void type4() {
        Twitter4 twitter = new Twitter4();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
```

### Approach 3

Latest tweet will come at the top in the heap adding self tweet list pointer to max heap adding followee tweets to the map heap now we have all the pointers in the max heap, we can just fetch top 10 tweets by using merge k list approach if the user tweet list is empty then we will not that user tweet list to the map heap as we know the range of userid and tweet id we use some from of an array

```java
private static void type3() {
        Twitter3 twitter = new Twitter3();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
```

### Approach 2

Self tweets other tweets todo little optimized from the last type as all the tweets have unique ids so we can just save (tweetId,time) in a separate map rather saving the time in the tweet map

```java
private static void type2() {
        Twitter2 twitter = new Twitter2();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
```

### Approach 1 — Brute Force

Adding the tweets of himself adding others tweets TODO optimize things here this is very brute force technique we do not need to store the tweet time along with tweet id as the tweet id are distinct we can create a separate map for tweet id Also get news feed method is also getting all feeds then sorting on that so this method can also be refactored

```java
private static void type1() {
        Twitter1 twitter = new Twitter1();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
```
