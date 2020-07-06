package com.verros.rest.dto;

public class CheckDigitDto {

    private Integer id;
    private String text;

    public CheckDigitDto() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
