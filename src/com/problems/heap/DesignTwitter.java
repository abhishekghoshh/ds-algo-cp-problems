package com.problems.heap;

import java.util.*;

/*
 *
 * problem links :
 * https://leetcode.com/problems/design-twitter/description/
 * https://www.codingninjas.com/studio/problems/design-twitter_8380711
 *
 * Solution link :
 * https://www.youtube.com/watch?v=pNichitDD2E
 *
 * */
public class DesignTwitter {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        type5();
    }

    // TODO implement it later
    // as we only need top 10 tweets so we can use a min heap
    // to collect all 10 latest tweets
    private static void type5() {

    }

    // we have covered almost all the optimization,
    // but in getFeeds method still we are doing brute force approach
    // we can use the technique of merge k sorted list using a maxHeap
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

    static class Twitter4 {

        HashSet<Integer>[] followeeSet;
        List<Integer>[] tweetMap;
        int[] tweetTimeMap;
        int time = 0;

        public Twitter4() {
            followeeSet = new HashSet[501];
            tweetMap = new List[501];
            tweetTimeMap = new int[10001];
        }

        public void postTweet(int userId, int tweetId) {
            time++;
            if (tweetMap[userId] == null)
                tweetMap[userId] = new ArrayList<>();
            tweetMap[userId].add(tweetId);
            tweetTimeMap[tweetId] = time;
        }

        // merge k list technique
        // this is could be enhanced more
        // see merge k sorted list problem
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<TweetList> maxHeap = new PriorityQueue<>(
                    (tl1, tl2) -> tweetTimeMap[tl2.tweets.get(tl2.n)] - tweetTimeMap[tl1.tweets.get(tl1.n)]
            );
            if (tweetMap[userId] != null && !tweetMap[userId].isEmpty())
                maxHeap.offer(new TweetList(tweetMap[userId], tweetMap[userId].size() - 1));
            if (followeeSet[userId] != null)
                for (int followeeId : followeeSet[userId])
                    if (tweetMap[followeeId] != null && !tweetMap[followeeId].isEmpty())
                        maxHeap.offer(new TweetList(tweetMap[followeeId], tweetMap[followeeId].size() - 1));
            List<Integer> tweets = new ArrayList<>();
            while (tweets.size() < 10 && !maxHeap.isEmpty()) {
                TweetList tweetList = maxHeap.poll();
                tweets.add(tweetList.tweets.get(tweetList.n));
                tweetList.n--;
                if (tweetList.n >= 0) maxHeap.offer(tweetList);
            }
            return tweets;
        }

        public void follow(int followerId, int followeeId) {
            if (followeeSet[followerId] == null)
                followeeSet[followerId] = new HashSet<>();
            followeeSet[followerId].add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followeeSet[followerId] != null)
                followeeSet[followerId].remove(followeeId);
        }

        static class TweetList {
            public List<Integer> tweets;
            public int n;

            public TweetList(List<Integer> tweets, int n) {
                this.tweets = tweets;
                this.n = n;
            }
        }
    }

    // as we know the range of userid and tweet id
    // we use some from of an array
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

    static class Twitter3 {

        HashSet<Integer>[] followeeSet;
        List<Integer>[] tweetMap;
        int[] tweetTimeMap;
        int time = 0;

        public Twitter3() {
            followeeSet = new HashSet[501];
            tweetMap = new List[501];
            tweetTimeMap = new int[10001];
        }

        public void postTweet(int userId, int tweetId) {
            time++;
            if (tweetMap[userId] == null)
                tweetMap[userId] = new ArrayList<>();
            tweetMap[userId].add(tweetId);
            tweetTimeMap[tweetId] = time;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> allTweetList = new ArrayList<>();
            if (tweetMap[userId] != null && !tweetMap[userId].isEmpty())
                allTweetList.addAll(tweetMap[userId]);
            if (followeeSet[userId] != null)
                for (int followeeId : followeeSet[userId])
                    if (tweetMap[followeeId] != null &&
                            !tweetMap[followeeId].isEmpty())
                        allTweetList.addAll(tweetMap[followeeId]);
            allTweetList.sort((t1, t2) -> tweetTimeMap[t2] - tweetTimeMap[t1]);
            return allTweetList.size() <= 10 ? allTweetList : allTweetList.subList(0, 10);
        }

        public void follow(int followerId, int followeeId) {
            if (followeeSet[followerId] == null)
                followeeSet[followerId] = new HashSet<>();
            followeeSet[followerId].add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followeeSet[followerId] != null)
                followeeSet[followerId].remove(followeeId);
        }

    }

    // little optimized from the last type
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

    static class Twitter2 {
        Map<Integer, HashSet<Integer>> followeeSet;
        Map<Integer, List<Integer>> tweetMap;
        Map<Integer, Integer> tweetTimeMap;
        int time = 0;

        public Twitter2() {
            followeeSet = new HashMap<>();
            tweetMap = new HashMap<>();
            tweetTimeMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            time++;
            if (!tweetMap.containsKey(userId))
                tweetMap.put(userId, new ArrayList<>());
            tweetMap.get(userId).add(tweetId);
            tweetTimeMap.put(tweetId, time);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> allTweetList = new ArrayList<>();
            if (tweetMap.containsKey(userId) && !tweetMap.get(userId).isEmpty())
                allTweetList.addAll(tweetMap.get(userId));
            if (followeeSet.containsKey(userId))
                for (int followeeId : followeeSet.get(userId))
                    if (tweetMap.containsKey(followeeId) &&
                            !tweetMap.get(followeeId).isEmpty())
                        allTweetList.addAll(tweetMap.get(followeeId));
            allTweetList.sort((t1, t2) -> tweetTimeMap.get(t2) - tweetTimeMap.get(t1));
            return allTweetList.size() <= 10 ? allTweetList : allTweetList.subList(0, 10);
        }

        public void follow(int followerId, int followeeId) {
            if (!followeeSet.containsKey(followerId))
                followeeSet.put(followerId, new HashSet<>());
            followeeSet.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followeeSet.containsKey(followerId))
                followeeSet.get(followerId).remove(followeeId);
        }

    }

    // this is very brute force technique
    // TODO optimize things here
    // we do not need to store the tweet time along with tweet id
    // as the tweet id are distinct we can create a separate map for tweet id
    // Also get news feed method is also getting all feeds then sorting on that
    // so this method can also be refactored
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

    static class Twitter1 {
        Map<Integer, HashSet<Integer>> followeeSet;
        Map<Integer, List<Tweet>> tweetMap;
        int time = 0;

        public Twitter1() {
            followeeSet = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            time++;
            if (!tweetMap.containsKey(userId))
                tweetMap.put(userId, new ArrayList<>());
            tweetMap.get(userId).add(new Tweet(tweetId, time));
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Tweet> allTweetList = new ArrayList<>();
            if (tweetMap.containsKey(userId) && !tweetMap.get(userId).isEmpty())
                allTweetList.addAll(tweetMap.get(userId));
            if (followeeSet.containsKey(userId))
                for (int followeeId : followeeSet.get(userId))
                    if (tweetMap.containsKey(followeeId) &&
                            !tweetMap.get(followeeId).isEmpty())
                        allTweetList.addAll(tweetMap.get(followeeId));
            allTweetList.sort((t1, t2) -> t2.time - t1.time);
            List<Integer> tweets = new ArrayList<>();
            int bound = Math.min(10, allTweetList.size());
            for (int i = 0; i < bound; i++) tweets.add(allTweetList.get(i).tweetId);
            return tweets;
        }

        public void follow(int followerId, int followeeId) {
            if (!followeeSet.containsKey(followerId))
                followeeSet.put(followerId, new HashSet<>());
            followeeSet.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followeeSet.containsKey(followerId))
                followeeSet.get(followerId).remove(followeeId);
        }

        static class Tweet {
            int tweetId;
            int time;

            public Tweet(int tweetId, int time) {
                this.tweetId = tweetId;
                this.time = time;
            }
        }
    }
}
