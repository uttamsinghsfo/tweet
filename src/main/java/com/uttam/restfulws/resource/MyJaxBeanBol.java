package com.uttam.restfulws.resource;

/**
 *
 * @author uttam
 */
public class MyJaxBeanBol {
  private String statusCode;
  private String statusMsg;
  private boolean result;

   
  public MyJaxBeanBol(){}
  public MyJaxBeanBol(String statusCode,String statusMsg, boolean result){
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
  
  public boolean getResult() {
    return result;
  }

  public void setModels(boolean result) {
    this.result = result;
  }
  
}
