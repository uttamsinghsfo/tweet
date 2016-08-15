package com.uttam.restfulws.resource;

import com.uttam.core.Tweet;
import java.util.List;

/**
 *
 * @author uttam
 */
public class MyJaxBeanTweetList {
  private String statusCode;
  private String statusMsg;
  private List<Tweet> result;

   
  public MyJaxBeanTweetList(){}
  public MyJaxBeanTweetList(String statusCode,String statusMsg, List<Tweet> result){
    this.statusCode=statusCode;
    this.statusMsg=statusMsg;
    this.result = result;
  }
  
  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusMsg() {
    return statusMsg;
  }

  public void setStatusMsg(String statusMsg) {
    this.statusMsg = statusMsg;
  }
  
  public List<Tweet> getResult() {
    return result;
  }

  public void setModels(List<Tweet> result) {
    this.result = result;
  }
  
}
