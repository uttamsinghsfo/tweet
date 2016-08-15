package com.uttam.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author uttam
 */
public class SimpleController {
    
    public static HashMap<String, LinkedList<Tweet>> tweetMap = new HashMap<>();
    public static HashMap<String, Set<String>> followerMap = new HashMap<>();
    public static Queue<Tweet> top100 = new LinkedList<>();
    
    public boolean follow(String fromUser, String toUser) {
        String method = "follow( " + fromUser + "," + toUser + ")";
        System.out.println(method);
        try {
            Set<String> follows = new HashSet<>();
            follows.add(toUser);
            if (followerMap.containsKey(fromUser)) {
                follows.addAll(followerMap.get(fromUser));
            }
            followerMap.put(fromUser, follows);
            System.out.println("FollowerMap: " + followerMap);
            return true;
        } catch (Exception ex) {
            System.err.println("Error in adding follower: " + method + "\t" + ex);
        }
        return false;
    }
    
    public boolean unfollow(String fromUser, String toUser) {
        String method = "unfollow( " + fromUser + "," + toUser + ")";
        System.out.println(method);
        try {
        Set<String> unfollows = new HashSet<>();
        if (followerMap.containsKey(fromUser)) {
            unfollows = followerMap.get(fromUser);
            unfollows.remove(toUser);
        }
        followerMap.put(fromUser, unfollows);
        System.out.println("FollowerMap: " + followerMap);
        return true;
        } catch (Exception ex) {
            System.err.println("Error in adding unfollower: " + method + "\t" + ex);
        }
        return false;
    }
    
    public String postTweet(String fromUser, String toUser, Long time, String text) {
        String method = "postTweet( " + fromUser + "," + toUser + "," + time+ "," + text + ")";
        System.out.println(method);
        
        Tweet tweet = new Tweet(fromUser, toUser, text, time);
        System.out.println("FollowerMap: " + followerMap);
        System.out.println("TweetMap: " + tweetMap);
        
        // check if fromUser is a follower of toUser    // if yes, post .. if no, throw error
        if (followerMap.containsKey(fromUser) && followerMap.get(fromUser).contains(toUser)) {
            LinkedList<Tweet> tmp = new LinkedList<>();
            if (tweetMap.containsKey(fromUser)) {
                tmp = tweetMap.get(fromUser);
            }
            tmp.addFirst(tweet);
            tweetMap.put(fromUser, tmp);
            System.out.println("TweetMap: " + tweetMap);
            
            // also add to queue
            if (top100.size() >= 100) {
                top100.remove();
            }
            top100.add(tweet);
        } else {
            // user cannot post because he is not following toUser
            return "can't post, because " + fromUser + " is not following " + toUser;
        }
        return "posted";
    }
    
    public List<Tweet> getTop100() {
        List<Tweet> tweets = new ArrayList<>();
        for (Tweet tweet : top100) {
            tweets.add(tweet);
        }
        return tweets;
    }

    public List<Tweet> userTopTweet(String fromUser, int N) {
        String method = "userTopTweet( " + fromUser + "," + N + ")";
        System.out.println(method);
        
        List<Tweet> res = new ArrayList<>();
        if (tweetMap.containsKey(fromUser)) {
            LinkedList<Tweet> tweets = tweetMap.get(fromUser);
            for (Tweet tweet : tweets) {
                res.add(tweet);
                N = N-1;
                if (N <= 0) {
                    break;
                }
            }
        }
        return res;
    }
    
}
