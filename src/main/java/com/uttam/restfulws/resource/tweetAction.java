package com.uttam.restfulws.resource;

import com.uttam.core.SimpleController;
import com.uttam.core.Tweet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author uttam
 */

@Path("tweetDesign")
public class tweetAction {
    
    public tweetAction() {}
    
    // http://localhost:8080/uttam2-1.0/rest/tweetDesign/followSomeone?fromUser=steve&toUser=uttam
    @GET
    @Path("/followSomeone")
    @Produces("application/json")
    public MyJaxBeanBol followSomeone(@Context UriInfo ui) {
        
        MyJaxBeanBol mb = null;
        boolean result = false;
        
        MultivaluedMap<String,String> queryParams = ui.getQueryParameters();
        
        //Check for the Mandatory Parameters else return HTTP 412
        if( queryParams.containsKey("fromUser") && queryParams.containsKey("toUser") ) {
            String fromUser = queryParams.getFirst("fromUser");
            String toUser = queryParams.getFirst("toUser");
            SimpleController simpleC = new SimpleController();
            result = simpleC.follow(fromUser, toUser);
            mb = new MyJaxBeanBol("200" , "OK" , result);
        } else {
            // pre condition failed
            mb = new MyJaxBeanBol("412","PreCondition Failed / Mandatory Parameters Missing", result);
        }
        return mb;
    }
    
    // http://localhost:8080/uttam2-1.0/rest/tweetDesign/unfollowSomeone?fromUser=steve&toUser=uttam
    @GET
    @Path("/unfollowSomeone")
    @Produces("application/json")
    public MyJaxBeanBol unfollowSomeone(@Context UriInfo ui) {
        
        MyJaxBeanBol mb = null;
        boolean result = false;
        
        MultivaluedMap<String,String> queryParams = ui.getQueryParameters();
        
        //Check for the Mandatory Parameters else return HTTP 412
        if( queryParams.containsKey("fromUser") && queryParams.containsKey("toUser") ) {
            String fromUser = queryParams.getFirst("fromUser");
            String toUser = queryParams.getFirst("toUser");
            SimpleController simpleC = new SimpleController();
            result = simpleC.unfollow(fromUser, toUser);
            mb = new MyJaxBeanBol("200" , "OK" , result);
        } else {
            // pre condition failed
            mb = new MyJaxBeanBol("412","PreCondition Failed / Mandatory Parameters Missing", result);
        }
        return mb;
    }
    
    // http://localhost:8080/uttam2-1.0/rest/tweetDesign/postSomeone?fromUser=steve&toUser=uttam&text=first%20tweet
    @GET
    @Path("/postSomeone")
    @Produces("application/json")
    public MyJaxBeanStr postSomeone(@Context UriInfo ui) {
        
        MyJaxBeanStr mb = null;
        String result = "";
        
        MultivaluedMap<String,String> queryParams = ui.getQueryParameters();
        
        //Check for the Mandatory Parameters else return HTTP 412
        if( queryParams.containsKey("fromUser") && queryParams.containsKey("toUser") 
                && queryParams.containsKey("text") ) {
            String fromUser = queryParams.getFirst("fromUser");
            String toUser = queryParams.getFirst("toUser");
            String text = queryParams.getFirst("text");
            Long time = new Date().getTime();
            
            SimpleController simpleC = new SimpleController();
            result = simpleC.postTweet(fromUser, toUser, time, text);
            mb = new MyJaxBeanStr("200" , "OK" , result);
        } else {
            // pre condition failed
            mb = new MyJaxBeanStr("412","PreCondition Failed / Mandatory Parameters Missing", result);
        }
        return mb;
    }
    
    // http://localhost:8080/uttam2-1.0/rest/tweetDesign/getUserTweet?fromUser=steve&num=2
    @GET
    @Path("/getUserTweet")
    @Produces("application/json")
    public MyJaxBeanTweetList getUserTweet(@Context UriInfo ui) {
        
        MyJaxBeanTweetList mb = null;
        List<Tweet> result = new ArrayList<>();
        
        MultivaluedMap<String,String> queryParams = ui.getQueryParameters();
        
        //Check for the Mandatory Parameters else return HTTP 412
        if( queryParams.containsKey("fromUser") && queryParams.containsKey("num") ) {
            String fromUser = queryParams.getFirst("fromUser");
            int N = Integer.parseInt(queryParams.getFirst("num"));
            
            SimpleController simpleC = new SimpleController();
            result = simpleC.userTopTweet(fromUser, N);
            mb = new MyJaxBeanTweetList("200" , "OK" , result);
        } else {
            // pre condition failed
            mb = new MyJaxBeanTweetList("412","PreCondition Failed / Mandatory Parameters Missing", result);
        }
        return mb;
    }
    
    // http://localhost:8080/uttam2-1.0/rest/tweetDesign/getTop100
    @GET
    @Path("/getTop100")
    @Produces("application/json")
    public MyJaxBeanTweetList getTop100(@Context UriInfo ui) {
        
        MyJaxBeanTweetList mb = null;
        List<Tweet> result = new ArrayList<>();
        
        SimpleController simpleC = new SimpleController();
        result = simpleC.getTop100();
        mb = new MyJaxBeanTweetList("200" , "OK" , result);
        return mb;
    }
    
}
