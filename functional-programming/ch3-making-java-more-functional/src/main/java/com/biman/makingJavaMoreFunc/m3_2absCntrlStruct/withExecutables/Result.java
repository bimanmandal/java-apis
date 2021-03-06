package com.biman.makingJavaMoreFunc.m3_2absCntrlStruct.withExecutables;

public interface Result {

  public class Success implements Result {}

  public class Failure implements Result {
    private final String errorMessage;

    public Failure(String errorMessage) {
      this.errorMessage = errorMessage;
    }

    public String getMessage() {
      return errorMessage;
    }
  }
}
