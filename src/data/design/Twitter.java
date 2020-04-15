package data.design;

import java.util.*;

/**
 * @Author: liyuzhan
 * @classDesp： LeetCode第335题——设计Twitter
 * @Date: 2020/4/13 7:53
 * @Email: 1031759184@qq.com
 */
public class Twitter {
    /**
     * 权重
     */
    private int weight;
    class Node {
        int articleId;
        int followeeId;
        int thisWeight;
        public Node(int articleId,int followeeId) {
            this.articleId = articleId;
            this.followeeId = followeeId;
            thisWeight = ++weight;
        }

    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, PriorityQueue<Node>> articleMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>(16);
        articleMap = new HashMap<>(16);
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!followMap.containsKey(userId)){
            followMap.put(userId,new HashSet<>());
        }
        if (!articleMap.containsKey(userId)) {
            PriorityQueue<Node> articleList = new PriorityQueue<>((a,b)->b.thisWeight-a.thisWeight);
            articleList.offer(new Node(tweetId,userId));
            articleMap.put(userId, articleList);
        } else {
            PriorityQueue<Node> newList = articleMap.get(userId);
            newList.offer(new Node(tweetId,userId));
            articleMap.put(userId,newList);
        }
        followMap.forEach(
                (k,v)->{
                    if (followMap.get(k).contains(userId)){
                        PriorityQueue<Node> newList = articleMap.get(k);
                        newList.offer(new Node(tweetId,userId));
                        articleMap.put(k,newList);
                    }
                }
        );
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> resultList = new LinkedList<>();
        if (articleMap.containsKey(userId)){
            PriorityQueue<Node> articleQueue = new PriorityQueue<>((a,b)->b.thisWeight-a.thisWeight);
            articleQueue.addAll(articleMap.get(userId));
            int count = 0;
            while (!articleQueue.isEmpty()){
                resultList.add(articleQueue.poll().articleId);
                count++;
                if (count>=10){
                    break;
                }
            }
        }
        return resultList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId==followeeId) return;
        if (!followMap.containsKey(followerId)){
            Set<Integer> followerList = new HashSet<>();
            followerList.add(followeeId);
            followMap.put(followerId,followerList);
            articleMap.put(followerId,new PriorityQueue<>((a,b)->b.thisWeight-a.thisWeight));
            if (articleMap.containsKey(followeeId)){
                PriorityQueue<Node> nodes = articleMap.get(followerId);
                for (Node node : articleMap.get(followeeId)){
                    if (node.followeeId!=followerId&&node.followeeId==followeeId){
                        nodes.add(node);
                    }
                }
            }
        }else {
            if (followMap.get(followerId).contains(followeeId)) return;
            Set<Integer> newList = followMap.get(followerId);
            newList.add(followeeId);
            followMap.put(followerId,newList);
            if (articleMap.containsKey(followeeId)){
                PriorityQueue<Node> nodes = articleMap.get(followerId);
                for (Node node : articleMap.get(followeeId)){
                    if (node.followeeId!=followerId&&node.followeeId==followeeId){
                        nodes.add(node);
                    }
                }
            }
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)&&followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
            PriorityQueue<Node> nodes = articleMap.get(followerId);
            nodes.removeIf(node -> node.followeeId == followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,1);
        twitter.postTweet(2,2);
        twitter.postTweet(3,3);
        twitter.postTweet(1,4);
        twitter.postTweet(2,5);
        twitter.postTweet(3,6);
        twitter.postTweet(1,7);
        twitter.postTweet(2,8);
        twitter.postTweet(3,9);
        twitter.follow(2,1);
        twitter.follow(2,3);
        twitter.follow(2,2);
        twitter.unfollow(2,1);

        twitter.unfollow(1,3);
        System.out.println(twitter.getNewsFeed(2));
    }
}

