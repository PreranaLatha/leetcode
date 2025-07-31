import java.util.*;

class Twitter {

    private static int timestamp = 0;

    private static class Tweet {
        int time;
        int tweetId;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }

    // userId → set of followees
    private Map<Integer, Set<Integer>> follows;

    // userId → list of tweets
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    // User posts a tweet
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId));
    }

    // Retrieve 10 most recent tweet ids in the user's news feed
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(10, Comparator.comparingInt(t -> t.time));

        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Include own tweets

        for (int uid : followees) {
            List<Tweet> userTweets = tweets.getOrDefault(uid, new ArrayList<>());
            for (int i = userTweets.size() - 1; i >= 0 && i >= userTweets.size() - 10; i--) {
                minHeap.offer(userTweets.get(i));
                if (minHeap.size() > 10) {
                    minHeap.poll(); // Keep only top 10 recent tweets
                }
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll().tweetId); // reverse order (most recent first)
        }

        return res;
    }

    // Follower follows a followee
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    // Follower unfollows a followee
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
