package com.sg.employeeportal.dto;

import java.util.Map;

public class ErrorDetails {
  private String msg;
  private Map<String, String> details;
  
  public ErrorDetails(String msg, Map<String, String> details) {
    super();
    this.msg = msg;
    this.details = details;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  public Map<String,String> getDetails() {
    return details;
  }
  
  public void setDetails(Map<String,String>  details) {
    this.details = details;
  }
  
}
