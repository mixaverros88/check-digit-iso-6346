package com.verros.rest.exception;

public class BusinessException extends Exception {

  private String code;
  private String message;

  public BusinessException(String message, String code) {
    super(message);
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
