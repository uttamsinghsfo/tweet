package com.uttam.core;

/**
 *
 * @author uttam
 */
public class Tweet {
    
    public String text;
    public String fromUser;
    public String toUser;
    public Long timestamp;
    
    public Tweet(String fromUser, String toUser, String text, Long timestamp) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "from[" + fromUser + "] to[" + toUser + "] text[" + text + "]  at[" + timestamp + "]";
    }
    
}
