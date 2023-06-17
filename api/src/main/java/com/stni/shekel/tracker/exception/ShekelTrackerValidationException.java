package com.stni.shekel.tracker.exception;

public class ShekelTrackerValidationException extends RuntimeException {
  public ShekelTrackerValidationException() {
    super();
  }

  public ShekelTrackerValidationException(String message) {
    super((message));
  }

  public ShekelTrackerValidationException(String message, Exception e) {
    super(message, e);
  }
}
