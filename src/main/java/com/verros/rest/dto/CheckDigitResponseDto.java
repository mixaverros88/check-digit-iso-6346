package com.verros.rest.dto;


public class CheckDigitResponseDto {

  private long id;
  private boolean validateStatus;

  public CheckDigitResponseDto() {
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isValidateStatus() {
    return validateStatus;
  }

  public void setValidateStatus(boolean validateStatus) {
    this.validateStatus = validateStatus;
  }
}
